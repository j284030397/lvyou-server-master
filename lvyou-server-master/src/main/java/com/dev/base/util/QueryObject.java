package com.dev.base.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dev.Constants;

public class QueryObject implements Serializable {
	 private static final long serialVersionUID = 1L;
	  private String sort;
	  private String dir;
	  private int start;
	  private int limit;
	  private int totalCount;
	  private Collection parameters;
	  private Map staticParam;
	  
	  private List results;
	  private String selectId;
	  private String filterSql;
	  private PageObj pageObj;

	  public PageObj getPageObj() {
		return pageObj;
	}

	public void setPageObj(PageObj pageObj) {
		this.pageObj = pageObj;
	}

	public QueryObject()
	  {
	    this.dir = "0";
	    this.start = 0;
	    this.limit = Constants.PAGE_SIZE;
	    this.totalCount = 0;
	    this.parameters = new ArrayList();
	    this.staticParam = new HashMap();
	    //this.pageObj=new PageObj();
	  }

	  public List getResults() {
	    return this.results;
	  }

	  public void setResults(List result) {
	    this.results = result;
	  }

	  public int getTotalCount() {
	    return this.totalCount;
	  }

	  public void setTotalCount(int totalSize) {
	    this.totalCount = totalSize;
	  }

	  public Collection getParameters() {
	    return this.parameters;
	  }

	  public void setParameters(Collection parameters) {
	    this.parameters = parameters;
	  }

	  public Map getStaticParam() {
	    return this.staticParam;
	  }

	  public void setStaticParam(Map staticParam) {
	    this.staticParam = staticParam;
	  }

	  public String getDir() {
	    return this.dir;
	  }

	  public void setDir(String dir) {
	    this.dir = dir;
	  }

	  public int getLimit() {
	    return this.limit;
	  }

	  public void setLimit(int limit) {
	    this.limit = limit;
	  }

	  public String getSort() {
	    return this.sort;
	  }

	  public void setSort(String sort) {
	    this.sort = sort;
	  }

	  public int getStart() {
	    return this.start;
	  }

	  public void setStart(int start) {
	    this.start = start;
	  }

	  public String getSelectId() {
	    return this.selectId;
	  }

	  public void setSelectId(String selectId) {
	    this.selectId = selectId;
	  }

	  public String getFilterSql() {
	    return this.filterSql;
	  }

	  public void setFilterSql(String filterSql) {
	    this.filterSql = filterSql;
	  }
}
