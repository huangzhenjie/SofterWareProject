package huangzhengjie.softerwareproject.sendmessage.bean;

/**
 * Created by asd13_000 on 2015/10/15.
 */
public class Festival {

    public Festival(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}