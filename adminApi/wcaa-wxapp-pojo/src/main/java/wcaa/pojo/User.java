package wcaa.pojo;

import javax.persistence.Id;
import java.util.Date;

public class User {
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
     * 用户登录密码
     */
    private String password;

    /**
     * ip||登录地址
     */
    private String ip;

    /**
     * 用户头像
     */
    private String face;

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
     * 对应用户岗位表中的postcode
     */
    private String roles;

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
     * 获取用户登录密码
     *
     * @return password - 用户登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户登录密码
     *
     * @param password 用户登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取ip||登录地址
     *
     * @return ip - ip||登录地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip||登录地址
     *
     * @param ip ip||登录地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取用户头像
     *
     * @return face - 用户头像
     */
    public String getFace() {
        return face;
    }

    /**
     * 设置用户头像
     *
     * @param face 用户头像
     */
    public void setFace(String face) {
        this.face = face;
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

    /**
     * 获取对应用户岗位表中的postcode
     *
     * @return roles - 对应用户岗位表中的postcode
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置对应用户岗位表中的postcode
     *
     * @param roles 对应用户岗位表中的postcode
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }
}