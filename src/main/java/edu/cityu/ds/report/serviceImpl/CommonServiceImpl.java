package edu.cityu.ds.report.serviceImpl;

import edu.cityu.ds.report.entity.Category;
import edu.cityu.ds.report.entity.Topic;
import edu.cityu.ds.report.mapper.CategoryMapper;
import edu.cityu.ds.report.mapper.CityMapper;
import edu.cityu.ds.report.mapper.TopicMapper;
import edu.cityu.ds.report.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TopicMapper topicMapper;

    @Override
    public Map<String, Object> getMetaData() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("cities", cityMapper.listCity());
        resultMap.put("categories", categoryMapper.listCategory());
        resultMap.put("topics", topicMapper.listTopic());
        return resultMap;
    }
}
