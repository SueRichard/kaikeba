package com.hllg.chap4.io;

import java.io.*;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  15:04
 */
public class TryWithResources {
    public static void main(String[] args) throws FileNotFoundException {
        //1.7,它会自动关闭
        //try()里的必须实现Closeable/AutoCloseable
//        try(FileReader fr = new FileReader("l://a.txt")){
//            int c = fr.read();
//            System.out.println((char)c);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        //1.9优化
//        FileReader fr = new FileReader("l://a.txt");
//        PrintWriter pw = new PrintWriter("l://a.txt");
//        //多个资源分号隔开，使用完成后自动关闭
//        try (fr; pw) {
//            int c = fr.read();
//            System.out.println((char) c);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //-------------------
        CloseDemo cd = new CloseDemo();
        try (cd) {

        } catch (Exception e) {
        }

    }

    /**
     * 必须实现Closeable/AutoCloseable，放入try小括号才不会报错
     */
    static class CloseDemo implements Closeable {
        @Override
        public void close() throws IOException {
            System.out.println("close方法被调用");
        }
    }
}
