package com.kingsley.rpc.custom.framework;

import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZhangTao
 * @date 2022/9/24
 * @desc
 */
public class ProviderReflect {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 服务发布
     *
     * @param service
     * @param port
     * @throws IOException
     */
    public static void provider(final Object service, int port) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> {
                    try {
                        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
                            String methodName = ois.readUTF();
                            Object[] args = (Object[]) ois.readObject();
                            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                            try {
                                Object result = MethodUtils.invokeExactMethod(service, methodName, args);
                                oos.writeObject(result);
                            } catch (Throwable t) {
                                oos.writeObject(t);
                            } finally {
                                oos.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

}
