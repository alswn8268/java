$(() => {

    $('button').eq(0).click(() => {
        // prepend(): 인수로 지정된 요소를 선택된 요소 내부에 첫 번째로 추가한다.
        // <div> 태그의 1번째 요소로 <p> 태그를 만들어 넣어준다.
        // $('<tag>'): 인수로 지정된 태그를 만든다.
        // $('div').eq(0).prepend($('<p>')).text('prepend'); (X)

        // prepend() 메소드에서 태그를 만들고 속성까지 모두 지정해야 한다.
        $('div').eq(0).prepend($('<p>').text('prepend').addClass('prepend'));
        // 태그를 만들어 넣으면 태그가 추가되지만, 태그를 선택해서 넣으면 선택한 태그가 이동한다.
        $('div').eq(0).prepend($('div > p:last'));
    });

    $('button').eq(1).click(() => {
        // append(): 인수로 지정된 요소를 선택된 요소 내부에 마지막 요소로 추가한다.
        $('div').eq(0).append($('<p>').text('append').addClass('append'));
        // 태그를 만들어 넣으면 태그가 추가되지만, 태그를 선택해서 넣으면 선택한 태그가 이동한다.
        $('div').eq(0).append($('div > p:first'));
    })

    $('button').eq(2).click(() => {
        $('div').html('<marquee>html 요소를 변경한다.</marquee>');
    })
    
    $('button').eq(3).click(() => {
        $('div').text('<marquee>html 요소를 변경한다.</marquee>');
    })

});