package com.swipeabletabs.activities;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.swipeabletabs.R;
import com.swipeabletabs.adapters.ViewPagerAdapter;
import com.swipeabletabs.fragments.DesignFragment;
import com.swipeabletabs.fragments.HistoryFragment;
import com.swipeabletabs.fragments.MoviesFragment;
import com.swipeabletabs.fragments.MusicFragment;
import com.swipeabletabs.fragments.PoliticsFragment;
import com.swipeabletabs.fragments.SportsFragment;
import com.swipeabletabs.fragments.TechnologiesFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black));
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#B22222"));
        tabLayout.setSelectedTabIndicatorHeight((int) (5 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#727272"), Color.parseColor("#000000"));

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new SportsFragment(), "Sports");
        adapter.addFrag(new TechnologiesFragment(), "Technologies");
        adapter.addFrag(new DesignFragment(), "Design");
        adapter.addFrag(new PoliticsFragment(), "Politics");
        adapter.addFrag(new MoviesFragment(), "Movies");
        adapter.addFrag(new MusicFragment(), "Music");
        adapter.addFrag(new HistoryFragment(), "History");
        viewPager.setAdapter(adapter);
    }
}
