package com.code.news.customs;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by Destiny on 2019/4/18.
 */

public class CustomerSimpleAdapter extends SimpleAdapter {

    public CustomerSimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        //更新第一个TextView的背景
        if (position==0)
        {
            TextView categoryTitle = (TextView)v;
            categoryTitle.setTextColor(Color.parseColor("#ffffff"));
        }
        return v;
    }
}
