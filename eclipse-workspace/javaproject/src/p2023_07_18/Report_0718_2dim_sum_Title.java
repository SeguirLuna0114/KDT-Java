package p2023_07_18;

public class Report_0718_2dim_sum_Title {

  // 2차원 배열을 사용하여 학생들의 과목별 점수 저장 및
  // 과목별&학생별 총점을 계산하는 프로그램
  public static void main(String[] args) {
   
	// 2차원 배열 형성(초기값을 바로 설정)
    int [][]score = { { 85,  60,  70},   //0 행
				      { 90,  95,  80},   //1 행
				      { 75,  80, 100},   //2 행
                      { 80,  70,  95},   //3 행
				      {100,  65,  80}    //4 행
					};
    
    // 1차원 배열 형성 => 표지로 사용하기 위함
    String[] subArray = {"국어", "영어", "수학"};
    
    // row - 학생, column - 과목
    // 2차원 배열 각 요소 출력
    System.out.println("\t"
    +"국어"+"\t"+"영어"+"\t"+"수학"); // 열 타이틀 출력
    for(int i=0; i<score.length; i++) {
    	System.out.print("학생"+(i+1)); // 행 타이틀 출력
    	for (int j=0; j<score[i].length; j++) {
    		System.out.print("\t"+score[i][j]);
    	}
    	System.out.println();
    }
    
    // 과목&학생 총점 저장을 위한 1차원 배열 선언
    int [] subject = new int[3]; //3개의 열 목차(과목)총점 저장 
    int [] student = new int[5]; //5개의 행 목차(학생)의 총점 저장
        // int배열 초기값 0으로 설정됨
    	// subject[0]=0, subject[1]=0, subject[2]=0 
    	// student[0]=0, student[1]=0,..., student[4]=0
    int  r, c;  
	
    System.out.println("\n각 과목별 총점구하기 ");
    for(c = 0; c < 3 ; c++){ // 열(과목)
//      System.out.print(subArray[c]+": ");
      for(r = 0; r < 5 ; r++){ // 행(학생)      
        subject[c] += score[r][c];   
      }//subject[c]=subject[c]+score[r][c];
      System.out.print(subArray[c]+": "+subject[c]);  // 과목별 학생들의 총점 출력
      System.out.println();
    }

    int rowIdx = 0;
    System.out.println("\n학생별 총점구하기");
    for(r = 0; r < 5 ; r++){    //학생
      System.out.print("학생"+(rowIdx+1)+": ");
      for(c = 0; c < 3 ; c++){  //과목    
        student[r] += score[r][c];  
      }//student[r]=student[r]+score[r][c];
      System.out.println(student[r]);	// 학생별 과목의 총점 출력
      rowIdx++;
    }

  }//main() end
}// class end        