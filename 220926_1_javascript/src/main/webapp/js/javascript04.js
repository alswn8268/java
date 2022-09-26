/*
함수
function 함수이름([인수, ...]) {
	함수가 실행할 문장...;
	...;
	[return 값]
} 
*/

function printHello() {
	console.log('Hello');
}

printHello(); // 함수 호출 
console.log('--------------------------')

// 자바스크립트의 함수는 인수의 개수가 달라도 상관 없다. 
// 함수의 오버로딩을 지원하지 않는다.
function log(message) {
	console.log(message);
}

log('안녕하세용');
log();
log(1, 2);
console.log('--------------------------')

// 함수의 인수로 객체를 받을 수 있다.
function setName(obj) {
	obj.name = '임꺽정';
}

const hong = {
	name: '홍길동',
	age: 20
};
log(hong);
log(hong.name);
log(hong.age);

setName(hong);
log(hong);
console.log('--------------------------')

// 디폴트 인수 => ES6 추가
// 인수가 넘어오면 넘어온 값으로 함수를 실행하지만, 넘어오지 않으면 undefined로 처리된다.

// ES5
function showMessage(message, from) {
	if (from == undefined) {
		from = '발신인 없음';
	}
	console.log(`ES5: ${message} by ${from}`);
}

showMessage('Hi~');

// ES6
// 디폴트 인수는 기본값을 가지는 인수를 말한다.
// from에 데이터가 넘어오면 넘어온 데이터로 함수를 실행하고, 데이터가 넘어오지 않으면 디폴트 인수로 지정된 '발신인 없음'으로 처리한다.
function showMessage2(message, from = '발신인 없음') {
	console.log(`ES6: ${message} by ${from}`);
}

showMessage2('Bye~');
showMessage2('Bye~', '홍길동');
console.log('--------------------------')

// rest => 가변 인자 => ES6 추가
// 가변 인자는 '...'을 앞에 붙여서 선언하면 배열로 만들어진다.
function printAll(...args) {
	// console.log(typeof args);
	// console.log('배열의 크기: ' + args.length);
	// console.log('배열에 저장된 값: ' + args);

	// 일반 for
	/* for (let i = 0; i < args.length; i++) {
		console.log(args[i]);
	} */

	// 향상된 for는 배열의 첫 번째 인덱스의 값을 변수에 넣어 반복을 시작하고, 마지막 값을 변수에 넣어 반복한 후 종료된다.
	for (let arg of args) {
		console.log(arg);
	}

}
printAll('홍길동');
console.log('--------------------------')
printAll('홍길동', '임꺽정');
console.log('--------------------------')
printAll('홍길동', '임꺽정', '장길산');
console.log('--------------------------')
printAll('홍길동', '임꺽정', '장길산', '일지매');
console.log('--------------------------')

// 익명 함수
// 자바스크립트는 변수에 함수를 할당할 수 있기 때문에, 익명으로 만든 함수를 변수에 할당해서 사용할 수 있다.
const print = function() {
	console.log('print');
}

// 함수를 할당한 변수를 함수명처럼 사용한다.
print();

const printAgain = print;
printAgain();

// 변수에는 꼭 익명 함수만 할당할 수 있는 것이 아니고 일반 함수도 할당할 수 있다.
function sum(a, b) {
	return a + b;
}

console.log(sum(5, 8));
const sumAgain = sum; // 변수에 일반 함수 할당
console.log(sumAgain(5, 8));

// callback 함수
// callback 함수는 코드를 통해서 명시적으로 호출하는 함수가 아니라, 개발자가 단지 함수를 등록하기만 하고 어떤 이벤트가 발생했거나 특정 시점에 도달했을 때 시스템에서 호출(자동으로 실행)하는 함수를 말한다.
// 익명 함수가 callback을 구현할 때 주로 사용된다.

// printYes, printNo 변수에 함수를 등록한다.
const printYes = function() {
	console.log('yes');
}
const printNo = function() {
	console.log('no');
}

function quiz(answer, yes, no) {
	if (answer == '사랑해') {
		yes();
	} else {
		no();
	}
}

// 함수를 호출할 때 처리할 데이터와 그 데이터를 처리할 함수까지 전달한다.
quiz('사랑해', printYes, printNo);
quiz('미워해', printYes, printNo);
console.log('--------------------------')

// 화살표(Arrow) 함수 => ES6 추가
// 일반 익명 함수
const simplePrint = function() {
	console.log('일반 익명 함수 simplePrint() 실행');
};
simplePrint();

// 화살표 함수
// function을 사용하지 않고 ')'와 '{' 사이에 화살표(=>)를 사용한다. 
const simplePrint2 = () => {
	console.log('일반 익명 함수 simplePrint2() 실행');
};
simplePrint2();

// 화살표 함수가 실행할 문장이 1문장일 때 {}를 생략할 수 있다.
const simplePrint3 = () => console.log('일반 익명 함수 simplePrint3() 실행');
simplePrint3();
console.log('--------------------------')


const whoAreYou = function(name) {
	console.log(name + '님 안녕하세요?');
}
whoAreYou('홍길동');

const whoAreYou2 = (name) => { console.log(name + '님 안녕하세요?') };
whoAreYou2('홍길동');

const whoAreYou3 = (name) => console.log(name + '님 안녕하세요?');
whoAreYou3('홍길동');

// 화살표 함수의 인수가 1개일 경우 ()를 생략할 수 있다.
const whoAreYou4 = name => console.log(name + '님 안녕하세요?');
whoAreYou4('홍길동');
console.log('--------------------------')

// 함수가 실행할 문장이 return 1문장만 있을 경우 {}를 생략하면 반드시 리턴도 생략해야 한다.
const add = function(a, b) {
	return a + b;
}
console.log(add(5, 8));

const add2 = (a, b) => {return a + b;}
console.log(add2(5, 8));

const add3 = (a, b) => a + b;
console.log(add3(5, 8));

// 자동 실행 함수
// 자동으로 실행할 함수는 함수 전체를 ()로 묶고 ')' 뒤에 ()를 붙여준다.
(function hello() {
	console.log('자동 실행');
}) ();

// 자동 실행 함수는 일반 함수처럼 실행하면 에러가 발생된다.
// hello(); (x)




