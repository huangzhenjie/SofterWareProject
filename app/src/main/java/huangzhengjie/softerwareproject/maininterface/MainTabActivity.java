package huangzhengjie.softerwareproject.maininterface;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

import huangzhengjie.softerwareproject.DoorActivity;
import huangzhengjie.softerwareproject.R;
import huangzhengjie.softerwareproject.sendmessage.SMSMainActivity;

//主界面的选项卡页面
public class MainTabActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //定义一个tabhosts类，这个类是用来操作我们的tabactivity
        TabHost tabHostNews=getTabHost();

        Intent intentNews=new Intent();
        intentNews.setClass(this,MainTabNews.class);

        //表示这个对象的一页
        TabHost.TabSpec tabSpecNews=tabHostNews.newTabSpec("消息");

        Resources resources=getResources();
        tabSpecNews.setIndicator("消息",resources.getDrawable(R.drawable.actionbar_icon));
        //加载我们的内容，内容在intent里面
        tabSpecNews.setContent(intentNews);
        //添加到tabhost里面去
        tabHostNews.addTab(tabSpecNews);

        TabHost tabHostContact=getTabHost();
        Intent intentContact=new Intent();
        intentContact.setClass(this,MainTabContact.class);
        TabHost.TabSpec tabSpecContact=tabHostContact.newTabSpec("联系人");
        Resources resourcesContact=getResources();
        tabSpecContact.setIndicator("联系人",resourcesContact.getDrawable(R.drawable.actionbar_icon));
        tabSpecContact.setContent(intentContact);
        tabHostContact.addTab(tabSpecContact);

        TabHost tabHostDynamic=getTabHost();
        Intent intentDynamic=new Intent();
        intentDynamic.setClass(this,MainTabDynamic.class);
        TabHost.TabSpec tabSpecDynamic=tabHostDynamic.newTabSpec("动态");
        Resources resourcesDynamic=getResources();
        tabSpecDynamic.setIndicator("动态",resourcesDynamic.getDrawable(R.drawable.actionbar_icon));
        tabSpecDynamic.setContent(intentDynamic);
        tabHostDynamic.addTab(tabSpecDynamic);
    }


    //btn按钮跳转到SMSMainActivity
    public void smsfestival(View v) {
        Intent intent = new Intent(MainTabActivity.this,SMSMainActivity.class);
        startActivity(intent);
        //this.finish();
    }
}
