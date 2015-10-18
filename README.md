# code-coder
代码自动生成器

webapp
	|--source:代码生成的数据来源，json结构
	|--codeTmpl:代码模板
	|--output:生成的成型代码文件
	
#注意
source的json结构与codeTmpl都可以自定义
	
//==============================================
//source代码数据源json结构定义
[{
	"classInfo":{
		"packageName":包名(string),
		"className":类名(string),
		"tableName":表名(string)
	},
	"attrInfoList":[
		{
			"attrTitle":属性汉字名(string),
			"attrName":属性英文名(string),
			"attrType":属性对象类型(string),
			"columnType":字段类型(string),
			"columnChecks":字段约束(string)
		}
	]
}]
//demo请参考"source/table_object.json"
//==============================================
