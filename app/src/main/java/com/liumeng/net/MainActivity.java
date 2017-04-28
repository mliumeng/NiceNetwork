package com.liumeng.net;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab:
                break;
            case R.id.imageView:
                break;
            case R.id.textView:
                break;
            case R.id.item_android:
                break;
            case R.id.item_ios:
                break;
            case R.id.item_web:
                break;
            case R.id.item_beaut:

                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
