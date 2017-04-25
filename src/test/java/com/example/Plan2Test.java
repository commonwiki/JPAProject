package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.example.plan.aspose.ProcessWord;
import com.example.plan.entity.Plan2;
import com.example.plan.repository.Plan2Repository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Plan2Test {

	@Autowired
	Plan2Repository plan2Repository;

	@Autowired
	ProcessWord processWord;

	/**
	 * 获取license
	 * 
	 * @return
	 */
	public boolean getLicense() {
		boolean result = false;
		try {

			String  licensePath = Plan2Test.class.getResource(File.separator + "aspose" +File.separator + "license.xml").getPath();
			
			File file = new File(licensePath);
			InputStream is = new FileInputStream(file);
			License aposeLic = new License();
			aposeLic.setLicense(is);
			result = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Test
	public void contextLoads() throws Exception {

		// 验证License
		getLicense();

		List<Plan2> listOfPlans = plan2Repository.findAll();

		System.out.println(listOfPlans.size());

		Document doc = null;
		String docSavePath = "D:/star-plan2-export/";

		for (Plan2 plan2 : listOfPlans) {

			System.out.println(plan2.getAc1());

			String docxName = "C:\\Users\\Administrator.SKY-20170216RHG\\Desktop\\company_plan2.docx";
			doc = processWord.execute(docxName, plan2);
			String pname = plan2.getAc1();

			doc.save(docSavePath + "/" + plan2.getId() + "_" + pname + ".docx");

		}

	}

}
