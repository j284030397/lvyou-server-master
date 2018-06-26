package com.dev.base.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PageObj
{
  private static final int DEFAULT_PAGE_SIZE = 10;
  private Integer pageSize;
  private Integer totalRecord;
  private Integer currPage;

  @JsonIgnore
  private int end;

  @JsonIgnore
  private int start;
  private Integer totalPage;

  public int getStart()
  {
    return this.start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return this.end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public PageObj(int currPage)
  {
    this.currPage = Integer.valueOf(currPage);
  }

  public PageObj()
  {
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getTotalPage() {
    return this.totalPage;
  }

  public void setTotalPage(Integer totalRecord) {
    this.totalRecord = totalRecord;
    if (this.pageSize == null) this.pageSize = Integer.valueOf(10);
    this.totalPage = Integer.valueOf(totalRecord.intValue() % this.pageSize.intValue() == 0 ? totalRecord.intValue() / this.pageSize.intValue() : totalRecord.intValue() / this.pageSize.intValue() + 1);
    this.start = ((this.currPage.intValue() - 1) * this.pageSize.intValue());
    this.end = (this.currPage.intValue() * this.pageSize.intValue() > totalRecord.intValue() ? totalRecord.intValue() : this.currPage.intValue() * this.pageSize.intValue() + 1);
  }

  public Integer getTotalRecord() {
    return this.totalRecord;
  }

  public void setTotalRecord(Integer totalRecord) {
    this.totalRecord = totalRecord;
  }

  public Integer getCurrPage() {
    return this.currPage;
  }

  public void setCurrPage(Integer currPage) {
    this.currPage = currPage;
  }
}