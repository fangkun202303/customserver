package com.multimodule.customserver.MyHandler;

import com.multimodule.customserver.MyRequest.MyRequest;
import com.multimodule.customserver.MyResponse.MyResponse;

/**
 * @ClassName: Handler
 * @Description: 消息处理的接口
 * @Author: FangKun
 * @Date: Created in 2019/1/17 8:49
 * @Version: 1.0
 */
public interface  Handler {
    public void service(MyRequest request, MyResponse response);

    public void doGet(MyRequest request, MyResponse response);

    public void doPost(MyRequest request, MyResponse response);

}
