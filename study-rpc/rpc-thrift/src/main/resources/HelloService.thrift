// 不使用注解方式时需要下载 thrift-0.9.3.exe 将 *.thrift 文件生成 .java文件
namespace java thrift.gencode.server
include 'UserModel.thrift'
service HelloService {
    string sayHello(1: UserModel.User user)
}