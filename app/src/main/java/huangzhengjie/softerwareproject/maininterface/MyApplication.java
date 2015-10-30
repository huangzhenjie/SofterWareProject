package huangzhengjie.softerwareproject.maininterface;

import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

import com.easemob.EMEventListener;
import com.easemob.EMNotifierEvent;
import com.easemob.chat.CmdMessageBody;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMMessage;
import com.easemob.util.EMLog;

import java.util.Iterator;
import java.util.List;

import huangzhengjie.softerwareproject.R;

/**
 * Created by asd13_000 on 2015/10/13.
 */
public class MyApplication extends Application {
//    private EMEventListener eventListener;

    @Override
    public void onCreate() {
        super.onCreate();
        EMChat.getInstance().init(this);

//        int pid = android.os.Process.myPid();
//        String processAppName = getAppName(pid);
//
//        if (processAppName == null || !processAppName.equalsIgnoreCase("huangzhengjie.softerwareproject")) {
//            Log.e("main", "enter the service process!");
//            //"com.easemob.chatuidemo"为demo的包名，换到自己项目中要改成自己包名
//
//            // 则此application::onCreate 是被service 调用的，直接返回
//            return;
//        }
//
//
//        EMChat.getInstance().init(getApplicationContext());
//
///**
// * debugMode == true 时为打开，sdk 会在log里输入调试信息
// * @param debugMode
// * 在做代码混淆的时候需要设置成false
// */
//        EMChat.getInstance().setDebugMode(true);//在做打包混淆时，要关闭debug模式，如果未被关闭，则会出现程序无法运行问题
//        initLis();
//    }
//
//    private String getAppName(int pID) {
//        String processName = null;
//        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
//        List l = am.getRunningAppProcesses();
//        Iterator i = l.iterator();
//        PackageManager pm = this.getPackageManager();
//        while (i.hasNext()) {
//            ActivityManager.RunningAppProcessInfo info = (ActivityManager.RunningAppProcessInfo) (i.next());
//            try {
//                if (info.pid == pID) {
//                    CharSequence c = pm.getApplicationLabel(pm.getApplicationInfo(info.processName, PackageManager.GET_META_DATA));
//                    // Log.d("Process", "Id: "+ info.pid +" ProcessName: "+
//                    // info.processName +"  Label: "+c.toString());
//                    // processName = c.toString();
//                    processName = info.processName;
//                    return processName;
//                }
//            } catch (Exception e) {
//                // Log.d("Process", "Error>> :"+ e.toString());
//            }
//        }
//        return processName;
//    }
//
//
//    //注册监听
//    private void initLis() {
//
//        eventListener = new EMEventListener() {
//            @Override
//            public void onEvent(EMNotifierEvent event) {
//
//                switch (event.getEvent()) {
//                    case EventNewMessage:
//                    {
//                        EMMessage message = (EMMessage)event.getData();
//                        Log.d("main",message.getBody().toString());
//                        break;
//                    }
//                    case EventNewCMDMessage:
//                    {
//                        break;
//                    }
//                    // add other events in case you are interested in
//                    default:
//                        break;
//                }
//
//            }
//        };
//
//        EMChatManager.getInstance().registerEventListener(eventListener);
    }
}
