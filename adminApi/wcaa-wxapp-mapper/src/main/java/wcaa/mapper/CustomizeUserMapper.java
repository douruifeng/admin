package wcaa.mapper;


import wcaa.Vo.UserVo;
import wcaa.pojo.User;
import wcaa.utils.MyMapper;

import java.util.List;

public interface CustomizeUserMapper extends MyMapper<User> {
    public List<UserVo> queryAllUser();
}