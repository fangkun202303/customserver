package com.multimodule.customserver.StartCustomServer;

import com.multimodule.customserver.MyHandler.impl.MyHttpHandlerImpl;
import com.multimodule.customserver.MyRequest.MyRequest;
import com.multimodule.customserver.MyResponse.MyResponse;

/**
 * @ClassName: FirstHandler
 * @Description: TODO
 * @Author: FangKun
 * @Date: Created in 2019/1/17 16:37
 * @Version: 1.0
 */
public class FirstHandler extends MyHttpHandlerImpl {
    @Override
    public void doGet(MyRequest request, MyResponse response) {
        System.out.println("doGet");
//        System.out.println(request.getParamter("aaa"));
//        System.out.println(request.getParamter("bbb"));
        response.write("这是自定义http服务的get请求");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        System.out.println("doPost");
        System.out.println(request.getParamter("aaa"));
        System.out.println(request.getParamter("bbb"));
        response.write("这是自定义http服务的post请求");
    }
}
