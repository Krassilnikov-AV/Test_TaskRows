package com.readAndWrite.test_tasks;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Класс ReadAndWriteFileImpl
 */
public class ReadAndWriteFileImpl implements ReadAndWriteFile {

	@Override
	public List<String> readFile(String path) throws IOException {
		List<String> arrayLine = new ArrayList();
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();

			while (line != null) {
				arrayLine.add(line);
				line = reader.readLine();
			}
		} catch (
			FileNotFoundException e) {
			System.out.println("Не нашлось файла по укзанному пути!");
		}
		return arrayLine;
	}

	@Override
	public void writeUsingFiles(List<String> data, String outputPath) throws IOException {
			Files.write(Paths.get(outputPath), data);
	}
}