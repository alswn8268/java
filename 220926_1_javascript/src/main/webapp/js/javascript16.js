// 변수 선언 방법
// var는 변수 선언 방식에 있어서 큰 단점을 가진다.
var name = 'hong'; // 변수 선언
console.log('name: ' + name);

// 같은 이름으로 변수를 다시 선언해도 오류가 발생하지 않고, 각기 다른 값이 출력된다.
var name = 'javascript';
console.log('name: ' + name);

// 이 방식은 유연한 변수 선언으로, 간단한 테스트에는 편리하지만 코드의 양이 많아지면 사용 파악이 힘들다.
// => ES6에서 let, const가 보완을 위해 추가

let id = 'lim'; // 변수 선언
console.log('id: ' + id);
// let으로 선언한 id 변수를 같은 이름으로 다시 선언하면 Uncaught Syntax Error가 발생한다.
// let id = 'jang';(x)
id = 'jang'; // 선언된 변수에 값을 할당
console.log('id: ' + id);

const test = 'test' // 상수 선언
console.log('test: ' + test);
// const로 선언한 변수를 같은 이름으로 다시 선언하면 Uncaught Syntax Error가 발생한다.
// const test = 'test'; (x)
// test = 'a'; // 상수에 값을 할당하면 오류가 발생한다.

// let과 const는 변수 재선언이 되지 않는다는 공통점이 있다.
// 그러나 let은 선언된 변수에 데이터 재할당이 가능하지만, const는 선언시 데이터 재할당을 할 수 없다.
console.log('-----------------------------');

// 전역 변수: 함수 외부에서 선언한 변수로, 스크립트의 모든 함수에서 공통적으로 변수에 저장된 데이터를 사용할 수 있다.
//			  var를 붙이지 않고 변수르 선언하면 전역 변수로 인식한다.
// 지역 변수: 함수 내부에서 선언한 변수로, 선언된 함수 내부(var) 또는 {} 블록 내부(let, const)에서만 사용할 수 있다.
// 전역 변수와 같은 이름의 지역 변수를 사용하려면 지역 변수를 선언할 때 var를 붙여서 선언한다.

var variable = 10; // 전역 변수
function scopeTest() {
	var a = 0; // 지역 변수
	if (true) {
		console.log('scopeTest() 함수 블록 a: ' + a);
		var b = 5; // 지역 변수
		console.log('if 블록 b: ' + b);
		let c = 100;
		console.log('if 블록 c: ' + c);

		// hoisting에 의해 i라는 변수가 선언은 되었지만 값은 할당되지 않는다.
		console.log('for 블록 외부 i: ' + i); // undefined
		for (var i = 0; i < 5; i++) {
			console.log('for 블록 내부 i: ' + i);
		}
	}
	// var로 선언한 변수는 function scope이므로 선언된 함수 내부에서 자유롭게 사용할 수 있다.
	console.log('scopeTest() 함수 블록 a: ' + a);
	console.log('if 블록 b: ' + b);
	// let과 const는 block scope 이므로 변수가 선언된 {} 블록 외부에서 사용할 수 없다.		
	//	console.log('if 블록 c: ' + c); (X)

	console.log('함수 내부 전역 변수 variable: ' + variable);
	variable = 999;
	console.log('함수 내부 전역 변수 variable: ' + variable);

	// 전역 변수와 같은 이름으로 지역 변수를 선언하면 더이상 전역 변수를 사용할 수 없다.
	var variable = 777;
	console.log('지역 변수 variable: ' + variable);
	console.log('전역 변수 variable: ' + variable);

}
console.log('1. 함수 외부 전역 변수 variable: ' + variable);

function test1() {
//	console.log('test1() 함수 실행')
	variable += 5;
	console.log(variable);

//	getElementById(): html 문서에서 인수로 지정된 id 속성을 가지는 객체(태그)를 얻어온다.
//	console.log(window.document.getElementById('var1'));
//	console.log(document.getElementById('var1'));

// innerText: 태그 내부를 의미하고 hrml 태그 구현이 불가능하다. 모두 문자열로 처리한다.
	document.getElementById('var1').innerText = '<b>' + variable + '</b>';
	
// innerHTML: 태그 내부를 의미하고 html 태그 구현이 가능하다.
	document.getElementById('var1').innerHTML = '<b style="color: salmon; background-color: skyblue;">' + variable + '</b>';
	
}

function test2() {
	console.log(variable);
	// 함수 내부에서 전역 변수와 같은 이름의 지역 변수를 선언하면 지역 변수에 우선권이 있다.
	// 함수 내부에서 아래와 같이 var를 이용해서 전역 변수와 같은 이름의 지역 변수를 선언하면, 함수 내부에 variable 이라는 지역 변수로 선언되지만 var를 사용하지 않으면 전역 변수를 의미한다.
	// 지역 변수가 선언되기 전에 지역 변수를 사용하면 undefined가 출력된다. => hoisting
//	var variable =5;
}

function test3() {
	var variable2 = variable + 3;	
	document.getElementById("var2").innerText = variable2;
}

function test4() {
	var variable3 = '문자열';
	console.log(typeof variable3); // string
	variable3 = 5;
	console.log(typeof variable3); // number
	variable3 = 5.5;
	console.log(typeof variable3); // number
	variable3 = true;
	console.log(typeof variable3); // boolean
	variable3 = null;
	console.log(typeof variable3); // object
	variable3 = [1, 2, 3, 4, 5];
	console.log(typeof variable3); // object
	variable3 = {name: '홍길동'};
	console.log(typeof variable3); // object		
	
	variable3 = function (name) {
		console.log(name + '님 안녕하세요');
	}
	console.log(typeof variable3); // object
	
	variable3('홍길동');		
}













