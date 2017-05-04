package com.liumeng.net.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.liumeng.net.R;
import com.liumeng.net.app.BaseFragment;
import com.liumeng.net.utils.FragmentTag;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.liumeng.net.utils.FragmentTag.DETAIL;

/**
 * ****************************************************
 * 项目名：NiceNetwork
 * 创建时间：2017/5/3
 * 创建人：刘蒙
 * 功能：
 * *****************************************************
 */

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_frame_layout)
    FrameLayout mainFrameLayout;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    BaseFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        fab.hide();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        Bundle extras = getIntent().getExtras();

        startFragmentByTag(DETAIL, extras);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();
        }
        return true;
    }

    private void startFragmentByTag(String tag, Bundle extras) {
        if (fragment != null) {
            if (fragment.getTag().equals(tag))
                return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = FragmentTag.getFragment(tag);
        if (extras != null) fragment.setArguments(extras);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.replace(R.id.main_frame_layout, fragment, tag);
        fragmentTransaction.commit();

    }
}
