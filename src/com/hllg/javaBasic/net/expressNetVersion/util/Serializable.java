package com.hllg.javaBasic.net.expressNetVersion.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author HLLG
 * @version 1.0
 * @create 02/02/2021  16:59
 */
public class Serializable {
    public static void serialize(Object o, String filename) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        oos.writeObject(o);
        oos.close();
    }

    public static Object deserialize(String filename) throws IOException, ClassNotFoundException {
        Object o = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            o = ois.readObject();
        } catch (EOFException e) {
            o = Collections.synchronizedList(new ArrayList<>());
        }
        return o;
    }
}
