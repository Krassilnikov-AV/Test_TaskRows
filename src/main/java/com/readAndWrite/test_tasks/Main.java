package com.readAndWrite.test_tasks;

import com.readAndWrite.test_tasks.task_1.File_1ProcessImpl;
import com.readAndWrite.test_tasks.task_2.File_2ProcessImpl;
import com.readAndWrite.test_tasks.task_3.File_3ProcessImpl;

import java.io.IOException;

/**
 * Класс Main
 */
public class Main {


	public static void main(String[] args) throws IOException {
		File_1ProcessImpl fileProcess1 = new File_1ProcessImpl();
		File_2ProcessImpl fileProcess2 = new File_2ProcessImpl();
		File_3ProcessImpl fileProcess3 = new File_3ProcessImpl();
		String path3 = "src/main/resources/input3.txt";
		fileProcess3.splittingArrayAndProcessing(path3);
		String path1 = "src/main/resources/input1.txt";
		fileProcess1.splittingArrayAndProcessing(path1);
		String path2 = "src/main/resources/input2.txt";
		fileProcess2.splittingArrayAndProcessing(path2);

	}
}