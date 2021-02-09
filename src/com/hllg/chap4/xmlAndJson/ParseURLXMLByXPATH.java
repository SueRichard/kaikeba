package com.hllg.chap4.xmlAndJson;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/09  Tue  11:41
 * 解析URL对应的XML
 */
public class ParseURLXMLByXPATH {
    public static void main(String[] args) throws IOException, DocumentException {
        String phone = "18205624169";
        URL url = new URL("http://apis.juhe.cn/mobile/get?phone=" + phone + "&dtype=xml&key=9f3923e8f87f1ea50ed4ec8c39cc9253");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        SAXReader sr = new SAXReader();
        Document doc = sr.read(is);
        //只有单个节点，如果有多个，返回第一个；
        //解析效率和Element没区别，就是写起来方便，内部封装了代码
        //Node是Element和Document的父接口
        Node node = doc.selectSingleNode("//company");
        System.out.println("运营商是：" + node.getText());
    }
}
