package com.zaoming.utils;

import java.util.Map;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

public final class StringTemplateRenderer {

	/**
	 * 模板渲染
	 * 
	 * @param strTmpl
	 * @param source
	 * @return
	 */
	public static String render(String strTmpl, Map<String, Object> source) {

		// 自定义占位符
		STGroup group = new STGroup('$', '$');
		ST st = new ST(group, strTmpl);

		// 添加替换内容
		st.add("source", source);

		// 内容渲染
		return st.render();
	}

}
