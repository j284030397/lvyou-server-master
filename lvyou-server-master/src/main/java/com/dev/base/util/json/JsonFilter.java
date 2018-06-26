package com.dev.base.util.json;

import org.apache.commons.codec.binary.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


/**
 * 自定义JSON返回字段
 * @author Administrator
 *
 */
public class JsonFilter {

    private static final String INCLUDE = "JSON_INCLUDE";
    private static final String EXCEPT = "JSON_EXCEPT";

    @com.fasterxml.jackson.annotation.JsonFilter(INCLUDE)
    interface MyJsonInclude {}

    @com.fasterxml.jackson.annotation.JsonFilter(EXCEPT)
    interface MyJsonExcept {}


    public static String mapper(Object bean, Class<?> clazz, String include, String except) throws JsonProcessingException {

        if(clazz == null)
            return null;

        ObjectMapper mapper = new ObjectMapper();

        if(include!=null&&!include.equals("")){
            mapper.setFilters(new SimpleFilterProvider().addFilter(INCLUDE,
                    SimpleBeanPropertyFilter.filterOutAllExcept(include.split(","))));

            mapper.addMixInAnnotations(clazz, MyJsonInclude.class);
        }

        if(except!=null&&!except.equals("")){
            mapper.setFilters(new SimpleFilterProvider().addFilter(EXCEPT,
                    SimpleBeanPropertyFilter.serializeAllExcept(except.split(","))));

            mapper.addMixInAnnotations(clazz, MyJsonExcept.class);
        }

        return mapper.writeValueAsString(bean);
    }
    
    public static ObjectMapper getMapper( Class<?> clazz, String include, String except) throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
        if(clazz == null)
            return mapper;


        if(include!=null&&!include.equals("")){
            mapper.setFilters(new SimpleFilterProvider().addFilter(INCLUDE,
                    SimpleBeanPropertyFilter.filterOutAllExcept(include.split(","))));

            mapper.addMixInAnnotations(clazz, MyJsonInclude.class);
        }

        if(except!=null&&!except.equals("")){
            mapper.setFilters(new SimpleFilterProvider().addFilter(EXCEPT,
                    SimpleBeanPropertyFilter.serializeAllExcept(except.split(","))));

            mapper.addMixInAnnotations(clazz, MyJsonExcept.class);
        }

        return mapper;
    }

}
