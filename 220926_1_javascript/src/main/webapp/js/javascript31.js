function locationTest() {
    // location.href='https://www.naver.com'

    // location 객체의 assign() 함수는 location.href와 같은 기능이 실행된다.
    location.assign('https://www.naver.com');

    // location객체의 replace() 함수는 location.href, location.assign()와 같은 기능이지만 돌아가기를 사용할 수 없다.
    location.replace('https://www.naver.com')
}
