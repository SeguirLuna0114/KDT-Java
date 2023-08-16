import java.awt.event.*;

// Event를 처리하는 EventHandler를 정의한 클래스
public class ButtonEventHandler implements ActionListener {
    // 버튼에서 발생시킨 ActionEvent를 처리하는 메소드
    public void actionPerformed( ActionEvent ae ) {
	
		System.out.println( "버튼이 눌려 졌어요." );

    }
}

	