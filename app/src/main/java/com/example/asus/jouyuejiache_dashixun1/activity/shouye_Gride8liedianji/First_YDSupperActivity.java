package com.example.asus.jouyuejiache_dashixun1.activity.shouye_Gride8liedianji;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.jouyuejiache_dashixun1.R;
import com.example.asus.jouyuejiache_dashixun1.activity.First_LogActivity;
import com.example.asus.jouyuejiache_dashixun1.adapter.Shouye_Recycl_YDAdapter;
import com.example.asus.jouyuejiache_dashixun1.adapter.Shouye_YDSuperLVAdapter;
import com.example.asus.jouyuejiache_dashixun1.base.BaseActivity;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.ResultListBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.SuperLVBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.LiKaLiJuanBean;
import com.example.asus.jouyuejiache_dashixun1.bean.yuedousuper.likalijuan.ListBean;
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

public class First_YDSupperActivity extends BaseActivity<YueDouPresenter, YueDouModel> implements YueDouContract.View {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.mtv_yuedou)
    TextView mtvYuedou;
    @BindView(R.id.mtv_jilu)
    TextView mtvJilu;
    @BindView(R.id.med_chengshi)
    EditText medChengshi;
    @BindView(R.id.mlv)
    ListView mlv;
    @BindView(R.id.mtv_tiaomu)
    TextView mtvTiaomu;
    @BindView(R.id.mXRecycl)
    XRecyclerView mXRecycl;
    private List<String> mlist = new ArrayList<>();
    //定义一个成员集合并传入适配器，获取到数据之后将请求的集合添加到传入适配器的集合当中，再此之前需清空集合
    //好处是，避免重复请求数据
    private List<ListBean> listBeans = new ArrayList<>();

    Boolean mIsRefreshing;
    private Shouye_Recycl_YDAdapter shouye_recycl_ydAdapter;

    @Override
    public int getActivityLayoutId() {
        return R.layout.activity_first__ydsupper;
    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        /*mXRecycl.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        if (mIsRefreshing) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
        );*/
        LinearLayoutManager xLinearLayoutManager = new LinearLayoutManager(this);
        //xLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecycl.setLayoutManager(xLinearLayoutManager);
        mXRecycl.setRefreshProgressStyle(ProgressStyle.BallZigZag); //设定下拉刷新样式
        mXRecycl.setLoadingMoreProgressStyle(ProgressStyle.BallZigZag);//设定上拉加载样式
        mPresenter.getSuper_zuoP("https://api.dyhoa.com/dapi/v4/mall");
        //1、自定义集合添加地址
        initDataList();
        //2.使用集合获取到第1个索引的变量写Recycl适配器
        String s = mlist.get(0);
        Log.e("TAGs", s.toString());

        shouye_recycl_ydAdapter = new Shouye_Recycl_YDAdapter(listBeans, First_YDSupperActivity.this);
        mXRecycl.setAdapter(shouye_recycl_ydAdapter);
        shouye_recycl_ydAdapter.setMyCallBack(new Shouye_Recycl_YDAdapter.MyCallBack() {
            @Override
            public void getData(int id) {

            }
        });
    }

    private void initDataList() {

        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=bad6045f74be22701cca6caee2a16f38&signature=8aa6882f38aae1d39a26d26149834f7fb3e52f03&categoryId=11&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530752569&os=1501&nonceStr=5513c36e7c334dd20ab0ffeac130dca8");
        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=eab90cdfe6055b9e6bf05042a44c6ece&signature=b8349fbdaf039fc5a5ff9271f0303000370d05dd&categoryId=12&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530752665&os=1501&nonceStr=43f8e83d15ca083fb58e9b745e5de0d4");
        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=d3feedfa2296fdea2929993e8393fdcc&signature=0e4ccfa9ec0a11d4377e416f803c6f0ab113563d&categoryId=21&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530752732&os=1501&nonceStr=2aec405d4b5959235c49ec1d78edb0c2");
        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=3e9b48daa39e1055de40dd65ad424014&signature=aff890653c188a8c3fa72eee7695d09158518dbb&categoryId=13&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530752814&os=1501&nonceStr=8068fee5f49946b3a8f85b1007cd40bb");
        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=c9f0f7e11561fbec4e05e00965c8b8c7&signature=b6919e18067363d7b5fd2335dfac3338b132e731&categoryId=14&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530752855&os=1501&nonceStr=ee8374ec4e4ad797d42350c904d73077");
        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=1efb492116e7fece7753bc4ab0cdc667&signature=83f6ba42c465b22be873257a7e8c6652e430d61a&categoryId=15&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530752915&os=1501&nonceStr=a29d1598024f9e87beab4b98411d48ce");
        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=216d3d071ce20d33d76e0931cc3e3f54&signature=13a7da4784a5aa1213a33c800680b5531cbeafbf&categoryId=16&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530752954&os=1501&nonceStr=5d293363c4be77f134214bec786e2feb");
        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=9ced84694331e90a565a6cae395734f6&signature=ed9cb7e7273de3855cb20ce813122c69d2836679&categoryId=17&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530752986&os=1501&nonceStr=3636638817772e42b59d74cff571fbb3");
        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=dd41a6a3c2294d745d86237c88959090&signature=6c234dfb3cf8b513ae34a0709897a866f72f216f&categoryId=19&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530753009&os=1501&nonceStr=b9f35816f460ab999cbc168c4da26ff3");
        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=baebde57d5f169a2fd2b247d9657a405&signature=bace9e592dd311691003c82c9f166570a5b47b48&categoryId=22&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530753050&os=1501&nonceStr=5680522b8e2bb01943234bce7bf84534");
        mlist.add("https://api.dyhoa.com/dapi/v4/mall/productList?nextPage=1&terminal=1601&sign=7f763ad694cd17eb4d713b2c82ff66b0&signature=744e9d8e6f79929134a3716303c78f2e16ad90fe&categoryId=23&pageSize=10&version=3.6.8.9&phone=18201222438&timestamp=1530753084&os=1501&nonceStr=07042ac7d03d3b9911a00da43ce0079a");

    }

    @OnClick({R.id.mtv_yuedou, R.id.mtv_jilu,R.id.img_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mtv_yuedou:
                Intent intent = new Intent(First_YDSupperActivity.this, First_LogActivity.class);
                startActivity(intent);
                break;
            case R.id.mtv_jilu:
                Intent intent1 = new Intent(First_YDSupperActivity.this, First_LogActivity.class);
                startActivity(intent1);
                break;
            case R.id.img_back:
                finish();
                break;
        }
    }

    @Override
    public void getSuper_zuoV(SuperLVBean superLVBean) {
        Log.e("TAG_zuo", superLVBean.getResultList().get(0).getName());
        final List<ResultListBean> resultList = superLVBean.getResultList();
        resultList.get(0).setSelcted(true);
        final Shouye_YDSuperLVAdapter shouye_ydSuperLVAdapter = new Shouye_YDSuperLVAdapter(resultList, First_YDSupperActivity.this);
        mlv.setAdapter(shouye_ydSuperLVAdapter);
        mlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < resultList.size(); i++) {
                    resultList.get(i).setSelcted(false);
                }
                resultList.get(position).setSelcted(true);
                shouye_ydSuperLVAdapter.notifyDataSetChanged();
                //4使用自定义泛型是String的集合的索引发起再次请求
                //因为我需要点击自定义string的集合（每条Item地址）来显示对应我右边的数据
                String s = mlist.get(position);
                mPresenter.getSuper_youP(s);
            }
        });
    }

    @Override
    public void getLiJuanV(LiKaLiJuanBean liKaLiJuanBean) {
        listBeans.clear();
        List<ListBean> list = liKaLiJuanBean.getResultList().getList();
        listBeans.addAll(list);
        shouye_recycl_ydAdapter.notifyDataSetChanged();
    }
}
