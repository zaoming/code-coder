package com.codeCoder.core;

import java.io.Reader;
import java.util.List;

import org.apache.log4j.Logger;

import com.codeCoder.conf.CodeTmplConf;
import com.codeCoder.conf.CoderConfFactory;
import com.codeCoder.conf.OutputConf;
import com.codeCoder.conf.SourceConf;
import com.codeCoder.source.SourceConvertor;
import com.codeCoder.source.SourceReader;
import com.codeCoder.source.bean.ClassTableBean;
import com.zaoming.utils.FileHelper;
import com.zaoming.utils.JsonUtil;

public class CodeCoder {

	private Logger log = Logger.getLogger(FileHelper.class);

	public boolean code() {

		// 1.获取项目配置项
		SourceConf sourceConf = CoderConfFactory.getSourceConf();
		CodeTmplConf codeTmplConf = CoderConfFactory.getCodeTmplConf();
		OutputConf outputConf = CoderConfFactory.getOutputConf();

		// 2.读取数据文件,一个文件一条记录
		List<Reader> sourceList = SourceReader.readSource(sourceConf);

		if (sourceList == null || sourceList.size() == 0) {
			System.out.println("sourceList为空");
			return false;
		}

		System.out.println("sourceList:" + sourceList.size());

		// 3.根据数据文件构造数据对象
		List<ClassTableBean> classTableBeanList = SourceConvertor
				.convert(sourceList);

		if (classTableBeanList == null || classTableBeanList.size() == 0) {
			System.out.println("classTableBeanList为空");
			return false;
		}

		System.out.println(JsonUtil.toJsonString(classTableBeanList));

		// 4.根据数据对象构造配置对象

		// 5.根据数据对象与配置对象进行模板替换生成代码文件

		return true;
	}
}
