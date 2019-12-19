package edu.cityu.ds.report.controller;

import edu.cityu.ds.report.entity.Result;
import edu.cityu.ds.report.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
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
    
    @RequestMapping(value = "/admin/count", method = RequestMethod.GET)
    public int getCount(HttpServletRequest request){
        return userService.getCount();
    }
    
    @RequestMapping(value = "/admin/areaCount", method = RequestMethod.GET)
    public Result getAreaCount(HttpServletRequest request){
        Map<String, Object> map = userService.getAreaCount();
        if(map!=null && map.size()!=0){
            return new Result(200, null, null,  map);
        }else{
            return new Result(202, null, "Program Failed!", null);
        }
    }
    
    @RequestMapping(value = "/admin/increasedCountTrend", method = RequestMethod.POST)
    public Result getTimeTrend(@RequestBody(required = false) Map<String, Object>map, HttpServletRequest request){
        Timestamp lTime = null;
        Timestamp rTime = null;
        Integer cityId = null;
        if(map != null) {
            if(map.get("lTime") != null && !"".equals(map.get("lTime").toString().trim())) {
                lTime = Timestamp.valueOf(map.get("lTime").toString());
            }
            if(map.get("rTime") != null && !"".equals(map.get("rTime").toString().trim())) {
                rTime = Timestamp.valueOf(map.get("rTime").toString());
            }
            if(map.get("cityId") != null) {
                cityId = Integer.valueOf(map.get("cityId").toString());
            }
        }

        Map<String, Object>  mapResult = userService.getIncreasedCountTrend(lTime, rTime, cityId);
        if(mapResult != null && mapResult.size()!=0){
            return new Result(200, null, null,  mapResult);
        }else{
            return new Result(202, null, "Program Failed!", null);
        }
    }
    
    @RequestMapping(value = "/admin/mTopicMembers", method = RequestMethod.POST)
    public Result getCategoryGroups(HttpServletRequest request){
        List<Map<String, List>> mapList = userService.getmTopicMembers();
        if(mapList!=null){
            return new Result(200, null, null, mapList);
        }else{
            return new Result(202, null, "Program Failed!", null);
        }
    }
    
}
