package huangzhengjie.softerwareproject;

import android.app.Activity;
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

import huangzhengjie.softerwareproject.maininterface.LoginActivity;
import huangzhengjie.softerwareproject.maininterface.MainTabActivity;
/*
动画步骤
1.创建AnimationSet对象。
2.根据需要创建对应的Animation对象。
3.根据对动画的需求，为Animation对象设置相应的数据
4.将Animation对象添加到AnimationSet对象中。
5.使用控件对象开始执行AnimationSet。
 */

/*
实现目标：图片左右移动，中间的字变大变模糊
 */
public class DoorActivity extends Activity {
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

        //设置图片向左的动画集合
        AnimationSet aS_Left=new AnimationSet(true);
        /*
        1.确定类型：Absolute相对于屏幕，Relative to self相对于自己，Relative to parent相对于父控件
        2.确定x的起始位置
        3.确定x的模式
        4.确定x的结束动画的位置
        5.Y同X一样
         */
        TranslateAnimation tA_Left=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,-1f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f);
        //设置动画的持续时间
        tA_Left.setDuration(2000);
        //确定动画开始时间
        aS_Left.setStartOffset(800);
        //添加动画
        aS_Left.addAnimation(tA_Left);
        //停留在最后的位置
        aS_Left.setFillAfter(true);
        iVLeft.startAnimation(aS_Left);

        //设置图片向右的动画集合
        AnimationSet aS_Right=new AnimationSet(true);
        TranslateAnimation tA_Right=new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,+1f,Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0f);
        tA_Right.setDuration(1500);
        aS_Right.addAnimation(tA_Right);
        aS_Right.setStartOffset(800);
        aS_Right.setFillAfter(true);
        iVRight.startAnimation(aS_Right);

        //字体的动画设置
        AnimationSet aS_TV=new AnimationSet(true);
        /*
        float fromY动画起始时Y坐标上的伸缩尺寸
        float fromX动画起始时X坐标上的伸缩尺寸
        float toX动画结束时X坐标上的伸缩尺寸
        float toY动画结束时Y坐标上的伸缩尺寸

        int pivotXType 动画在x轴相对于物件位置类型
        int pivotYType 动画在Y轴相对于物件位置类型
        float pivotXValue 动画相对于物件的X坐标的开始位置
        float pivotYValue 动画相对于物件的Y坐标的开始位置
         */
        ScaleAnimation sA_TV_01=new ScaleAnimation(1f,3f,1f,3f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        //放大效果的持续时间
        sA_TV_01.setDuration(1000);
        AlphaAnimation sA_TV_02=new AlphaAnimation(1,0.0001f);
        //渐变效果的持续时间
        sA_TV_02.setDuration(1500);
        aS_TV.addAnimation(sA_TV_01);
        aS_TV.addAnimation(sA_TV_02);
        aS_TV.setFillAfter(true);
        tV.startAnimation(aS_TV);

        //1.5秒后跳转到MainTabActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(DoorActivity.this, LoginActivity.class);
                startActivity(intent);
                DoorActivity.this.finish();
            }
        }, 1500);
    }
}
