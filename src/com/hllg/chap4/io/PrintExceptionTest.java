package com.hllg.chap4.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  13:46
 */
public class PrintExceptionTest {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            String t = null;
            //制造异常
            t.toString();
        }catch (Exception e){
            PrintWriter pw = new PrintWriter("l://bug.txt");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
            pw.println(sdf.format(new Date()));
         e.printStackTrace(pw);
         pw.close();
        }
    }
}
