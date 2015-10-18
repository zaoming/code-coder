package com.zaoming.utils;

import java.io.Reader;
import java.lang.reflect.Type;

import com.google.gson.Gson;

public final class JsonUtil {

	private JsonUtil() {
	}

	/**
	 * 把java对象转为json字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJsonString(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}

	/**
	 * json字符串转为简单的java对象
	 * 
	 * 如：Person.class
	 * 
	 * @param strJson
	 * @param cls
	 * @return
	 */
	public static <T> T fromJson(String strJson, Class<T> cls) {
		Gson gson = new Gson();
		return gson.fromJson(strJson, cls);
	}

	public static <T> T fromJson(Reader reader, Class<T> cls) {
		Gson gson = new Gson();
		return gson.fromJson(reader, cls);
	}

	/**
	 * json字符串转为复杂的集合对象
	 * 
	 * 如：new TypeToken<List<String>>(){}.getType();
	 * 
	 * @param strJson
	 * @param type
	 * @return
	 */
	public static <T> T fromJson(String strJson, Type type) {
		Gson gson = new Gson();
		return gson.fromJson(strJson, type);
	}

	public static <T> T fromJson(Reader reader, Type type) {
		Gson gson = new Gson();
		return gson.fromJson(reader, type);
	}

}
