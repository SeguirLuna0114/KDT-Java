package p2018_11_01;

import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckboxTest2 implements ItemListener {

	Frame f;
	Panel p;
	Checkbox cb1, cb2, cb3;
	TextArea ta;

	public CheckboxTest2() {

		f = new Frame("Checkbox Test");

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		cb1 = new Checkbox("빨간 색");
		cb2 = new Checkbox("파란 색");
		cb3 = new Checkbox("초록 색");
		ta = new TextArea();

		p = new Panel();
		p.add(cb1);
		p.add(cb2);
		p.add(cb3);

		f.add(p, "North");
		f.add(ta, "Center");

		f.setSize(400, 200);
		f.setVisible(true);

		// 체크박스에 아이템 이벤트 처리 리스너 객체(this) 등록함
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
	}// 생성자의 끝

	// 아이템(체크 박스)의 상태가 변했을 때 호출되는 메서드
	public void itemStateChanged(ItemEvent e) {
		String strState = "";

		// e.getStateChange(): 체크박스의 현재 상태를 알아낸다(선택, 해제)
//    if(e.getStateChange()  == ItemEvent.SELECTED){
		if (e.getStateChange() == 1) {
			strState = "선택";
		} else {
			strState = "해제";
		}
//		strState = "선택";
		// e.getItem(): 선택된 아이템을 알아낸다
		ta.append(e.getItem() + "이 " + strState + "되었습니다.\n");
	}

	public static void main(String[] args) {
		CheckboxTest2 cbt = new CheckboxTest2();
	}
}