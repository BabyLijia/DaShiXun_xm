package com.example.asus.jouyuejiache_dashixun1.bean.jiaxiaoCar;

public class ScoolCar {
    private String name;
    private String registered;
    private int img;
    private String ground;

    public ScoolCar() {
    }

    @Override
    public String toString() {
        return "ScoolCar{" +
                "name='" + name + '\'' +
                ", registered='" + registered + '\'' +
                ", img='" + img + '\'' +
                ", ground='" + ground + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public ScoolCar(String name, String registered, int img, String ground) {

        this.name = name;
        this.registered = registered;
        this.img = img;
        this.ground = ground;
    }
}
