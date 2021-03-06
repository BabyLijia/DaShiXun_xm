package com.example.asus.jouyuejiache_dashixun1.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ChengShiQieHuan {

    private static Map<String,String> mMap=new HashMap<>();
    private static String name;
    private static ChengShiQieHuan chengShiQieHuan;

    private ChengShiQieHuan() {
        initData();
    }

    public static ChengShiQieHuan getChengShiQieHuan() {
        if(chengShiQieHuan==null){
            synchronized (ChengShiQieHuan.class){
                chengShiQieHuan=new ChengShiQieHuan();
            }
        }
        return chengShiQieHuan;
    }

    private static void initData(){
        mMap.clear();
        mMap.put("宝鸡市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=110000&imei=358882010140233&nonceStr=f056bfa71038e04a2400266027c169f9&version=3.6.8.9&sign=27f5f13eaf637d159dd867e604af64cc&timestamp=1531187663&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=a07e7d8965b30f5f8128cc6b4d87f916aea3fb7e");
        mMap.put("北京市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=110000&imei=358882010140233&nonceStr=5e7d00134ba3a8b3e37edf5038bc51fc&version=3.6.8.9&sign=6856dd76d74bc9a5698d85de488c0677&timestamp=1531187889&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=42222a85dd1cd893b01c26d6ed575df4b25f79d1");
        mMap.put("保定市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=130600&imei=358882010140233&nonceStr=c1502ae5a4d514baec129f72948c266e&version=3.6.8.9&sign=772d0dbf51272d9a1bd33402eacb0d9b&timestamp=1531187944&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=4cbbc08833cc651b0115d2bb0bbb1762f16e5521");
        mMap.put("沧州市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=130900&imei=358882010140233&nonceStr=a223c6b3710f85df22e9377d6c4f7553&version=3.6.8.9&sign=9beccaa7b6840d4e396a5364d337139e&timestamp=1531188118&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=1fd0945688c87681ea10df83affc93eb30465ca0");
        mMap.put("邯郸市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=130400&imei=358882010140233&nonceStr=d58e2f077670f4de9cd7963c857f2534&version=3.6.8.9&sign=d36efc834a961bea73dfd0730ae28b5a&timestamp=1531188149&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=175a258ecbbdbeae8ee3747df2ad5b133a8fa580");
        mMap.put("呼和浩特市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=150100&imei=358882010140233&nonceStr=4845b84d63ea5fa8df6268b8d1616a8f&version=3.6.8.9&sign=99a361f05216d5573f0fe464faa2dcc7&timestamp=1531188176&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=335f21a22ba3e0b4d2b3d75d1e614f8de1e6bc40");
        mMap.put("衡水市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=131100&imei=358882010140233&nonceStr=7501e5d4da87ac39d782741cd794002d&version=3.6.8.9&sign=a2bab8095e6b70b8df769d6550bc7b6b&timestamp=1531188220&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=f1fd883d3ab46c79d7c7f1b5d134583d89ce5da6");
        mMap.put("济南市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=370100&imei=358882010140233&nonceStr=8526e0962a844e4a2f158d831d5fddf7&version=3.6.8.9&sign=6e9ab120ac9e6fb80dc2a416f89d6f12&timestamp=1531188258&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=a6b2b7d01fa1078cb2557c290ea4bb245b44584c");
        mMap.put("晋中市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=140700&imei=358882010140233&nonceStr=b710915795b9e9c02cf10d6d2bdb688c&version=3.6.8.9&sign=3a995442c91706530c88a04a1f7ea441&timestamp=1531188401&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=21752f479df2401fe1fcd3154027a94a28c44703");
        mMap.put("昆明市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=530100&imei=358882010140233&nonceStr=ac9edbbe0533cef12e50fd6fb6cfde52&version=3.6.8.9&sign=a9b6ae012e0188a8941fb0b70f7441a4&timestamp=1531188445&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=64b448e2cf44276e52e2f2be527c8f876094e575");
        mMap.put("廊坊市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=131000&imei=358882010140233&nonceStr=8aa2c95dc0a6833d2d0cb944555739cc&version=3.6.8.9&sign=b7507856ca421d8e48fee6be114b314a&timestamp=1531188511&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=4df862a73a06151ad69d18ae8b4d64f6397a3e23");
        mMap.put("南京市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=320100&imei=358882010140233&nonceStr=700a4d3e9b7edabf9e4b69008b0718d6&version=3.6.8.9&sign=3554202d7be140ea1254d9ac4aa276be&timestamp=1531188582&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=f74cf0e3ce95b5490462a51a610c542e3d8b7e08");
        mMap.put("秦皇岛市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=130300&imei=358882010140233&nonceStr=7e8d7e5ccbddfd9576be61e3ab86aa73&version=3.6.8.9&sign=86b98212f69070b737e2a32cb6382128&timestamp=1531189309&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=155c510f4bab012305d9fa032bf20c8796500eaf");
        mMap.put("石家庄市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=130100&imei=358882010140233&nonceStr=1b38735595369838f208dd2b25315195&version=3.6.8.9&sign=13555a1ebff044ef0cd2960444c5cae3&timestamp=1531189359&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=f76dd6211c4f52601e6d270d9ac692c7d3bf374e");
        mMap.put("上绕市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=361100&imei=358882010140233&nonceStr=7f39f8317fbdb1988ef4c628eba02591&version=3.6.8.9&sign=df31ecd339465ae974c40fb6310b67ea&timestamp=1531189385&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=898649ad77ada8c3dda539f91dfd2b61ce0048a5");
        mMap.put("太原市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=140100&imei=358882010140233&nonceStr=95c8f422f9c3308d391cbcefae21d5ad&version=3.6.8.9&sign=0ef8b6fa9331791d7095ad08a9f70fbd&timestamp=1531189413&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=b2fa0b6cbb7c57ad7fe5a0cf0638063167d21e55");
        mMap.put("唐山市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=130200&imei=358882010140233&nonceStr=8606f35ec6c77858dfb80a385d0d1151&version=3.6.8.9&sign=6988e5b0db622b2b163b00f0f7d51399&timestamp=1531189658&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=f6e373470d0fe93aafb7384f78e10b5c352c6df3");
        mMap.put("武汉市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=420100&imei=358882010140233&nonceStr=d958628e70134d9e1e17499a9d815a71&version=3.6.8.9&sign=c72ec4611b3d50789a97a81f3951abea&timestamp=1531189682&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=fe70a51e21e5e8e0e849be27c47814cda0d99a18");
        mMap.put("武威市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=620600&imei=358882010140233&nonceStr=73d915c91b99b170993ea97d875a6330&version=3.6.8.9&sign=7dfba32abbd6ab1b23452132bd09b540&timestamp=1531189707&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=6909906ca3da9f579ed7e1d0dbfb7e20b855aa74");
        mMap.put("邢台市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=130500&imei=358882010140233&nonceStr=7cc538b1337957dae283c30ad46def38&version=3.6.8.9&sign=687d35f4f5f7a7cdd3b5189972f4f97f&timestamp=1531189750&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=ab4b239f6ad4ea0aaf67da422fde8e4a3d0b1901");
        mMap.put("西安市","dapi/v4?os=1501&model=GT-I9220&phone=&cityId=610100&imei=358882010140233&nonceStr=0d352b4d3a317e3eae221199fdb49651&version=3.6.8.9&sign=7b995a52340735a42d898b34ae961816&timestamp=1531189817&terminal=1601&push_id=AlgGPGMqrwtTypTmAfiLykn11H6EiT8aYWK3BidNOvwO&longitude=105.594475&mid=&latitude=25.528372&signature=256bb7824cf690c327ba0c818bf82ab92da864c3");
    }
    private boolean isboos=false;
    public String getData(String name1){
        if(mMap.size()>0){
            Set<String> strings = mMap.keySet();
            for (String string : strings) {
                if(string.equals(name1)){
                    isboos=true;
                    break;
                }
            }
            if(isboos){
                name = mMap.get(name1);
            }else {
                name = "a";
            }
        }
        return name;
    }
}
