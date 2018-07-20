package com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.adapter.Shouye_Recycl_YDAdapter;
import com.example.asus.jouyuejiache_dashixun1.adapter.Shouye_YDSuperLVAdapter;
import com.example.asus.jouyuejiache_dashixun1.adapter.carsupper_adapter.CarSupper_YouAdapter;
import com.example.asus.jouyuejiache_dashixun1.adapter.carsupper_adapter.CarSupper_ZuoAdapter;
import com.example.asus.jouyuejiache_dashixun1.base.BaseActivity;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.CarSupperBean;
import com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.car_you1.HuaChengCar1;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.ResultListBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.SuperLVBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.LiKaLiJuanBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.ListBean;
import com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.callsupper_mvp.CallSupper_Contract;
import com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.callsupper_mvp.CallSupper_Presenter;
import com.example.asus.jouyuejiache_dashixun1.carsupper_mudel4.callsupper_mvp.Callsupper_Model;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoumvp.YueDouContract;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoumvp.YueDouModel;
import com.example.asus.jouyuejiache_dashixun1.yuedou_mudel2.yuedou.yuedoumvp.YueDouPresenter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class First_CarSupperActivity extends BaseActivity<CallSupper_Presenter,Callsupper_Model> implements CallSupper_Contract.View {

    @BindView(R.id.mlv)
    ListView mlv;
    @BindView(R.id.mtv_tiaomu)
    TextView mtvTiaomu;
    @BindView(R.id.mXRecycl)
    XRecyclerView mXRecycl;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.med_chengshi)
    EditText medChengshi;
    private List<String> mlist = new ArrayList<>();
    //定义一个成员集合并传入适配器，获取到数据之后将请求的集合添加到传入适配器的集合当中，再此之前需清空集合
    //好处是，避免重复请求数据
    //左集合
    private List<com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.
            ResultListBean> mzuolist = new ArrayList<>();
    //右集合

    private List<com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.car_you1.ListBean> mYoulist=new ArrayList();
    private CarSupper_YouAdapter carSupper_youAdapter;

    @OnClick(R.id.img_back)
    public void onClick() {
        finish();
    }

    @Override
    public void getCarSupper_zuoV(CarSupperBean carSupperBean) {
        List<com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.ResultListBean> resultList = carSupperBean.getResultList();
        mzuolist.addAll(resultList);
        mzuolist.get(0).setSelcted(true);
        final CarSupper_ZuoAdapter carSupper_zuoAdapter= new CarSupper_ZuoAdapter(mzuolist, First_CarSupperActivity.this);
        mlv.setAdapter(carSupper_zuoAdapter);
        mlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < mzuolist.size(); i++) {
                    mzuolist.get(i).setSelcted(false);
                }
                mzuolist.get(position).setSelcted(true);
                carSupper_zuoAdapter.notifyDataSetChanged();
                //4使用自定义泛型是String的集合的索引发起再次请求
                //因为我需要点击自定义string的集合（每条Item地址）来显示对应我右边的数据
                String s = mlist.get(position);
                mPresenter.getCarSupper_you(s);
            }
        });
    }

    @Override
    public void getCarSupper_youV(HuaChengCar1 huaChengCar1) {
        mYoulist.clear();
        List<com.example.asus.jouyuejiache_dashixun1.bean.shouye_car_supper.car_you1.ListBean> succes_youlist = huaChengCar1.getResultList().getList();
        mYoulist.addAll(succes_youlist);
        carSupper_youAdapter.notifyDataSetChanged();
        String name = succes_youlist.get(0).getName();
        Log.e("TAG", name );
    }

    @Override
    protected void initData() {
        ButterKnife.bind(this);
        LinearLayoutManager xLinearLayoutManager = new LinearLayoutManager(this);
        //xLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecycl.setLayoutManager(xLinearLayoutManager);
        mXRecycl.setRefreshProgressStyle(ProgressStyle.BallZigZag); //设定下拉刷新样式
        mXRecycl.setLoadingMoreProgressStyle(ProgressStyle.BallZigZag);//设定上拉加载样式
        mPresenter.getCarSupper_zuoP("https://api.dyhoa.com/dapi/v4/car?phone=&timestamp=1531732444&terminal=1601&sign=04051446782d1d64f6b5df7e1923b30c&mid=0&signature=7df16219c02492622ef5e95561f3a66898e51947&os=1501&nonceStr=a36b598abb934e4528412e5a2127b931&version=3.6.8.9");
        //1、自定义集合添加地址
        initDataList();
        //2.使用集合获取到第1个索引的变量写Recycl适配器
        String s = mlist.get(0);
        Log.e("TAGs", s.toString());

        carSupper_youAdapter = new CarSupper_YouAdapter(mYoulist, First_CarSupperActivity.this);
        mXRecycl.setAdapter(carSupper_youAdapter);
        carSupper_youAdapter.setMyCallBack(new Shouye_Recycl_YDAdapter.MyCallBack() {
            @Override
            public void getData(int id) {

            }
        });
    }

    private void initDataList() {
        mlist.add("https://api.dyhoa.com/dapi/v4/car/carList?nextPage=1&terminal=1601&sign=fd9d4c227184049f54ffa5a9b162f6f8&mallId=4&signature=f33b08a8772b278bc21f5260953c4a1e8c3240d7&pageSize=10&version=3.6.8.9&phone=&timestamp=1531732444&os=1501&nonceStr=3a15c7d0bbe60300a39f76f8a5ba6896");
        mlist.add("https://api.dyhoa.com/dapi/v4/car/carList?nextPage=1&terminal=1601&sign=eca119220ad320bed0130279269c188b&mallId=1&signature=fdbf395c23501331c9feeb98f187435e782e8127&pageSize=10&version=3.6.8.9&phone=&timestamp=1531732674&os=1501&nonceStr=61c66a2f4e6e10dc9c16ddf9d19745d6");
        mlist.add("https://api.dyhoa.com/dapi/v4/car/carList?nextPage=1&terminal=1601&sign=2bc03d97f530a7709a98f1e43697b91d&mallId=41&signature=1ed1d43f3f583af4e4469e4b77918e1b683f3a81&pageSize=10&version=3.6.8.9&phone=&timestamp=1531732731&os=1501&nonceStr=43cf3ae60279360eab2d678461a565c3");
        mlist.add("https://api.dyhoa.com/dapi/v4/car/carList?nextPage=1&terminal=1601&sign=fb88aa9746ae72876b6c63ad173062f5&mallId=53&signature=0a6efb19a7cbdb77458b440a320967de57404910&pageSize=10&version=3.6.8.9&phone=&timestamp=1531732768&os=1501&nonceStr=0f49c89d1e72");
    }

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_first__car_supper;
    }
}
