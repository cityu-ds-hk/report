package edu.cityu.ds.report.controller;

import edu.cityu.ds.report.entity.Result;
import edu.cityu.ds.report.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "User Interfaces", description = "Rest API of user function")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{id}")
    @Operation(summary = "Find user by user_id")
    public Result getUserById(@PathVariable("id") Integer id) throws Exception {
        return new Result(200, null, null, userService.getUserById(id));
    }
}
