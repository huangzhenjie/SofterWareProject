package huangzhengjie.softerwareproject.maininterface;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.easemob.EMCallBack;
import com.easemob.chat.EMChat;
import com.easemob.chat.EMChatManager;
import com.easemob.chat.EMConversation;
import com.easemob.chat.EMGroupManager;
import com.easemob.chat.EMMessage;
import com.easemob.chat.TextMessageBody;

import huangzhengjie.softerwareproject.R;
import huangzhengjie.softerwareproject.sendmessage.smsFragment.FestivalCategoryFragment;

public class MainTabNewsMessage extends Activity {
//    private EditText ed_Text;
//    private Button send;
//    private EMConversation conversation;
     private ListView listView;
     private  Button sendButton;
     private  EditText inputContentEditText;
     private  EMConversation conversation;
     private String toChatUsername="huangzhenjie";
     //private String toChatUsername;
     private DataAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab_news_message_01);

        listView= (ListView) findViewById(R.id.listView);
        sendButton= (Button) findViewById(R.id.send);
        inputContentEditText= (EditText) findViewById(R.id.input_content);




                EMChatManager.getInstance().getChatOptions().setShowNotificationInBackgroud(false);


//        EMChatManager.getInstance().login("huangzhenjie12", "123456", new EMCallBack() {
//            @Override
//            public void onSuccess() {
//                EMGroupManager.getInstance().loadAllGroups();
//                EMChatManager.getInstance().loadAllConversations();
//                Log.d("main", "登陆聊天服务器成功");
//
//                EMChat.getInstance().setAppInited();
//            }
//
//            @Override
//            public void onError(int i, String s) {
//
//                Log.d("main", "登陆聊天服务器失败");
//            }
//
//            @Override
//            public void onProgress(int i, String s) {
//
//            }
//        });
//        Intent intent = getIntent();
//        toChatUsername = intent.getStringExtra("username");
        conversation=EMChatManager.getInstance().getConversation(toChatUsername);
        adapter=new DataAdapter();
        listView.setAdapter(adapter);


        //只有注册了广播才能接收到新消息，目前离线消息，在线消息都是走接收消息的广播（离线消息目前无法监听，在登录以后，接收消息广播会执行一次拿到所有的离线消息）
        NewMessageBroadcastReceiver msgReceiver = new NewMessageBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(EMChatManager.getInstance().getNewMessageBroadcastAction());
        intentFilter.setPriority(3);
        registerReceiver(msgReceiver, intentFilter);


        EMChat.getInstance().setAppInited();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取到与聊天人的会话对象。参数username为聊天人的userid或者groupid，后文中的username皆是如此
                EMConversation conversation = EMChatManager.getInstance().getConversation(toChatUsername);
//创建一条文本消息
                EMMessage message = EMMessage.createSendMessage(EMMessage.Type.TXT);
//如果是群聊，设置chattype,默认是单聊
//                message.setChatType(EMMessage.ChatType.GroupChat);
//设置消息body

                //内容
                TextMessageBody txtBody = new TextMessageBody(inputContentEditText.getText().toString());
                message.addBody(txtBody);
//设置接收人
                message.setReceipt(toChatUsername);
//把消息加入到此会话对象中
                conversation.addMessage(message);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
                listView.setSelection(listView.getCount()-1);
                inputContentEditText.setText("");
//发送消息
                EMChatManager.getInstance().sendMessage(message, new EMCallBack(){
                    @Override
                    public void onSuccess() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainTabNewsMessage.this,"发送成功",Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    @Override
                    public void onError(int i, String s) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainTabNewsMessage.this,"error",Toast.LENGTH_LONG).show();
                            }
                        });
                    }

                    @Override
                    public void onProgress(int i, String s) {

                    }
                });
            }
        });



