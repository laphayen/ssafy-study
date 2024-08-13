# 기본 입력과 출력

## 입력

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String input = br.readLine();  // -> 여기서 throws IOException 처리를 해준다.
```

## 출력

```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
bw.write(변수);
bw.newLine(); // 줄바꿈
bw.flush(); // 버퍼 비우기
```

---

---

# 문자 배열

## 문자배열 - 개행입력 - (char) br.read();

```java
char[] charArray = new char[5];
for (int i = 0; i < 5; i++) {
    charArr[i] = (char) br.read();
    br.readLine();
}
```

br.read() 는 문자의 `ASCII 코드` 값을 반환 → `(char)` 로 캐스팅

입력을 받은 후에 개행이 필요하다. → `br.readLine()` 하지 않으면 Enter도 문자로 인식해버린다.

## 문자배열 - 공백입력1 - split(”\\s+”);

```java
String str = br.readLine();
String[] strArr = str.split("\\s+");
		
char [] charArr = new char[strArr.length];
for (int i = 0; i < strArr.length; i++) {
		charArr[i] = strArr[i].charAt(0);
}
```

문자열을 전체로 받아서, 공백(”\\s+”)으로 문자열 배열에 담는 방법이다.

각각의 문자가 담긴 문자열배열 → 문자배열로 변환

## 문자배열 - 공백입력2 - StringTokenizer(br.readLine(), " ");

```java
StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
int index = 0;
while (st.hasMoreTokens() && index < 5) {
    charArr[index++] = st.nextToken().charAt(0);
}
```

공백 기준으로 입력 받아서 각각의 토큰을 문자배열에 넣는다.

`st.hasMoreTokens()` 는 다음 토큰이 있는지 확인한다.

## 문자배열 - 한줄로출력 - `bw.write()`

```java
for (char c : charArr) {
    bw.write(c);
}
bw.newLine();
bw.flush(); // abcde로 출력
```

## 문자배열 - 한줄로 출력 - 중간에 공백 포함 - `bw.write(c + " ");`

```java
for (char c : charArr) {
    bw.write(c + " ");
}
bw.newLine();
bw.flush(); // a b c d e로 출력
```

## 문자배열 - 한줄씩 출력 - `bw.newLine();`

```java
for (char c : charArr) {s
    bw.write(c);
    bw.newLine();
}
bw.newLine();
bw.flush();
```

---

---

## 2차원 문자 배열 - StringTokenizer(input, " ");

```java
char[][] charArr = new char[3][3];
        
// 2차원 배열 입력 받기
for (int i = 0; i < 3; i++) {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int index = 0;
    while (st.hasMoreTokens() && index < charArr[i].length) {
        charArr[i][index++] = st.nextToken().charAt(0);
    }
}
```

## 2차원 배열 출력

```java
for (int i = 0; i < charArr.length; i++) {
    for (int j = 0; j < charArr[i].length; j++) {
        bw.write(charArr[i][j] + " "); // 문자를 출력
    }
    bw.newLine(); // 줄바꿈
}
bw.flush(); // 출력 버퍼 비우기
```

---

---

## 숫자 공백 입력

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
String input = br.readLine();
		
StringTokenizer st = new StringTokenizer(input); // 2 3
		
int num1 = Integer.parseInt(st.nextToken()); // 2
int num2 = Integer.parseInt(st.nextToken()); // 3
		
System.out.println(num1 + " " + num2);
```
