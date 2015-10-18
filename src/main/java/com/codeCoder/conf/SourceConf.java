package com.codeCoder.conf;

import java.util.List;

public class SourceConf {

	private String sourceBasePath;
	private List<String> sourceFileList;

	public String getSourceBasePath() {
		return sourceBasePath;
	}

	public void setSourceBasePath(String sourceBasePath) {
		this.sourceBasePath = sourceBasePath;
	}

	public List<String> getSourceFileList() {
		return sourceFileList;
	}

	public void setSourceFileList(List<String> sourceFileList) {
		this.sourceFileList = sourceFileList;
	}

}
