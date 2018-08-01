package com.dajia.yzyfu.daka;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.dajia.yzyfu.common.User;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnv;
    private ViewPager vp;
    private MenuItem menuItem;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        checkLogin();
    }

    private void checkLogin () {
//        user = new User();
//        if(user.getStorage() == null){
//
//        }else{
//            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
//            startActivity(intent);
//        }
    }

    private void initView() {
        bnv = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        vp = (ViewPager) findViewById(R.id.vp);

        vp.setAdapter(setupViewPager());
        //ViewPager监听
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled( int position,float positionOffset,int positionOffsetPixels){
            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bnv.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bnv.getMenu().getItem(position);
                menuItem.setChecked(true);

                ActionBar ac = getSupportActionBar();
                switch (position){
                    case 0:ac.setTitle(R.string.homeLabel);break;
                    case 1:ac.setTitle(R.string.workLabel);break;
                    case 2:ac.setTitle(R.string.mineLabel);break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //这里可true是一个消费过程，同样可以使用break，外部返回true也可以
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                menuItem = item;

                switch (item.getItemId()) {
                    case R.id.navHome:
                        vp.setCurrentItem(0);

                        return true;

                    case R.id.navWork:
                        vp.setCurrentItem(1);

                        return true;

                    case R.id.navMine:
                        vp.setCurrentItem(2);

                        return true;
                }
                return false;
            }
        });

    }


    private BottomAdapter setupViewPager() {
        BottomAdapter adapter = new BottomAdapter(getSupportFragmentManager());
        adapter.addFragment(new NavHomeFragment());
        adapter.addFragment(new NavWorkFragment());
        adapter.addFragment(new NavMineFragment());
        return adapter;
    }
}
