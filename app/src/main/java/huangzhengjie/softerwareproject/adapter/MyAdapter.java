package huangzhengjie.softerwareproject.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;

import java.util.List;

import huangzhengjie.softerwareproject.R;
import huangzhengjie.softerwareproject.userinformation.UserIM;

/**
 * Created by asd13_000 on 2015/10/12.
 */
public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<UserIM.UserI> userIList;

    public  MyAdapter(Context context,List<UserIM.UserI> userIList){
        this.context=context;
        this.userIList=userIList;
    }

    @Override
    public int getCount() {
        return userIList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        if(convertView!=null){
            view=convertView;
        }else {
            view=View.inflate(context, R.layout.listview_adapter_tab_news,null);

        }
        SmartImageView smartImageView= (SmartImageView) view.findViewById(R.id.SIV);
        TextView name= (TextView) view.findViewById(R.id.TV_Name);
        TextView signature= (TextView) view.findViewById(R.id.TV_Signature);

        UserIM.UserI user=userIList.get(position);
        smartImageView.setImageUrl(user.getHead(),R.drawable.image1,R.drawable.touxiang);
        Log.d("main", "" + user.getHead());
        name.setText(user.getName());
        Log.d("main", "" + user.getName());
        signature.setText(user.getSignature());
        Log.d("main", "" + user.getSignature());
        return  view;
    }
}
