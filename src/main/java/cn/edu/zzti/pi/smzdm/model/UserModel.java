package cn.edu.zzti.pi.smzdm.model;

/**
 * 用户模型
 */
public class UserModel extends BaseModel {

    /**
     * 用户主键
     */
    private String id;
    /**
     * 用户名
     */
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
