package com.hllg.javaBasic.xmlAndJson;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/09  Tue  13:49
 */
public class GenerateXML {
    public static void main(String[] args) throws IOException {
        //  1. 通过文档帮助器创建一个空白文档
        Document doc = DocumentHelper.createDocument();
        //  2. 给文档添加第一个节点（根节点）
        Element wives = doc.addElement("wives");
        //  3. 通过根节点，丰富文档内容
        for (int i = 0; i < 100; i++) {
            Element wife = wives.addElement("wife");
            Element name = wife.addElement("name");
            name.setText("hl" + i + "号");
            Element say = wife.addElement("say");
            say.setText("喜欢你" + i + "次");
            //加""是为了转换成字符串；追加属性
            wife.addAttribute("id", 100 + i + "");
        }
        //  4. 创建一个文件输出输出流
        FileOutputStream fos = new FileOutputStream("com/hllg/javaBasic/xmlAndJson/hl.xml");
        //  5. 将文件输出流转换成XML输出流
        XMLWriter xw = new XMLWriter(fos);
        //  6. 写出文档
        xw.write(doc);
        //  7 . 释放资源
        xw.close();
        System.out.println("执行完毕");
    }
}
