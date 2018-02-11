package com.ide.shota.topactionoverflowmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomOverflowMenuAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater = null;
    private ArrayList<String> mMenuLabels;

    CustomOverflowMenuAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    void setMenuLabels(ArrayList<String> mainMenuLabels) {
        mMenuLabels = mainMenuLabels;
    }

    @Override
    public int getCount() {
        return mMenuLabels.size();
    }

    @Override
    public Object getItem(int position) {
        return mMenuLabels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.custom_overflow_menu_item, null);
        }
        TextView textView = convertView.findViewById(R.id.custom_overflow_menu_item_label);
        textView.setText(mMenuLabels.get(position));
        return convertView;
    }
}
