package edu.cityu.ds.report;

import edu.cityu.ds.report.entity.User;
import edu.cityu.ds.report.service.CommonService;
import edu.cityu.ds.report.service.GroupService;
import edu.cityu.ds.report.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ReportApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(ReportApplicationTests.class);

    @Autowired
    UserService userService;
    @Autowired
    GroupService groupService;
    @Autowired
    CommonService commonService;

    @Test
    void contextLoads() {
        User user = userService.loginIn("admin", "admin");
        System.out.println(user);
    }

    @Test
    void test() {
//        List<Map<String, Object>> list = groupService.listGroupNumByCategoryCity();
//        logger.info("List: {}", list);
        List<Map<String, Object>> list = groupService.listGroupNumByDate("Year", 1, "2010", "2018", 10001);
        logger.info("List: {}", list);
        Map<String, Object> map = commonService.getMetaData();
        logger.info("Map: {}", map);

    }

}
