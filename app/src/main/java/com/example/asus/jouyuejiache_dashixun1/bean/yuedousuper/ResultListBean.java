package com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper;

public class ResultListBean {
    /**
     * code : M00011
     * name : 礼卡礼券
     * fatherid : null
     * id : 11
     */

    private String code;
    private String name;
    private Object fatherid;
    private int id;
    private boolean isSelcted;

    public boolean isSelcted() {
        return isSelcted;
    }

    public void setSelcted(boolean selcted) {
        isSelcted = selcted;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getFatherid() {
        return fatherid;
    }

    public void setFatherid(Object fatherid) {
        this.fatherid = fatherid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
