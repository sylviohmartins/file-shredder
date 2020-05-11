package com.example.fileshredder.step.writer;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class FileShredderWriter implements ItemWriter<File[]> {

	private static final Logger LOG = LoggerFactory.getLogger(FileShredderWriter.class);

	@Override
	public void write(List<? extends File[]> files) throws Exception {
		try {
			if (files != null && files.length > 0) {
				for (File file : files) {
					file.delete();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
