package com.example.plan.aspose;

import org.springframework.stereotype.Component;

import com.aspose.words.Document;

/**
 * 功能：根据自定义模板进行数据匹配替换，返回Document
 * 
 * @author Administrator
 * 
 */
@Component("DocumentBean")
public class DocumentBean extends ProcessWord {

	@Override
	public Document execute(String templatePath, Object object) throws Exception {

		// 打开word模板
		Document doc = new Document(templatePath);

		doc.getMailMerge().executeWithRegions(new JavaBaenMailMergeDataSource<Object>(object, "Plan"));

		return doc;

	}
}
