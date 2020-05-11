package com.example.fileshredder.step.reader;

import java.io.File;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class FileShredderReader implements ItemReader<File[]> {

	@Override
	public File[] read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		File diretorio = new File("D:\\file-shredder");
		File[] files = null;

		if (diretorio.isDirectory()) {
			files = diretorio.listFiles();

			return files;
		}

		return null;
	}

	// private static final Logger LOG =
	// LoggerFactory.getLogger(FolderReader.class);

	/*
	 * @Override public List<Path> read() throws Exception,
	 * UnexpectedInputException, ParseException, NonTransientResourceException {
	 * List<Path> files = FileShredderReader.listFiles("D:\\file-shredder"); return
	 * files; }
	 * 
	 * public static List<Path> listFiles(String dir) throws IOException {
	 * List<Path> fileList = new ArrayList<>();
	 * 
	 * Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
	 * 
	 * @Override public FileVisitResult visitFile(Path file, BasicFileAttributes
	 * attrs) throws IOException { if (!Files.isDirectory(file)) {
	 * fileList.add(file); }
	 * 
	 * return FileVisitResult.CONTINUE; } });
	 * 
	 * return fileList; }
	 */

}
