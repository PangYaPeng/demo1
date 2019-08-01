package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    //记录所有用户名和密码的集合
    List<User> users = new ArrayList<>();

    //决定转到的页面
    //但是不熟，不能转过去
    Boolean b;


    @RequestMapping("/login")
    public String login(
            @RequestParam("name") String name,
            @RequestParam("password") String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        users.add(user);
        //判断list里面包不包含这个对象
        for (int i = 0; i < users.size(); i++) {
            if (user.equals(users.get(i))) {

                b = true;
            }

        }

        //最后转到的页面
        if (b) {
            System.out.println("已有用户登录");
            return "old";

        } else {
           System.out.println("新用户登录");
            return "new";
        }
    }
}

//存在一些问题：
//1.不能多个user加到集合里面
//2.想最后在页面上转到对应的html没有弄好

