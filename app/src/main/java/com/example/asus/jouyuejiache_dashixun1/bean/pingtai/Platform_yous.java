package com.example.asus.jouyuejiache_dashixun1.bean.pingtai;

public class Platform_yous {
    private String title;
    private String massege;
    private int img;

    public void setImg(int img) {
        this.img = img;
    }

    public int getImg() {

        return img;
    }

    public Platform_yous(String title, String massege, int img) {

        this.title = title;
        this.massege = massege;
        this.img = img;
    }

    @Override
    public String toString() {
        return "Platform_yous{" +
                "title='" + title + '\'' +
                ", massege='" + massege + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }


    public Platform_yous() {

    }
}
