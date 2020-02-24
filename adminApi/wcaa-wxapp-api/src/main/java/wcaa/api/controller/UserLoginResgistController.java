package wcaa.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import wcaa.Vo.ResultData;
import wcaa.Vo.Token;
import wcaa.utils.JSONResult;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@Api(value = "用户注册登录的接口",tags = "用户登录注册")
public class UserLoginResgistController extends BasicController{


    @ApiOperation(value = "用户注册", notes = "用户注册接口")
	@PostMapping("/regist")
	public JSONResult regist() {

		/**if(StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword() ))
		{
          return JSONResult.errorMsg("用户名或密码不能为空！");
		}


		if(!(userService.queryUsernameIsExist(user.getUsername())))
		{
            try {
                user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            userService.saveUserInfo(user);
            user.setPassword("");
            return JSONResult.ok(getUserVo(user));
		}
		else{
            return JSONResult.errorMsg("用户名已存在！");
        }*/

        return JSONResult.ok();
	}


    @ApiOperation(value = "用户登录", notes = "用户登录接口")
    @PostMapping("/login")
    public JSONResult login(@RequestBody String username,String password) {

        System.out.print(username);
        System.out.print(password);
        Token token = new Token();
        token.setToken("admin-token");


        return JSONResult.ok(token);

    }


    @ApiOperation(value = "用户注销", notes = "用户注销接口")
    @PostMapping("/logout")
    public JSONResult logout() {

        return JSONResult.ok("success");

    }


    @ApiOperation(value = "用户信息", notes = "用户信息接口")
    @ApiImplicitParam(name="token",value="用户登录的token",dataType="string",required = true)
    @GetMapping("/info")
    public JSONResult info(String token) {


        ResultData resultData = new ResultData();
        String[] roless = {"admin"};
        resultData.setRoles(roless);
        resultData.setIntroduction("我是一个超级管理员");
        resultData.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        resultData.setName("超级管理员");
        return JSONResult.ok(resultData);

    }














    //获得用户的token
    /**public UserVo getUserVo(User user)
    {
        String uniqueToken = UUID.randomUUID().toString().replaceAll("-", "");
        redisOperator.set(USER_REDIS_SESSION+":"+user.getId(),uniqueToken,1000 * 60 * 30);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);
        userVo.setUserToken(uniqueToken);

        return userVo;
    }*/
}
