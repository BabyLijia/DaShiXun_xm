package com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper;

import java.util.List;

public class CarSupperBean {

    /**
     * result : null
     * total : 4
     * code : 200
     * message :
     * resultList : [{"phone":"80445099","name":"华晨二手车","id":4,"sort":101,"city_id":131000},{"phone":"80445099","name":"万尤卡新车","id":1,"sort":100,"city_id":131000},{"phone":"18832654444","name":"金源车行","id":41,"sort":100,"city_id":131000},{"phone":"15100638455","name":"祥瑞车行","id":53,"sort":100,"city_id":131000}]
     */

    private Object result;
    private int total;
    private int code;
    private String message;
    private List<ResultListBean> resultList;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
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
