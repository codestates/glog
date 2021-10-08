# 커밋 메시지 규칙
1. function별 기능구현이 완료 되었을 때만 commit 가능
2. 한 줄로 메세지 작성해주세요.
3. 형태 : 브랜치명 변경사항
4. 영어로 작성
- 추가 : add
- 수정 : change
- 삭제 : delete 
## 예시
```
feature/login add function validation
``` 
❗ ing 금지

# Lint 규칙
- eslint air bnb 규칙에 따릅니다.
## 주요 규칙
- tab (공백 4번) 사용
- var 사용 금지
- 중괄호는 매소드 옆으로 붙이기
- js, java 모두 ;(세미콜론) 사용
- js : single quote을 기본으로 사용

# 브랜치 이름 형식
|종류|사용패턴|특징|
|------|---|---|
|master|master|최종 버전|
|alpha|alpha|beta 버전 - 3일에 한번씩 배포|
|dev|dev|개발 버전 - PR병합|
|feature|feature/function-name|개발 진행|

# PR 규칙
- 코드리뷰는 상시 진행
1. PR 진행 시 코더는 본인 외에 다른 팀원 reviewer로 선택한 후 PR하기
2. 코드리뷰는 작성자 외에 다른분들이 모두 확인 후 approve혹은 code review를 진행합니다.
3. 코더는 reviewer가 지적한 부분에 대해 모두 수정을 후 push
4. 수정한 코드를 확인 후 리뷰어는 approve를 다음날 오후 1시전까지 눌러준다.
5. 모두 approve가 된다면 당일 merge 가능

- 리뷰가 있는 경우 approve가 없을 시 PR 불가
- PR 시간 : 오후 1시~1시반 다 같이 진행<br>
  (리뷰가 없는 경우 전날 올라온 PR은 모두 merge를 합니다.) 
- PR 메시지 확인 후 리뷰어 3명은 ✅ 표시하기

## PR 제목
```
[client/back] / 수정사항 간단하게 한글로 설명
```
## PR 본문
```
### PR 타입(하나 이상의 PR 타입을 선택해주세요)
-[] 기능 추가
-[] 기능 삭제
-[] 버그 수정
-[] 의존성, 환경 변수, 빌드 관련 코드 업데이트

### 변경 사항
ex) 로그인 시, 구글 소셜 로그인 기능을 추가했습니다.

### 테스트 결과(필수X)
ex) 베이스 브랜치에 포함되기 위한 코드는 모두 정상적으로 동작해야 합니다. 결과물에 대한 스크린샷, GIF, 혹은 라이브 데모가 가능하도록 샘플API를 첨부할 수도 있습니다.
```

# Issue 형식
## Issue 제목
```
[title] / body
```
## Issue 형식
```
### Issue 타입(하나 이상의 Issue 타입을 선택해주세요)
-[] 기능 추가
-[] 기능 삭제
-[] 버그 수정
-[] 의존성, 환경 변수, 빌드 관련 코드 업데이트

### 상세 내용
ex) Github 소셜 로그인 기능이 필요합니다.

### 예상 소요 시간
-[] `0.5h`
-[] `1h`
-[] `1.5h`
-[] `2h`
-[] `2.5h`
-[] `3h`
### 라벨
- 예상 소요 시간: `E: 1h`
- 그룹: `client`, `server`
- 긴급도: `High`, `Middle`, `Low`
```

# 명명규칙
## 변수 이름 - Camel
```
clientLogin
```
## 파일 & 생성자 이름 - Pascal
```
ClientSide
```
## AWS
- EC2 프리 티어
- os : Red Hat
- Instance Name : gTeam-glog
- Host : ec2-3-34-94-52.ap-northeast-2.compute.amazonaws.com

## RDS
- DB Name :  glog-databases-1
- DBMS : MySQL

## S3
- Host : http://glog-bucket-deploy.s3-website.ap-northeast-2.amazonaws.com


# 버전 통일
## node & npm 버전 통일
- node v16.X.X
- npm v7.X.X
