package com.liumeng.net;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liumeng.net.app.BaseFragment;
import com.liumeng.net.utils.FragmentTag;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.android)
    TextView android;
    @BindView(R.id.item_android)
    LinearLayout itemAndroid;
    @BindView(R.id.ios)
    TextView ios;
    @BindView(R.id.item_ios)
    LinearLayout itemIos;
    @BindView(R.id.web)
    TextView web;
    @BindView(R.id.item_web)
    LinearLayout itemWeb;
    @BindView(R.id.beaut)
    TextView beaut;
    @BindView(R.id.item_beaut)
    LinearLayout itemBeaut;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.main_frame_layout)
    FrameLayout mainFrameLayout;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private BaseFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        startFragmentByTag(FragmentTag.BEAUTY);
    }


    private void startFragmentByTag(String tag) {
        if (fragment != null) {
            if (fragment.getTag().equals(tag))
                return;
        }
        setSelectItem(tag);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = FragmentTag.getFragment(tag);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.replace(R.id.main_frame_layout, fragment, tag);
        fragmentTransaction.commit();

    }

    private void setSelectItem(String tag) {
        int selectItem = -1;
        switch (tag) {
            case FragmentTag.ANDROID:
                selectItem = 0;
                break;
            case FragmentTag.IOS:
                selectItem = 1;
                break;
            case FragmentTag.WEB:
                selectItem = 2;
                break;
            case FragmentTag.BEAUTY:
                selectItem = 3;

                break;
        }
        setSelectItem(selectItem);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @OnClick({R.id.fab, R.id.imageView, R.id.textView, R.id.item_android, R.id.item_ios, R.id.item_web, R.id.item_beaut})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                break;
            case R.id.imageView:
                break;
            case R.id.textView:
                break;
            case R.id.item_android:
                setSelectItem(0);
                break;
            case R.id.item_ios:
                setSelectItem(1);
                break;
            case R.id.item_web:
                setSelectItem(2);
                break;
            case R.id.item_beaut:
                setSelectItem(3);
                startFragmentByTag(FragmentTag.BEAUTY);
                break;
        }
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
    }

    public void setSelectItem(int selectItem) {
        TextView[] tvItems = {android, ios, web, beaut};
        if (selectItem > 0 && selectItem < tvItems.length)
            for (TextView item : tvItems) {
                if (item == tvItems[selectItem]) {
                    item.setTextColor(getResources().getColor(R.color.colorAccent));
                } else {
                    item.setTextColor(getResources().getColor(R.color.colorBlack));
                }
            }
    }
}
