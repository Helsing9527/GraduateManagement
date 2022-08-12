package icu.jswz.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import icu.jswz.pojo.User;
import icu.jswz.service.IUserService;
import icu.jswz.util.R;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理用户注册、登录
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    // 登录业务
    @PostMapping
    public R login(@RequestBody User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Strings.isNotEmpty(user.getAccount()),User::getAccount, user.getAccount()).eq(Strings.isNotEmpty(user.getPassword()), User::getPassword, user.getPassword());
        User loginUser = userService.getOne(lambdaQueryWrapper);
        if (loginUser != null) {
            return new R(true, loginUser, "登录成功 ^_^");
        }
        return new R(false, null, "登录失败");
    }

    // 注册业务
    @PostMapping("/register")
    public R register(@RequestBody User user) {
        if (user.getPermission() == 1024 || user.getPermission().equals(null)) {
            boolean flag = userService.save(user);
            if (flag) {
                return new R(true, null, "注册成功 ^_^ 自动跳转登录页...");
            }
            return new R(false, null, "哎呀~注册失败了 -_-||");
        }
        return new R(false, null, "当个普通人不好么，非要乱填授权码，重新注册吧");
    }
}
