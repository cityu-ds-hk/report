package edu.cityu.ds.report.controller;

import edu.cityu.ds.report.entity.Result;
import edu.cityu.ds.report.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "User Interfaces", description = "Rest API of user function")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{id}")
    @Operation(description = "Find user by user_id")
    public Result getUserById(@PathVariable("id") Integer id) throws Exception {
        return new Result(200, null, null, userService.getUserById(id));
    }
    
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int getCount(HttpServletRequest request){
        return userService.getCount();
    }
    
    @RequestMapping(value = "/areaCount", method = RequestMethod.GET)
    public Result getAreaCount(HttpServletRequest request){
        Map<String, List> map = userService.getAreaCount();
        if(map!=null && map.size()!=0){
            return new Result(200, null, null,  map);
        }else{
            return new Result(202, null, "Program Failed!", null);
        }
    }
}
