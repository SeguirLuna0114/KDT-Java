import java.awt.*;
import java.awt.event.*;

public class CheckboxTest {
    Frame f;
	
    Checkbox name1, name2, name3;
    Checkbox apple, banana, grape;
    CheckboxGroup fruit;

    public CheckboxTest() {
	// 프레임 생성
	f = new Frame( "CheckboxTest" );
		
	// 윈도우 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	    } 
	});

	// 라디오 버튼으로 사용하기 위해 Checkbox 객체를 
	// 하나의 그룹으로 형성하기 위한 객체 선언
	fruit = new CheckboxGroup();

	// 다중 선택이 가능한 Checbox 객체 선언
	name1 = new Checkbox( "gemini" );
	name2 = new Checkbox( "johnharu" ,true);
	name3 = new Checkbox( "gracedew" );

	// 초기 선택 값을 설정
	name1.setState(true );

	// 단일 선택이 가능한 Checkbox 객체 선언
	apple = new Checkbox( "사과", fruit, false );
	banana = new Checkbox( "바나나", fruit, false );
	grape = new Checkbox( "포도", fruit, true );

	// 다중 선택이 가능한 Checkbox를 붙이고 있는 Panel
	Panel p1 = new Panel();
	p1.add( name1 );
	p1.add( name2 );
	p1.add( name3 );

	// 단일 선택이 가능한 Checkbox를 붙이고 있는 Panel
	Panel p2 = new Panel();
	p2.add( apple );
	p2.add( banana );
	p2.add( grape );

	f.setLayout( new FlowLayout() );
	f.add( p1 );
	f.add( p2 );
	
	f.setSize( 300, 150 );
	f.setVisible( true );
	f.setResizable(false);
    }//생성자 end

    public static void main( String[] args ) {
		CheckboxTest cbt = new CheckboxTest();
    }
}

