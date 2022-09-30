function foodShow() {
    let food = document.getElementsByName('food')[0];
    console.log(food)
    // length는 select 태그 내부의 option 태그의 개수를 얻어온다.
    console.log(food.length);
    // options는 select 태그 내부의 option 태그들을 모아놓는다.
    // console.log(typeof food.options);
    // selectedIndex는 options 객체에서 몇 번째 option이 선택되었는지 얻어온다.
    let index = food.options.selectedIndex;
    console.log(food.options[index].value);
}

function foodShow2() {
    let food2 = document.getElementsByName('food')[1];
    // console.log(food2.length);
    let str = '';
    for (let i = 0; i < food2.length; i++) {
        // value는 특정 option 객체의 값을 얻어온다.
        // console.log(food2[i].value);
        // selected는 특정 option 객체가 선택되었는지 여부를 얻어온다.
        // console.log(food2[i].selected);
        // console.log(food2[i].value + (food2[i].selected ? ' 선택됨' : ' 선택되지 않음'))
        str += food2[i].selected ? food2[i].value + ' ' : '';
    }
    console.log(str.length > 0 ? str : '없음');

}