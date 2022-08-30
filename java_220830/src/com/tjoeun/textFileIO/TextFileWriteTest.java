package com.tjoeun.textFileIO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileWriteTest {

	public static void main(String[] args) {

		Scanner scanner = null;
		PrintWriter printWriter = null;

//		파일의 경로와 이름을 설정한다.
//		경로 지정방식은 절대경로 지정방식과 상대경로 지정방식이 있다.
//		절대경로는 작업중인 파일이 위치한 디스크 드라이브의 최상위(root) 폴더(디렉토리)부터 파일이 위치한 폴더까지의 경로를 의미한다.
//		상대경로는 작업중인 파일이 포함된 프로젝트 이름의 폴더(".")부터 작업중인 파일이 위치한 폴더까지의 경로
//		Python이나 c/c++의 "."은 화면에 열려있는 파일이 위치나 폴더를 의미하지만 java의 "."은 파일이 포함된 프로젝트 이름의 폴더를 의미한다.
//		경로 지정시 경로와 경로, 경로와 파일을 구분하는 "\"가 에러가 발생되면 "\\"나 "/"로 변경한다.		

//		절대경로
//		String filePath = "D:\\workspace\\data\\out.txt";
//		String filePath = "D:/workspace/data/out.txt";
//		String filePath = "D:\\workspace\\java_220830\\src\\com\\tjoeun\\textFileIO\\data\\out.txt";
		String filePath = ".\\src\\com\\tjoeun\\textFileIO\\data\\out.txt";

		try {
			printWriter = new PrintWriter(filePath);
			scanner = new Scanner(System.in);

//			"QUIT"가 입력될 때까지 반복하며 키보드로 입력한 데이터를 파일에 저장한다.
			while (true) {
//				텍스트 파일에 저장할 데이터를 키보드로 입력받는다.
				System.out.print(">>> ");
				String str = scanner.nextLine().trim();

//				입력받은 내용이 "QUIT"일 경우 무한루프를 탈출한다.
				if (str.toUpperCase().equals("QUIT")) {
					break;
				}

//				키보드로 입력받은 내용을 텍스트 파일에 저장한다.
//				write() 메소드를 사용해서 PrintWriter 클래스 객체로 생성한 파일에 출력한다.
//				write() 메소드로 출력할 때 "\n"을 입력했음에도 불구하고 텍스트 파일에서 줄이 변경되어 보이지 않는다면 "\r\n"을 사용한다.
//				\n: new line, 줄을 바꾼다.
//				\r: carriage return, 커서를 그 줄의 맨 앞으로 보낸다.
				if (str.length() != 0) {
					printWriter.write(str + "\r\n");
				}
			}
			System.out.println("Saved!");
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			System.out.println("디스크에 파일이 존재하지 않습니다.");
		} finally {
			if (printWriter != null) {
//				출력 파일은 출력 작업이 완료되면 반드시 파일을 닫아야 정상적으로 파일이 생성된다.				
				printWriter.close();			
			}
		}

	}

}
