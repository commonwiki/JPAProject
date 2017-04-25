package com.example;

import java.io.File;
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
import com.example.plan.entity.Plan;
import com.example.plan.repository.PlanRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanTest {

	@Autowired
	PlanRepository planRepository;

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
			
	        InputStream resourceAsStream = PlanTest.class.getClassLoader().getResourceAsStream("aspose" +File.separator + "license.xml");  
			License aposeLic = new License();
			aposeLic.setLicense(resourceAsStream);
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

		List<Plan> listOfPlans = planRepository.findAll();

		Document doc = null;
		String docSavePath = "D:/star-plan-export/";
		String docxName = "C:\\Users\\Administrator.SKY-20170216RHG\\Desktop\\company_plan.docx";
		
		for (Plan plan : listOfPlans) {

			doc = processWord.execute(docxName, plan);
			doc.save(docSavePath + plan.getId() + "_" + plan.getAc1() + ".docx");

		}

	}

}
