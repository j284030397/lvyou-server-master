package com.lht.pdm;

import java.util.List;
import java.util.Map;

public class TableEntity {
    private String tableName;
    private String tableClassName;
    public String getTableClassName() {
		return tableClassName;
	}
	public void setTableClassName(String tableClassName) {
		this.tableClassName = tableClassName;
	}
	private String tableComment;
    private String tablePK;
    private List columns;
    public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTableComment() {
		return tableComment;
	}
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
	public String getTablePK() {
		return tablePK;
	}
	public void setTablePK(String tablePK) {
		this.tablePK = tablePK;
	}
	public List getColumns() {
		return columns;
	}
	public void setColumns(List columns) {
		this.columns = columns;
	}
}
