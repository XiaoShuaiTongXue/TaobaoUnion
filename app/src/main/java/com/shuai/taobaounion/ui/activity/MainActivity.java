 package com.shuai.taobaounion.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shuai.taobaounion.R;
import com.shuai.taobaounion.base.BaseFragment;
import com.shuai.taobaounion.ui.fragment.HomeFragment;
import com.shuai.taobaounion.ui.fragment.RedPacketFragement;
import com.shuai.taobaounion.ui.fragment.SearchFragment;
import com.shuai.taobaounion.ui.fragment.SelectedFragment;
import com.shuai.taobaounion.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

 public class MainActivity extends AppCompatActivity {

     private FragmentManager mFragManager;
     private FragmentTransaction mTransaction;
     @BindView(R.id.main_navigation_view)
     public BottomNavigationView mNavigationView;
     private Unbinder mBind;
     private HomeFragment mHomeFragment;
     private SelectedFragment mSelectedFragment;
     private RedPacketFragement mRedPacketFragement;
     private SearchFragment mSearchFragment;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        initFragment();
        initLister();
    }

     private void initFragment() {
         mHomeFragment = new HomeFragment();
         mSelectedFragment = new SelectedFragment();
         mRedPacketFragement = new RedPacketFragement();
         mSearchFragment = new SearchFragment();
         switchFragment(mHomeFragment);
     }

     private void switchFragment(BaseFragment targetFragment) {
         mFragManager = getSupportFragmentManager();
         mTransaction = mFragManager.beginTransaction();
         mTransaction.replace(R.id.main_page_container,targetFragment);
         mTransaction.commit();
     }

     private void initLister() {
         mNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 if(item.getItemId() == R.id.home){
                     LogUtils.d(MainActivity.class,"点击了首页");
                     switchFragment(mHomeFragment);
                 }else if (item.getItemId() == R.id.selected){
                     LogUtils.d(MainActivity.class,"点击了精选");
                     switchFragment(mSelectedFragment);
                 }else if(item.getItemId() == R.id.red_packet){
                     LogUtils.d(MainActivity.class,"点击了特惠");
                     switchFragment(mRedPacketFragement);
                 }else if (item.getItemId() == R.id.search){
                     LogUtils.d(MainActivity.class,"点击了搜索");
                     switchFragment(mSearchFragment);
                 }else {
                     return false;
                 }
                 return true;
             }
         });
     }

     @Override
     protected void onDestroy() {
         super.onDestroy();
         mBind.unbind();
     }

 }