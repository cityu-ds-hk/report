package edu.cityu.ds.report.serviceImpl;

import edu.cityu.ds.report.entity.Category;
import edu.cityu.ds.report.entity.City;
import edu.cityu.ds.report.entity.Topic;
import edu.cityu.ds.report.mapper.CategoryMapper;
import edu.cityu.ds.report.mapper.CityMapper;
import edu.cityu.ds.report.mapper.TopicMapper;
import edu.cityu.ds.report.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
        List<City> cityList = cityMapper.listCity();
        List<Category> categoryList = categoryMapper.listCategory();
        List<Topic> topicList = topicMapper.listTopic();
        Map<Integer, String> cityMap = new HashMap<>();
        Map<Integer, String> categoryMap = new HashMap<>();
        Map<Integer, String> topicMap = new HashMap<>();

        for(City city: cityList) {
            cityMap.put(city.getCityId(), city.getCity());
        }

        for(Category category: categoryList) {
            categoryMap.put(category.getCategoryId(), category.getCategoryName());
        }

        for(Topic topic: topicList) {
            topicMap.put(topic.getTopicId(), topic.getTopicName());
        }
        resultMap.put("cities", cityMap);
        resultMap.put("categories", categoryMap);
        resultMap.put("topics", topicMap);
        return resultMap;
    }
}
