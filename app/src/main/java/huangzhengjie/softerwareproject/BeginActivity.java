package huangzhengjie.softerwareproject;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class BeginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(BeginActivity.this,PagerActivity.class);
                startActivity(intent);
                BeginActivity.this.finish();
            }
        },1500);
    }

}
