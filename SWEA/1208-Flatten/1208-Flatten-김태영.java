/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;
// double b = 1.0;
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b);                                     // double 변수 1개 출력하는 예제
//System.out.println(g);                                     // char 변수 1개 출력하는 예제
//System.out.println(var);                             // 문자열 1개 출력하는 예제
//System.out.println(AB);                                // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
 
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class 1208-Flatten-김태영
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
 
        for(int testCase = 1; testCase <= 10; testCase++)
        {
            int dumpChance = sc.nextInt();
            int[] map = new int[100];
 
            // 맵 생성
            for (int i = 0; i < 100; i++) {
                map[i] = sc.nextInt();
            }
 
            for (int i = 0; i < dumpChance; i++) {
                int lowestIdx = findLowestIndex(map);
                int highestIdx = findHighestIndex(map);
 
                map[lowestIdx]++;
                map[highestIdx]--;
            }
 
            int result = map[findHighestIndex(map)] - map[findLowestIndex(map)];
            System.out.println("#" + testCase + " " + result);
        }
    }
 
    public static int findLowestIndex(int[] map) {
        int min = 101;
        int minIdx = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] < min) {
                min = map[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
 
    public static int findHighestIndex(int[] map) {
        int max = 0;
        int maxIdx = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] > max) {
                max = map[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
