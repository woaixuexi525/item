package com.code.news.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.code.news.R;
import com.code.news.customs.CustomerSimpleAdapter;
import com.code.news.model.Category;
import com.code.news.utils.ScreenUtils;
import com.code.news.utils.StringUtil;
import com.code.news.utils.SyncHttp;



import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private int mCid;
    ArrayList<Map<String,Object>> mNewsData;
    ListView newsList;
    SimpleAdapter newListAdapter;
    LayoutInflater bFlater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_main);

        if (Build.VERSION.SDK_INT >= 11) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads  ().detectDiskWrites().detectNetwork().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().penaltyDeath().build());
        }

        //[4]获取分类资源
        String[] categoryArray = getResources().getStringArray(R.array.categories);


        bFlater = getLayoutInflater();
        mNewsData = new ArrayList<Map<String,Object>>();
        //[13]把新闻分类存到list中
        final List<Map<String,Category>> catregories = new ArrayList<>();
        //[14]解析新闻分类
        for(int i=0;i<categoryArray.length;i++){
            String[] temp = categoryArray[i].split("[|]");
            if (temp.length==2)
            {
                int cid = StringUtil.String2Int(temp[0]);
                String title = temp[1];
                Category type = new Category(cid, title);
                HashMap<String, Category> hashMap = new HashMap<String, Category>();
                hashMap.put("category_title", type);
                catregories.add(hashMap);
            }
        }


        int itemWidth = ScreenUtils.dip2px(this,50);
        int itemPaddingH = ScreenUtils.dip2px(this, 1);
        int size = categoryArray.length;
        int gridviewWidth = size * (itemWidth + itemPaddingH);

        mCid = 1;

        //[6]创建适配器
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.catrgory_title,categoryArray);
        CustomerSimpleAdapter arrayAdapter = new CustomerSimpleAdapter(this,catregories, R.layout.catrgory_title, new String[]{"category_title"}, new int[]{R.id.category_title});
        //[3]创建categoryList所需要的视图
        GridView category = new GridView(this);
        //[3.1]手动创建视图或者使用xml
        category.setColumnWidth(itemWidth);//每个单元格宽度
        category.setNumColumns(size);//单元格数目
        category.setGravity(Gravity.CENTER);//设置对其方式

        //[5]设置LinerLayout容器的布局方式,控制子view的摆放方式
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(gridviewWidth, LinearLayout.LayoutParams.FILL_PARENT);
        category.setLayoutParams(params);

        //[6]设置GridView的适配器
        category.setAdapter(arrayAdapter);
        //[1]获取控件填充数据
        LinearLayout categoryList = (LinearLayout) findViewById(R.id.category_layout);
        //[2]给布局组件填充视图
        categoryList.addView(category);

        //[7]给GridView添加事件
        category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //parent:GridView
                //view:TextView
                //position：位置
                //id:下标
                //Toast.makeText(MainActivity.this, "id:"+id, Toast.LENGTH_SHORT).show();
                //[1]恢复每个TextVIew背景色
                TextView categoryTitle;
                for(int i=0;i<parent.getChildCount();i++){
                    //[2]获取每一个TextView
                    categoryTitle = (TextView) parent.getChildAt(i);
                    //[3]设置背景颜色
                    categoryTitle.setTextColor(Color.parseColor("#000000"));
                }
                //[4]设置选中单元格的颜色
                categoryTitle = (TextView) parent.getChildAt(position);
                categoryTitle.setTextColor(Color.parseColor("#ffffff"));


                //获取选中新闻分类
                mCid = catregories.get(position).get("category_title").getCid();
                //Toast.makeText(MainActivity.this, "cid"+mCid, Toast.LENGTH_SHORT).show();
                //获取该栏目下新闻
                getSpeCateNews(mCid,mNewsData,0,true);
                //通知更新
                newListAdapter.notifyDataSetChanged();

            }
        });


        //[11]创建SimpleAdapter所需要的数据
        //[11.1]先创建List
         getSpeCateNews(mCid,mNewsData,0,true);


        //[11.2]创建list所需要的数据
        /*Map<String,String> hashMap = new HashMap<>();
        for(int i=0;i<5;i++){
            hashMap.put("newslist_item_title","525" );
            hashMap.put("newslist_item_digest","525" );
            hashMap.put("newslist_item_source", "来源：525");
            hashMap.put("newslist_item_ptime", "2012-03-12 10:21:22");
            newsData.add(hashMap);
        }*/

        //[10]创建适配器
        newListAdapter = new SimpleAdapter(this,mNewsData,R.layout.news_list,new String[]{"newslist_item_title",
                "newslist_item_digest","newslist_item_source","newslist_item_ptime"},
                new int[]{R.id.newslist_item_title,R.id.newslist_item_digest,R.id.newslist_item_source,R.id.newslist_item_ptime});

        //[8]显示新闻列表
        newsList = (ListView) findViewById(R.id.news_list);

        //加载更多布局
        View loadMore = bFlater.inflate(R.layout.loading,null);
        newsList.addFooterView(loadMore);
        //[11]设置适配器
        newsList.setAdapter(newListAdapter);
        //[12]设置监听
        newsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, NewsDetails.class);
                //把需要的信息放到Intent中
                intent.putExtra("newsDate", mNewsData);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

        //设置最下面的加载按钮
        Button loadMoreBtn = (Button) findViewById(R.id.loadmore_btn);
        loadMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取该栏目下新闻
                getSpeCateNews(mCid,mNewsData,mNewsData.size(),false);
                //通知ListView进行更新
                newListAdapter.notifyDataSetChanged();
            }
        });

       Button refresh  = (Button)findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "cid"+mCid, Toast.LENGTH_SHORT).show();
                getSpeCateNews(mCid,mNewsData,mNewsData.size(),false);
                //通知ListView进行更新
                newListAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * 通过cid获取指定的新闻类型
     * @param cid
     * @return
     */
    private void getSpeCateNews( int cid,final  List<Map<String,Object>> newsList,int startnid,Boolean firstTimes){
        //String url = "http://url?name="+ URLEncoder.encode("aaa", "utf-8") + "&pass=" + URLEncoder.encode("bbb", "utf-8");
        //http://dkmxyc.natappfree.cc/NewServices/getSpecifyCategoryNews
        //String url = "http://192.168.8.147:8080/NewServices/getSpecifyCategoryNews";
        String url = "http://group.natapp1.cc/NewsServices/CategoriesServlet";
        String params = "startnid="+startnid+"&count=9&cid="+cid;
       // String params = "startnid=0&count=10&cid="+cid;

        if (firstTimes)
        {
            //如果是第一次，则清空集合里数据
            newsList.clear();
        }
        //请求URL和字符串
        SyncHttp syncHttp = new SyncHttp();
        try
        {
            //以Get方式请求，并获得返回结果
            String retStr = syncHttp.httpGet(url, params);
            JSONObject jsonObject = new JSONObject(retStr);
            //获取返回码，0表示成功
            int retCode = jsonObject.getInt("ret");
            if (0==retCode)
            {
                JSONObject dataObject = jsonObject.getJSONObject("data");
                //获取返回数目
                int totalnum = dataObject.getInt("totalnum");
                if (totalnum>0)
                {
                    //获取返回新闻集合
                    JSONArray newslist = dataObject.getJSONArray("newslist");
                    for(int i=0;i<newslist.length();i++)
                    {
                        JSONObject newsObject = (JSONObject)newslist.opt(i);
                        HashMap<String, Object> hashMap = new HashMap<String, Object>();
                        hashMap.put("nid", newsObject.getInt("nid"));
                        hashMap.put("newslist_item_title", newsObject.getString("title"));
                        hashMap.put("newslist_item_digest", newsObject.getString("digest"));
                        hashMap.put("newslist_item_source", newsObject.getString("source"));
                        hashMap.put("newslist_item_ptime", newsObject.getString("ptime"));
                        newsList.add(hashMap);
                    }
                }
                else
                {
                    if (firstTimes)
                    {
                        Toast.makeText(MainActivity.this, "该栏目下暂时没有新闻", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "该栏目下没有更多新闻", Toast.LENGTH_LONG).show();
                    }
                }
            }
            else
            {
                Toast.makeText(MainActivity.this, "获取新闻失败", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "获取新闻失败", Toast.LENGTH_LONG).show();
        }

    }



}
