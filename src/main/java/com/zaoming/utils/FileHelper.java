package com.zaoming.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public final class FileHelper {

	/**
	 * 文件读取
	 * 
	 * @param filePath
	 * @return
	 */
	public static String readString(String filePath) throws IOException {

		// 文件路径非空检测
		if (filePath == null || filePath.length() == 0) {
			System.out.println("模板文件路径为空");
			return null;
		}

		// 创建文件对象
		File file = new File(filePath);

		// 判断文件是否存在
		if (!file.exists()) {
			System.out.println("模板文件(" + filePath + ")不存在");
			return null;
		}

		// ==============================读取文件内容==============================
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), "UTF-8"));

		int n = 0;
		char[] ch = new char[1024];
		StringBuilder builder = new StringBuilder(1024);

		while (reader.ready()) {
			n = reader.read(ch);
			builder.append(ch, 0, n);
		}

		if (reader != null) {
			reader.close();
		}
		// ==============================//读取文件内容==============================

		// 获取文件内容
		String strTmpl = builder.toString();

		System.out.println("模板文件(" + filePath + ")内容:\n" + strTmpl);

		return strTmpl;
	}

	public static Reader read(String filePath) throws IOException {

		// 文件路径非空检测
		if (filePath == null || filePath.length() == 0) {
			System.out.println("模板文件路径为空");
			return null;
		}

		// 创建文件对象
		File file = new File(filePath);

		// 判断文件是否存在
		if (!file.exists()) {
			System.out.println("模板文件(" + filePath + ")不存在");
			return null;
		}

		// ==============================读取文件内容==============================
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(file), "UTF-8"));
		// ==============================//读取文件内容==============================

		return reader;
	}

	/**
	 * 文件写入
	 * 
	 * @param filePath
	 * @param strData
	 * @return
	 * @throws IOException
	 */
	public static boolean write(String filePath, String strData)
			throws IOException {

		// 文件路径非空检测
		if (filePath == null || filePath.length() == 0) {
			System.out.println("文件路径为空");
			return false;
		}

		// 文件内容赋默认值
		strData = strData == null ? "" : strData;

		// ============================文件夹检测与创建============================
		String fileDir = filePath.substring(0, filePath.lastIndexOf('/') + 1);
		File dir = new File(fileDir);

		if (!dir.exists()) {
			if (!dir.mkdirs()) {
				System.out.println("文件夹(" + fileDir + ")创建失败");
				return false;
			}
		}
		// ============================//文件夹检测与创建============================

		// ============================文件创建============================
		File file = new File(filePath);
		if (!file.exists()) {
			if (!file.createNewFile()) {
				System.out.println("文件(" + filePath + ")创建失败");
				return false;
			}
		}
		// ============================//文件创建============================

		// ============================把数据写到文件中============================
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(strData);

		if (writer != null) {
			writer.close();
		}
		// ============================把数据写到文件中============================

		System.out.println("新建文件(" + filePath + ")写入成功");

		return true;
	}

}
