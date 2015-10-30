package huangzhengjie.softerwareproject.sendmessage.smsFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import huangzhengjie.softerwareproject.R;
import huangzhengjie.softerwareproject.sendmessage.bean.FestivalLab;
import huangzhengjie.softerwareproject.sendmessage.bean.Msg;

public class ChooseMsgActivity extends AppCompatActivity {

    private ListView mLvMsgs;
    private FloatingActionButton mFabToSend;
//    private MsgAdapter adapter;
    private  ArrayAdapter<Msg> adapter;
    private int mFestivalId;
    private LayoutInflater mInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_choose_msg);
        mInflater = LayoutInflater.from(this);
        Intent intent = getIntent();
        if (intent != null)
            mFestivalId = intent.getExtras().getInt(FestivalCategoryFragment.ID_FESTIVAL);
        else
            finish();

        setTitle(FestivalLab.getInstance().getFestivalById(mFestivalId).getName());
        initViews();
        initEvent();
    }

    private void initEvent() {
        mFabToSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
    }

    private void initViews() {
        mLvMsgs = (ListView) findViewById(R.id.id_lv_msgs);
        mFabToSend = (FloatingActionButton) findViewById(R.id.id_fab_toSend);
//        adapter = new MsgAdapter(FestivalLab.getInstance().getMsgByFestivalId(mFestivalId));
//

        mLvMsgs.setAdapter(adapter=new ArrayAdapter<Msg>(this,-1,FestivalLab.getInstance().getMsgByFestivalId(mFestivalId)){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView==null)
                {
                    convertView=mInflater.inflate(R.layout.item_msg,parent,false);
                }
                 TextView content= (TextView) convertView.findViewById(R.id.id_tv_content);
                Button toSend= (Button) convertView.findViewById(R.id.id_btn_toSend);

                content.setText("      "+getItem(position).getContent());
                toSend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO
                    }
                });
                return convertView;
            }

        });
    }


    //Adapter

//    class MsgAdapter extends BaseAdapter {
//        private List<Msg> mList;
//
//        public MsgAdapter(List<Msg> list) {
//            this.mList = list;
//        }
//
//        @Override
//        public int getCount() {
//            return mList == null ? 0 : mList.size();
//        }
//
//        @Override
//        public Msg getItem(int position) {
//            if (mList != null && mList.size() >= 0)
//                return mList.get(position);
//            else
//                return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ViewHoler holder;
//            if (convertView == null) {
//                holder = new ViewHoler();
//                convertView = mInflater.inflate(R.layout.item_msg, parent, false);
//                holder.msgText = (TextView) convertView.findViewById(R.id.id_tv_content);
//                holder.sendButton = (Button) convertView.findViewById(R.id.id_btn_toSend);
//                convertView.setTag(holder);
//            } else {
//                holder = (ViewHoler) convertView.getTag();
//            }
//            if (getItem(position) != null)
//                holder.msgText.setText(getItem(position).getContent());
//            holder.sendButton.setOnClickListener(listener);
//            holder.sendButton.setTag(getItem(position).getContent());
//            return convertView;
//        }
//
//
//        class ViewHoler {
//            public TextView msgText;
//            public Button sendButton;
//        }
//
//        private View.OnClickListener listener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ChooseMsgActivity.this, (String) v.getTag(), Toast.LENGTH_SHORT).show();
//            }
//        };
//    }


}
