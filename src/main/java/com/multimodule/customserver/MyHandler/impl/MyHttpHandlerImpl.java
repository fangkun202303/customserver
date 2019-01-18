package com.multimodule.customserver.MyHandler.impl;

import com.multimodule.customserver.MyHandler.Handler;
import com.multimodule.customserver.MyRequest.MyRequest;
import com.multimodule.customserver.MyResponse.MyResponse;

/**
 * @ClassName: MyHttpHandlerImpl
 * @Description: 消息处理的接口实现
 * @Author: FangKun
 * @Date: Created in 2019/1/17 11:22
 * @Version: 1.0
 */
public abstract class MyHttpHandlerImpl implements Handler {
    @Override
    public void service(MyRequest request, MyResponse response) {
        request.initRequestHeader();
        request.initRequestParam();
        if(request.getMethod().equals("GET")){
            doGet(request,response);
        }else if(request.getMethod().equals("POST")){
            request.initRequestBody();
            doPost(request,response);
        }
    }

    @Override
    public abstract  void doGet(MyRequest request, MyResponse response);

    @Override
    public abstract  void doPost(MyRequest request, MyResponse response);
}
