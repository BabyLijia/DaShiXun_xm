package com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq;

import java.util.List;

public class ResultBean {
    /**
     * area_name : 昌平区
     * latitude : 40.184026
     * num : 1个训练场
     * icon : null
     * is_auth : 0
     * range : 距您685.0公里
     * share_descs : 微笑服务，技术一流，用心教学，快速拿本。
     * content : <p>北京北方汽车驾驶学校有限公司成立于1993年3月，位于北京市昌平区马池口，京北车辆管理所西侧，毗邻京昌八达岭高速路，驱车从德胜门出发走京昌高速仅20分钟车程就能到达。北方驾校一直秉承着“专业、专注、专心、专长”的教学传统，精心致力于合格驾驶员的培训工作。</p><p>北方驾校多次被社会各界授予殊荣：1998年首都职工喜爱的“十佳驾校”，1999年消费者心目中的“首选驾校”，2000年北京青年报读者心目中的“明星驾校”；历年被昌平区教育局评为“社会力量办学先进单位”2005年被《劳动午报》评为“首都名牌驾校”……所有这些都诠释着北方人以自己实际行动树立起京城驾校行业闪亮的名牌形象。</p><p>“一切为了学员”是北方驾校不变的教学宗旨；“确保教学质量、培训合格驾驶员”是北方人孜孜以求的奋斗目标；“高素质的管理人才、优秀的教练队伍”是北方驾校坚实的基础；“加强廉政、文明教学”是北方驾校廉洁自律的有利保证。</p>
     * rateCount : 0
     * feature : ["免费班车","明星驾校","十佳驾校"]
     * enrollNum : 954
     * little_url : null
     * id : 188
     * schoolImgList : [{"name":"","id":4088,"url":"http://misc.dyhoa.com/20171115/bee434b8-d02c-4627-8d16-053fbc6d04f0.jpg"}]
     * longitude : 116.232056
     * address : 昌平区满白路一号
     * star : 5
     * icon2 : http://misc.dyhoa.com/20171115/30f756f8-c51f-4df8-8491-c24693449a83.jpg
     * share_title : 老铁，分享给你一个超级棒的驾校
     * isConcern : 1
     * rateList : []
     * share_url : http://api.dyhoa.com/dh5/school?schoolId=188&longitude=110.260994&latitude=36.342678
     * name : 北方驾校
     * short_name : null
     * location : {"address":"昌平区满白路一号","distance":"最近训练场685.0公里","locationImg":["http://misc.dyhoa.com/20171115/68c30dcc-1d14-4bee-9ed8-ba33bfe3b526.jpg","http://misc.dyhoa.com/20171115/4e100a19-35a9-4ee7-b4f9-2f2bb6392d4d.jpg"],"latitude":40.184026,"name":"北方驾校训练场","longitude":116.232056}
     * signUpNum : 0
     * is_pay : 1
     */

    private String area_name;
    private String latitude;
    private String num;
    private Object icon;
    private int is_auth;
    private String range;
    private String share_descs;
    private String content;
    private int rateCount;
    private int enrollNum;
    private Object little_url;
    private int id;
    private String longitude;
    private String address;
    private int star;
    private String icon2;
    private String share_title;
    private int isConcern;
    private String share_url;
    private String name;
    private Object short_name;
    private LocationBean location;
    private int signUpNum;
    private int is_pay;
    private List<String> feature;
    private List<SchoolImgListBean> schoolImgList;
    private List<?> rateList;

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Object getIcon() {
        return icon;
    }

    public void setIcon(Object icon) {
        this.icon = icon;
    }

    public int getIs_auth() {
        return is_auth;
    }

    public void setIs_auth(int is_auth) {
        this.is_auth = is_auth;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getShare_descs() {
        return share_descs;
    }

    public void setShare_descs(String share_descs) {
        this.share_descs = share_descs;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRateCount() {
        return rateCount;
    }

    public void setRateCount(int rateCount) {
        this.rateCount = rateCount;
    }

    public int getEnrollNum() {
        return enrollNum;
    }

    public void setEnrollNum(int enrollNum) {
        this.enrollNum = enrollNum;
    }

    public Object getLittle_url() {
        return little_url;
    }

    public void setLittle_url(Object little_url) {
        this.little_url = little_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getIcon2() {
        return icon2;
    }

    public void setIcon2(String icon2) {
        this.icon2 = icon2;
    }

    public String getShare_title() {
        return share_title;
    }

    public void setShare_title(String share_title) {
        this.share_title = share_title;
    }

    public int getIsConcern() {
        return isConcern;
    }

    public void setIsConcern(int isConcern) {
        this.isConcern = isConcern;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getShort_name() {
        return short_name;
    }

    public void setShort_name(Object short_name) {
        this.short_name = short_name;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public int getSignUpNum() {
        return signUpNum;
    }

    public void setSignUpNum(int signUpNum) {
        this.signUpNum = signUpNum;
    }

    public int getIs_pay() {
        return is_pay;
    }

    public void setIs_pay(int is_pay) {
        this.is_pay = is_pay;
    }

    public List<String> getFeature() {
        return feature;
    }

    public void setFeature(List<String> feature) {
        this.feature = feature;
    }

    public List<SchoolImgListBean> getSchoolImgList() {
        return schoolImgList;
    }

    public void setSchoolImgList(List<SchoolImgListBean> schoolImgList) {
        this.schoolImgList = schoolImgList;
    }

    public List<?> getRateList() {
        return rateList;
    }

    public void setRateList(List<?> rateList) {
        this.rateList = rateList;
    }
}
