package huangzhengjie.softerwareproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class PagerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        ViewPager mViewPager= (ViewPager) findViewById(R.id.viewPaper);

        //利用LayoutInflater把xml布局文件转换为View
        LayoutInflater mPagers=LayoutInflater.from(this);
        View mPager_01=mPagers.inflate(R.layout.viewpager_01, null);
        View mPager_02=mPagers.inflate(R.layout.viewpager_02, null);
        View mPager_03=mPagers.inflate(R.layout.viewpager_03,null);

        //将要分页显示的View装入数组中
        final ArrayList<View> arrayList=new ArrayList<>();
        arrayList.add(mPager_01);
        arrayList.add(mPager_02);
        arrayList.add(mPager_03);

        //viewpager的适配器
        PagerAdapter pagerAdapter=new PagerAdapter() {

            //确定页面的个数
            @Override
            public int getCount()
            {
                return arrayList.size();
            }


            @Override
            public boolean isViewFromObject(View view, Object object)
            {
                return view==object;
            }

            //确定需要加载的页面
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                //((ViewPager)container).addView(arrayList.get(position));
                container.addView(arrayList.get(position));
                return arrayList.get(position);
            }

            //需要删除的页面
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                //((ViewPager)container).removeView(arrayList.get(position));
                container.removeView(arrayList.get(position));
            }
        };

    mViewPager.setAdapter(pagerAdapter);

    }

    //btn按钮跳转到DoorActivity
    public void startbutton(View v) {
        Intent intent = new Intent(PagerActivity.this,DoorActivity.class);
        startActivity(intent);
        this.finish();
    }
}
