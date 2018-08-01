package com.dajia.yzyfu.daka;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;


public class NavHomeFragment extends Fragment {

    private String[] tabTitle = {"待接手","制作中","待取货","交易完成"};
    private TabLayout tabLayout;
    private ViewPager viewPager;
    String[] mData = {"1","2","3","4"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nav_home, container, false);
        initView();
        return view;
    }
    public void initView(){
        tabLayout = (TabLayout) getView().findViewById(R.id.orderTab);
        viewPager = (ViewPager) getView().findViewById(R.id.homeVp);

        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitle[position % tabTitle.length];
            }
            @Override
            public Fragment getItem(int i) {
                Fragment fragment = new Fragment();
                return fragment;
            }

            @Override
            public int getCount() {
                return tabTitle.length;
            }
        });

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
