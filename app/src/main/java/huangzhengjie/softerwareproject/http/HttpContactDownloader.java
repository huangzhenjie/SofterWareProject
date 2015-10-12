package huangzhengjie.softerwareproject.http;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



import huangzhengjie.softerwareproject.adapter.MyAdapter;
import huangzhengjie.softerwareproject.maininterface.MainTabNews;
import huangzhengjie.softerwareproject.userinformation.UserIM;

public class HttpContactDownloader extends AsyncTask<String,Void,String>{

    private URL url;
    private HttpURLConnection httpURLConnection;
    private ListView listView;
    private Context context;

    public HttpContactDownloader(ListView listView, Context context) {

        this.listView = listView;
        this.context = context;
    }


    @Override
    protected String doInBackground(String... params) {

        StringBuffer stringBuffer=new StringBuffer();
        String line=null;
        BufferedReader bufferedReader = null;
        try {
            url=new URL("http://192.168.1.108:8080/users/userinfos.xml");
            httpURLConnection= (HttpURLConnection) url.openConnection();

            bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((line=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stringBuffer.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("main",""+s);
        try {
            Gson gson = new Gson();
           UserIM user = gson.fromJson(s, UserIM.class);


            Log.d("mainn", "" + gson.fromJson(s, UserIM.class).toString());
            MyAdapter adapter = new MyAdapter(context, user.userInfo);
           listView.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
