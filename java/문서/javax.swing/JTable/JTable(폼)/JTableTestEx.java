import java.awt.*; //java.awt.BorderLayout
import javax.swing.*; 
import javax.swing.border.*; //javax.swing.border.TitledBorder
import javax.swing.table.*; //javax.swing.table.DefaultTableModel

public class JTableTestEx extends JFrame {
	JTable table;
	DefaultTableModel model;

	JTextField txt1 = new JTextField("",6);
	JTextField txt2 = new JTextField("",6);
	JTextField txt3 = new JTextField("",6);
	JTextField txt4 = new JTextField("",6);

	JScrollPane sp;

	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();

	JButton btn;
	
	String colum[]={"번호","이름","국어","영어","수학",
													"총점","평균"};

    public JTableTestEx(){
		super("JTable EX");
		model=new DefaultTableModel(colum,0);
		table=new JTable(model);
		sp=new JScrollPane(table);			
	
		btn=new JButton("추가");		

		p.setLayout(new GridLayout(4,1));
		p.setBorder(new TitledBorder("입력"));
		p1.add(new JLabel("이름"));
		p1.add(txt1);
		p2.add(new JLabel("국어"));
		p2.add(txt2);
		p3.add(new JLabel("영어"));
		p3.add(txt3);
		p4.add(new JLabel("수학"));
		p4.add(txt4);
		
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);

		p5.add(btn);

		p6.setLayout(new BorderLayout());
		p6.add(p, "Center");
		p6.add(p5, "South");	
		
		add(p6, "West");
		add(sp,"Center");		

		setBounds(300, 300, 659, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
    }//생성자 end
	
	public static void main(String[] args){
	  JTableTestEx jt = new JTableTestEx();
	}

}



	