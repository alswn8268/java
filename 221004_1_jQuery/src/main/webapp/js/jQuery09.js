$(() => {

    // $('div b').css({'fontSize':'20px', 'color':'slateblue'});
    $('div').find('b').css({'font-size':'20px', 'color':'slateblue'});

    // $('#chd').text('손오공');
    $('div').children('#chd').html('<i>사오정</i>')

    $('span').css('fontSize', '20px').css('backgroundColor', 'yellowgreen');
    $('span').parent().css('backgroundColor', 'skyblue');
    $('span').parents('div').css('backgroundColor', 'peachpuff');

    $('p').eq(2).next().css('background', 'lemonchiffon')
    $('p').eq(2).prev().css('background', 'slateblue')
})