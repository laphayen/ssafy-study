# 자바 알고리즘 스터디

### 참여자

<table>
    <tr height="120px">
        <td align="center">
            <a href="https://github.com/laphayen"><img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/29139465?v=4"/></a>
            <br />
            <a href="https://github.com/laphayen">백기찬</a>
        </td>
        <td align="center">
            <a href="https://github.com/taehaha"><img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/39082769?v=4"/></a>
            <br />
            <a href="https://github.com/taehaha">김태영</a>
        </td>
        <td align="center">
            <a href="https://github.com/CodeChimpanzee"><img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/77719074?v=4"/></a>
            <br />
            <a href="https://github.com/CodeChimpanzee">유건희</a>
        </td>
        <td align="center">
            <a href="https://github.com/hgyuhyeon"><img height="100px" width="100px" src="https://avatars.githubusercontent.com/u/57509844?v=4"/></a>
            <br />
            <a href="https://github.com/hgyuhyeon">황규현</a>
        </td>
    </tr>
</table> 

### Commit 규칙

명령어를 통해서 업로드가 아닌 깃허브 데스크탑이나 웹 페이지에서 커밋할 경우 "Add: 문제제목 / 이름 / 날짜 / 시간"을 입력합니다.

커밋 메시지는 대소문자를 구별합니다.

* 파일 생성 & 업로드: Add

```
git commit -m "#이슈번호 - Add: 문제제목 / 이름 / 날짜 / 시간 "


[예시]
git commit -m "#23 - Add: 스도쿠검증 / 백기찬 / 07.07 / 128ms"
```

* 파일 수정: Update

```
git commit -m "#이슈번호 - Update: 문제제목 / 이름 / 날짜 / 시간 "


[예시]
git commit -m "#23 - Update: 스도쿠검증 / 백기찬 / 07.07 / 128ms"
```

* 파일 삭제: Delete
```
git commit -m "#이슈번호 - Delete: 문제제목 / 이름 / 날짜"


[예시]
git commit -m "#23 - Delete: 스도쿠검증 / 백기찬 / 07.07"
```

* 기타
```
- Feat 		: 새로운 기능 추가
- Fix 		: 버그 수정
- Docs 		: 문서 수정
- Style 	: 코드 formatting, 세미콜론(;) 누락, 코드 변경이 없는 경우
- Refactor 	: 코드 리팩토링
- Test 		: 테스트 코드, 리팽토링 테스트 코드 추가
- Chore 	: 빌드 업무 수정, 패키지 매니저 수정
```

* * *

### Issue 규칙

* Issue Open
```
Title: 출제사이트 / 문제번호 / 문제이름
Add a description: 
* [ ] 백기찬
* [ ] 김태영
* [ ] 유건희
* [ ] 황규현

[예시]
SWEA / 1974 / 스도쿠 검증
* [ ] 백기찬
* [ ] 김태영
* [ ] 유건희
* [ ] 황규현
```

* Issue Close - 전원이 문제를 풀이한 경우 마지막 PR를 남긴 사람이 이슈를 닫습니다. 모든 사람이 x가 되어있는지 확인한 경우만 `This closes #이슈번호`를 사용합니다.
```
Add a title: #이슈번호-문제제목-이름

Leave a comment:
* [x] 백기찬
* [x] 김태영
* [x] 유건희
* [x] 황규현
This closes #이슈번호


[예시]
#23-백기찬

* [x] 백기찬
* [x] 김태영
* [x] 유건희
* [x] 황규현
This closes #23
```


* * *

### Branch 규칙

* Branch Create
```
git checkout -b <#이슈번호-문제제목-이름>


[예시]
git checkout -b #23-스도쿠검증-백기찬
```

* Branch Delete
```
git checkout -d <#이슈번호-문제제목-이름>


[예시]
git checkout -d #23-스도쿠검증-백기찬
```

* * *

### Pull Request 규칙

* Create Pull Request - 제목에는 브랜치 이름을 지정합니다. 설명에는 PR을 남기는 본인의 이름에 x 표시를 남깁니다. 먼저 푼 인원이 있다면 포함해서 x를 표시합니다.

```
Add a title: #이슈번호-문제제목-이름

Leave a comment:
* [x] 백기찬
* [ ] 김태영
* [ ] 유건희
* [ ] 황규현


[예시]
#23-백기찬
* [x] 백기찬
* [ ] 김태영
* [ ] 유건희
* [ ] 황규현
```
