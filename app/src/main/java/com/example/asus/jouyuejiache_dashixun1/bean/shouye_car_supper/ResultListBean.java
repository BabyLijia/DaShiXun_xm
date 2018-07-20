package com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper;

public class ResultListBean {
    /**
     * phone : 80445099
     * name : 华晨二手车
     * id : 4
     * sort : 101
     * city_id : 131000
     */

    private String phone;
    private String name;
    private int id;
    private int sort;
    private int city_id;
    private boolean isSelcted;

    public boolean isSelcted() {
        return isSelcted;
    }

    public void setSelcted(boolean selcted) {
        isSelcted = selcted;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }
}
