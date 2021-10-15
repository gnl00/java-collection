package com.demo.io;

import com.demo.bean.User;

import java.io.*;
import java.util.Arrays;

/**
 * ObjectOutInStreamTest
 *
 * @author gnl
 */

public class ObjectOutInStreamTest {
    public static void main(String[] args) {

        File file = new File("java-demo/src/main/resources/oos-write-test.txt");
        FileOutputStream fos = null;
        ByteArrayOutputStream bos = null;
        ByteArrayInputStream bis = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            fos = new FileOutputStream(file);
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);

            fos.write("Hello World".getBytes("UTF-8"));

            // 序列化
            oos.writeInt(1230);
            oos.writeUTF("asdff");
            oos.writeObject(new User("asss", "adsffzvc"));

            System.out.println(Arrays.toString(bos.toByteArray()));

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            // 反序列化
            // 读和写的类型顺序需要一致
            int inputInt = ois.readInt();
            String str = ois.readUTF();
            Object obj = ois.readObject();

            System.out.println(inputInt);
            System.out.println(str);
            System.out.println(obj);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // close...
        }
    }
}
