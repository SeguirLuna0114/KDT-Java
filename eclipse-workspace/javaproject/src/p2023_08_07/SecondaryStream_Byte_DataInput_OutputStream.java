package p2023_08_07;

/* 	지금까지 배운 클래스들은 모두 데이터를 바이트나 문자 단위로만 취급하고 입,출력을 했었다.                                                     
	정수형이나 실수형 같은 기본 데이터 타입을 유지 하면서 입.출력하는 방법은?
	DataInputStream, DataOutputStream 클래스를 이용하는 방법
	
	# DataOutputStream과 DataInputStream을 사용하여 
	기본 자료형 데이터를 파일로 출력(저장)하고, 다시 파일에서 읽어와서 출력하는 예시
	
	o DataOutputStream
	: 보조스트림. 기본 자료형의 데이터를 출력할 때 사용
	- 바이트 스트림을 처리
   	   : 다양한 자료형의 데이터를 바이트형태로 변환하여 출력 스트림에 전달
	- 데이터를 기록할 때는 해당 자료형의 크기에 맞춰 바이트로 변환하여 출력됨
	-  OutputStream 클래스를 확장형

	o DataOutputStream 객체생성
	-  DataOutputStream 객체를 생성하기 위해서는 출력 대상이 되는 OutputStream 객체가 필요
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("iodata.txt"));

	o DataInputStream
	: 보조스트림. 기본 자료형의 데이터를 바이트 스트림으로부터 읽어올 때 사용
	- 기본 자료형 데이터를 바이트로 변환하여 입력 스트림으로부터 읽어올 수 있음
	- InputStream 클래스의 확장형

	o DataInputStream 객체 생성 방법
	- DataInputStream 객체를 생성하기 위해서는 읽어올 데이터가 있는 InputStream 객체가 필요
		DataInputStream dis = new DataInputStream(new FileInputStream("iodata.txt"));
 */

import java.io.*;

public class SecondaryStream_Byte_DataInput_OutputStream {

	public static void main(String[] args) {
		
		try {
			/*
			 * "iodata.txt"라는 파일에 데이터를 저장
			 * - FileOutputStream과 DataOutputStream을 사용하여 
			 * 	 데이터를 바이트 스트림으로 변환하여 파일에 저장
			 * - 메소드를 사용하여 해당 자료형에 맞게 데이터를 파일에 저장
			 */
			// 1. 파일에 데이터를 출력(저장)하기 위한 FileOutputStream 객체 생성
			FileOutputStream fos = new FileOutputStream("iodata.txt");

			// 2. DataOutputStream으로 FileOutputStream을 래핑하여 데이터를 기록할 준비
			// FileOutputStream 객체를 argument로 받아 들이는 DataOutputStream 객체 생성
			DataOutputStream dos = new DataOutputStream(fos);
			
			// => 인라인 선언(변수 선언하면서 동시에 객체 생성 및 초기화) 가능
//			DataOutputStream dos = new DataOutputStream(new FileOutputStream("iodata.txt"));

			// 각 데이터 타입에 맞는 write 메소드를 호출해 파일에 데이터를 저장
			dos.writeBoolean(true);
			dos.writeChar('j');
			dos.writeInt(1234);
			dos.writeFloat(3.14F);
			dos.writeDouble(123.5423);
			dos.writeUTF("gemini");

			/*
			 * "iodata.txt" 파일에서 데이터를 읽어와서 출력
			 * - FileInputStream과 DataInputStream을 사용하여 
			 * 	 파일로부터 데이터를 바이트 스트림으로 읽어옴
			 * - 메소드를 사용해 자료형에 맞게 데이터를 읽어온 후, 각각의 값을 출력
			 */
			// 1. 파일에서 InputStream 객체로부터 데이터를 읽어 들이기 위한 FileInputStream 객체 생성
			FileInputStream fis = new FileInputStream("iodata.txt");

			// 2. DataInputStream으로 FileInputStream을 래핑하여 기본 자료형 데이터 읽기 준비
			// 각 데이터 타입별로 데이터를 읽어 들이기 위한 DataInputStream 객체 생성
			DataInputStream dis = new DataInputStream(fis);
			
			// => 인라인 선언(변수 선언하면서 동시에 객체 생성 및 초기화) 가능
//			DataInputStream dis = new DataInputStream(new FileInputStream("iodata.txt"));

			
			// 각 데이터 타입에 맞게 read()를 호출해
			// 파일에서 데이터를 읽어 들여 화면 출력
			System.out.println(dis.readBoolean());
			System.out.println(dis.readChar());
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());

			// 파일 스트림 해제
			// - 파일 스트림을 사용한 후에는 반드시 close() 메서드를 호출하여 스트림을 닫아 리소스를 해제
			dos.close();
			dis.close();
			
		} catch (IOException io) {
			System.out.println(io.toString());
		}
	}
}
