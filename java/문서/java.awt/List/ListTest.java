import java.awt.*;
import java.awt.event.*;

public class ListTest {
    Frame f;
    List nameList;
    List fruitList;

    public ListTest() {
	// 프레임과 List 객체 생성
	f = new Frame( "List" );
	
	// 윈도우 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
	    }
	});
	
	// 두 개의 List 객체 생성
	nameList = new List( 10 );
	fruitList = new List( 10, true );

	// nameList에 Item 추가
	nameList.add( "gemini" );
	nameList.add( "johnharu" );
	nameList.add( "gracedew" );
		
	// fruitList에 Item 추가
	fruitList.add( "apple" );
	fruitList.add( "banana" );
	fruitList.add( "grape" );

	Panel p1 = new Panel();	
	p1.setLayout( new BorderLayout() );	
	p1.add(new Label( "이름", Label.CENTER ), "North");
	p1.add( nameList, "Center" );

	Panel p2 = new Panel();
	p2.setLayout( new BorderLayout() );
	p2.add( new Label( "과일", Label.CENTER ), "North");
	p2.add( fruitList, "Center" );
/*		
	Panel p3 = new Panel();
	p3.add( p1 );
	p3.add( p2 );
*/
	f.setLayout( new FlowLayout());
	f.add( p1);
	f.add( p2);
//	f.add( p3 ,"Center");

	// List에서 index가 0인 값을 리턴받아 화면에 출력	
	System.out.println("Item:"+nameList.getItem(0));
	// List의 item의 총 갯수를 리턴받음
	System.out.println( "Item count:" + nameList.getItemCount());

	// 모든 아이템을 String[]에 저장 후 화면에 출력
	String[] items = nameList.getItems();
	for( int i=0 ; i<items.length ; i++ ) {
	    System.out.println( items[i] );
	}

	f.setSize( 400, 250 );
	f.setVisible( true );
	}// 생성자 end

    public static void main( String[] args ) {
		ListTest lt = new ListTest();
    }
}

