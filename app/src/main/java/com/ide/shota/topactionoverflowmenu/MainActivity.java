package com.ide.shota.topactionoverflowmenu;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private PopupWindow mOverflowMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View menuRootView = getLayoutInflater().inflate(R.layout.custom_overflow_menu, null);

        ListView menuListView = menuRootView.findViewById(R.id.custom_overflow_menu_body);
        ArrayList<String> overflowMenuItems = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.overflow_menu_labels)));
        CustomOverflowMenuAdapter adapter = new CustomOverflowMenuAdapter(this);
        adapter.setMenuLabels(overflowMenuItems);

        View menuHeaderRootView = getLayoutInflater().inflate(R.layout.custom_overflow_menu_header, null);
        GridView gridView = menuHeaderRootView.findViewById(R.id.custom_overflow_menu_header_container);
        ArrayList<Integer> menuHeaderIcons = new ArrayList<>();
        menuHeaderIcons.add(R.drawable.ic_action_refresh_dark);
        menuHeaderIcons.add(R.drawable.ic_action_star_dark);
        gridView.setNumColumns(menuHeaderIcons.size());
        gridView.setAdapter(new CustomOverflowMenuHeaderAdapter(this, R.layout.custom_overflow_menu_header_item, menuHeaderIcons));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, String.valueOf(i) + " was clicked", Toast.LENGTH_SHORT).show();
            }
        });

        menuListView.addHeaderView(gridView);
        menuListView.setAdapter(adapter);
        menuListView.setDividerHeight(0);

        mOverflowMenu = new PopupWindow(this);
        mOverflowMenu.setContentView(menuRootView);
        mOverflowMenu.setOutsideTouchable(true);
        mOverflowMenu.setFocusable(true);
        mOverflowMenu.setWidth(700);
        mOverflowMenu.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.white)));
        mOverflowMenu.setAnimationStyle(R.style.AnimationsPopup);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            float menuElevation = 6;
            mOverflowMenu.setElevation(menuElevation);
        }

        Button button = findViewById(R.id.toolbar_three_dots);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOverflowMenu.showAsDropDown(v, 0, - 48 - 36);
            }
        });

        button = menuRootView.findViewById(R.id.menu_three_dots);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOverflowMenu.dismiss();
            }
        });

        Toolbar toolbar = findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);
    }
}
