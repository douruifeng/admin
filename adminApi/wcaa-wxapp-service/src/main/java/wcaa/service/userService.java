package wcaa.service;

import wcaa.Vo.PageResult;
import wcaa.pojo.User;

import java.util.List;


public interface userService {

    /**
     * 判断用户是否存在
     */

    public  boolean queryUsernameIsExist(String username);

    /**
     * 查询用户信息
     * @param user
     */
    public  void saveUserInfo(User user);

    /**
     * 登录判断用户是否存在
     * @param user
     * @return
     */
    public User userLoginIsExist(User user);


    /**
     * 上传用户头像，更新用户信息
     * @param user
     */
    public  void updateUser(User user);

    /**
     * 根据UserId查询User信息
     * @param userId
     * @return
     */
    public User QueryUser(String userId);


    /**
     *
     * @return
     */
    public List<User> selestAll();

    /**
     *
     * @param page
     * @param limit
     * @return
     */
    public PageResult selePage(String page,String limit);
}
