package sample15;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*@Component*/
@Repository		// BookDaoImpl 클래스를 DAO 빈으로 등록
public class BookDaoImpl implements BookDao {
	public Book getBook(String title) {   //title="바람과 함께 사라지다"
		return new Book(title, 25000);
	}
}