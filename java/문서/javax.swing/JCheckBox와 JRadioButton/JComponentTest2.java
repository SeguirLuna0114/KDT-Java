import java.awt.*;
import javax.swing.*;

public class JComponentTest2 extends JFrame {
   JCheckBox c1, c2, c3;
   JPanel p, p1, p2;
   JRadioButton r1, r2; 
   ButtonGroup bg;
   JComboBox com;
   JList jl;
   String major[]={"컴퓨터공학과","기계공학과",
		"전자공학과 ","제어계측학과","산업공학과"};
   String sports[]={"농구","야구","축구","배구","격투기"};
   
   public JComponentTest2(){
      super( "JComponent연습" );

//    Container c = getContentPane();
      setLayout(new FlowLayout());

 	  p=new JPanel(new GridLayout(1,2));

      p1= new JPanel(new GridLayout(3,1));
	  c1 = new JCheckBox( "잠자기", true );
	  c2 = new JCheckBox( "TV시청" );
	  c3 = new JCheckBox( "만화보기" );
	  p1.add( c1 );
	  p1.add( c2 );
	  p1.add( c3 );      

      p2= new JPanel(new GridLayout(2,1));
	  r1 = new JRadioButton( "남자" ,true);
	  r2 = new JRadioButton( "여자" ,false);

	  bg = new ButtonGroup();
	  bg.add(r1);
	  bg.add(r2);
	  p2.add( r1 );
	  p2.add( r2 );

	  p.add(p1);
	  p.add(p2); 	  

	  com = new JComboBox(major);      

      jl = new JList(sports );
	  JScrollPane s1= new JScrollPane(jl);
	  jl.setVisibleRowCount(4);	//화면에 출력될 아이템의 갯수
	  
	  add( p );
	  add(com);
	  add( s1 );

      setSize( 250, 300 );
      setVisible(true);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public static void main( String args[] ) { 
      JComponentTest2 jc = new JComponentTest2();	 
   }
}