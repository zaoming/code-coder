package com.codeCoder.source;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.codeCoder.source.bean.ClassTableBean;
import com.google.gson.reflect.TypeToken;
import com.zaoming.utils.JsonUtil;

public class SourceConvertor {

	/**
	 * 把资源文件内容列表转为java对象列表
	 * 
	 * @param sourceList
	 * @return
	 */
	public static List<ClassTableBean> convert(List<Reader> sourceList) {

		// 参数非空检测
		if (sourceList == null) {
			return null;
		}

		// 把资源文件内容转为ClassTableBean对象
		List<ClassTableBean> classTableBeanList = new ArrayList<ClassTableBean>();

		for (Reader source : sourceList) {

			List<ClassTableBean> classTableBean = JsonUtil.fromJson(source,
					new TypeToken<List<ClassTableBean>>() {
					}.getType());

			System.out.println(JsonUtil.toJsonString(classTableBean));

			if (classTableBean == null) {
				continue;
			}

			classTableBeanList.addAll(classTableBean);

		}

		return classTableBeanList;
	}
}
