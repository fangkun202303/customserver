package com.multimodule.customserver.MyContext;

import com.multimodule.customserver.MyHandler.Handler;
import com.multimodule.customserver.MyRequest.MyRequest;
import com.multimodule.customserver.MyRequest.impl.MyRequestImpl;
import com.multimodule.customserver.MyResponse.MyResponse;
import com.multimodule.customserver.MyResponse.impl.MyResponseImpl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

/**
 * @ClassName: MyHttpHandler
 * @Description: TODO
 * @Author: FangKun
 * @Date: Created in 2019/1/17 11:20
 * @Version: 1.0
 */
public class MyHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        MyRequest request = new MyRequestImpl(httpExchange);
        MyResponse response = new MyResponseImpl(httpExchange);
        Handler handler = MyContext.getHandler(request.getReuestURI().getPath());
        handler.service(request, response);
    }
}
