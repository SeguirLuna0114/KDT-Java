package BufferedReader;

// 달팽이가 나무막대를 모두 올라가는데 며칠이 걸리는지 출력하는 프로그램
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 땅 위에 달팽이가 높이 V미터인 나무 막대를 올라갈 것
// 달팽이는 낮에 A미터 올라갈 수 있고, 밤에는 B미터 미끄러짐. 정상에 올라간 후에는 미끄러지지X
// 달팽이가 나무막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램

// 알고리즘 (Let B=down, A=up, V=length)
// down횟수는 항상 up횟수보다 하나 적음
// 정점에 도달하면 미끄러지지x => 잔여블록 남아있다면 한번더 down한 다음에 up 해야 함
// => 결과적으로 (length - down) / (up - down) : 최소한의 일 수
// (length - down) % (up - down)의 값이 나머지가 존재 = 잔여블럭이 남음 = 1번 더 down&up(1일 더 소요됨)


public class ClimbSnail_Tokenizer {

	// 첫째줄에 정수 A, B, V가 공백으로 구분되어 주어짐
	// (1 <= B < A <= V <= 1,000,000,000)
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("세 정수 A, B, V를 입력하세요?(단, 1 <= B < A <= V <= 1,000,000,000)");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력받은 값을 공백으로 구분 => StringTokenizer클래스 사용
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		// B=down, A=up, V=length
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		// (length - down) / (up - down) : 최소한의 일 수
		int day = (length - down) / (up - down);
		
		// 나머지가 존재한다면 잔여블럭이 남기에, 1일이 더 소요됨
		if ((length - down) % (up - down) != 0) {
			day++;
		}
		System.out.println(day);
	}

}
