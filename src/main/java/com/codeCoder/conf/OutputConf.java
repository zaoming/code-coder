package com.codeCoder.conf;

import java.util.Map;

public class OutputConf {

	private String outputBasePath;
	private Map<String, String> outputFileMap;

	public String getOutputBasePath() {
		return outputBasePath;
	}

	public void setOutputBasePath(String outputBasePath) {
		this.outputBasePath = outputBasePath;
	}

	public String getOutputFileMap(String key) {
		return outputFileMap.get(key);
	}

	public void setOutputFileMap(Map<String, String> outputFileMap) {
		this.outputFileMap = outputFileMap;
	}

}