//        setContentView(R.layout.activity_main_tab_news_message);
//
//        ed_Text = (EditText) findViewById(R.id.eD_Text);
//        send = (Button) findViewById(R.id.send);
//
//
//        EMChatManager.getInstance().getChatOptions().setShowNotificationInBackgroud(false);
//
//
//        EMChatManager.getInstance().login("huangzhenjie12", "123456", new EMCallBack() {
//            @Override
//            public void onSuccess() {
//                EMGroupManager.getInstance().loadAllGroups();
//                EMChatManager.getInstance().loadAllConversations();
//                Log.d("main", "登陆聊天服务器成功");
//
//                EMChat.getInstance().setAppInited();
//            }
//
//            @Override
//            public void onError(int i, String s) {
//
//                Log.d("main", "登陆聊天服务器失败");
//            }
//
//            @Override
//            public void onProgress(int i, String s) {
//
//            }
//        });
//
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (conversation == null)
//                    conversation = EMChatManager.getInstance().getConversation("huangzhenjie");
//                EMMessage message = EMMessage.createSendMessage(EMMessage.Type.TXT);
//
//                TextMessageBody txtBody = new TextMessageBody("发送的内容");
//                message.addBody(txtBody);
//                message.setReceipt("huangzhenjie");
//                conversation.addMessage(message);
//                EMChatManager.getInstance().sendMessage(message, new EMCallBack() {
//                    @Override
//                    public void onSuccess() {
//
//                        Log.d("main", "发送成功");
//                    }
//
//                    @Override
//                    public void onError(int i, String s) {
//
//                        Log.d("main", "发送失败");
//                    }
//
//                    @Override
//                    public void onProgress(int i, String s) {
//
//                        Log.d("main", "发送中...");
//                    }
//                });
//                    ed_Text.setText("");
//            }
//        });

    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }

    private class NewMessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 注销广播
            abortBroadcast();

            // 消息id（每条消息都会生成唯一的一个id，目前是SDK生成）
            String msgId = intent.getStringExtra("msgid");
            //发送方
            String username = intent.getStringExtra("from");
            // 收到这个广播的时候，message已经在db和内存里了，可以通过id获取mesage对象
            EMMessage message = EMChatManager.getInstance().getMessage(msgId);
            EMConversation	conversation = EMChatManager.getInstance().getConversation(username);
            // 如果是群聊消息，获取到group id
            if (message.getChatType() == EMMessage.ChatType.GroupChat) {
                username = message.getTo();
            }
            if (!username.equals(username)) {
                // 消息不是发给当前会话，return
                return;
            }
            //刷新listview
            conversation.addMessage(message);
            adapter.notifyDataSetChanged();
            listView.setAdapter(adapter);
            listView.setSelection(listView.getCount()-1);
        }
    }




    private class DataAdapter extends BaseAdapter
    {

        TextView textViewName;
    @Override
    public int getCount()
        {
            return conversation.getAllMessages().size();
        }

    @Override
    public Object getItem(int position)
        {
            return conversation.getAllMessages().get(position);
        }

    @Override
    public long getItemId(int position)
        {
            return position;
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
        {
        EMMessage message=conversation.getAllMessages().get(position);
        TextMessageBody body= (TextMessageBody) message.getBody();
        if(message.direct==EMMessage.Direct.RECEIVE)
            {
            if(message.getType()==EMMessage.Type.TXT)
                {
                convertView= LayoutInflater.from(MainTabNewsMessage.this).inflate(R.layout.listview_item,null);
                textViewName= (TextView) convertView.findViewById(R.id.textViewName);
                textViewName.setText(message.getFrom());
                }
            }
        else
            {
            if (message.getType()==EMMessage.Type.TXT)
                {
                convertView= LayoutInflater.from(MainTabNewsMessage.this).inflate(R.layout.listview_item_01,null);
                }
            }

            TextView textViewContent= (TextView) convertView.findViewById(R.id.textViewContent);
        textViewContent.setText(body.getMessage());
        return convertView;
}
}

}
