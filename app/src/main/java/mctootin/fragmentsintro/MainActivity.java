package mctootin.fragmentsintro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by dingn on 8/15/2017.
 */

public class MainActivity extends AppCompatActivity{

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;
    private Button btnNavFrag1;
    private Button btnNavFrag2;
    private Button btnNavFrag3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNavFrag1 = (Button) findViewById(R.id.btnNavFrag1);
        btnNavFrag2 = (Button) findViewById(R.id.btnNavFrag2);
        btnNavFrag3 = (Button) findViewById(R.id.btnNavFrag3);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        // ViewPager android class allows users to flip left and right through pages of data
        // Conveniently supplies and manages the lifecycle of each page / fragment
        // Developer has to supply an implementation of PagerAdapter to generate the pages that the view shows
        mViewPager = (ViewPager) findViewById(R.id.container); // selects component for ViewPager to manage
        // set up the pager
        setupViewPager(mViewPager);


        btnNavFrag1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Going to Fragment 1",Toast.LENGTH_SHORT).show();
                setViewPager(0);
            }});

        btnNavFrag2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Going to Fragment 2",Toast.LENGTH_SHORT).show();
                setViewPager(1);
            }});

        btnNavFrag3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Going to Fragment 3",Toast.LENGTH_SHORT).show();
               setViewPager(2);
            }});
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        // Order determines which fragment shows first, adding fragments loads it up into the ViewPager.
        // Think of it like, all fragments are loaded into the container but the viewPager determines
        // which one shows up on top
        adapter.addFragment(new Fragment1(),"Fragment1");
        adapter.addFragment(new Fragment2(),"Fragment2");
        adapter.addFragment(new Fragment3(),"Fragment3");

        // SectionsStatePagerAdapter stores the fragments and readies them to be loaded into view
        // set a PageAdapter that will supply views for this pager as needed
        viewPager.setAdapter(adapter); // puts SectionsStatePagerAdapter as mViewPager's adapter
    }

    // Handles which fragment shows in the container. The fragment display is being handled in the
    // container (activity) in which the fragments reside, which is good protocol
    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber); // view is handled by the ViewPager
    }
}
