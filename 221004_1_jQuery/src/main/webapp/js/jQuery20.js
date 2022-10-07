$(() => {

    // 자바스크립트로 주기적인 작업을 실헹하기 위해서 setInterval() 함수와 setTimeout() 함수를 사용한다.
    
    // setInterval(): 지정된 시간마다 함수를 반복해서 실행한다.
    // setInterval(실행할 함수, 함수를 주기적으로 실행할 시간)
    // clearInterval(): setInterval() 함수의 실행을 중지시킨다.

    // setTimeout(): 지정된 시간이 되면 함수를 1번 실행한다.
    // setTimeout(실행할 함수, 시간)
    // clearTimeout(): setTimeout() 함수의 실행을 중지시킨다.

    // let count = 0;
    setInterval(() => {
        // console.log('setInterval: ' + ++count);
        // 메뉴의 첫 번째 이미지를 선택해서 마지막 이미지로 위치를 이동시킨다.
        // appendTo(): 선택된 요소를 인수로 지정한 요소의 마지막에 추가한다.
        $('.active').first().appendTo($('#menu'));
    }, 50);

    $('button').click(() => {
        // 클릭된 버튼 위의 문자열이 start면 stop으로, stop이면 start로 변경한다.
        // start 버튼이 클릭되면 active 클래스를 추가하여 이미지 롤링을 시작한다.
        if ($('button').text() == 'start') {
            $('button').text('stop');
            // stop 버튼이 클릭되면 active 클래스를 제거하여 이미지 롤링을 중지한다.
        } else if ($('button').text() == 'stop') {
            $('button').text('start');
            // console.log('오늘 점심은 ' + $('img').eq(2).attr('alt') + '입니다.')
            alert('오늘 점심은 ' + $('img').eq(2).attr('alt') + '입니다.')
        }
        ($('img').toggleClass('active'));
    });

});