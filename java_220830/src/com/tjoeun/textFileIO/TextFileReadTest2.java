package com.tjoeun.textFileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TextFileReadTest2 {

	public static void main(String[] args) {
		
		Scanner scanner = null;
		String filePath = ".\\src\\com\\tjoeun\\textFileIO\\data\\input.txt";
		
		try {
			scanner = new Scanner(new File(filePath));
			while (scanner.hasNextLine()) {
				String str = scanner.nextLine().trim();
				System.out.println(str);
				System.out.println(Arrays.toString(str.split(" ")));
				
				int i = 0; boolean b = false; double d = 0; String s = null;
				
//				String 변수에 저장된 문자열을 읽어들이는 Scanner
//				Scanner 클래스의 객체를 만들 때 생성자의 인수로 String 변수를 넘기면 String 변수에 저장된 데이터를 읽어들인다.
				Scanner scan = new Scanner(str);
//				hasNext() 메소드는 스캐너로 지정된 문자열에서 공백을 경계로 읽어들일 데이터가 있으면 true, 없으면 false를 리턴한다.
				while (scan.hasNext()) {
					if (scan.hasNextInt()) {	//	Scanner로 읽을 데이터가 int면 true, 아니면 false
						i = scan.nextInt();						
					} else if (scan.hasNextDouble()) {
						d = scan.nextDouble();
					} else if (scan.hasNextBoolean()) {
						b = scan.nextBoolean();						
					} else {
						s = scan.next();
					}					
				}
				System.out.println("i: " + i);
				System.out.println("b: " + b);
				System.out.println("d: " + d);
				System.out.println("s: " + s);
			}
			System.out.println("Success!");
		} catch (FileNotFoundException e) {
			System.out.println("디스크에 파일이 없습니다.");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		
		
	}
	
}
