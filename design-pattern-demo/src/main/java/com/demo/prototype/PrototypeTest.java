package com.demo.prototype;

import java.io.*;

/**
 * PrototypeTest 浅拷贝
 *
 * @author gnl
 */

public class PrototypeTest {
    public static void main(String[] args) {
        PrototypeUser user1 = new PrototypeUser("zss", "123456", new PrototypeDepartment("1", "java"));
        PrototypeUser user2 = (PrototypeUser) user1.deepCloneV2();

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1 == user2);
        System.out.println(user1.getUsername() == user2.getUsername());
        System.out.println(user1.getDepartment() == user2.getDepartment());

    }
}

class PrototypeUser implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private PrototypeDepartment department;

    public PrototypeUser() {
    }

    public PrototypeUser(String username, String password, PrototypeDepartment department) {
        this.username = username;
        this.password = password;
        this.department = department;
    }

    public PrototypeDepartment getDepartment() {
        return department;
    }

    public void setDepartment(PrototypeDepartment department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 浅拷贝
     */
    @Override
    protected Object clone() {

        PrototypeUser clone = null;

        try {
            // 完成基本数据类型的克隆
            clone = (PrototypeUser) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    /**
     * 深拷贝
     */
    protected Object deepClone() {
        PrototypeUser clone = null;
        try {
            // 完成基本数据类型的克隆
            clone = (PrototypeUser) super.clone();
            // 对引用类型的属性进行单独处理
            clone.department = (PrototypeDepartment) department.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    /**
     * 序列化方式实现深拷贝
     */
    protected Object deepCloneV2() {
        PrototypeUser clone = null;

        // 创建流对象
        ByteArrayOutputStream baos = null;
        ByteArrayInputStream bais = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try {
            // 1. 先序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);

            // 2. 将当前对象以流的形式输出
            oos.writeObject(this);

            // 3. 反序列化
            bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            clone = (PrototypeUser) ois.readObject();
            return clone;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                baos.close();
                bais.close();
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public String toString() {
        return "PrototypeUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", department=" + department +
                '}';
    }
}

class PrototypeDepartment implements Cloneable, Serializable {

    private static final long serialVersionUID = 2L;

    private String id;
    private String name;

    public PrototypeDepartment() {
    }

    public PrototypeDepartment(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PrototypeDepartment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
