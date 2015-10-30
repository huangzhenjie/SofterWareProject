package huangzhengjie.softerwareproject.maininterface;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import huangzhengjie.softerwareproject.R;
import huangzhengjie.softerwareproject.http.HttpContactDownloader;

public class MainTabNews extends ActionBarActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab_news);
        listView= (ListView) findViewById(R.id.lV_News);
        HttpContactDownloader httpContactDownloader=new HttpContactDownloader(listView,this);
        httpContactDownloader.execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(MainTabNews.this,MainTabNewsMessage.class);
                startActivity(intent);
            }
        });


    }


}
