function numberObject() {
	// Number 객체 생성 방법
	let num = new Number(5); // new를 사용해 Number 객체 선언
	console.log('num: ' + num);	
	console.log(typeof num);	

	let num2 = 5; // 숫자 리터럴을 입력해서 Number 객체 선언
	console.log('num2: ' + num2);	
	console.log(typeof num2);	

	console.log('num + num2: ' + (num + num2));
	// document.write(): 인수로 지정한 내용을, 브라우저의 내용을 전부 지우고 출력한다.
	// document.write('메롱');
	// document.write('<b><i><marquee>num + num2 = ' + (num + num2) + '</marquee></i></b>')

	const divs = document.querySelectorAll('div');
	divs[0].innerHTML = '<b><i><marquee>num + num2 = ' + (num + num2) + '</marquee></i></b>';

	// parseInt(): 문자열이나 실수를 정수로 변환한다.
	divs[1].innerHTML = '100' + 5; // 연결
	divs[2].innerHTML = parseInt('100') + 5; // 덧셈

	// '100a'와 같이 숫자로 시작하고 정수로 변환할 수 없는 문자열이 뒤에 나오면, 변환 가능한 위치까지 정수로 변환한다.
	divs[3].innerHTML = parseInt('100a') + 5;
	// 'a100'과 같이 정수로 변환할 수 없는 문자열로 시작하고 숫자가 뒤에 나오면, NaN을 리턴한다.
	divs[4].innerHTML = parseInt('a100') + 5;

	divs[5].innerHTML = parseInt('3.14') + 5;
	divs[6].innerHTML = parseInt(3.14) + 5;
	divs[7].innerHTML = parseInt('3.14a') + 5;
	divs[8].innerHTML = parseInt('a3.14') + 5;

	divs[9].innerHTML = Number.MAX_VALUE + 0.00000001e+308;
	divs[10].innerHTML = -1 / 0;
}
