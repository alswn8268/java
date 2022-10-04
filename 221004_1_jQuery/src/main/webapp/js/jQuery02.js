function a1() {
    // let span = document.getElementsByTagName('span');
    // let span = document.querySelectorAll('span');
    // console.log(span)
    // for (let i = 0; i < span.length; i++) {
    //     span[i].style.color = 'salmon';
    // }

    // jQuery는 배열 형태도 반복문 없이 처리한다.
    $('span').css('color', 'salmon'); // $('tag'): 태그 선택자
}

function a2() {
    $('#t1').css('color', 'skyblue'); // $('#id'): id 선택자
}

function a3() {
    $('.t2').css('color', 'orange'); // $('.class'): class 선택자
}

function a4() {
    $('li > span').css('color', 'yellowgreen') // >: 자식 선택자
}

function a5() {
    $('li span').css('color', 'violet') // 공백: 자손 선택자
}

// :nth-child, :nth-last-child: 같은 부모 요소를 가지는 형제 요소 중에서 특정 순서에 있는 요소를 선택하는 선택자이다.
// :nth-child()는 앞에서부터, :nth-last-child:는 뒤에서부터 센다.
// 인수로 숫자, 연산식(*는 숫자가 앞에 와야 하고, +-는 숫자가 뒤에 와야 한다.)
// odd(홀수), even(짝수)도 사용할 수 있다.

function a6() {
    // $('li').eq(0)와 $('li:eq(0)')는 같은 의미로 사용된다.
    // $('li').eq(0).css('color', 'lemonchiffon');
    // $('li:eq(0)').css('color', 'dodgerblue');

    // eq()는 index가 0부터 시작하고 nth-child는 index가 1부터 시작된다.
    // $('li:nth-child(1)').css('backgroundColor', 'lightgray'); // 처음부터 위치를 센다.
    // $('li:nth-last-child(1)').css('backgroundColor', 'lightgray'); // 마지막부터 위치를 센다.

    // $('li:nth-child(odd)').css('backgroundColor', 'lightgray'); // 홀수 인덱스를 선택한다.
    // $('li:nth-child(even)').css('backgroundColor', 'lightpink'); // 짝수 인덱스를 선택한다.

    // n은 0부터 1씩 증가는 정수로, +, -, * 연산을 사용할 수 있다.
    // $('li:nth-child(n)').css('backgroundColor', 'dodgerblue'); // 모두 선택한다.
    // $('li:nth-child(n + 3)').css('backgroundColor', 'dodgerblue'); // 3번째부터 모두 선택한다.
    
    // '*' 연산을 할 때는 '2n' 같은 형식으로 사용한다.
    $('li:nth-child(3n)').css('backgroundColor', 'dodgerblue'); // 3의 배수번째 인덱스만 선택한다. 
}

// first-child: 같은 부모 요소를 가지는 형제 요소 중에서 첫 번째 자식 요소만 선택한다.
// last-child: 같은 부모 요소를 가지는 형제 요소 중에서 마지막 자식 요소만 선택한다.

function a7() {
    $('li:first-child').css('backgroundColor', 'tomato');
}

function a8() {
    $('li:last-child').css('backgroundColor', 'blueviolet');
}
