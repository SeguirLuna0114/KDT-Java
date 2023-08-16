package p2023_07_19;

public class Report_0718_2dim_sum_Title_proff {

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
    
    // 과목&학생 총점 저장을 위한 1차원 배열 선언
    int [] subject = new int[3]; //과목총점 저장 
    int [] student = new int[5]; //학생의 총점 저장

    // 1차원 배열 형성 => 표지로 사용하기 위함
    String[] subName = {"국어:", "영어:", "수학:"};
    String[] stuName={"1번학생:","2번학생:","3번학생:","4번학생:","5번학생:"};
    //    subject[0]=0, student[0]=0;
   
    // row - 학생, column - 과목
	int  r, c;	    
    System.out.println("각 과목별 총점구하기 ");
    for(c = 0; c < 3 ; c++){ // 과목         
      for(r = 0; r < 5 ; r++){ //학생      
        subject[c] += score[r][c];   
      }//subject[c]=subject[c]+score[r][c];
      // 과목 타이틀 출력
      System.out.println(subName[c]+subject[c]);  
    }
    
    System.out.println();
    System.out.println("학생별 총점구하기");
    for(r = 0; r < 5 ; r++){    //학생      
      for(c = 0; c < 3 ; c++){  //과목    
        student[r] += score[r][c];  
      }//student[r]=student[r]+score[r][c];
//    System.out.println((r+1)+"번 학생:" + student[r]);
      System.out.println(stuName[r] + student[r]);
    }

  }//main() end
}// class end        