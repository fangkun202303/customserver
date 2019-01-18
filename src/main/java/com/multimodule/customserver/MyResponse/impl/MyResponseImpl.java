package com.multimodule.customserver.MyResponse.impl;

import com.multimodule.customserver.MyResponse.MyResponse;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName: MyResponseImpl
 * @Description: 响应的实现类
 * @Author: FangKun
 * @Date: Created in 2019/1/17 8:52
 * @Version: 1.0
 */
public class MyResponseImpl implements MyResponse {

    private HttpExchange httpExchange;

    public MyResponseImpl (HttpExchange httpExchange){
        this.httpExchange = httpExchange;
    }

    @Override
    public void write(String result) {
        try{
            byte[] b=result.getBytes();
            httpExchange.sendResponseHeaders(200,b.length);
            OutputStream out=httpExchange.getResponseBody();
            out.write(b);
            out.flush();
            out.close();
            httpExchange.close();
        }catch (IOException i){
            System.out.println("出现错误了！错误是："+i.getMessage());
        }


    }
}
