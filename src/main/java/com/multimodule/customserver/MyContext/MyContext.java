package com.multimodule.customserver.MyContext;

import com.multimodule.customserver.MyHandler.impl.MyHttpHandlerImpl;
import com.multimodule.customserver.utils.XmlUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: MyContext
 * @Description: TODO
 * @Author: FangKun
 * @Date: Created in 2019/1/16 17:32
 * @Version: 1.0
 */
public class MyContext {
    private static Map<String, MyHttpHandlerImpl> contextMap=new ConcurrentHashMap<>();
    public static String myContextPath="";
    public static void load(){
        try{
            //读取配置文件的信息,通过反射创建对象
            Document doc = XmlUtils.load(MyContext.class.getResource("/").getPath()+"/context.xml");
            Element root = doc.getDocumentElement();
            myContextPath = XmlUtils.getAttribute(root, "context");
            Element[] handlers = XmlUtils.getChildrenByName(root, "handler");
            for (Element e :handlers){
                String handler_class=XmlUtils.getChildText(e,"handler-class");
                String url_pattren=XmlUtils.getChildText(e,"url-pattern");
                        Class<?> c=Class.forName(handler_class);
                Object newInstance = c.newInstance();
                if (newInstance instanceof MyHttpHandlerImpl) {
                    contextMap.put(myContextPath+url_pattren, (MyHttpHandlerImpl) newInstance);
                }
            }
        }catch (Exception e){
            System.out.println("出现的异常是："+e.getMessage());
            e.printStackTrace();
        }
    }

    public static MyHttpHandlerImpl getHandler(String key){
        return contextMap.get(key);
    }

    public static void main(String[] args){}

}
