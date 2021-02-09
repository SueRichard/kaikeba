package com.hllg.chap4.xmlAndJson;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/09  Tue  10:20
 */
public class ParseXML {
    public static void main(String[] args) throws IOException, DocumentException {
        //  1. 获取输入流
        FileInputStream fis = new FileInputStream("src/com/hllg/chap4/xmlAndJson/person.xml");
        //  2. 创建xml读取对象
        SAXReader sr = new SAXReader();
        //  3. 读取并得到文档对象
        Document doc = sr.read(fis);
        //  4. 通过文档获取跟元素
        Element root = doc.getRootElement();
        //  5.开始解析元素，读取元素名称
        System.out.println(root.getName());
        //只能获取到第一个匹配的
        Element person = root.element("person");
        Element name = person.element("name");
        System.out.println(name.getText());
        System.out.println("-----------------------");
        //获取所有根下的元素
        List<Element> es = root.elements();
        for (int i = 0; i < es.size(); i++) {
            //遍历根下所有的子元素
            Element persons = es.get(i);
            //person节点id属性的值
            System.out.println(persons.attributeValue("id"));
            //person节点name元素的值
            System.out.println(persons.elementText("name"));
            System.out.println(persons.elementText("sex"));
            System.out.println(persons.elementText("info"));
            System.out.println("-----------------------");
        }
        System.out.println("------------------------");

        //  6. 用完关流
        fis.close();
        // 异常信息，非法反射，jdk版本过高，降到1.8就没有了
    }
}
