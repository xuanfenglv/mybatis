package model;

import com.alibaba.fastjson.JSON;

/**
 * @Author:Lvxingqing
 * @Description:
 * @Date:Create in 13:58 2018/5/30
 * @Modified By:
 */
public class User {
    private int id;
    private String name;
    private byte age;

    public User() {
    }

    public User(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
