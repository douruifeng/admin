package wcaa.api.controller;


import io.swagger.annotations.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import wcaa.Vo.PageResult;
import wcaa.pojo.User;
import wcaa.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wcaa.utils.JSONResult;
import java.io.*;
import java.util.List;

@CrossOrigin
@RestController
@Api(value = "用户相关业务的接口",tags = "用户相关业务的接口")
@RequestMapping("/user")
public class UserController extends BasicController{

    @Autowired
    private userService userService;

    @ApiOperation(value = "用户上传头像", notes = "用户上传接口")
    @ApiImplicitParam(name="userId",value="用户ID",dataType="string",required = true)
    @PostMapping("/uploadFace")
    public JSONResult logout(String userId,
                             @RequestParam("file") MultipartFile[] files) {

        //文件保存的空间
        String SaveFilesSpace ="C:/DRF/touxiang";

        //保存到数据库中的相对路径
        String SaveFilesDB = "/"+userId+"/face";

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;

        if(StringUtils.isBlank(userId))
        {
            return JSONResult.errorMsg("用户ID不能为空");
        }

        try {
        //操作文件流
        if(files != null && files.length > 0)
        {


            String filename = files[0].getOriginalFilename();
            if(StringUtils.isNotBlank(filename))
            {

                //文件上传的最终保存路径
                String fileFacePace = SaveFilesSpace + SaveFilesDB + "/" + filename;

                //设置数据库保存路径
                SaveFilesDB += ("/" + filename);

                File outFile = new File(fileFacePace);

                if(outFile.getParentFile() != null || outFile.getParentFile().isDirectory())
                {
                    //创建父文件夹
                    outFile.getParentFile().mkdirs();

                }


                fileOutputStream = new FileOutputStream(outFile);
                inputStream = files[0].getInputStream();
                IOUtils.copy(inputStream,fileOutputStream);
            }else {
                return JSONResult.errorMsg("上传访问出错！");
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
            return  JSONResult.errorMsg("上传访问出错！");
        }finally {
            if(fileOutputStream != null)
            {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (Exception e){
                    e.printStackTrace();
                    return  JSONResult.errorMsg("上传访问出错！");
                }
            }
        }

        //User user = new User();
        //user.setId(userId);
        //user.setPicture(SaveFilesDB);
        //userService.updateUser(user);

        return JSONResult.ok(SaveFilesDB);
    }

    @ApiOperation(value = "管理员信息", notes = "管理员信息查询接口")
    @GetMapping("/list")
    public JSONResult QueryUser(@ApiParam @RequestParam (value="page",required = false,defaultValue = "1") String page,
                                @ApiParam @RequestParam (value="limit",required = false,defaultValue = "20") String limit,
                                @ApiParam @RequestParam (value="sort",required = false,defaultValue = "%2Bid") String sort) {

        PageResult pageResult = userService.selePage(page,limit);
        return JSONResult.ok(pageResult);
    }
}
