package com.dev.lvyou.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@ResponseBody  
    @RequestMapping ( "/showView" )
    public List showView() {
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName( "viewName" );
       System.out.println("showView...");
       List list=new ArrayList();
       Map<String,String> map=new HashMap();
       map.put("id", "987543");
       map.put("name", "xiaojianjun");
       Map<String,String> map2=new HashMap();
       map2.put("id", "987543");
       map2.put("name", "xiaojianjun");
       list.add(map);
       list.add(map2);
       modelAndView.addObject( " 需要放到 model 中的属性名称 " , " 对应的属性值，它是一个对象 " );
       return list;
    }

} 