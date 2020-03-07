package wcaa.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import wcaa.Vo.PageResult;
import wcaa.Vo.UserVo;
import wcaa.mapper.CustomizeUserMapper;
import wcaa.mapper.UserMapper;
import wcaa.pojo.User;
import wcaa.service.userService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CustomizeUserMapper customizeUserMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {

        User user = new User();
        user.setUsername(username);

        User userResult = userMapper.selectOne(user);


        return userResult == null ? false : true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveUserInfo(User user) {

        //获取一个时间戳作为用户id
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        user.setUserid(dateFormat.format(date));

        userMapper.insert(user);

    }


    @Override
    public User userLoginIsExist(User user) {
        Example userExample = new Example(User.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username",user.getUsername());
        criteria.andEqualTo("password",user.getPassword());
        User res = userMapper.selectOneByExample(userExample);

        return res;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUser(User user) {

        Example userExample = new Example(User.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("id",user.getId());
        userMapper.updateByExampleSelective(user,userExample);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User QueryUser(String userId) {
        Example userExample = new Example(User.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("userid",userId);
        User result = userMapper.selectOneByExample(userExample);
        return result;
    }

    @Override
    public List<User> selestAll() {
        List<User> result = userMapper.selectAll();
        return result;
    }

    @Override
    public PageResult selePage(String page, String limit) {

        PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(limit));
        List<UserVo> result = customizeUserMapper.queryAllUser();
        PageInfo pageInfo = new PageInfo<>(result);

        PageResult pageResult = new PageResult();
        pageResult.setItems(result);
        pageResult.setTotal(pageInfo.getSize());
        return pageResult;
    }

}
