function createImg() {
    // 라디오 버튼의 value 속성값을 얻어와서 브라우저에 표시할 이미지의 경로와 이름으로 사용한다.
    let radios = document.getElementsByName('radioBtn');
    // console.log(radios.length);

    radioValue = '';
    for (let radio of radios) {
        // console.log(radio.checked);
        if (radio.checked) {
        // console.log(radio.value);
        radioValue = radio.value;
        }
    }
    console.log(radioValue);
    // img 태그를 만들고 src 속성값을 radiolValue로 지정한다.
    let img = document.createElement('img'); // <img>
    // img 태그에 이미지를 표시하기 위해서 src 속성과 속성값을 추가한다.
    img.setAttribute('src', radioValue)
    // img 태그를 넣어줄 div 태그를 얻어온다.
    let div = document.getElementById('imgView');

    // 이미지 생성 버튼을 클릭할 때마다 이미지가 변경되게 하려면 기존 img 태그를 제거하고 새로 만든 img 태그를 넣는다.
    // div 태그에 들어가있는 마지막 노드를 선택해서 제거한다.

    // firstElementChild: 첫 번째 자식 노드
    // lastElementChild: 마지막 자식 노드
    let divImg = div.lastElementChild
    // removeChild(태그): 인수로 지정된 자식 태그르 제거한다.
    div.removeChild(divImg); 

    // div 태그에 img 태그를 자식으로 넣어준다.
    div.appendChild(img);
}

function removeImg() {
    let div = document.getElementById('imgView');
    div.innerHTML = '<br/>';
}