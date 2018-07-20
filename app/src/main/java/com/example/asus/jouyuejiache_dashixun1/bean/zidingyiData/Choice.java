package com.example.asus.jouyuejiache_dashixun1.bean.zidingyiData;

public class Choice {
    private String name;
    private int img;

    public Choice() {
    }

    public Choice(String name, int img) {

        this.name = name;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "name='" + name + '\'' +
                ", img=" + img +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {

        return name;
    }

    public int getImg() {
        return img;
    }
}
