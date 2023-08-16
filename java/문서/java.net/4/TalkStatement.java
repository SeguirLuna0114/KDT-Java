import java.io.*;

public class TalkStatement {

    public static String readString() {
     	
        // 키보드로 입력받는 byte stream을 character stream으로 
		// 변환시키는 InputStreamReader 객체 생성       
        InputStreamReader isr = new InputStreamReader( System.in );
        
        // buffer를 사용하기 위한 BufferedReader 객체 생성
        BufferedReader br = new BufferedReader( isr );

        // 입력받은 데이터를 저장하기 위한 변수 선언
        String line = null;

        // 한 라인을 읽어 들임
        try {
			line = br.readLine();	
			
        } catch ( IOException io ) {
			System.out.println( io );
/*        } finally{
			if (br != null) 
                     try {
                             br.close(); 
                     } catch(IOException iex) {}*/
		}

        return line;
    }// readString() end	
}

