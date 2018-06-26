package com.dev.base.util;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

public class MyStringHttpMessageConverter2 extends StringHttpMessageConverter {  
    
    private static final MediaType utf8 = new MediaType("text", "plain", Charset.forName("GBK"));   
  
    @Override  
    protected MediaType getDefaultContentType(String dumy) {  
    	System.out.println("编码设四置。。。。。。。。。。。。。。。。。。。。。。。。");
        return utf8;  
    }  
      
} 