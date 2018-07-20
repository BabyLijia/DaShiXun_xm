package com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq;

import java.util.List;

public class LocationBean {
    /**
     * address : 昌平区满白路一号
     * distance : 最近训练场685.0公里
     * locationImg : ["http://misc.dyhoa.com/20171115/68c30dcc-1d14-4bee-9ed8-ba33bfe3b526.jpg","http://misc.dyhoa.com/20171115/4e100a19-35a9-4ee7-b4f9-2f2bb6392d4d.jpg"]
     * latitude : 40.184026
     * name : 北方驾校训练场
     * longitude : 116.232056
     */

    private String address;
    private String distance;
    private double latitude;
    private String name;
    private double longitude;
    private List<String> locationImg;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<String> getLocationImg() {
        return locationImg;
    }

    public void setLocationImg(List<String> locationImg) {
        this.locationImg = locationImg;
    }
}
