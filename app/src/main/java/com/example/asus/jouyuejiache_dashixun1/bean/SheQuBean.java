package com.example.asus.jouyuejiache_dashixun1.bean;

public class SheQuBean {
    private String img;
    private String eyes;
    private String times;
    private String massege;
    private String xinxi;
    private String zan;
    private String xin;

    @Override
    public String toString() {
        return "SheQuBean{" +
                "img='" + img + '\'' +
                ", eyes='" + eyes + '\'' +
                ", times='" + times + '\'' +
                ", massege='" + massege + '\'' +
                ", xinxi='" + xinxi + '\'' +
                ", zan='" + zan + '\'' +
                ", xin='" + xin + '\'' +
                '}';
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }

    public String getXinxi() {
        return xinxi;
    }

    public void setXinxi(String xinxi) {
        this.xinxi = xinxi;
    }

    public String getZan() {
        return zan;
    }

    public void setZan(String zan) {
        this.zan = zan;
    }

    public String getXin() {
        return xin;
    }

    public void setXin(String xin) {
        this.xin = xin;
    }

    public SheQuBean(String img, String eyes, String times, String massege, String xinxi, String zan, String xin) {

        this.img = img;
        this.eyes = eyes;
        this.times = times;
        this.massege = massege;
        this.xinxi = xinxi;
        this.zan = zan;
        this.xin = xin;
    }

    public SheQuBean() {

    }
}
