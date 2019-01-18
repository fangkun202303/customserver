package com.multimodule.customserver.MyRequest.impl;

import com.multimodule.customserver.MyRequest.MyRequest;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: MyRequestImpl
 * @Description: 请求的实现类
 * @Author: FangKun
 * @Date: Created in 2019/1/17 8:48
 * @Version: 1.0
 */
public class MyRequestImpl implements MyRequest {

    private HttpExchange httpExchange;
    private Map<String,String> paramMap=new ConcurrentHashMap<>();
    private Map<String, List<String>> headMap=new ConcurrentHashMap<>();
    private String requestBody="";

    public MyRequestImpl (HttpExchange httpExchange){
        this.httpExchange = httpExchange;
    }

    @Override
    public String getParamter(String param) {
        return paramMap.get(param);
    }

    @Override
    public String getMethod() {
        return httpExchange.getRequestMethod().trim().toUpperCase();
    }

    @Override
    public URI getReuestURI() {
        return httpExchange.getRequestURI();
    }

    @Override
    public void initRequestHeader() {
        String query=getReuestURI().getQuery();
        if(query!=null){
            String[] arr=query.split("&");
            for (String s:arr){
                paramMap.put(s.split("=")[0], s.split("=")[1]);
            }
        }
    }

    @Override
    public void initRequestParam() {
        for(String s : httpExchange.getRequestHeaders().keySet()){
            headMap.put(s,httpExchange.getRequestHeaders().get(s));
        }
    }

    @Override
    public void initRequestBody() {
        //获取输入流
        InputStream in =httpExchange.getRequestBody();
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        String temp=null;
        try{
            while((temp=reader.readLine())!=null){
                requestBody +=temp;
            }
        }catch (IOException i){
            System.out.println("出错了：错误内容是："+i.getMessage());
            i.printStackTrace();
        }
    }

    @Override
    public String getRequestBody() {
        return requestBody;
    }
}
