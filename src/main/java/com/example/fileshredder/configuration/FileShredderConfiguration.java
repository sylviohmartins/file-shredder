package com.example.fileshredder.configuration;

import java.io.File;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.fileshredder.listener.FileShredderListener;
import com.example.fileshredder.step.reader.FileShredderReader;
import com.example.fileshredder.step.writer.FileShredderWriter;


@Configuration
@EnableBatchProcessing
public class FileShredderConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	private FileShredderReader reader;

	/*@Autowired
	private FileShredderProcessor processor;*/

	@Autowired
	private FileShredderWriter writer;

	@Bean
	public Step step1() {
		return stepBuilderFactory
				.get("step1")
				.<File[], File[]>chunk(1)
				.reader(reader)
				//.processor(processor)
				.writer(writer)
				.build();
	}

	@Bean
	public Job myJob(FileShredderListener listener, Step step1) {
		return jobBuilderFactory
				.get("myJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}

}
