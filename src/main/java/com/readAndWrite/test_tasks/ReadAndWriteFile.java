package com.readAndWrite.test_tasks;

import java.io.IOException;
import java.util.List;

/**
 * Класс ReadAndWriteFile
 */
public interface ReadAndWriteFile {

	List<String> readFile(String path) throws IOException;
	void writeUsingFiles(List<String> data, String outputPath) throws IOException;
}