onload = () => {
    let a = document.querySelectorAll('a');
    let img = document.querySelectorAll('img')[0];
    let count = 3; // 화면에 보이는 이미지 위치

    // '◀'에 onclick 이벤트를 연결한다.
    a[0].onclick = () => {
        // getAttribute('속성이름'): 인수로 지정된 속성의 속성값을 얻어온다.
        let imgAlt = img.getAttribute('alt');
        // console.log(imgAlt)
        count = --count < 1 ? 5 : count;
        img.setAttribute('src', './images/img0' + count + '.jpg')
        img.setAttribute('alt', 'img0' + count);
        // img.setAttribute('src', './images/img0' + (imgAlt == 'img01' ? count = 5 : --count) + '.jpg')
        // img.setAttribute('alt', 'img0' + (imgAlt == 'img01' ? count = 5 : count))
    }

    // '▶'에 onclick 이벤트를 연결한다.
    a[1].onclick = () => {
        let imgAlt = img.getAttribute('alt');
        count = ++count > 5 ? 1 : count;
        img.setAttribute('src', './images/img0' + count + '.jpg')
        img.setAttribute('alt', 'img0' + count);
        // img.setAttribute('src', './images/img0' + (imgAlt == 'img05' ? count = 1 : ++count) + '.jpg')
        // img.setAttribute('alt', 'img0' + (imgAlt == 'img05' ? count = 1 : count))

    }
};