package com.example.fileshredder.step.processor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

//@Component
public class FileShredderProcessor implements ItemProcessor<List<Path>, List<Path>> {

	// private static final Logger LOG =
	// LoggerFactory.getLogger(FolderProcessor.class);

	@Override
	public List<Path> process(List<Path> files) throws Exception {
		for (Path file : files) {
			Files.delete(file);
		}

		return files;
	}

}
