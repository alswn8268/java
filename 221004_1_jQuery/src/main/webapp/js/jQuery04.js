// input 요소의 선택
//   :button: type 속성이 'button'인 모든 요소를 선택한다.
//   :checkbox: type 속성이 'checkbox'인 모든 요소를 선택한다.
//   :file: type 속성이 'file'인 모든 요소를 선택한다.
//   :image: type 속성이 'image'인 모든 요소를 선택한다.
//   :password: type 속성이 'password'인 모든 요소를 선택한다.
//   :radio: type 속성이 'radio'인 모든 요소를 선택한다.
//   :reset: type 속성이 'reset'인 모든 요소를 선택한다.
//   :submit: type 속성이 'submit'인 모든 요소를 선택한다.
//   :text: type 속성이 'text'인 모든 요소를 선택한다.
//   :checked: type 속성이 'checkbox' 또는 'radio'인 요소 중에서 체크된 모든 요소들를 선택한다.
//   :selected: option 요소 중에서 선택된 모든 요소들를 선택한다.
//   :focus: 현재 포커스를 가지고 있는 요소를 선택한다.
//   :disabled: 비활성화 되어있는 모든 요소를 선택한다.
//   :enabled: 활성화 되어있는 모든 요소를 선택한다.

function choice() {
    // 전체 선택
    // let inputs = document.getElementsByTagName('input');
    // let inputs = document.querySelectorAll('input');
    // console.log(inputs.length);
    // console.log(inputs[0]);

    // 개별 선택
    // let input = document.getElementsByTagName('input')[0];
    // let input = document.querySelectorAll('input')[0];
    // let input = document.querySelector('input');
    // console.log(input.value)
    // input.value = '임꺽정';

    // javascript는 value 속성을 사용해서 ~~.value 형태로 값을 얻어오고, ~~.value='값' 형태로 값을 넣어준다.
    // jQuery는 value 속성 대신 val() 메소드를 사용해서 ~~.val() 형태로 값을 얻어오고, ~~.val('값') 형태로 값을 넣어준다.

    // let inputs = $('input'); // input 태그 전체를 얻어온다.
    // console.log(inputs.length); // 7

    let inputs = $('input:text'); // input 태그 중에서 type이 text인 태그 전체를 얻어온다.
    // console.log(inputs.length); // 2

    // jQuery는 속성에 맞는 요소가 여러 개가 있다 하더라도 첫 번째 값만 가져온다.
    // let doc = $('input:text').val();
    // console.log(doc); // 

    // console.log(inputs);
    // console.log(inputs.value); // undefined(배열의 index 지정이 안 된 상태라서)
    // console.log(inputs[0].value);
    // console.log(inputs[1].value);

    let text = $('input:text').eq(0);
    console.log(text.value); // undefined
    console.log(text.val());
    let text2 = $('input:text').eq(1);
    console.log(text2.value); // undefined
    console.log(text2.val());
    $('input:text').eq(1).val('장길산');
}

function choice2() {
    let input = document.getElementsByTagName('input')[3];
    console.log(input.value);
    console.log(input);

    // document.getElementById('a').innerHTML = '<h2>' + input.value + '</h2>';
    // document.getElementById('a').textContent = input.value;

    // let text = $('input:radio').eq(0).val();

    // javascript는 innerHTML, innerText, textContent를 사용해서 태그 내부에 텍스트를 넣는다.
    // jQuery는 html() 메소드나 text() 메소드를 사용해서 태그 내부에 텍스트를 넣는다.
    // html() 메소드는 태그를 지원하고 text() 메소드는 태그를 지원하지 않는다.

    let text = $('input:radio:eq(0)').val();
    $('#a').html('<h2>' + text + '</h2>');
}

function choice3() {
    let text = $('input:checkbox:eq(0)').val();
    $('#a').html('<h2>' + text + '</h2>');
}

// 1.
// $('document').ready(function(){
//     alert('$("document").ready(function(){})');
// })

// 2.
// $().ready(function () {
//     alert('$("document").ready(function(){})');
// });

// 3.
// $().ready(() => {
//     alert('$("document").ready(function(){})');
// });

// 4.
// $(function () {
//     alert('$("document").ready(function(){})');
// });

// 5.
// $(() => {
//     alert('$("document").ready(function(){})');
// });

$(() => {
/*    let select = document.getElementsByTagName('select')[0];
    // console.log(select);

    // 이벤트를연결할객체.이벤트 = function () {};
    // 이벤트를연결할객체.이벤트 = () => {};
    select.onchange = () => {
        console.log(select.selectedIndex); // 몇 번째 option이 선택되었는지 얻어온다.
        console.log(select.options); // option 목록을 배열 형태로 얻어온다.
        console.log(select.options[select.selectedIndex]); // 어떤 option이 선택되었는지 얻어온다.
        console.log(select.options[select.selectedIndex].value);

        let v = select.options[select.selectedIndex].value;
        document.getElementsByTagName('input')[0].value = v;
    }; */

    // javascript는 onclick, onchange와 같이 이벤트가 'on'으로 시작하지만 jQuery는 앞에 'on'을 붙이지 않는다.
    $('select:eq(0)').change(() => {
        // alert('select 태그의 change');
        // option:selected는 option 태그 중에서 선택(selected)된 option 태그를 얻어온다.
        let select = $('select:eq(0) > option:selected').eq(0).val();
        // console.log(select);
        $('input:text').eq(0).val(select);
    });

    $('input[name=gender]').click(() => {
        let check = $('input[name=gender]:checked').val();
        console.log(check)
        $('input:text').eq(1).val(check);
    })

});