package cn.bdqn.controller;

import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("list")
    public String list(@RequestParam(value = "currPageNo",defaultValue = "1",required = false)int currPageNo, Model model){
        PageBean<User> pageBean = userService.findLimit(currPageNo,1);
        model.addAttribute("page",pageBean);
        return "list";
    }

    @RequestMapping("toadd")
    public String toadd(User user){
        return "add";
    }

    @RequestMapping("add")
    public String add(User user){
        userService.add(user);
        return "redirect:list";
    }

    @RequestMapping("toUpdate")
    public String getUserById(Model model,int id){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "update";
    }

    @RequestMapping("update")
    public String update(User user){
        userService.update(user);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(int id){
        userService.delete(id);
        return "redirect:list";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
