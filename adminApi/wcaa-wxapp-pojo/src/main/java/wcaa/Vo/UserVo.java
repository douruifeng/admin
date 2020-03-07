package wcaa.Vo;

import javax.persistence.Id;
import java.util.Date;

public class UserVo {
    @Id
    private Integer id;

    /**
     * 用户id
     */
    private String userid;

    /**
     * 用户登录名
     */
    private String username;


    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 登录时间
     */
    private Date usertime;

    /**
     * 账号锁定时间
     */
    private Date locktime;

    /**
     * 用户岗位名称
     */
    private String postname;


    public String getPostname() {
        return postname;
    }

    public void setPostname(String postname) {
        this.postname = postname;
    }

    /**

     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return userid - 用户id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取用户登录名
     *
     * @return username - 用户登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户登录名
     *
     * @param username 用户登录名
     */
    public void setUsername(String username) {
        this.username = username;
    }



    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取登录时间
     *
     * @return usertime - 登录时间
     */
    public Date getUsertime() {
        return usertime;
    }

    /**
     * 设置登录时间
     *
     * @param usertime 登录时间
     */
    public void setUsertime(Date usertime) {
        this.usertime = usertime;
    }

    /**
     * 获取账号锁定时间
     *
     * @return locktime - 账号锁定时间
     */
    public Date getLocktime() {
        return locktime;
    }

    /**
     * 设置账号锁定时间
     *
     * @param locktime 账号锁定时间
     */
    public void setLocktime(Date locktime) {
        this.locktime = locktime;
    }


}