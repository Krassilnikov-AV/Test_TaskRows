package com.readAndWrite.test_tasks.task_3;

import com.readAndWrite.test_tasks.*;

import java.io.IOException;
import java.util.*;
import java.util.regex.*;

/**
 * Класс File_3ProcessImpl
 * осуществляет обработку данных с полученного файла для чтения при помощи метода splittingArrayAndProcessing(String path)
 * после получения данных и формирования их в массиве, прочитанные данные получают согасно заданию определённые числа
 * n и m. Полувченные числа соответсвуют количествуют заполненным строкам в искомом файле, а так же являются
 * указателем для добавления данных во вновь созданные списки (List) для последующей работы с ними.
 * В методе purposeRows() метод для разбивки прочитанных и рассортированных по спискам данных в окончательный список
 * для вывода. Для этого создаётся два списка (один для хранения сопоставляющих строк - totalString, второй для
 * хранения результирующего списка, который запишется в файл).
 */
public class File_3ProcessImpl implements FileProcess {
	private ReadAndWriteFileImpl readFileImpl = new ReadAndWriteFileImpl();
	private List<String> array;
	private String str;
	private int n = 0, m = 0;
	private List<String> arrN_element = new ArrayList<>();
	private List<String> arrM_element = new ArrayList<>();

	@Override
	public void splittingArrayAndProcessing(String path) throws IOException, NumberFormatException {
		array = readFileImpl.readFile(path);
		for (String arr : array) {
			str = arr;
			if (!str.isEmpty()) {
				if (n == 0 & m == 0 & !isAlpha(str)) {
					int tempN;
					tempN = Integer.parseInt(str);
					n = tempN;
				} else if (n != 0 & m == 0 & !isAlpha(str)) {
					int tempM = 0;
					try {
						tempM = Integer.parseInt(str);
					} catch (NumberFormatException ignored) {
					}
					m = tempM;
				}
			}
			String tempSn = String.valueOf(n);
			String tempSm = String.valueOf(m);
			if (!str.isEmpty() & !str.equals(tempSn) & n != 0 & m == 0) {
				arrN_element.add(str);
			} else if (!str.isEmpty() & !str.equals(tempSm) & n != 0 & m != 0) {
				arrM_element.add(str);
			}
		}
		String outputPath = "src/main/resources/write/output3.txt";
		readFileImpl.writeUsingFiles(purposeRows(), outputPath);
	}

	private boolean isAlpha(String str) {
		return str.matches("[a-zA-Z]+");
	}

	@Override
	public List<String> purposeRows() {
		String str1, str2;
		List<String> totalString = new ArrayList<>();
		List<String> resaltArray = new ArrayList<>();
		String[] words;
		int i, j;
		Pattern pattern;
		Matcher matcher;
		for (i = 0; i < arrN_element.size(); i++) {
			str1 = arrN_element.get(i);
			words = str1.split(" ");
			for (j = 0; j < arrM_element.size(); j++) {
				str2 = arrM_element.get(j);
				for (String word : words) {
					String w = word.toLowerCase();
					if (w.length() > 3) {
						pattern = Pattern.compile(w + "\\w*");
						matcher = pattern.matcher(str2);
						String res;
						while (matcher.find()) {
							res = matcher.group();
							if (res.contains(w)) {
								totalString.add(str1 + " : " + str2);
								System.out.println(str1 + " : " + str2);
							}
						}
					}
				}
			}
		}
		for (String t : totalString) {
			for (String aM : arrM_element) {
				if (!t.contains(aM)) {
					resaltArray.add(aM + " : ?");
					System.out.println(aM + " : ?" + "\n***********");
				} else if (t.contains(aM)) {
					resaltArray.add(t);
				}
			}
		}
		return resaltArray;
	}
}
