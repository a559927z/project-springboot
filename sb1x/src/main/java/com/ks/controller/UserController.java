package com.ks.controller;

import com.ks.dto.SbUser;
import com.ks.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title: ${type_name} <br/>
 * <p>
 * Description: <br/>
 *
 * @author jxzhang
 * @DATE 2018年08月27日 16:54
 * @Verdion 1.0 版本
 * ${tags}
 */

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 重定向列表页
     */
    private final String REDIRECT_LIST = "redirect:/user/list";

    @Resource
    UserService userService;


    /**
     * http://localhost:8080/sb1x/user/
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return REDIRECT_LIST;
    }


    /**
     * http://localhost:8080/sb1x/user/list
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model) {
        List<SbUser> users = userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }


    /**
     * http://localhost:8080/sb1x/user/toAdd
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    /**
     * http://localhost:8080/sb1x/user/add
     *
     * @return
     */
    @RequestMapping("/add")
    public String add(SbUser user) {
        userService.save(user);
        return REDIRECT_LIST;
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        SbUser user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(SbUser user) {
        userService.edit(user);
        return REDIRECT_LIST;
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return REDIRECT_LIST;
    }


}
