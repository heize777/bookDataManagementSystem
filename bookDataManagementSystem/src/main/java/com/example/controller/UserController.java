package com.example.controller;

import com.example.exception.BusinessException;
import com.example.model.User;
import com.example.service.UserService;
import com.example.utils.ProjectUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 登录
    @PostMapping("/login")
    public Result userLogin(@RequestBody User user) {
        // 传来的账号密码
        String username = user.getUsername();
        String password = user.getPassword();
        // 对账号密码长度进行校验
        if (!ProjectUtil.verify(username, password)) {
            throw new BusinessException(Code.BUSINESS_LOGIN_ERR, "用户名或密码输入长度有误");
        }
        User realUser = userService.getPassword(username);
        if (realUser == null) {
            throw new BusinessException(Code.BUSINESS_LOGIN_ERR, "该用户没有注册,请先注册");
        }
        // 数据库查询的账号密码
        String rUsername = realUser.getUsername();
        String rPassword = realUser.getPassword();
        // 账号密码校验
        Boolean flag = (Objects.equals(rUsername, username) && Objects.equals(rPassword, password));
        User userInfo = userService.getUserInfo(username);
        String token = ProjectUtil.generateJwt(userInfo);
        return new Result(flag ? Code.LOGIN_OK : Code.LOGIN_ERR, flag ? token : null, flag ? "登陆成功" : "账号或密码有误");
    }

    // 注册
    @PostMapping("/register")
    public Result userRegister(User user,@RequestParam("repassword") String repassword) {
        String username = user.getUsername();
        String password = user.getPassword();
        // 账号密码和再次输入密码进行长度校验
        if (!ProjectUtil.verify(username, password, password)) {
            throw new BusinessException(Code.BUSINESS_REGISTER_ERR, "账号密码和再次输入密码长度有误");
        }

        // 密码与再次输入密码是否一致
        if (!Objects.equals(password, repassword)) {
            throw new BusinessException(Code.BUSINESS_REGISTER_ERR, "两次密码不一致");
        }

        User rUser = userService.getPassword(username);
        // 看看用户是否注册过
        if (rUser != null) {
            throw new BusinessException(Code.BUSINESS_REGISTER_ERR, "该账号已存在请重新创建");
        }

        // 没有注册则添加用户
        Boolean flag = userService.addUser(user);

        return new Result(flag ? Code.REGISTER_OK : Code.REGISTER_ERR, null, "注册成功");
    }

    // 更新用户信息
    @PostMapping("/update")
    public Result userUpdate(User user,@RequestParam("image") MultipartFile image) throws IOException {
        System.out.println(image);
        Boolean flag = false;
        if (!image.isEmpty()) {
            // 获取文件路径长度
            String fileName = ProjectUtil.UUIDFileName(image);
            // 转存到指定目录下
            image.transferTo(new File(fileName));
            // 给参数添加该属性值
            user.setUserPic(fileName);
            // 长度校验
            if (!ProjectUtil.verify(user.getNickname())) {
                throw new BusinessException(Code.BUSINESS_ERR, "昵称长度有误");
            }
            // 进行更新操作
            flag = userService.updateUser(user);
            return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, null, flag ? "更新个人信息成功" : "更新个人信息失败");
        }
        return new Result(Code.UPDATE_ERR, null, "更新个人信息失败");
    }

    // 获取用户个人信息
    @GetMapping("/getInfo")
    public Result userGetInfo(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        User user = userService.getUserInfo(username);
        return new Result(Code.GET_OK, user, "获取个人信息成功");
    }
}
