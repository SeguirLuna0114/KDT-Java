import java.awt.*;
import java.awt.event.*;

public class DialogEvent implements ActionListener {
    // 멤버 변수 선언
    private Frame f;
    private TextField nameField;
    private Button ok, cancel;
    private List inputList;

    // Dialog를 위한 멤버 변수
    private Dialog dialog;
    private Button dialOk, dialCancel;
    private TextField dialNameField;
	
    // GUI 입력 폼을 구성
    public DialogEvent() {
	// 프레임 생성
	f = new Frame( "Input Name List" );

	// 윈도우의 종료 이벤트
	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
		System.exit( 0 );
	    }
	});

	// TextField 객체 생성
	nameField = new TextField( 15 );

	// Button 객체 생성
	ok = new Button( "확인" );
	cancel = new Button( "취소" );

	// 입력된 데이터를 나타내는 List 객체 생성
	inputList = new List(10);

	// Label과 TextField를 붙이는 패널
	Panel p1 = new Panel();
	p1.add( new Label( "이름", Label.RIGHT ));
	p1.add( nameField );

	// 버튼 두 개를 붙이는 패널
	Panel p2 = new Panel();
	p2.add( ok );
	p2.add( cancel );

	// Lable과 TextField를 붙인 Panel과 
	// 버튼 두 개를 붙이고 있는 Panel을 하나로 묶는 Panel
	Panel p3 = new Panel();
	p3.setLayout( new GridLayout( 2, 1, 0, 10 ));
	p3.add( p1 );
	p3.add( p2 );

	// Label과 입력된 결과를 나타내는 List를 붙인 Panel
	Panel p4 = new Panel();
	p4.setLayout( new BorderLayout() );
	p4.add( new Label( "입력된 데이타", Label.CENTER ), "North" );
	p4.add( inputList, "Center" );

	// 프레임에 Panel을 붙여서 화면 구성
	f.setLayout( new FlowLayout() );
	f.add( p3 );
	f.add( p4 );

	// 프레임의 화면 구성및 출력
	f.setSize( 400, 230 );
	f.setVisible( true );

	registrationEvent();
	}//생성자 end

	// 각 컴포넌트에 Event Listener를 등록
	public void registrationEvent() {
		nameField.addActionListener( this );
		ok.addActionListener( this );
		cancel.addActionListener( this );
    }

    // Evnet가 발생했을 경우 처리를 해주는 Handler Method
    public void actionPerformed( ActionEvent ae ) {
        // 이벤트를 발생시킨 컴포넌트의 정보를 얻음
	Object o = ae.getSource();
//	String s = (String)ae.getSource(); //다운캐스팅
	
	// TextFied에 입력된 데이터를 저장
	String name = nameField.getText();

	// 어떤 컴포넌트가 이벤트를 발생시켰는지 판단해서
	// 알맞은 명령문을 수행한다. 
	if( o == nameField ) {
	    // 공백이 입력되면
        if( name.equals( "" )) {
	        // Dialog 창을 띄운다
	        makeDialog();
	    } else {
	        addItemList( name );
	    }
	} else if( o == ok ) {
	    // 공백이 입력되면
        if( name.equals( "" )) {
	        // Dialog 창을 띄운다
	        makeDialog();
	    } else {
	        addItemList( name );
	    }
	} else if( o == cancel ) {
	    nameField.setText( "" );
		
	// Dialog에 있는 ok 버튼이 눌려지면
	} else if( o == dialOk ) {
	    String dialName = dialNameField.getText();
	    // Dialog에서도 공백이 입력되면
	    if( dialName.equals( "" ) ) {
		// TextField에 focus를 맞춤.
		dialNameField.requestFocus();
	    } else {
		// 공백이 입력되지 않았으면, 
		// Dialog를 화면에서 사라지게 하고
		dialog.setVisible( false );
//		dialog.dispose();
		// List에 name을 추가
		addItemList( dialName );
	    }
        // Dialog의 cancel 버튼이 눌려지면
	// Name Field를 깨끗이 지운다. 
	} else if( o == dialCancel ) {
	    dialNameField.setText( "" );
	} else if ( o == dialNameField ){
		String dialName = dialNameField.getText();		
		addItemList( dialName );
		dialog.setVisible( false );
	}
    }

    // Dialog 폼을 만드는 method
    public void makeDialog() {
	dialog = new Dialog( f, "Input Name", true );
	dialog.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
//		System.exit( 0 );
		dialog.dispose();
	    }
	});

	dialNameField = new TextField( 15 );
	dialOk = new Button( "OK" );
	dialCancel = new Button( "CANCEL" );

	dialOk.addActionListener( this );
	dialCancel.addActionListener( this );
	dialNameField.addActionListener( this );

	Panel dp1 = new Panel();
	dp1.add( dialOk );
	dp1.add( dialCancel );

	Panel dp2 = new Panel();
	dp2.add( new Label( "이름", Label.RIGHT ));
	dp2.add( dialNameField );

	Panel dp3 = new Panel();
	dp3.setLayout( new GridLayout( 2, 1, 0, 10 ));
	dp3.add( dp2 );
	dp3.add( dp1 );
		
	dialog.add( new Label( "공백을 입력하실 수 없습니다. 이름을 입력하세요", Label.CENTER ), "North" );
	dialog.add( dp3, "Center" );
	dialog.setSize( 400, 150 );
	dialog.setVisible( true );
    }

    // TextField나 ok 버튼이 눌려졌을 경우 List에 데이터를 추가하고, 
    // TextField를 깨끗이 지워주는 method
    public void addItemList( String inputName ) {
		inputList.add( inputName );
		nameField.setText( "" );
    }

    public static void main( String[] args ) {
		DialogEvent mc = new DialogEvent();
    }
}		