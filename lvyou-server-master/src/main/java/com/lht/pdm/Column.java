package com.lht.pdm;

import java.util.ArrayList;
import java.util.List;

import com.lht.util.StringUtils;


/*
 * Column 存放表的字段
 */
public class Column {
	//属性名
	private String colName;
	private String colDataType;
	private String colComment;
	private String colLength;
	private boolean isRequired;
	private boolean FK;
	private boolean PK;
	
	private List<ForeignField> foreignField;

	public List<ForeignField> getForeignField() {
		return foreignField;
	}

	public void setForeignField(List<ForeignField> foreignField) {
		this.foreignField = foreignField;
	}

	//大写属性名
	private String colClassName;
	//表字段名
	private String colTbName;
	public String getColTbName() {
		return colTbName;
	}

	public void setColTbName(String colTbName) {
		this.colTbName = colTbName;
	}

	public String getColClassName() {
		return colClassName;
	}

	public void setColClassName(String colName) {
		this.colClassName = StringUtils.toClassCase(colName);
	}

	public String getColDataType() {
		return colDataType;
	}

	public void setColDataType(String colDataType) {
		this.colDataType = colDataType;
	}

	public boolean isRequired() {
		return isRequired;
	}

	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}



	public String getColLength() {
		return colLength;
	}

	public void setColLength(String colLength) {
		this.colLength = colLength;
	}



	public String getColName() {
		return colName;
	}

	public void setColName(String colName) {
		this.colName = colName;
		setColClassName(colName);
	}

	public String getColComment() {
		return colComment;
	}

	public void setColComment(String colComment) {
		this.colComment = colComment;
	}

	public boolean isFK() {
		return FK;
	}

	public void setFK(boolean fK) {
		FK = fK;
	}

	public boolean isPK() {
		return PK;
	}

	public void setPK(boolean pK) {
		PK = pK;
	}
}