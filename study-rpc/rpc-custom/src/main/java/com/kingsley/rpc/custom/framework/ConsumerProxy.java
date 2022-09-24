package com.kingsley.rpc.custom.framework;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author ZhangTao
 * @date 2022/9/24
 * @desc
 */
public class ConsumerProxy {

    /**
     * 服务消费代理接口
     *
     * @param interfaceClazz
     * @param host
     * @param port
     * @return
     */
    public static <T> T consume(final Class<T> interfaceClazz, final String host, final int port) throws Exception {
        return (T) Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class<?>[]{interfaceClazz}, (proxy, method, args) -> {
            try (Socket socket = new Socket(host, port)) {
                try (ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
                    oos.writeUTF(method.getName());
                    oos.writeObject(args);
                    oos.flush();
                    try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
                        Object result = ois.readObject();
                        if (result instanceof Throwable) {
                            throw (Throwable) result;
                        }
                        return result;
                    }
                }
            }
        });
    }

}
