package com.dajia.yzyfu.daka;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnv;
    private ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bnv = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        vp = (ViewPager) findViewById(R.id.vp);

        //这里可true是一个消费过程，同样可以使用break，外部返回true也可以
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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
        setupViewPager(vp);
        //ViewPager监听
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled( int position,float positionOffset,int positionOffsetPixels){

            }

            @Override
            public void onPageSelected(int position) {
                bnv.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void setupViewPager(ViewPager viewPager) {
        BottomAdapter adapter = new BottomAdapter(getSupportFragmentManager());
        adapter.addFragment(new NavHomeFragment());
        adapter.addFragment(new NavWorkFragment());
        adapter.addFragment(new NavMineFragment());
        viewPager.setAdapter(adapter);
    }
}
