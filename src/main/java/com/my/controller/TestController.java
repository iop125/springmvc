package com.my.controller;

import com.my.dao.OclassMapper;
import com.my.domain.Item;
import com.my.domain.po.Oclass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {
    @Resource(name ="oclassMapper")
    private OclassMapper oclassMapper;

    @Resource(name ="jedisPool")
    private JedisPool jedisPool;

    @RequestMapping("index")
    public ModelAndView index() {
        List<Item> itemList = new ArrayList<>();
        //商品列表
        Item item_1 = new Item();
        item_1.setName("联想笔记本");
        item_1.setPrice(6000f);
        item_1.setDetail("ThinkPad T430 联想笔记本电脑！");
        Item item_2 = new Item();
        item_2.setName("苹果手机");
        item_2.setPrice(5000f);
        item_2.setDetail("iphone6苹果手机！");

        itemList.add(item_1);
        itemList.add(item_2);
        //创建modelandView对象
        ModelAndView modelAndView = new ModelAndView();
        //添加model
        modelAndView.addObject("itemList", itemList);
        //添加视图
        modelAndView.setViewName("item/item-list");
        return modelAndView;
    }

    @RequestMapping("insertClass")
    @ResponseBody
    public String insertClass() {
        Oclass oclass = new Oclass(null,"第七班",2L);
//        oclassMapper.insert(oclass);
        return  jedisPool.getResource().get("key2");
    }
}
