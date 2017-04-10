package com.example.aspose;

import org.springframework.stereotype.Component;

import com.aspose.words.Document;

@Component("ProcessWord")
public abstract class ProcessWord {
	public abstract Document execute(String templatePath, Object object) throws Exception;
}
