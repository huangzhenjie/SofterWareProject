package huangzhengjie.softerwareproject.sendmessage.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asd13_000 on 2015/10/31.
 */
public class SendedMsg
    {
        private int id;
        private String msg;
        private String numbers;
        private String names;
        private String festivalName;
        private Date date;
        private String dateStr;
        private DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public static final String TABLE_NAME="tb_sended_msg";
        public static final String COLUMN_MSG="msg";
        public static final String COLUMN_NUMBERS="numbers";
        public static final String COLUMN_NAMES="names";
        public static final String COLUMN_FES_NAME="festivalName";
        public static final String COLUMN_DATE="date";

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDateStr()
        {
            dateStr=df.format(date);
            return dateStr;
        }


        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getFestivalName() {
            return festivalName;
        }

        public void setFestivalName(String festivalName) {
            this.festivalName = festivalName;
        }

        public String getNames() {
            return names;
        }

        public void setNames(String names) {
            this.names = names;
        }

        public String getNumbers() {
            return numbers;
        }

        public void setNumbers(String numbers) {
            this.numbers = numbers;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
