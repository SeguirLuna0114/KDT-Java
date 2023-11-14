package com.example.demo.model;

// DTO 클래스
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Data	
// @Data 어노테이션: @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor를 모두 포함하는 종합적인 어노테이션
public class Member {

	// 같은 이름의 필드
	private String id;
	private String passwd;
	
	// getter and setters	
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getPasswd() {
//		return passwd;
//	}
//	public void setPasswd(String passwd) {
//		this.passwd = passwd;
//	}
}
