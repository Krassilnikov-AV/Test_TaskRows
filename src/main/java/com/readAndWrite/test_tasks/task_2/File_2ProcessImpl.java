package com.readAndWrite.test_tasks.task_2;

import com.readAndWrite.test_tasks.*;

import java.io.IOException;
import java.util.*;

/**
 * Класс File_1ProcessImpl
 */
public class File_2ProcessImpl implements FileProcess {
	private ReadAndWriteFileImpl readFileImpl = new ReadAndWriteFileImpl();
	//		длина первого и второго массивов
	private int n = 0, m = 0;
	//		временная переменная для установки количества элементов в массиве

	private List<String> arrN_element = new ArrayList<>();
	private List<String> arrM_element = new ArrayList<>();
	private List<String> resaltArray = new ArrayList<>();
	private String strNel, strMel;

	@Override
	public void splittingArrayAndProcessing(String path)  throws IOException {
		List<String> array = readFileImpl.readFile(path);
		for (String arr : array) {
			if (arr.isEmpty()) {
			} else {
				if (n != 0 & m == 0) {
					int tempM = 0;
					try {
						tempM = Integer.parseInt(arr);
					} catch (NumberFormatException ignored) {
					}
					m = tempM;
				} else if (n == 0 & m == 0) {
					int tempN = 0;
					try {
						tempN = Integer.parseInt(arr);
					} catch (NumberFormatException ignored) {
					}
					n = tempN;
				}
			}

			String tempSn = String.valueOf(n);
			String tempSm = String.valueOf(m);
			if (!arr.isEmpty() & !arr.equals(tempSn) & n != 0 & m == 0) {
				arrN_element.add(arr);
			} else if (!arr.equals(tempSm) & n != 0 & m != 0) {
				arrM_element.add(arr);
			}
		}
		String outputPath = "src/main/resources/write/output2.txt";
		readFileImpl.writeUsingFiles(purposeRows(), outputPath);
	}

	@Override
	public List<String> purposeRows() {
		for (String nStr : arrN_element) {
			strNel = nStr;
			for (String mStr : arrM_element) {
				strMel = mStr;
			}
			resaltArray.add(strNel + " : " + strMel);
		}
		System.out.println(strNel + " : " + strMel);
		return resaltArray;
	}
}