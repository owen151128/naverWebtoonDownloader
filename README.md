# naverWebtoonDownloader
완간된 네이버 웹툰을 저장해 두기 위한 툴

추후 기술 내역에 대해서 기술할 예정

## NaverWebtoonUtil
- 네트워크 관련 I/O 유틸 모음
- Single-tone 패턴 적용
- getWebtoon - webtoon 페이지 파싱해서 가져오는 메소드
- setConnection - http time_out, header 설정 하는 메소드
- downloadWebtoon - 파싱된 정보로 웹툰 이미지 다운로드 & html 뷰어 생성메소드

## NaverWebtoonParser
- 파싱 관련 유틸 모음
- Single-tone 패턴 적용
- parseWebtoonImageUrl - 파싱된 웹툰 데이터에서 이미지 url 을 파싱후 가공해주는 메소드

## NaverWebtoonConstants
- 관련 상수들이 모인 클래스
- File - FileUtil 에서 사용할 상수들 모임
- Util - NaverWebtoonUtil 에서 사용할 상수들 모임
- Parser - NaverWebtoonParser 에서 사용할 상수들 모임

## FileUtil

- File I/O 관련 유틸 모음
- Single-tone 패턴 적용
- writeCache - 캐시에 내용을 저장하는 메소드
- readCache - 캐시에 내용을 읽어오는 메소드
- writeImage - 웹툰 이미지를 저장하는 메소드
- writeHtml - 웹툰 html 뷰어를 저장하는 메소드
