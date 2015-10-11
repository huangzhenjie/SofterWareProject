package huangzhengjie.softerwareproject.maininterface;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import huangzhengjie.softerwareproject.R;

public class MainTabActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        TabHost tabHostNews=getTabHost();
        Intent intentNews=new Intent();
        intentNews.setClass(this,MainTabNews.class);
        TabHost.TabSpec tabSpecNews=tabHostNews.newTabSpec("消息");
        Resources resourcesNews=getResources();
        tabSpecNews.setIndicator("消息",resourcesNews.getDrawable(R.drawable.actionbar_icon));
        tabSpecNews.setContent(intentNews);
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


}
