package wcaa.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import wcaa.service.userService;
import org.springframework.web.bind.annotation.*;
import wcaa.Vo.ResultData;
import wcaa.Vo.Token;
import wcaa.pojo.User;
import wcaa.utils.JSONResult;
import wcaa.utils.MD5Utils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;


@CrossOrigin
@RestController
@Api(value = "用户注册登录的接口",tags = "用户登录注册")
public class UserLoginController extends BasicController{


    @Resource
    private userService userService;



    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @PostMapping("/login")
    public JSONResult login(@RequestBody User user,HttpServletRequest httpServletRequest) {

        System.out.print(user.getUsername());
        if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()) )
        {
            return JSONResult.errorMsg("用户名或密码不能为空");
        }

        try {
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        User userResult = userService.userLoginIsExist(user);

        if(userResult != null)
        {

            return JSONResult.ok(getUserVo(userResult));

        }else {

            return JSONResult.errorMsg("用户名或密码错误！");

        }



    }


    @ApiOperation(value = "用户注销", notes = "用户注销接口")
    @PostMapping("/logout")
    public JSONResult logout() {

       /* if(StringUtils.isBlank(token))
        {
            return JSONResult.errorMsg("注销退出时Token值不允许为空");
        }*/

        //redisOperator.del(token);
        return JSONResult.ok("success");

    }


    @ApiOperation(value = "用户信息", notes = "用户信息接口")
    @ApiImplicitParam(name="token",value="用户登录的token",dataType="string",required = true)
    @GetMapping("/info")
    public JSONResult info(String token) {

        if(StringUtils.isBlank(token))
        {
            return JSONResult.errorMsg("获取用户信息的Token值不允许为空");
        }

        //String userId = redisOperator.get(token);

        User user = userService.QueryUser(token);

        ResultData resultData = new ResultData();

        resultData.setRoles(getSz(user));
        resultData.setIntroduction(user.getUsername());
        resultData.setAvatar(user.getFace());
        resultData.setName(user.getNickname());
        return JSONResult.ok(resultData);

    }














    //获得用户的token
    public Token getUserVo(User user)
    {
        String uniqueToken = UUID.randomUUID().toString().replaceAll("-", "");
        //redisOperator.set(user.getUserid(),uniqueToken,1000 * 60 * 30);
        Token token = new Token();
        token.setToken(user.getUserid());
        return token;
    }

    public String[] getSz(User user)
    {

        String[] roless = new String[1];
        roless[0] = user.getRoles();
        return roless;
    }


}
