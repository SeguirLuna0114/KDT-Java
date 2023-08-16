package p2023_08_04;

import java.io.*;

public class ByteStream_FileOutputStream_write {
	public static void main(String[] args) {

		// 객체 외부에서 선언 => try~catch문 외에서도 사용가능
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			// * 첫째 인수로 지정된 파일 객체에서 읽어서
			// 둘째 인수로 지정된 파일 객체에 출력함
			// (즉, 동일한 파일이 생성됨)
			// File에서 데이터를 읽어오는 FileInputStream 객체 생성
			fis = new FileInputStream("read.txt");

			// File에 데이터를 전송하기 위한 FileOutputStream 객체 생성
			fos = new FileOutputStream("read1.txt");	// 상대경로
//			fos = new FileOutputStream("d:/read1.txt");	// 상대경로

			int input = 0;

			// File에 저장된 모든 데이터를 스트림을 통해
			// 읽어 들여 File에 저장
			// 파일의 내용을 끝까지 다 읽으면 -1이 반환됨.
			while ((input = fis.read()) != -1) {
				System.out.print((char) input); // 화면에 출력 부분
				fos.write(input); // 다른 파일에 쓰는 부분
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			
			if (fis != null) {
				try {
					// FileInputStream을 해제
					fis.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			if (fos != null) {
				try {
					// FileOutputStream을 해제
					fos.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
