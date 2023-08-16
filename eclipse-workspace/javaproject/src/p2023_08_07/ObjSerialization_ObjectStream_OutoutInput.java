package p2023_08_07;

/* 	객체를 파일로 직렬화하고 파일로부터 객체를 역직렬화하는 프로그램
	주어진 코드를 통해 ObjectStreamTest 클래스를 정의하고, 
	PersonInformation 객체와 Date 객체를 생성하여 직렬화하고 역직렬화
 */
import java.io.*;
import java.util.*; //java.util.Date;

/*
 * 객체 직렬화(Object Serialization)
	- 자바 객체를 바이트 스트림으로 변환하는 것
	  이렇게 변환된 바이트 스트림은 파일이나 네트워크를 통해 전송하거나 저장하는 등의 작업에 사용됨
	- 직렬화된 객체는 나중에 역직렬화를 통해 원래의 객체로 복원 가능

	- 방법) java.io.Serializable 인터페이스를 구현하는 것으로 객체 직렬화 가능
	  
	o 직렬화된 객체 생성 방법
	- 직렬화된 객체를 생성하고 사용하기 위해서는
	   ObjectOutputStream(객체를 직렬화)과 ObjectInputStream 클래스(객체를 역직렬화)를 사용
	   
	o ObjectOutputStream 클래스
	: 자바에서 객체 직렬화를 위해 사용되는 클래스
	- java.io.OutputStream을 상속받아 객체를 바이트 스트림으로 직렬화하여 출력
	- 객체를 '파일에 저장'하거나 '네트워크를 통해 전송'하기 위해 주로 사용
	
	o 객체 생성 방법
	case)	인터페이스를 구현한 클래스 객체를 파일에 저장하는 경우
	ObjectOutputStream out
		 = new ObjectOutputStream(new FileOutputStream("person.ser"));
	
	o 주요 메소드
	- void writeObject(Object obj) throws IOException
		: 지정된 객체를 직렬화하여 출력 스트림에 작성
	ex)	// "객체"를 직렬화하여 파일에 저장
        out.writeObject(person);

	o ObjectInputStream 클래스
	: 객체 역직렬화를 위해 사용되는 클래스
  	"직렬화된 바이트 스트림을 읽어와서 객체로 변환하는 역할"
	- java.io.InputStream을 상속받아 객체를 바이트 스트림에서 역직렬화하여 객체로 복원하는 기능
	- 역직렬화된 객체는 파일에 저장되거나
  		네트워크로부터 전송된 직렬화된 데이터를 다시 원래의 객체로 변환하는 데에 사용

	o 객체 생성 방법
	case)	인터페이스를 구현한 클래스 객체를 파일에 저장하는 경우
	ObjectInputStream in 
		= new ObjectInputStream(new FileInputStream("person.ser"));

	o 주요 메소드
	- Object readObject() throws IOException, ClassNotFoundException
	: 입력 스트림에서 직렬화된 데이터를 읽어와서 객체로 역직렬화
	- Object 타입으로 역직렬화된 객체를 리턴
	- 파일의 끝에 도달하면 읽을 데이터가 없어서 readObject() 메소드는 null을 리턴
	ex)	// 파일 끝까지 반복
		Object obj = null;
		while((obj = ois.readObject()) != null) {
			// if(변수 instanceof 클래스명): 변수가 이 클래스의 instance인지 아닌지 체크
			if(obj instanceof PersonInformation) {
				System.out.print(((PersonInformation) obj).getName() + " : ");
*/

public class ObjSerialization_ObjectStream_OutoutInput {

	// 멤버변수
	// Serializable 인터페이스를 구현한 PersonInforamtion 클래스의 객체를 선언
	ObjSerialization_PersonInformation_Serializable gemini;
	ObjSerialization_PersonInformation_Serializable johnharu;
	
	// Date클래스 객체 선언
	Date d;

	// 생성자
	public ObjSerialization_ObjectStream_OutoutInput() {

		// PersonInforamtion 객체를 생성 및 초기화
		gemini = new ObjSerialization_PersonInformation_Serializable("gemini", 10, "seoul", "02-321-3234");
		johnharu = new ObjSerialization_PersonInformation_Serializable("johnharu", 20, "seoul", "02-473-4232");

		// 날짜 정보를 지니는 Data 객체 생성 및 초기화
		d = new Date();
	}

	// File에 객체를 저장하는 메소드 - 객체를 파일로 직렬화하는 메소드
	public void writeObjectFile() {
		
		try {
			// 파일에 저장하기 위한 FileOutputStream 생성
			FileOutputStream fos = new FileOutputStream("person.dat");

			// 파일에 객체를 저장하기 위한 ObjectOutputStream 객체 생성
			// argument로 FileOutputStream 객체를 받음
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// write()를 이용해 person.dat 파일에 gemini, johnharu, d 객체를 순서대로 저장
			oos.writeObject(gemini);
			oos.writeObject(johnharu);
			oos.writeObject(d);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// File에서 객체를 읽어오는 메소드 - 파일로부터 객체를 역직렬화하는 메소드
	public void readObjectFile() {
		
		try {
			// 파일에서 데이터를 읽어오기 위한 FileInputStream 객체 생성
			FileInputStream fis = new FileInputStream("person.dat");

			// File에 저장된 객체를 읽어 오기 위해
			// FileInputStream 객체를 생성자 argument를 받아 객체 생성
			// ObjectInputStream을 사용하여 person.dat 파일에서 객체들을 읽어옴
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object o = null;
			// 파일(person.dat)에 저장된 객체를 모두 읽어 올 때까지 반복
			// readObject()메소드: Object 타입으로 역직렬화된 객체를 리턴
			while ((o = ois.readObject()) != null) {

				// instanceof 연산자를 사용 => 해당 클래스의 인스턴스인지 체크
				// if( 변수 instanceof 클래스명) : 변수가 이 클래스의 instance인지 아닌지를 체크함.
				if (o instanceof ObjSerialization_PersonInformation_Serializable) {
					// 만약 읽어온 객체가 PersonInforamtion 객체이면
					// PersonInformation 클래스의 gemini 객체와 johnharu 객체의 정보를 읽어와서 출력
					// & Date 객체 d의 정보를 출력
					
					// obj 객체를 PersonInformation 클래스로 캐스팅한 뒤, 해당 객체의 getName() 메소드를 호출
					System.out.print(((ObjSerialization_PersonInformation_Serializable) o).getName() + " : ");
					System.out.print(((ObjSerialization_PersonInformation_Serializable) o).getAge() + " : ");
					System.out.print(((ObjSerialization_PersonInformation_Serializable) o).getAddress() + " : ");
					System.out.print(((ObjSerialization_PersonInformation_Serializable) o).getTelephone());

					System.out.println();
				} else {
					System.out.println(o.toString());
				}
			}
			
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		
		ObjSerialization_ObjectStream_OutoutInput ost = new ObjSerialization_ObjectStream_OutoutInput();
		
		// writeObjectFile() 메소드를 통해 객체들을 파일로 직렬화
		ost.writeObjectFile();
		// readObjectFile() 메소드를 통해 파일로부터 객체들을 역직렬화하여 읽어옴
		// => 역직렬화된 객체들을 출력하면서 각 객체들의 정보를 확인가능
		ost.readObjectFile();
	}
}
