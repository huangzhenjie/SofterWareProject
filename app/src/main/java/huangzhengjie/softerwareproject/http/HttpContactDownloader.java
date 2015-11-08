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

//耗时任务，AsyncTask封装了handle
public class HttpContactDownloader extends AsyncTask<String,Void,String>
{

    private URL url;
    private HttpURLConnection httpURLConnection;
    private ListView listView;
    private Context context;

    public HttpContactDownloader(ListView listView, Context context)
    {
        this.listView = listView;
        this.context = context;
    }

    //耗时任务执行的地方，执行完后，把结果返回到onPostExecute（）方法的参数处
    @Override
    protected String doInBackground(String... params) {

        StringBuffer stringBuffer=new StringBuffer();
        String line=null;
        BufferedReader bufferedReader = null;

        try {
            url=new URL("http://192.168.1.103:8080/users/userinfos.xml");
            httpURLConnection= (HttpURLConnection) url.openConnection();
            bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((line=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(line);
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try
            {
                bufferedReader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    //主线程操作（设置）
    @Override
    protected void onPostExecute(String s) {
        Log.d("main",""+s);
        try {
            //创建一个Gson对象
            Gson gson = new Gson();
            //解析一个json数据转化为一个实体类
           UserIM user = gson.fromJson(s, UserIM.class);

            Log.d("mainn", "" + gson.fromJson(s, UserIM.class).toString());

            //new一个自定义的adapter出来，把context对象和list集合传递过去
            MyAdapter adapter = new MyAdapter(context, user.userInfo);
           listView.setAdapter(adapter);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
