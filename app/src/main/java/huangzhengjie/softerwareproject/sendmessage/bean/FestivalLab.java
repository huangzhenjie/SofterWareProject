package huangzhengjie.softerwareproject.sendmessage.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asd13_000 on 2015/10/15.
 */
public class FestivalLab {

    public static FestivalLab mInstance;

    private List<Festival> mfestivals=new ArrayList<>();
    private List<Msg> mMsgs=new ArrayList<>();


    private  FestivalLab()
    {
        mfestivals.add(new Festival(1,"国庆节"));
        mfestivals.add(new Festival(2,"中秋节"));
        mfestivals.add(new Festival(3,"元旦"));
        mfestivals.add(new Festival(4,"春节"));
        mfestivals.add(new Festival(5,"端午节"));
        mfestivals.add(new Festival(6,"七夕节"));
        mfestivals.add(new Festival(7,"圣诞节"));
        mfestivals.add(new Festival(8,"儿童节"));

        mMsgs.add(new Msg(1,1,"如果我有一百万我将送你999999，我有一百万吗？没有，所以我只能用一毛钱发个短信祝你国庆快乐。"));
        mMsgs.add(new Msg(2,1,"如果我有一百万我将送你9，我有一百万吗？没有，所以我只能用一毛钱发个短信祝你国庆快乐。"));
        mMsgs.add(new Msg(3,1,"如果我有一百万我将送你999999，我有一百万吗？没有，所以我只能用一毛钱发个短信祝你国庆快乐。"));
        mMsgs.add(new Msg(4,1,"如果我有一百万我将送你999999，我有一百万吗？没有，所以我只能用一毛钱发个短信祝你国庆快乐。"));
        mMsgs.add(new Msg(5,1,"如果我有一百万我将送你999999，我有一百万吗？没有，所以我只能用一毛钱发个短信祝你国庆快乐。"));
        mMsgs.add(new Msg(6,1,"如果我有一百万我将送你999999，我有一百万吗？没有，所以我只能用一毛钱发个短信祝你国庆快乐。"));
        mMsgs.add(new Msg(7,1,"如果我有一百万我将送你999999，我有一百万吗？没有，所以我只能用一毛钱发个短信祝你国庆快乐。"));
        mMsgs.add(new Msg(8,1,"如果我有一百万我将送你999999，我有一百万吗？没有，所以我只能用一毛钱发个短信祝你国庆快乐。"));
        mMsgs.add(new Msg(9,1,"如果我有一百万我将送你999999，我有一百万吗？没有，所以我只能用一毛钱发个短信祝你国庆快乐。"));
    }

    public List<Msg> getMsgByFestivalId(int fesId)
    {
        List<Msg> msgs=new ArrayList<>();
        for(Msg msg:mMsgs)
        {
            if(msg.getFestivalId()==fesId)
            {
                msgs.add(msg);
            }
        }
        return msgs;
    }

    public Msg getMsgByMsgId(int id)
    {
        for(Msg msg:mMsgs)
        {
            if(msg.getId()==id)
                return msg;
        }
        return null;
    }

    public List<Festival> getFestivals()
    {
        return new ArrayList<Festival>(mfestivals);
    }

    public Festival getFestivalById(int fesId)
    {
        for(Festival festival:mfestivals)
        {
            if(festival.getId()==fesId)
                return festival;
        }

        return null;
    }



    public static FestivalLab getInstance()
    {
        if(mInstance==null)
        {
            synchronized (FestivalLab.class)
            {
                if(mInstance==null)
                {
                    mInstance=new FestivalLab();
                }
            }
        }
        return mInstance;
    }
}
