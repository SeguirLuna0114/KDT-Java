package p2023_08_07;

// File 클래스는 데이터들이 입.출력 하면서 사용하는 파일이나
// 디렉토리 체제를 관리하는 클래스임.

import java.io.*;

public class FileClass_file_directory_IO {

	public static void main(String[] args) {
		try {
			// File 객체 생성방법
			// "C:/java01" 디렉토리(폴더) 안에 "temp"라는 이름의 디렉토리를 나타내는 File 객체를 생성
			File temp = new File("C:/java01", "temp");	// 지정된위치에 파일 형성
			// 현재 작업 디렉토리에서 "test"라는 이름의 파일을 나타내는 File 객체를 생성
			File tempFile = new File("test");

			// 디렉토리 생성(mkdirs()는 디렉토리를 만들면 true를 반환함)
			System.out.println("create directory state : " + temp.mkdirs());
			System.out.println("create directory state : " + tempFile.mkdirs());

//			1. 디렉토리 삭제: 비어있는 디렉토리가 삭제됨
			tempFile.delete();
			
//			2. 비어있지 않은 디렉토리 삭제(과제)
			
//			3. 자식 디렉토리 삭제
			temp.delete();			// temp디렉토리 삭제
			
//			4. 부모 디렉토리 삭제
			// getParentFile()메소드를 사용하여 부모디렉토리 경로를 반환
			// => delete()메소드를 사용해 부모 디렉토리 삭제
			temp.getParentFile().delete();		// c:/java01 디렉토리 삭제
			
			
			// File 클래스에서 제공하는 메소드로 파일 시스템에 대한
			// 여러가지 정보를 얻을수 있음

			System.out.println("temp canRead : " + temp.canRead());
			System.out.println("temp canWrite : " + temp.canWrite());
			System.out.println("temp getAbsoluteFile : " + temp.getAbsoluteFile());
			System.out.println("temp getName : " + temp.getName());
			System.out.println("temp getParent : " + temp.getParent());
			System.out.println("temp getPath : " + temp.getPath());
			System.out.println("temp isDirectory : " + temp.isDirectory());
			System.out.println("temp isFile : " + temp.isFile());
			
		} catch (Exception e) {
		}
	}
}
