package com.multimodule.customserver.StartCustomServer;

import com.multimodule.customserver.MyContext.MyContext;
import com.multimodule.customserver.MyContext.MyHttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @ClassName: MyHttpServer
 * @Description: TODO
 * @Author: FangKun
 * @Date: Created in 2019/1/16 17:27
 * @Version: 1.0
 */
public class MyHttpServer {

    public static void main(String[] args) throws IOException {
        start();
    }


    //启动服务，监听来自客户端的请求
    public static void start() throws IOException {
        MyContext.load();
        HttpServerProvider provider = HttpServerProvider.provider();
        HttpServer httpserver =provider.createHttpServer(new InetSocketAddress(8080), 100);//监听端口8080,能同时接 受100个请求
        httpserver.createContext(MyContext.myContextPath, new MyHttpHandler());
        httpserver.setExecutor(null);
        httpserver.start();
        System.out.println("server started");
    }

}
