package com.hllg.chap4.xmlAndJson;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
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
public class ParseURLXML {
    public static void main(String[] args) throws IOException, DocumentException {
        String phone = "18205624169";
        URL url = new URL("http://apis.juhe.cn/mobile/get?phone=" + phone + "&dtype=xml&key=9f3923e8f87f1ea50ed4ec8c39cc9253");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        SAXReader sr = new SAXReader();
        Document doc = sr.read(is);
        Element root = doc.getRootElement();
        String resultCode = root.elementText("resultcode");
        //System.out.println(resultCode);
        if ("200".equals(resultCode)) {
            Element result = root.element("result");
            String province = result.elementText("province");
            String city = result.elementText("city");
            String zip = result.elementText("zip");
            String areaCode = result.elementText("areacode");
            String company = result.elementText("company");
            if (province.equals(city)) {
                System.out.println("你所在的城市是：" + city + "，邮编是：" + zip + "，区号是：" + areaCode + "，所属运营公司：" + company);
            } else {
                System.out.println("你所在的省份是：" + province + "，城市是：" + city + "，邮编是：" + zip + "，区号是：" + areaCode + "，所属运营公司：" + company);
            }
        } else {
            System.out.println("手机号输入有误");
        }
    }
}
