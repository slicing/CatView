package com.slow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TraversalFile {
	public static void main(String[] args) {
		String path = "C:\\Users\\Sun Yongjiao\\Desktop\\大二下\\web开发";
		List<File> files = new ArrayList<>();
		findFile(path,files);
		for (File file : files){
			System.out.println(file.getName());
		}
	}

	private static void findFile(String path,List<File> files) {
		File file = new File(path);
		if (!file.exists()){
			System.out.println("This path not exist.");
		}
		else {
			File[] listFiles = file.listFiles();

			for (int i  = 0;i<listFiles.length;i++){
				if (listFiles[i].isDirectory())
					findFile(listFiles[i].getPath(),files);
				else if (listFiles[i].isFile()){
					if (listFiles[i].getName().toLowerCase().endsWith("exe"))
						files.add(listFiles[i]);
				}

			}
		}
	}
}
