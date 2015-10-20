package com.zaoming.utils;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.codeCoder.source.bean.ClassInfo;

public class STRendererTest {

	@Test
	public void testRender() {

		String strTmpl = "$source.classInfo.className$";

		ClassInfo classInfo = new ClassInfo();
		classInfo.setClassName("ldt");

		Map<String, Object> source = new HashMap<String, Object>();
		source.put("classInfo", classInfo);

		assertTrue("ldt".equals(STRenderer.render(strTmpl, source)));

	}
}
