package com.example.fileshredder.step.writer;

import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class FileShredderWriter implements ItemWriter<List<Path>> {

	private static final Logger LOG = LoggerFactory.getLogger(FileShredderWriter.class);

	@Override
	public void write(List<? extends List<Path>> files) throws Exception {
		for (List<Path> file : files) {
			files.contains(file);
		}

		if (!files.isEmpty()) {
			LOG.info("Falha.");
		}
	}

}
