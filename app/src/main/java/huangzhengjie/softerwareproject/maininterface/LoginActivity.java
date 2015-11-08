package huangzhengjie.softerwareproject.maininterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMGroupManager;

import huangzhengjie.softerwareproject.R;
import huangzhengjie.softerwareproject.sendmessage.smsFragment.ChooseMsgActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText tousername;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        login.setOnClickListener(btn_login);
    }


    View.OnClickListener btn_login=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EMChatManager.getInstance().login(username.getText().toString(), password.getText().toString(), new EMCallBack() {
                @Override
                public void onSuccess()
                {
                    EMGroupManager.getInstance().loadAllGroups();
                    EMChatManager.getInstance().loadAllConversations();

                    Log.d("main", "登陆聊天服务器成功");

                    EMChat.getInstance().setAppInited();
//                    Toast.makeText(LoginActivity.this, "登陆聊天服务器成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainTabActivity.class);
//                    intent.putExtra("username", tousername.getText().toString());
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onError(int i, String s)
                {
//                    Toast.makeText(LoginActivity.this,"登陆聊天服务器失败，请输入正确的账号或密码",Toast.LENGTH_SHORT).show();
                    Log.d("main", "登陆聊天服务器失败");
                }

                @Override
                public void onProgress(int i, String s)
                {

                }
            });
        }
    };

    private void initView()
    {
        username= (EditText) findViewById(R.id.username);
        tousername= (EditText) findViewById(R.id.tousername);
        password= (EditText) findViewById(R.id.password);
        login= (Button) findViewById(R.id.btn_login);
    }

}
