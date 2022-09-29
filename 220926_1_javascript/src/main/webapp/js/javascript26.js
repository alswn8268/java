function evalTest() {
	// let str = document.getElementsByName('evalValue')[0];
	// let str = document.getElementsByTagName('input')[0];
	let str = document.querySelectorAll('input')[0];
	console.log(str);
	console.log(str.value);
	console.log(typeof str.value);

	if (confirm('연산식을 올바르게 입력했나요?\n입력한 연산식: ' + str.value)) {
		// eval(): 인수로 지정된 문자열 형태의 자바스크립트 코드를 실행한다.
		// document.getElementsByTagName('span')[0].innerHTML ='<h2>계산 결과: ' + eval(str.value) + '</h2>';
		document.querySelectorAll('span')[0].innerHTML ='계산 결과:<h2> ' + eval(str.value) + '</h2>';
	} else {
		str.value = '';
		str.focus();
		alert('다시 입력해주세요.');
	}
}

function calTest() {
	let docs = document.getElementsByClassName('cal');
//	let docs = document.querySelectorAll('.cal');
	let str = '';
	for (let doc of docs) {
		str += doc.value;
	}
	console.log(str)
	console.log(typeof str)
	document.querySelectorAll('span')[1].innerHTML = '계산 결과: ' + eval(str);
}
