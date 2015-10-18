package com.codeCoder.source;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.codeCoder.conf.SourceConf;
import com.zaoming.utils.FileHelper;

public class SourceReader {

	/**
	 * 从资源文件里获取字符串内容，一个文件一条记录
	 * 
	 * @param sourceConf
	 * @return
	 */
	public static List<Reader> readSource(SourceConf sourceConf) {

		// 获取资源文件配置项
		String sourceBasePath = sourceConf.getSourceBasePath();
		List<String> sourceFileList = sourceConf.getSourceFileList();

		// 资源文件配置项检测
		if (sourceBasePath == null || sourceBasePath.length() == 0) {
			return null;
		}
		if (sourceFileList == null || sourceFileList.size() == 0) {
			return null;
		}

		// 遍历sourceFileList读取每个文件中的内容
		List<Reader> sourceList = new ArrayList<Reader>();

		for (String sourceFile : sourceFileList) {

			if (sourceFile == null || sourceFile.length() == 0) {
				continue;
			}

			try {

				Reader source = FileHelper.read(sourceBasePath + sourceFile);
				if (source != null) {
					sourceList.add(source);
				}

			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}

		}

		return sourceList;
	}
}
