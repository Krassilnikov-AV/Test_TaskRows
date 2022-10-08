package com.readAndWrite.test_tasks.task_1;

import com.readAndWrite.test_tasks.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class File_1ProcessImpl implements FileProcess {
	private ReadAndWriteFileImpl readFileImpl = new ReadAndWriteFileImpl();
	private List<String> array;
	private String str;
	private int n = 0, m = 0, temp = 0;
	private List<String> arrN_element = new ArrayList<>();
	private List<String> arrM_element = new ArrayList<>();

	@Override
	public void splittingArrayAndProcessing(String path) throws IOException {

		array = readFileImpl.readFile(path);
		for (String arr : array) {
			str = arr;
			try {
				temp = Integer.parseInt(str);
			} catch (NumberFormatException ignored) {
			}
			if (temp != 0) {
				if (n == 0) {
					n = temp;
				} else {
					m = temp;
				}
			}
		}
		completionArrays();
		String outputPath = "src/main/resources/write/output1.txt";
		readFileImpl.writeUsingFiles(purposeRows(), outputPath);
	}

	private void completionArrays() {
		for (String s : array) {
			str = s;
			if (!str.isEmpty())
				try {
					temp = Integer.parseInt(str);
				} catch (NumberFormatException ignored) {
				}
			String tempS = String.valueOf(temp);
			if (temp == n & temp != m & !str.isEmpty() & !str.equals(tempS)) {
				arrN_element.add(str);
			} else if (temp == m & !str.isEmpty() & !str.equals(tempS)) {
				arrM_element.add(str);
			}
		}
	}

	@Override
	public List<String> purposeRows() {
		int i, j;
		String str1, str2;
		String[] words;
		List<String> totalString = new ArrayList<>();
		List<String> noEquals = new ArrayList<>();
		List<String> resalt = new ArrayList<>();

		for (i = 0; i < arrN_element.size(); i++) {
			str1 = arrN_element.get(i);
			words = str1.split(" ");
			for (j = 0; j < arrM_element.size(); j++) {
				str2 = arrM_element.get(j);
				for (String word : words) {
					if (str2.contains(word) & !totalString.contains(str1 + " : " + str2)) {
						totalString.add(str1 + " : " + str2);
					}
				}
			}
		}
		for (
			String tS : totalString) {
			resalt.add(tS);
			System.out.println(tS);
		}
		String strN;
		List<String> list = Arrays.asList(totalString.toString());
		String delim = "";
		String res = list.stream()
			.map(Object::toString)
			.collect(Collectors.joining(delim));

		for (i = 0; i < arrN_element.size(); i++) {
			strN = arrN_element.get(i);
			if (!res.contains(strN))
				noEquals.add(strN);
		}
		String strM;
		for (i = 0; i < arrM_element.size(); i++) {
			strM = arrM_element.get(i);
			if (!res.contains(strM))
				noEquals.add(strM);
		}
		for (
			String notEl : noEquals) {
			resalt.add(notEl + " : ?");
			System.out.println(notEl + " : ?");
		}
		return resalt;
	}
}