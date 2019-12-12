package edu.cityu.ds.report;

import edu.cityu.ds.report.entity.User;
import edu.cityu.ds.report.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ReportApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        User user = userService.loginIn("admin", "admin");
        System.out.println(user);
    }

}
