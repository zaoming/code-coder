package com.codeCoder.api;

import javax.servlet.http.HttpServletRequest;

import com.codeCoder.core.CodeCoder;

public class CodeCoderService implements IBaseService {

	public boolean action(HttpServletRequest req) {

		CodeCoder codeCoder = new CodeCoder();

		return codeCoder.code();
	}

}
