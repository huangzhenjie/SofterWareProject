package huangzhengjie.softerwareproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import huangzhengjie.softerwareproject.maininterface.MainTabActivity;


public class DoorActivity extends ActionBarActivity {
    private ImageView iVLeft;
    private ImageView iVRight;
    private TextView tV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);
         iVLeft= (ImageView) findViewById(R.id.iVLeft);
        iVRight= (ImageView) findViewById(R.id.iVRight);
         tV= (TextView) findViewById(R.id.tV);

        AnimationSet aS_Left=new AnimationSet(true);
        TranslateAnimation tA_Left=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-1f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f);
        tA_Left.setDuration(2000);
        aS_Left.setStartOffset(800);
        aS_Left.addAnimation(tA_Left);
        aS_Left.setFillAfter(true);
        iVLeft.startAnimation(aS_Left);

        AnimationSet aS_Right=new AnimationSet(true);
        TranslateAnimation tA_Right=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,+1f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f);
        tA_Right.setDuration(1500);
        aS_Right.addAnimation(tA_Right);
        aS_Right.setStartOffset(800);
        aS_Right.setFillAfter(true);
        iVRight.startAnimation(aS_Right);

        AnimationSet aS_TV=new AnimationSet(true);
        ScaleAnimation sA_TV_01=new ScaleAnimation(1f,3f,1f,3f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        sA_TV_01.setDuration(1000);
        AlphaAnimation sA_TV_02=new AlphaAnimation(1,0.0001f);
        sA_TV_02.setDuration(1500);
        aS_TV.addAnimation(sA_TV_01);
        aS_TV.addAnimation(sA_TV_02);
        aS_TV.setFillAfter(true);
        tV.startAnimation(aS_TV);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(DoorActivity.this, MainTabActivity.class);
                startActivity(intent);
                DoorActivity.this.finish();
            }
        }, 1500);


    }

}
