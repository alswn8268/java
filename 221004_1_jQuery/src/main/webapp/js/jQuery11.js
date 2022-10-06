// animate(): 여러 css의 스타일을 이용해서 사용자 이펙트를 정의할 수 있다.
// $('선택자').animate({스타일}[, 재생시간][, '속도함수'][, 애니메이션이 종료되면 실행할 콜백 함수()]);
// [] 안의 내용은 생략할 수 있지만 앞의 기능을 생략하면 뒤의 기능은 사용할 수 없다.
// 스타일: 이펙트를 구성할 css 스타일 속성을 지정한다.
// 재생시간: 이펙트가 지속될 시간을 밀리초 단위로 지정한다.
// 속도함수: 이펙트의 시간당 속도를 지정한다.
//      => swing: 시작 부분과 끝 부분에서는 천천히 움직이고 중간 부분에서는 빠르게 움직인다.
//      => linear: 시작, 중간, 끝 부분 구분 없이 일정한 속도로 움직인다.
// 콜백함수: 이펙트 동작이 완료된 후 실행할 함수를 구현한다.

$('h2').click(() => {
    $('p').show();
    $('p').each(function(index) {
        // console.log(index)
        $(this).animate(
            {
                'top': 50 * (index + 1) + 'px'
            },
            700,
            'swing',
            () => console.log('안녕하세요?')
        );
    });
});

$(() => {
    // $('선택자').이벤트(실행할 함수)
    // $('p').click(function() {})

    // bind(): jQuery 이벤트에 실행할 함수를 연결한다.
    // $('선택자').bind('이벤트', 실행할 함수);
    $('p').bind('click', function() {
        // 클릭한 <p>태그의 배경색을 변경한다.
        $(this).css('backgroundColor', 'lightskyblue');
        // 클릭한 <p>태그를 제외한 나머지 형제요소를 배경색을 흰색으로 변경한다.
        $(this).siblings('p').css('backgroundColor', 'transparent');

        // contains(): 인수로 지정된 문자열을 포함하면 true, 포함하지 않으면 false를 리턴한다.
        /*
        if ($(this).is('p:contains(hide)')) {
            $('#img').hide();
        }
        */

        let command = $(this).text();
        console.log(command)
        
        /*
        if (command == 'hide()') {
            $('#img').hide();
        } else if (command == 'show()') {
            $('#img').show();
        } else if (command == 'toggle()') {
            $('#img').toggle();
        }
        */

        switch(command) {
            case 'hide()':
            $('#img').hide();
            break;
            case 'show()':
            $('#img').show();
            break;
            case 'toggle()':
            $('#img').toggle();
            break;
            case 'slideUp()':
            $('#img').slideUp();
            break;
            case 'slideDown()':
            $('#img').slideDown();
            break;
            case 'slideToggle()':
            $('#img').slideToggle();
            break;
            case 'fadeOut()':
            $('#img').fadeOut();
            break;
            case 'fadeIn()':
            $('#img').fadeIn();
            break;
            case 'fadeToggle()':
            $('#img').fadeToggle();
            break;

            // fadeTo(재생시간, 투명도): fade 효과에서 사용하는 opacity 속성값을 직접 지정한다.
            // fadeTo() 메소드가 실행되어 투명도가 변경되면 변경된 투명도가 유지되며 표시되기 때문에 투명도를 다시 1로 설정해야할 수 있다. 
            case 'fadeTo()':
            $('#img').fadeTo(1000, 0.2);
            break;
            case 'animate()':
            $('#img').animate(
                // 스타일
                {
                    'width': '300px',
                    'left': '600px',
                    'top': '300px'
                },
                // 재생 시간
                1000,
                // 속도 함수
                'swing',
                // 콜백 함수
                () => console.log('끗')
            )
            // clone(): 선택한 요소를 복사해서 새로운 요소를 만든다.
            let img2 = $('#img').clone().attr('id', 'img2').attr('src', './images/img02.png');
            $('#img').after(img2)
            break;
        }

    });
});