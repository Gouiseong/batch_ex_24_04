package com.koreait.exam.batch_ex_24_04;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchEx2404Application {
	public static void main(String[] args) {
		SpringApplication.run(BatchEx2404Application.class, args);
	}

}