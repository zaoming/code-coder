package com.codeCoder.source;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.codeCoder.source.bean.ClassInfo;
import com.codeCoder.source.bean.ClassTableBean;
import com.google.gson.reflect.TypeToken;
import com.zaoming.utils.JsonUtil;
import com.zaoming.utils.StringHelper;

public final class SourceConvertor {

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

	/**
	 * 把通过配置文件生成的java对象列表转换为用于模板替换的java对象列表
	 * 
	 * @param classTableBeanList
	 */
	public static void compile(List<ClassTableBean> classTableBeanList) {

		for (ClassTableBean ClassTableBean : classTableBeanList) {

			if (ClassTableBean == null) {
				continue;
			}

			// 获取类配置信息
			ClassInfo classInfo = ClassTableBean.getClassInfo();

			// 获取基础配置信息
			String packageName = classInfo.getPackageName();
			String className = classInfo.getClassName();

			if (packageName == null || packageName.length() == 0) {
				continue;
			}

			if (className == null || className.length() == 0) {
				continue;
			}

			// 待生成配置信息
			String daoPackagePath = getDaoPackagePathFromPackageName(packageName);
			String firstLowerName = StringHelper.firstToLower(className);

			classInfo.setDaoPackagePath(daoPackagePath);
			classInfo.setFirstLowerName(firstLowerName);

		}

	}

	/**
	 * 根据包名生成dao层包名
	 * 
	 * @param packageName
	 * @return
	 */
	private static String getDaoPackagePathFromPackageName(String packageName) {

		if (packageName == null) {
			return "";
		}

		packageName = packageName.trim();// 去首尾空格

		if (packageName.length() == 0) {
			return "";
		}

		packageName = packageName.charAt(packageName.length() - 1) == '.' ? packageName
				.substring(1, packageName.length() - 1) : packageName;// 去最后一个点

		if (packageName.length() == 0) {
			return "";
		}

		int firstDot = packageName.indexOf('.');
		int secondDot = packageName.indexOf('.', firstDot + 1);
		int lastDot = packageName.lastIndexOf('.');

		System.out.println(packageName + ":" + firstDot + '\t' + secondDot
				+ '\t' + lastDot + '\t');

		// 无点，如：“com”，返回“com.dao”
		if (firstDot == -1) {
			return packageName + ".dao";
		}

		// 只有一天点，如：“com.codeCoder”,返回“com.codeCoder.dao”
		else if (firstDot != -1 && firstDot == lastDot) {
			return packageName + ".dao";
		}

		// 有两个点以上的，放在第二个点前一个,如："com.codeCoder.core",返回“com.codeCoder.dao.core”
		else if (firstDot != -1 && secondDot > firstDot && secondDot <= lastDot) {
			return StringHelper
					.insertStrOnIndex(packageName, secondDot, ".dao");
		} else {
			return "";
		}

	}

}
