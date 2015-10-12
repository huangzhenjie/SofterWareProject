package huangzhengjie.softerwareproject.userinformation;

import java.util.List;

/**
 * Created by asd13_000 on 2015/10/12.
 */
public class UserIM {

    public List<UserI> userInfo;

    public static class UserI
    {
        private String head;
        private String name;
        private String signature;

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }


        @Override
        public String toString()
        {
            return "UserInfo [Head="+head+",name"+name+",signature="+signature+"]";
        }

    }
}
