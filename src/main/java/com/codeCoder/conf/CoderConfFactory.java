package com.codeCoder.conf;

public class CoderConfFactory {

	private static SourceConf sourceConf;
	private static CodeTmplConf codeTmplConf;
	private static OutputConf outputConf;

	public static SourceConf getSourceConf() {
		return sourceConf;
	}

	public static void setSourceConf(SourceConf sourceConf) {
		CoderConfFactory.sourceConf = sourceConf;
	}

	public static CodeTmplConf getCodeTmplConf() {
		return codeTmplConf;
	}

	public static void setCodeTmplConf(CodeTmplConf codeTmplConf) {
		CoderConfFactory.codeTmplConf = codeTmplConf;
	}

	public static OutputConf getOutputConf() {
		return outputConf;
	}

	public static void setOutputConf(OutputConf outputConf) {
		CoderConfFactory.outputConf = outputConf;
	}

}
