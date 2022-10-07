$(() => {

    $('button:eq(0)').click(() => {
        // after(): 선택된 요소 뒤에 새로운 요소를 추가한다.
        // after() 메소드의 인수로 추가할 요소를 적는다.
        $('#base').after('<div>after() 메소드로 추가한 요소</div>')
    })
    
    $('button:eq(1)').click(() => {
        // insertAfter(): 선택된 요소 뒤에 새로운 요소를 추가한다.
        // insertAfter() 메소드의 인수로 추가할 선택자를 적는다.
        $('<div>insertAfter() 메소드로 추가한 요소</div>').insertAfter('#base')
    })

    $('button:eq(2)').click(() => {
        // before(): 선택된 요소 앞에 새로운 요소를 추가한다.
        // before() 메소드의 인수로 추가할 요소를 적는다.
        $('#base').before('<div>before() 메소드로 추가한 요소</div>')
    })

    $('button:eq(3)').click(() => {
        // insertBefore(): 선택된 요소 앞에 새로운 요소를 추가한다.
        // insertBefore() 메소드의 인수로 추가할 선택자를 적는다.
        $('<div>insertBefore() 메소드로 추가한 요소</div>').insertBefore('#base')
    })

});