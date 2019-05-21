package com.code.news.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.code.news.R;
import com.code.news.utils.SyncHttp;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;


import org.apache.http.Header;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class NewsDetails extends Activity {
    public final String NEWS = "<p>　环比全部停涨首次出现</p>\r\n<p>　　" +
            "数据显示，在新建商品住宅方面，2012年1月全国70个大中城市，价格环比下降的城市有48个，" +
            "持平的城市有22个，没有一个城市出现上涨。从房价价格指数公布来看，首次出现了新建商品住宅环比全部停涨的现象。</p>\r\n<p>　　" +
            "从同比看，70个大中城市中，价格下降的城市有15个，比去年12月份增加6个。1月份，" +
            "同比涨幅回落的城市有50个，涨幅均未超过3.9%。</p>\r\n<p>　" +
            "　二手住宅</p>\r\n<p>　　仅有5个城市环比上涨</p>\r\n<p>";
    private ViewFlipper flipper;
    private LayoutInflater bodyFlater;
    private  float startX;
    private  int count;
    private ArrayList<HashMap<String, Object>> mNewsData;
    private int mPosition = 0;
    int nid;
    TextView newsDetails;
    final int UPDATE_TEXT = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);


        if (Build.VERSION.SDK_INT >= 11) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads  ().detectDiskWrites().detectNetwork().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        }




        //[1]获取导航栏的两个按钮对象
        /*Button next = (Button) findViewById(R.id.newsdetails_titlebar_next);
        Button previous = (Button) findViewById(R.id.newsdetails_titlebar_previous);
        TitleBarClicks titleBarClicks = new TitleBarClicks();
        //[2]添加响应事件
        next.setOnClickListener(titleBarClicks);
        previous.setOnClickListener(titleBarClicks);*/
        
        //获取传递的数据
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //获取新闻集合
        Serializable s = bundle.getSerializable("newsDate");
        mNewsData = (ArrayList<HashMap<String, Object>>)s;
        //获取点击位置
        mPosition = bundle.getInt("position");
        //获取点击新闻基本信息
        HashMap<String, Object> hashMap = mNewsData.get(mPosition);
        //获取编号
        nid = (Integer)hashMap.get("nid");

        bodyFlater = getLayoutInflater();

        //[4]动态创建视图
        View bodyLayout = bodyFlater.inflate(R.layout.news_body,null);
        TextView newsTitle = (TextView)bodyLayout.findViewById(R.id.news_body_title);
        newsTitle.setText(hashMap.get("newslist_item_title").toString());
        TextView newsPtimeAndSource = (TextView)bodyLayout.findViewById(R.id.news_body_ptime_source);
        newsPtimeAndSource.setText(hashMap.get("newslist_item_ptime").toString() + "    " + hashMap.get("newslist_item_source").toString());
        newsDetails =  (TextView)bodyLayout.findViewById(R.id.news_body_details);
        newsDetails.setText(Html.fromHtml(getNewsBody()));


        //[3]获取VIewFillper
        flipper = (ViewFlipper) findViewById(R.id.news_body_flipper);
        flipper.addView(bodyLayout);


        //[5]给新闻添加触摸事件
        //newsDetails.setOnTouchListener(new BodyTouchCliks());

    }




    /**
     * 获取新闻详细信息
     * @return
    */
    private String getNewsBody()
    {
        String retStr = "网络连接失败，请稍后再试";
        SyncHttp syncHttp = new SyncHttp();
        //String url = "http://192.168.8.147:8080/NewServices/getNews";
        String url = "http://group.natapp1.cc/NewsServices/NewsServlet";
        String params = "nid=" + nid;
        try
        {
            String retString = syncHttp.httpGet(url, params);
            JSONObject jsonObject = new JSONObject(retString);
            //获取返回码，0表示成功
            int retCode = jsonObject.getInt("ret");
            if (0 == retCode)
            {
                JSONObject dataObject = jsonObject.getJSONObject("data");
                JSONObject newsObject = dataObject.getJSONObject("news");
                retStr = newsObject.getString("body");
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return retStr;
    }

}
