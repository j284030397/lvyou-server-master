package com.lht.pdm;
import java.util.ArrayList;
/*
 * Table 存放表
 */
import java.util.List;
public class Table {
    private String tableName;
    private String tableComment;
    private String tablePK;
 
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
	private List<Column> allColumns;
   
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    
    public List<Column> getAllColumns() {
    	if(allColumns==null){
    		allColumns=new ArrayList<Column>();
    	}
        return allColumns;
    }
    public void setAllColumns(List<Column> allColumns) {
        this.allColumns = allColumns;
    }
 
}