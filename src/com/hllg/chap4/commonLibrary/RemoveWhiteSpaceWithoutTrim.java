package com.hllg.chap4.commonLibrary;

/**
 * @author HLLG
 * @version 1.0
 * @create 27/01/2021  17:23
 */
public class RemoveWhiteSpaceWithoutTrim {
    public static void main(String[] args) {
        removeWhiteSpace();
    }

    /**
     * 移除首尾空格
     */
    public static void removeWhiteSpace() {
        StringBuffer quotation = new StringBuffer();
        quotation.append("\"");
        String text = "    你好    你好       ";
        int start = extractedBegin(text);
        int end = extractedLast(text);
        String complete = text.substring(start, end + 1);
        quotation.append(complete);
        quotation.append("\"");
        System.out.println(quotation);
    }

    /**
     * 首部遍历到第一个不为空格的位置
     * @param text
     * @return
     */
    private static int extractedBegin(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                return i;
            }
        }
        return 0;
    }

    /**
     * 尾部遍历到第一个不为空格的位置
     * @param text
     * @return
     */
    private static int extractedLast(String text) {
        for (int i = text.length() - 1; i >= 0; i--) {
            if (text.charAt(i) != ' ') {
                return i;
            }
        }
        return 0;
    }

}
