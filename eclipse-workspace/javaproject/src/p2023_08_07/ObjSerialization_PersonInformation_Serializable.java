package p2023_08_07;

/*
 *  신상 정보를 간직한 객체를 만들기 위한 클래스
	- Serializable 인터페이스를 구현하여 객체 직렬화를 지원
	- 각 사람에 대한 객체를 만들어 놓고 객체 단위로 입.출력 하는 것
  	- 객체를 바이트 스트림으로 변환하여 직렬화하고, 나중에 필요한 경우 역직렬화하여 객체로 복원하기 위함
 */
import java.io.*;

/*
	* 객체 직렬화(Object Serialization)
	- 자바 객체를 바이트 스트림으로 변환하는 것
  	  이렇게 변환된 바이트 스트림은 파일이나 네트워크를 통해 전송하거나 저장하는 등의 작업에 사용됨
	- 직렬화된 객체는 나중에 역직렬화를 통해 원래의 객체로 복원 가능

	- 방법) java.io.Serializable 인터페이스를 구현하는 것으로 객체 직렬화 가능
	
	- 독립 객체들도 내부적으로는 사방에 흩어져 존재 하지만 
  	  입.출력 할때는 줄을 세워서 입.출입 하기 때문에 객체 직렬화라함

	o Serializable 인터페이스
	 : Serializable 인터페이스를 구현함으로써 
 		클래스는 자바의 기본 직렬화 메커니즘을 이용하여 객체를 직렬화할 수 있게됨
 		" 직렬화 한다는 표시자의 역할"

	-  메소드를 갖지 X. 단순히 마커(marker)인터페이스로 사용되며 직렬화 표시자의 역할 수행
	- 단지 클래스 선언에 implements Serializable 구문을 추가
  		=> 해당 클래스의 인스턴스를 직렬화할 수 있도록 지정
  		(객체 직렬화를 위해 Serializable 인터페이스를 상속받음)
  	- Serializable 인터페이스를 구현한 클래스로 객체를 만들고, 입.출력을 하면,
  	  우리가 프로그램에서 체크하지 않아도 "중복된 객체가 입.출력하는 것을 방지"해 준다.
  	  
  	o 직렬화된 객체 생성 방법
	- 직렬화된 객체를 생성하고 사용하기 위해서는
  	   ObjectOutputStream(객체를 직렬화)과 ObjectInputStream 클래스(객체를 역직렬화)를 사용
 */

public class ObjSerialization_PersonInformation_Serializable implements Serializable {
	// 객체 직렬화를 위해 Serializable 인터페이스를 상속받음
	// (객체를 바이트 스트림으로 변환하여 직렬화하고, 나중에 필요한 경우 역직렬화하여 객체로 복원)

	// 멤버 변수
	private String name;
	private int age;
	private String address;
	private String telephone;

	// 생성자
	public ObjSerialization_PersonInformation_Serializable(String name, int age, String address, String telephone) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.telephone = telephone;
	}

	// 각 멤버 변수의 값을 리턴시키는 getXXX()메소드 - 객체의 정보를 조회 가능
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public String getTelephone() {
		return telephone;
	}
}