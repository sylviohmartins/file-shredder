package com.example.fileshredder.step.reader;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class FileShredderReader implements ItemReader<List<Path>> {

	//private static final Logger LOG = LoggerFactory.getLogger(FolderReader.class);

	@Override
	public List<Path> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		List<Path> files = FileShredderReader.listFiles("D:\\file-shredder");
		return files;
	}

	public static List<Path> listFiles(String dir) throws IOException {
		List<Path> fileList = new ArrayList<>();

		Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if (!Files.isDirectory(file)) {
					fileList.add(file);
				}

				return FileVisitResult.CONTINUE;
			}
		});

		return fileList;
	}

}
