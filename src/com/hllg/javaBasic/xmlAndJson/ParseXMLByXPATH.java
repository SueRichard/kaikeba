package com.hllg.javaBasic.xmlAndJson;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021-2-9 13:17:23
 */
public class ParseXMLByXPATH {
    public static void main(String[] args) throws IOException, DocumentException {
        //  1. 获取输入流
        FileInputStream fis = new FileInputStream("com/hllg/javaBasic/xmlAndJson/person.xml");
        //  2. 创建xml读取对象
        SAXReader sr = new SAXReader();
        //  3. 读取并得到文档对象
        Document doc = sr.read(fis);
        //  4. 通过文档对象+XPATH查找所有name节点；注意集合类型
        List<Node> names = doc.selectNodes("//name");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i).getText());
        }
        System.out.println("--------------------");
        Node node = doc.selectSingleNode("//person[@id='002']//name");
        System.out.println(node.getName() + "：" + node.getText());
    }
}
