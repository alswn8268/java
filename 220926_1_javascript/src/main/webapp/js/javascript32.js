function allCheck() {
    // name 속성값이 all인 체크박스에 체크하면 true, 해제하면 false인 상태를 변수에 저장한다.
    let check = document.getElementsByName('all')[0].checked;
    console.log(check);

    // name 속성값이 chk인 모든 체크박스를 얻어온다.
    let checkBoxes = document.getElementsByName('chk');
    console.log(checkBoxes);

    // name 속성값이 chk인 체크박스의 개수만큼 반복하며 일괄적으로 선택 또는 해제시킨다.
    for (let checkBox of checkBoxes) {
        checkBox.checked = check;
    }
}

function chkSelect() {
/*    // name 속성값이 chk인 모든 체크박스를 얻어온다.
    let checkBoxes = document.getElementsByName('chk');

    // 빨강, 파랑, 노랑, 검정 체크박스가 모두 체크되었는지 검사한다.
    let count = 0;
    for (let checkBox of checkBoxes) {
        if (checkBox.checked) {
            count++;
        }
    }

    // 빨강, 파랑, 노랑, 검정 체크박스가 모두 체크되었으면 전체선택에 체크하고 한 개라도 체크가 안 되었으면 전체선택을 해제한다.
    if (count == checkBoxes.length) {
        document.getElementsByName('all')[0].checked = true;
    } else {
        document.getElementsByName('all')[0].checked = false;
    } */

    let checkBoxes = document.getElementsByName('chk');
    let flag = true;
    for(let checkBox of checkBoxes) {
        if (!checkBox.checked) { // 각각의 체크박스가 체크되었는지 검사한다.
            flag = false; // 체크박스가 체크가 안 되어있으면 flag를 false로 바꾼다.
            // 빨강, 파랑, 노랑 체크박스 중에서 한 개라도 체크가 안 되어 있으면 나머지는 비교할 필요가 없다.
            break;
        }
    }
    document.getElementsByName('all')[0].checked = flag;
}

function selectColor() {
    let checkBoxes = document.getElementsByName('chk');
    for (let checkBox of checkBoxes) {
        if (checkBox.checked) {
            console.log(checkBox.value + ' 선택');
            document.getElementById(checkBox.value).style.backgroundColor = checkBox.value;
        } else {
            console.log(checkBox.value + ' 해제');
            document.getElementById(checkBox.value).style.backgroundColor = 'transparent';

        }
    }
}

function clearColor() {
    // let divs = document.getElementsByTagName('#colorbox > div');
    let divs = document.querySelectorAll('div');
    for (let i = 0; i < divs.length; i++) {
        divs[i].style.backgroundColor = 'transparent';
    }
    
    // 모든 체크박스를 해제한다.
    document.getElementsByName('all')[0].checked = false;
    allCheck();
}