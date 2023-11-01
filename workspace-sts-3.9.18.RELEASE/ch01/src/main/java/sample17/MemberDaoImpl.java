package sample17;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {
	private Map<String, Member> map = new HashMap<String, Member>();
	
	// 새로운 회원을 추가할 때 사용할 다음 회원의 고유 ID를 생성
	private static int nextId = 0;

	// 회원가입(C): 새로운 회원 정보를 추가하는 메서드
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}

	// Email 중복검사 : 이메일 주소를 기반으로 회원 정보를 검색하는 메소드
	public Member selectByEmail(String email) {
		return map.get(email);
	}

	// 전체 회원 정보 목록을 조회하는 메소드
	public Collection<Member> list() {
		// map.values()메소드 : map에 저장된 Value값만 가져옴
		return (Collection<Member>) map.values();
	}

	// 회원정보 삭제(D): 특정 이메일 주소를 가진 회원 정보를 삭제
	public void delete(String email) {
		map.remove(email);
	}

	// 회원정보 수정(U): 회원 정보를 업데이트하는 메서드
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
}