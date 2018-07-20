package com.example.asus.jouyuejiache_dashixun1.utils;

/**
 * 全局变量
 *
 * @author gaobingbing
 */
public class Const {

    /** 一小时的毫秒数 */
    public static final int HOUR = 60*60*1000;
    /** 一天的毫秒数 */
    public static final int DAY = 24*HOUR;
    /** 请求数据缓存失效时间 默认1小时 */
    public static final int CACHE_RETAIN_TIME = 60*60;
    /** Assets路径 */
    public static final String ASSETS_ROOT = "file:///android_asset";
    /** Android端 */
    public static final String PHONE_TYPE = "1501";
    public static final String SP_TOURIST = "sp_tourist";
    public static final String DEFAULT_CITY_CODE = "131000";
    public static final String DEFAULT_CITY_NAME = "廊坊市";
//    public static LoginInfoBean loginInfo;
//    public static String personType = ConstEnum.STUDENT;
    /** 保存电话的key */
    public static final String SAVEPHONE = "savephone";
    /** 保存引导页头像key */
    public static final String SAVEICON = "saveicon";
    /** 保存引导页驾校ID key */
    public static final String SAVESCHOOLID= "saveschoolid";
    /**城市ID*/
    public static String cityCode=Const.DEFAULT_CITY_CODE;
    /**保存用户提现选择*/
    public static final String SAVEWALLET="savewallet";
    /**一键开团手动选择的经度*/
    public static double longitude_group ;
    /**一键开团手动选择维度*/
    public static double latitude_group ;
}
