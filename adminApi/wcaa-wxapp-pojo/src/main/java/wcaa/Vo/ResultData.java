package wcaa.Vo;

public class ResultData {
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getRoles() {

        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    String introduction  ;
    String avatar ;
    String name  ;
    String[] roles ;
}
