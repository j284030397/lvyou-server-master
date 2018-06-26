package com.dev.base.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCache
{
  private static final CacheManager cacheManager = new CacheManager();
  private Cache cache;

  public Cache getCache()
  {
    return this.cache;
  }

  public void setCache(Cache cache) {
    this.cache = cache;
  }

  public Object getCacheElement(String cacheKey)
    throws Exception
  {
    Element e = this.cache.get(cacheKey);
    if (e == null) {
      return null;
    }
    return e.getValue();
  }

  public void addToCache(String cacheKey, Object result)
    throws Exception
  {
    Element element = new Element(cacheKey, result);
    this.cache.put(element);
  }
}