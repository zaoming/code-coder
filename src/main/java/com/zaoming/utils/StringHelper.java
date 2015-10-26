package com.zaoming.utils;

public final class StringHelper {

	/**
	 * 字符串首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String firstToLower(String str) {

		String first = str.substring(0, 1);

		return str.replaceFirst(first, first.toLowerCase());

	}

	/**
	 * 在指定位置传入字符串
	 * 
	 * @param string
	 * @param index
	 * @param str
	 * @return
	 */
	public static String insertStrOnIndex(String string, int index, String str) {

		if (string == null || string.length() < index) {
			return string;
		}

		return string.substring(0, index) + str + string.substring(index);

	}

}
