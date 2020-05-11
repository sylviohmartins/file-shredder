package com.example.fileshredder.step.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class FileShredderReader implements ItemReader<List<File>> {

	private static final Logger LOG = LoggerFactory.getLogger(FileShredderReader.class);

	private List<File> arrayList = new ArrayList<>();

	@Override
	public List<File> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		String pattern = ".*txt";
		File directory = new File("D:\\file-shredder");
		List<File> files = new ArrayList<>();

		return search(pattern, directory, files);
	}

	public List<File> search(final String pattern, final File directory, List<?> files) {
		for (final File f : directory.listFiles()) {
			if (f.isDirectory()) {
				search(pattern, f, files);
			}

			if (f.isFile()) {
				if (f.getName().matches(pattern)) {
					arrayList.add(f);
					LOG.info("File [" + f.toString() + "]");
				}
			}
		}
		
		return arrayList;
	}

}
