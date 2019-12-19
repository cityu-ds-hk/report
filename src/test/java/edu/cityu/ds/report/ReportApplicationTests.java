package edu.cityu.ds.report;

import edu.cityu.ds.report.entity.User;
import edu.cityu.ds.report.mapper.EventMapper;
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
    @Autowired
    EventMapper eventMapper;

    @Test
    void contextLoads() {
        User user = userService.loginIn("admin", "admin");
        System.out.println(user);
    }

    @Test
    void test() {

        logger.info("Date: {}", eventMapper.listEventNumByCategoryCity());
        logger.info("Date: {}", eventMapper.listEventNumByCity());
        logger.info("Date: {}", eventMapper.listEventNumByDate("%Y-%m", 1,null, null));
        logger.info("Date: {}", eventMapper.listEventNumByDateWithCity("%Y-%m", 1, null, null, 10001));

        Map<String, Object> map = commonService.getMetaData();
        logger.info("Map: {}", map);

    }

}
