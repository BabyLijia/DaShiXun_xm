package com.example.asus.jouyuejiache_dashixun1.service;


import com.example.asus.jouyuejiache_dashixun1.bean.SheQuBean;
import com.example.asus.jouyuejiache_dashixun1.bean.jiakaoer.KeerBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.CarSupperBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.car_you1.HuaChengCar1;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.Xq_CarBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_carxq.carxq_reimen.RmBanZhiBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_toutiao_genduo.ResultListBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_toutiao_genduo.Shouye_Tt_gengduo;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.SuperLVBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.LiKaLiJuanBean;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

public interface ApiService {
    @GET
    Observable<ResponseBody> getPostData(@Url String url);

    //科二数据请求
    @GET
    Observable<KeerBean> getKeErData(@Url String url);

    //社区最新数据请求 https://api.dyhoa.com/dapi/v4/bbs/articleList?nextPage=1&terminal=1601&sign=b37c6323cb1960b2e2ce292647f12c2e&mid=21671&signature=1190f025ba715af00d27cd89545f7b08a44ed08f&pageSize=20&version=3.6.8.9&phone=18201222438&timestamp=1530782460&type=2&os=1501&nonceStr=70117ee3c0b15a2950f1e82a215e812b
    @GET
    Observable<ResponseBody> getSheQuZuiXin(@Url String url);

    //悦豆商场左LV https://api.dyhoa.com/dapi/v4/mall
    @GET
    Observable<SuperLVBean> getSuper(@Url String url);

    //悦豆商场右LV1 https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=bad6045f74be22701cca6caee2a16f38&signature=8aa6882f38aae1d39a26d26149834f7fb3e52f03&categoryId=11&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530752569&os=1501&nonceStr=5513c36e7c334dd20ab0ffeac130dca8
    @GET
    Observable<LiKaLiJuanBean> getLiJuan(@Url String url);

    //1驾校详情car https://api.dyhoa.com/dapi/v4/school/schoolDetail?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=27ed0fb950b856b06e1273989422e7d3&version=3.6.8.9&sign=fcf8f1f989a48c42c8346d6c3d1e0f75&timestamp=1531328713&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=188&mid=&signature=e103837547c9fb1848962d9de1ad861083ac6bc4
    @GET
    Observable<Xq_CarBean> getCarXq(@Url String url);

    //2热门班制 https://api.dyhoa.com/dapi/v4/course/getCourseList?os=1501&phone=&cityId=110000&imei=863254010682473&nonceStr=4671aeaf49c792689533b00664a5c3ef&version=3.6.8.9&sign=0644ff5cc2a7c77c55fb12248642f8c0&timestamp=1531328713&terminal=1601&longitude=110.260994&latitude=36.342678&schoolId=188&mid=&signature=daf9039bcf48a611290f789e687399fe1b78b29f
    @GET
    Observable<RmBanZhiBean> getCar_Rm(@Url String url);

    //首页 九悦头条 更多 https://api.dyhoa.com/dapi/v4/article/list
    @GET
    Observable<Shouye_Tt_gengduo> gettoutiao_Gd(@Url String url);

    //首页 汽车超市 左
    @GET
    Observable<CarSupperBean> getCarSupper_zuo(@Url String url);

    @GET
    Observable<HuaChengCar1> getCarSupper_you1(@Url String url);
}
