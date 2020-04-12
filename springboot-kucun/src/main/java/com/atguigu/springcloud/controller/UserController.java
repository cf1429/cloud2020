package com.atguigu.springcloud.controller;

import cn.hutool.core.util.StrUtil;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Book;
import com.atguigu.springcloud.entities.PageResult;
import com.atguigu.springcloud.entities.User;
import com.atguigu.springcloud.service.BookService;
import com.atguigu.springcloud.service.UserService;
import com.atguigu.springcloud.utils.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = {"/","/api/user"})
public class UserController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/findAllUser/{pageIndex}/{pageSize}")
    public CommonResult<PageResult<List<User>>> findAllBook(
            @PathVariable("pageSize") Integer pageSize, @PathVariable("pageIndex")Integer pageIndex){
        CommonResult<PageResult<List<User>>> commonResult = new CommonResult<>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pageIndex",pageIndex);
        map.put("pageSize",pageSize);
        PageResult<List<User>> bookList = userService.findAllUser(map);
        if(bookList != null){
            commonResult.setCode(200);
            commonResult.setData(bookList);
        }else{
            commonResult.setCode(404);
            commonResult.setMessage("没有查到有效信息");
        }
        return commonResult;
    }

    @PostMapping("/addUser")
    public CommonResult<String> addUser(@RequestBody User user){
        CommonResult<String> commonResult = new CommonResult<>();
        if(StrUtil.isBlank(user.getUserName()) || StrUtil.isBlank(user.getUserPassword())){
            commonResult.setCode(404);
            commonResult.setMessage("账号密码不能为空");
            return commonResult;
        }
        User user1 = userService.findUserByUserName(user.getUserName());
        if(user1 != null ){
            commonResult.setCode(404);
            commonResult.setMessage("账户名已存在");
            return commonResult;
        }
        user.setCreateTime(new Date());
        user.setState(0);
        user.setUserPassword(EncryptionUtil.getMd5(user.getUserPassword()));
        int num = userService.create(user);
        if(num >0 ){
            commonResult.setData("添加成功");
            commonResult.setCode(200);
        }else{
            commonResult.setMessage("添加失败");
            commonResult.setCode(404);
        }
        return commonResult;
    }

    @PostMapping(value = "/findUserById")
    public CommonResult<User> findUserById(@RequestBody User user){
        CommonResult<User> commonResult = new CommonResult<>();
        User user1 = userService.findUserById(Integer.valueOf(user.getId()));
        if(user1 != null ){
            commonResult.setData(user1);
            commonResult.setCode(200);
        }else{
            commonResult.setMessage("系统异常");
            commonResult.setCode(404);
        }
        return commonResult;
    }

    @PostMapping(value = "/updateUser")
    public CommonResult<String> updateUser(@RequestBody User user){
        CommonResult<String> commonResult = new CommonResult<>();
        int num = userService.updateUser(user);
        if(num >0 ){
            commonResult.setData("修改成功");
            commonResult.setCode(200);
        }else{
            commonResult.setMessage("修改失败");
            commonResult.setCode(404);
        }
        return commonResult;
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public CommonResult<String> deleteUser(@PathVariable(value = "id") String id){
        CommonResult<String> commonResult = new CommonResult<>();
        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setState(1);
        int num = userService.updateUser(user);
        if(num >0 ){
            commonResult.setData("修改成功");
            commonResult.setCode(200);
        }else{
            commonResult.setMessage("修改失败");
            commonResult.setCode(404);
        }
        return commonResult;
    }


}
