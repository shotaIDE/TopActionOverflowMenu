package com.ide.shota.topactionoverflowmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class CustomOverflowMenuHeaderAdapter extends ArrayAdapter<Integer> {

    private int resourceId;

    CustomOverflowMenuHeaderAdapter(Context context, int resource, ArrayList<Integer> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(resourceId, null);
        }
        ImageView imageView = convertView.findViewById(R.id.custom_overflow_menu_header_item_image);
        imageView.setImageResource(getItem(position));

        return imageView;
    }
}
