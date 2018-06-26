package com.dev.base.cache;

import com.dev.base.security.MD5Util;
import java.io.PrintStream;
import java.lang.reflect.Method;
import org.springframework.cache.interceptor.KeyGenerator;

public class SurveyKeyGenerator
  implements KeyGenerator
{
  public Object generate(Object arg0, Method arg1, Object[] arg2)
  {
    String targHashCode = arg0.getClass().getSimpleName() + "[" + arg0.hashCode() + "]";
    String mname = arg1.getName();
    String key = null;

    if ((arg2 != null) && (arg2.length > 0)) {
      StringBuffer buffer = new StringBuffer();
      for (Object p : arg2) {
        buffer.append(p.toString() + ",");
      }

      key = targHashCode + "." + mname + "(" + MD5Util.MD5(buffer.toString()) + ")";
      System.out.println(key);
      return key;
    }

    key = targHashCode + "." + mname + "()";
    System.out.println(key);
    return key;
  }
}
