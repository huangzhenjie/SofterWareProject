package huangzhengjie.softerwareproject.sendmessage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import huangzhengjie.softerwareproject.R;
import huangzhengjie.softerwareproject.sendmessage.smsFragment.FestivalCategoryFragment;

public class SMSMainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mViewPager;

    private String[] mTitles=new String[]{"节日短信","发送记录"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsmain);

        ininViews();
    }

    private void ininViews() {
        mTablayout= (TabLayout) findViewById(R.id.sms_tabLayout);
        mViewPager= (ViewPager) findViewById(R.id.sms_viewPager);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new FestivalCategoryFragment();
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });

        mTablayout.setupWithViewPager(mViewPager);
    }


}
