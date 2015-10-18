package com.codeCoder.conf;

import java.util.Map;

public class CodeTmplConf {

	private String codeTmplBasePath;
	private Map<String, String> codeTmplFileMap;

	public String getCodeTmplBasePath() {
		return codeTmplBasePath;
	}

	public void setCodeTmplBasePath(String codeTmplBasePath) {
		this.codeTmplBasePath = codeTmplBasePath;
	}

	public String getCodeTmplFileMap(String key) {
		return codeTmplFileMap.get(key);
	}

	public void setCodeTmplFileMap(Map<String, String> codeTmplFileMap) {
		this.codeTmplFileMap = codeTmplFileMap;
	}

}
