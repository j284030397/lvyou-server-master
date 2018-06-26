package com.dev.base.util.map;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;


/**
 * Map 对象与 JavaBean 对象互转工具类 
 */
public class BeanToMapUtil
{
    /**
     * 将 Map对象转化为JavaBean
     * <一句话功能简述>
     * <功能详细描述>
     * @param map
     * @param T
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static <T> T convertMap2Bean(Map<String,Object> map, Class<T> T)
        throws Exception
    {
        if (map == null || map.size() == 0)
        {
            return null;
        }
        BeanInfo beanInfo = Introspector.getBeanInfo(T);
        T bean = (T)T.newInstance();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0, n = propertyDescriptors.length; i < n; i++)
        {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            //System.out.println("propertyName"+propertyName);
            //            String upperPropertyName = propertyName.toUpperCase();
            if (map.containsKey(propertyName))
            {
                Object value = map.get(propertyName);
                //这个方法不会报参数类型不匹配的错误。
//                if (value instanceof String||value instanceof Integer||value instanceof Double||value instanceof Float||value instanceof Long||value instanceof Boolean) {
//                  
//                }  
               // if (value instanceof java.sql.Timestamp){
              //如果没有下面几行，则在转换null时会抛异常，例如：org.apache.commons.beanutils.ConversionException: No value specified for 'BigDecimal'  
              //在org.apache.commons.beanutils.converters这个包下面有很多的Converter，可以按需要使用  
                BeanUtilsBean beanUtilsBean = new BeanUtilsBean(); 
                beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.BigDecimalConverter(null), BigDecimal.class);  
                beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.DateConverter(null), java.util.Date.class);  
                beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.SqlTimestampConverter(null), java.sql.Timestamp.class);  
                beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.SqlDateConverter(null), java.sql.Date.class);  
                beanUtilsBean.getConvertUtils().register(new org.apache.commons.beanutils.converters.SqlTimeConverter(null), java.sql.Time.class);
                beanUtilsBean.copyProperty(bean, propertyName, value);
               // }
            }
        }
        return bean;
    }
    
    /**
     * 将一个 JavaBean 对象转化为一个 Map 
     * <一句话功能简述>
     * <功能详细描述>
     * @param bean
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @see [类、类#方法、类#成员]
     */
    public static Map<String, Object> convertBean2Map(Object bean)
        throws IntrospectionException, IllegalAccessException, InvocationTargetException
    {
        Class<? extends Object> type = bean.getClass();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++)
        {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class"))
            {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null)
                {
                    returnMap.put(propertyName, result);
                }
                else
                {
                    returnMap.put(propertyName, null);
                }
            }
        }
        return returnMap;
    }
    
    /**
     * 将 List<Map>对象转化为List<JavaBean>
     * <一句话功能简述>
     * <功能详细描述>
     * @param listMap
     * @param T
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static <T> List<T> convertListMap2ListBean(List<Map<String, Object>> listMap, Class<T> T)
        throws Exception
    {
        List<T> beanList = new ArrayList<T>();
        if (listMap != null && !listMap.isEmpty())
        {
            for (int i = 0, n = listMap.size(); i < n; i++)
            {
                Map<String, Object> map = listMap.get(i);
                T bean = convertMap2Bean(map, T);
                beanList.add(bean);
            }
            return beanList;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * 将 List<JavaBean>对象转化为List<Map>
     * <一句话功能简述>
     * <功能详细描述>
     * @param beanList
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static <T> List<Map<String, Object>> convertListBean2ListMap(List<T> beanList, Class<T> T)
        throws Exception
    {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        for (int i = 0, n = beanList.size(); i < n; i++)
        {
            Object bean = beanList.get(i);
            Map<String,Object> map = convertBean2Map(bean);
            mapList.add(map);
        }
        return mapList;
    }
}

