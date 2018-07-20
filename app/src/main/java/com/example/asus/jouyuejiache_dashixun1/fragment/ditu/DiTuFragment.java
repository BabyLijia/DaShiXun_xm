package com.example.asus.jouyuejiache_dashixun1.fragment.ditu;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.location.AMapLocation;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.utils.BaseUtils;
import com.example.asus.jouyuejiache_dashixun1.utils.SharedPreferencesUtil;

import java.util.ArrayList;


public class DiTuFragment extends Fragment implements PoiSearch.OnPoiSearchListener {

    SharedPreferencesUtil shareFile = BaseUtils.getShareFile();
    private MapView map;
    private AMap aMap;
    private PoiSearch.Query query;
    private PoiSearch poiSearch;
    MyLocationStyle myLocationStyle;

    public DiTuFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_di_tu, container, false);
        map = (MapView) inflate.findViewById(R.id.map);
        map.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = map.getMap();
        }
        initDitu();
        AMap.OnInfoWindowClickListener listener = new AMap.OnInfoWindowClickListener() {

            @Override
            public void onInfoWindowClick(Marker arg0) {

                arg0.setTitle("infowindow clicked");
            }
        };
//绑定信息窗点击事件
        aMap.setOnInfoWindowClickListener(listener);
        return inflate;
    }

    private void initDitu() {
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
//aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        String weizhi = String.valueOf(shareFile.getValueByKey("weizhi", ""));
        query = new PoiSearch.Query("北京市", "驾校");
        //keyWord表示搜索字符串，
//第二个参数表示POI搜索类型，二者选填其一，选用POI搜索类型时建议填写类型代码，码表可以参考下方（而非文字）
//cityCode表示POI搜索区域，可以是城市编码也可以是城市名称，也可以传空字符串，空字符串代表全国在全国范围内进行搜索
        query.setPageSize(10);// 设置每页最多返回多少条poiitem
        query.setPageNum(1);//设置查询页码
        poiSearch = new PoiSearch(getActivity(), query);
        poiSearch.setOnPoiSearchListener(this);
        poiSearch.searchPOIAsyn();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        map.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        map.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        map.onSaveInstanceState(outState);
    }

    @Override
    public void onPoiSearched(PoiResult poiResult, int i) {
        ArrayList<PoiItem> pois = poiResult.getPois();
        for (int j = 0; j < pois.size(); j++) {
            PoiItem poiItem = pois.get(j);
            Log.e("TAG", poiItem.getLatLonPoint().toString() + "--" + poiItem.getSnippet() + "--" + poiItem.getTitle());
            LatLonPoint latLonPoint = poiItem.getLatLonPoint();
            LatLng latLng = new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude());
            MarkerOptions markerOption = new MarkerOptions();
            markerOption.position(latLng);
            markerOption.title(poiItem.getTitle()).snippet(poiItem.getSnippet());

            markerOption.draggable(true);//设置Marker可拖动
            markerOption.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory
                    .decodeResource(getResources(),R.drawable.image_coordinates)));
           // markerOption.setFlat(true);//设置marker平贴地图效果
            Marker marker = aMap.addMarker(markerOption);
            marker.showInfoWindow();
        }
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    public interface InfoWindowAdapter {
        View getInfoWindow(Marker marker);
        View getInfoContents(Marker marker);
    }
    /**
     * 监听自定义infowindow窗口的infocontents事件回调
     */
    public View getInfoContents(Marker marker) {
        return null;
//示例没有采用该方法。
    }
    View infoWindow = null;

    /**
     * 监听自定义infowindow窗口的infowindow事件回调
     */
    public View getInfoWindow(Marker marker) {
        if(infoWindow == null) {
            infoWindow = LayoutInflater.from(getActivity()).inflate(
                    R.layout.custom_info_window, null);
        }
        render(marker, infoWindow);
        return infoWindow;
//加载custom_info_window.xml布局文件作为InfoWindow的样式
//该布局可在官方Demo布局文件夹下找到
    }

    /**
     * 自定义infowinfow窗口
     */
    public void render(Marker marker, View view) {
//如果想修改自定义Infow中内容，请通过view找到它并修改
    }

}
