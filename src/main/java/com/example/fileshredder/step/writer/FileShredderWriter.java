package com.example.fileshredder.step.writer;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.example.fileshredder.step.reader.FileShredderReader;

@Component
public class FileShredderWriter implements ItemWriter<List<File>> {

	private static final Logger LOG = LoggerFactory.getLogger(FileShredderReader.class);

	@Override
	public void write(List<? extends List<File>> files) throws Exception {
		try {
			if (files != null && !files.isEmpty()) {
				for (List<File> listFile : files) {
					for (File file : listFile) {
						file.delete();
						LOG.info("Deleted file :: " + file);
					}
				}
			}
			
			LOG.info("Erro ao interromper o processo.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
