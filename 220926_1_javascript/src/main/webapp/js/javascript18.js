// 명시적 함수(이름이 있는 함수)
function func1() {
	alert('명시적 함수')
}

// 익명 함수(이름이 없는 함수)
/*
var func2 = function () {
	alert('익명 함수');
}
*/

var func2 = () => alert('익명 함수');

// 함수 리터럴: 함수의 인수로 익명 함수를 전달하는 함수
function func3() {
	literalTest(
		function (msg) {
			alert(msg);
		} 
	);
}

function literalTest(literal) {
	literal('함수 리터럴입니다.')
}

// 자바스크립트 함수는 실인수와 가인수의 개수가 다르더라도 정상적으로 실행된다. => 함수 오버로딩은 불가능
// 함수가 호출될 때 넘어오는 인수를 저장할 변수가 모자라면 모자란 대로, 남으면 남는 대로 실행된다.
// 자바스크립트의 함수가 호출될 때, 가인수로 전달되는 인수는 arguments 객체로 먼저 전달되고 arguments 객체에 저장된 인수 목록에서 가인수의 개수만큼 반복하며 arguments 객체에 저장된 데이터를 꺼내어 가인수에 넣어준다.
function varTest(a, b, c) {
	console.log('함수가 호출될 때 전달되는 데이터 개수: ' + arguments.length);
	for (let i = 0; i < arguments.length; i++) {
		console.log('arguments[' + i + '] = ' + arguments[i]);
	}	
}

/*
function goodEdu(good) {
	console.log(good);	
}
*/

// 클로저: 함수가 생성될 당시  외부 함수의 값을 기억해 두었다가 함수가 호출될 때 사용한다.
// 참조할 수 없는 위치에 있는 값도 참조할 수 있다.
function closureTest(value) { // 외부 함수
	console.log('value: ' + value);
	var a = 100;
	
	function addValue(msg) { // 내부 함수
		console.log('msg: ' + msg);	
		console.log('a: ' + a);	
	}
	
	// 반드시 클로저 내부에서 정의한 함수를 리턴시켜야 한다.
	return addValue;
}

// closureTest() 함수를 호출해서 return된 결과를 goodEdu에 저장한다.
let goodEdu = closureTest('스프링');
// closureTest() 함수가 실행된 후 내부 함수(addValue)를 리턴시켜서 closureTest() 함수가 실행된 곳으로 내부 함수 addValue()가 리턴되므로,
// let goodEdu = function addValue(msg) { 
//		console.log('msg: ' + msg);	
//		console.log('a: ' + a);	
//	} 와 같이 된다.
// 즉, goodEdu 변수에 closureTest()의 내부 함수인 addValue() 함수가 할당된다.

// 리턴된 addValue() 함수가 goodEdu라는 변수에 할당되었고, 함수가 할당된 변수를 함수처럼 사용할 수 있다.
// => goodEdu(msg) 형태로 실행이 가능하다.


















