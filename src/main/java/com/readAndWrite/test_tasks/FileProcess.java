package com.readAndWrite.test_tasks;


import java.io.IOException;
import java.util.List;

public interface FileProcess {
	void splittingArrayAndProcessing(String path)  throws IOException;
	List<String> purposeRows();
}