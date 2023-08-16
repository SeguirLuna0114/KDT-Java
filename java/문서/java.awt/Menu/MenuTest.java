import java.awt.*;
import java.awt.event.*;

public class MenuTest {
    private Frame f;
    private MenuBar bar;
    private Menu file, edit, view, helpMenu;
    private MenuItem open, save, print, exit;
    private MenuItem cut, paste, clear;
    private MenuItem help, info;

    public MenuTest() {	
	f = new Frame( "Java Edit" );

	f.addWindowListener( new WindowAdapter() {
	    public void windowClosing( WindowEvent e ) {
			System.exit( 0 );
	    }
	});	

	bar = new MenuBar();	
	file = new Menu( "파일" );
	edit = new Menu( "편집" );
	view = new Menu("보기");
	helpMenu = new Menu( "도움말" );
	
	open = new MenuItem( "열기" );
	save = new MenuItem( "저장" );
	print = new MenuItem( "인쇄" );
	exit = new MenuItem( "종료" );
	
	file.add( open );
	file.add( save );
	file.addSeparator();
	file.add( print );
	file.addSeparator();
	file.add( exit );
	
	edit.add( cut = new MenuItem( "잘라내기" ));
	edit.add( paste = new MenuItem( "붙여넣기" ));
	edit.add( clear = new MenuItem( "지우기" ));
	
	helpMenu.add( help = new MenuItem("도움말 항목" ));
	helpMenu.addSeparator();
	helpMenu.add(info=new MenuItem("Java Edit 정보"));

	bar.add( file );
	bar.add( edit );	
	bar.add( view );
	bar.add ( helpMenu );
	
	f.setMenuBar( bar );
	f.setSize( 400, 200 );
	f.setVisible( true );
    }//생성자 end

    public static void main( String[] args ) {
		MenuTest mt = new MenuTest();
    }
}
