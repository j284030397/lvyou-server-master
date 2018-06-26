package com.dev.base.cache;

import com.dev.base.constants.Constants;
import com.dev.base.security.MD5Util;
import com.dev.lvyou.web.controller.dto.LyUserInfoDto;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memory")
public class Memory
{
  private static final Logger log = LoggerFactory.getLogger(Memory.class);
  private static final String CACHE_NAME="myCache";

  @Autowired
  CacheManager ehCacheManager;

  public void saveLyUserInfoDto(LyUserInfoDto loginUser)
  {
    String seed = MD5Util.MD5(loginUser.getUserName());
    System.out.println(seed);
    if (get(CACHE_NAME, seed) == null)
      log.debug(seed + "为空!");
    else {
      log.debug(String.format(loginUser.getUserName() + "的原seed为：%s,原token为：%s", new Object[] { seed, 
        get(CACHE_NAME, seed).toString() }));
    }

    String token = TokenProcessor.getInstance().generateToken(seed, true);

    loginUser.setLgtoken(token);

    remove(CACHE_NAME, seed);

    String timeout = Constants.tokenTimeout;
    int ttiExpiry = NumberUtils.toInt(timeout) * 60;
    log.debug("缓存新的seek值");
    put(CACHE_NAME, seed, token, ttiExpiry, 0);
    put(CACHE_NAME, token, loginUser, ttiExpiry, 0);
    log.debug(String.format(loginUser.getUserName() + "的新seed为：%s,新token为：%s", new Object[] { seed, 
      get(CACHE_NAME, seed).toString() }));
  }

  public boolean checkLoginInfo(String token)
  {
    return get(CACHE_NAME, token) != null;
  }

  public void put(String cacheName, String key, Object value)
  {
    Cache cache = this.ehCacheManager.getCache(cacheName);
    Element element = new Element(key, value);
    cache.put(element);
  }

  public void put(String cacheName, String key, Object value, int idle, int live)
  {
    Cache cache = this.ehCacheManager.getCache(cacheName);

    Element element = new Element(key, value, idle, live);
    cache.put(element);
  }

  public Object get(String cacheName, String key) {
	  System.out.println(this.ehCacheManager==null);
	 
    Cache cache = this.ehCacheManager.getCache(cacheName);
    System.out.println(cacheName);
    Element element = cache.get(key);
    return element == null ? null : element.getObjectValue();
  }

  public Cache get(String cacheName) {
    return this.ehCacheManager.getCache(cacheName);
  }

  public void remove(String cacheName, String key) {
    Cache cache = this.ehCacheManager.getCache(cacheName);
    cache.remove(key);
  }
}