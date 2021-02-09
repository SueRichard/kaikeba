package com.hllg.chap4.net.expressNetVersion.util;

import com.hllg.chap4.net.expressNetVersion.entity.Express;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author HLLG
 * @version 1.0
 * @time 2021/02/07  Sun  21:50
 * 进行文件的写入写出
 */
public class IOUtils {
    private static File file = new File("com/hllg/chap4/net/expressNetVersion/data.txt");

    public static void writeToFile(List<Express> list) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Express> readFromFile() {
        if (!file.exists() || file.length() == 0) return Collections.synchronizedList(new ArrayList<>());
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Express>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.synchronizedList(new ArrayList<>());
    }
}
