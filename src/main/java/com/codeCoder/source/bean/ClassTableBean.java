package com.codeCoder.source.bean;

import java.util.List;

public class ClassTableBean {

	private ClassInfo classInfo;
	private List<AttrInfo> attrInfoList;

	public ClassInfo getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(ClassInfo classInfo) {
		this.classInfo = classInfo;
	}

	public List<AttrInfo> getAttrInfoList() {
		return attrInfoList;
	}

	public void setAttrInfoList(List<AttrInfo> attrInfoList) {
		this.attrInfoList = attrInfoList;
	}

}
