package com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper;

import java.util.List;

public class SuperLVBean {

    /**
     * result : {"happyDou":0}
     * total : 11
     * code : 200
     * message :
     * resultList : [{"code":"M00011","name":"礼卡礼券","fatherid":null,"id":11},{"code":"M00012","name":"数码产品","fatherid":null,"id":12},{"code":"M00021","name":"休闲小食品","fatherid":null,"id":21},{"code":"M00013","name":"家居家访","fatherid":null,"id":13},{"code":"M00014","name":"厨房电器","fatherid":null,"id":14},{"code":"M00015","name":"男士专用","fatherid":null,"id":15},{"code":"M00016","name":"精致女人","fatherid":null,"id":16},{"code":"M00017","name":"日用电器","fatherid":null,"id":17},{"code":"M00019","name":"智能生活","fatherid":null,"id":19},{"code":"M00022","name":"日用洗涤","fatherid":null,"id":22},{"code":"M00023","name":"酒水饮料","fatherid":null,"id":23}]
     */

    private ResultBean result;
    private int total;
    private int code;
    private String message;
    private List<ResultListBean> resultList;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultListBean> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultListBean> resultList) {
        this.resultList = resultList;
    }
}
