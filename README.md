# Spring API Study

## 프로젝트 버전

- 🍃 Spring Boot : 2.7.8
- ☕️ Java : 11

## 스터디 내용

- 매 주마다 요구사항 1개를 지정합니다.
  - 요구사항은 디스코드에서 의견을 나눈 뒤 정합니다.
- 개인 브랜치를 생성합니다.
- 요구사항에 맞는 기능을 개발합니다.
  - 커밋의 단위는 기능별로 나눕니다.
- 개발이 완료될 경우 PR을 올립니다.

## 요구사항
- 사이렌오더 기능이 있는 카페 어플리케이션

### 1주차 Menu CRUD
- 어드민 관리자가 Menu를 CRUD 하는 기능을 생각하며 작성했습니다.

1. Create
   1. 어드민 계정이 메뉴를 추가할 수 있다.
   추가할 때 메뉴 타입은 셀렉트 타입으로 골라서 추가
   사용유무를 체크해서 진행할 수 있다. (테스트 중이거나, 문제가 발생한 음료는 사용유무 체크를 하지 않음으로 변경할 수 있는 기능)

        
2. Read
   1. 어드민 계정 및 사용자가 볼 수 있는 메뉴 목록


3. Update
   1. 어드민 계정에서 메뉴를 수정할 수 있다.


4. Delete
   1. 어드민 계정에서 메뉴 삭제
   삭제 했을 떄 real 삭제되는 것이 아니라 -> 삭제여부가 true 값으로 변경된다. YN 으로 할 지 true false로 할지 고민해보자
        
   


