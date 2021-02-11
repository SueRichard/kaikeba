package com.hllg.javaBasic.commonLibrary;

/**
 * @author HLLG
 * @version 1.0
 * @create 27/01/2021  16:21
 */
public class ExtractInfoFromString {
    /**
     * 提取字符串中的信息到实体类
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "name=王五 age=18 classNum=1101";
        String[] temp = s.split(" ");
        Student student = new Student();
        for (int i = 0; i < temp.length; i++) {
            String[] value = temp[i].split("=");
            if (value[0].equals("name")) {
                student.setName(value[1]);
            } else if (value[0].equals("age")) {
                student.setAge(Integer.parseInt(value[1]));
            } else if (value[0].equals("classNum")) {
                student.setClassNum(Integer.parseInt(value[1]));
            }
        }
        System.out.println(student.toString());
    }
}
