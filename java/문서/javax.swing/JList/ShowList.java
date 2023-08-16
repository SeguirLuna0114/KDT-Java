import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.util.*; //java.util.Vector;

public class ShowList extends JFrame implements ListSelectionListener{

	JList list;
    Vector data;
   
	public ShowList(){    

	super("미녀 영화배우들");      
	String[] name = {"황수정","고소영","이승연","채시라","채리나","김태희"};
	list = new JList(name);
	/*
    list = new JList();
        
    data = new Vector();
    data.addElement("황수정");
    data.addElement("고소영");
    data.addElement("이승연");
    data.addElement("채시라");   
    data.addElement("채리나");
	data.add("김태희");
        
    list.setListData(data);
 */   
	//자동으로 스크롤바가 생성 되도록 하는 부분
	JScrollPane jp = new JScrollPane(list);
    add(jp,"Center");
//	add(list,"Center");

	setSize(200, 100);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    list.addListSelectionListener(this);
  }//생성자 end

  @Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(list.getSelectedValue());
	}

public static void main(String s[]) {
	ShowList sl = new ShowList();
  }//main end

}