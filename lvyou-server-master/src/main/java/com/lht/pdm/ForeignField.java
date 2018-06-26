package com.lht.pdm;

import com.lht.util.StringUtils;

import freemarker.template.utility.StringUtil;

public class ForeignField {
	private String foreignField;	
	private String referField;
	private String referenceTb;
	private String fromTb;
	private String fromClassTb;
	
	
	private String referenceClassTb;
	private String foreignClassField;
	
	private String forgnClassFieldFirstLowcase;
	private String referenceClassTbFirstLowcase;
	private String fromClassTbFirstLowcase;
	
	
	
	public String getFromClassTbFirstLowcase() {
		return fromClassTbFirstLowcase;
	}
	public void setFromClassTbFirstLowcase(String fromClassTb) {
		this.fromClassTbFirstLowcase = StringUtils.toLowerCase(fromClassTb);
	}
	public String getFromTb() {
		return fromTb;
	}
	public void setFromTb(String fromTb) {
		this.fromTb = fromTb;
	}
	public String getFromClassTb() {
		return fromClassTb;
	}
	public void setFromClassTb(String fromTb) {
		this.fromClassTb = StringUtils.toClassCase(fromTb);
	}
	public String getReferenceClassTbFirstLowcase() {
		return referenceClassTbFirstLowcase;
	}
	public void setReferenceClassTbFirstLowcase(String referenceClassTb) {
		this.referenceClassTbFirstLowcase = StringUtils.toLowerCase(referenceClassTb);
	}

	public String getForgnClassFieldFirstLowcase() {
		return forgnClassFieldFirstLowcase;
	}
	public void setForgnClassFieldFirstLowcase(String foreignClassField) {
		this.forgnClassFieldFirstLowcase = StringUtils.toLowerCase(foreignClassField);;
	}
	public String getForeignClassField() {
		return foreignClassField;
	}
	public void setForeignClassField(String foreignField) {
		this.foreignClassField = StringUtils.toClassCase(foreignField);
	}
	public String getReferenceClassTb() {
		return referenceClassTb;
	}
	public void setReferenceClassTb(String referenceClassTb) {
		this.referenceClassTb =StringUtils.toClassCase(referenceClassTb);
	}
	
	public String getForeignField() {
		return foreignField;
	}
	public void setForeignField(String foreignField) {
		this.foreignField = foreignField;
	}
	public String getReferenceTb() {
		return referenceTb;
	}
	public void setReferenceTb(String referenceTb) {
		this.referenceTb = referenceTb;
	}
	public String getReferField() {
		return referField;
	}
	public void setReferField(String referField) {
		this.referField = referField;
	}
	
}
