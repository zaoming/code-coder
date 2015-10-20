package com.codeCoder.source.bean;

public class ClassInfo {

	private String packageName;
	private String className;
	private String tableName;

	private String daoPackagePath;
	private String firstLowerName;

	public String getDaoPackagePath() {
		return daoPackagePath;
	}

	public void setDaoPackagePath(String daoPackagePath) {
		this.daoPackagePath = daoPackagePath;
	}

	public String getFirstLowerName() {
		return firstLowerName;
	}

	public void setFirstLowerName(String firstLowerName) {
		this.firstLowerName = firstLowerName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
