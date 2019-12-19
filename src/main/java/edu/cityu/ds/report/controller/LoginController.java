package edu.cityu.ds.report.controller;

import edu.cityu.ds.report.entity.User;
import edu.cityu.ds.report.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Tag(name = "Login Interfaces", description = "Rest API of Login function")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }


    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @Operation(description = "User Login")
    public String login(String userName, String password, HttpSession session, HttpServletRequest request){
        User user = userService.loginIn(userName, password);
        logger.info("User Info: {}", user);
        if(user != null){
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("userId", user.getUserId());
            return "admin";
        }else {
            request.setAttribute("message", "User name or password error");
            return "forward:login";
        }
    }
    
    @RequestMapping(value = "/doLogout", method = RequestMethod.POST)
    @Operation(description = "User Logout")
    public String logout( HttpSession session, HttpServletRequest  request){
        session.invalidate();
        return "login";
    }

}
