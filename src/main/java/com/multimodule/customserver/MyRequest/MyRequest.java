package com.multimodule.customserver.MyRequest;

import java.net.URI;

/**
 * @ClassName: MyRequest
 * @Description: 请求的接口
 * @Author: FangKun
 * @Date: Created in 2019/1/17 8:45
 * @Version: 1.0
 */
public interface  MyRequest {

    public final static String GET = "GET";
    public final static String POST = "POST";

    public String getParamter(String param);

    public String getMethod();

    public URI getReuestURI();

    public void initRequestHeader();

    public void initRequestParam();

    public void initRequestBody();

    public String getRequestBody();
}
