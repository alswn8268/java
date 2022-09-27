superheroes = ['아이언맨', '캡틴 아메리카', '토르', '닥터 스트레인지'];

for (let i = 0; i < superheroes.length; i++) {
	console.log(superheroes[i]);
}
console.log('------------------------');

for (let hero of superheroes) {
	console.log(hero);
}
console.log('------------------------');

for (let hero in superheroes) {
	console.log(superheroes[hero]);
}
console.log('------------------------');

// forEach(): 인수로 지정된 함수로 배열 요소를 차례대로 전달하며 함수를 반복해 실행한다.
function print(hero) { // 일반 함수
	console.log(hero);
}

// forEach() 함수의 인수로 전달하는 함수는 뒤에 ()를 사용하면 안 된다.
superheroes.forEach(print);
console.log('------------------------');

const print2 = (hero) => { // 화살표 익명 함수
	console.log(hero);
}

superheroes.forEach(print2);
console.log('------------------------');

const print3 = hero => console.log(hero); // 화살표 익명 함수, ()와 {} 생략

superheroes.forEach(print3);
console.log('------------------------');

superheroes.forEach((hero) => { // forEach() 함수의 인수로 화살표 익명 함수를 전달
	console.log(hero);
});
console.log('------------------------');

// forEach() 함수의 인수로 ()와 {}를 생략한 화살표 익명 함수를 전달
superheroes.forEach(hero => console.log(hero));
console.log('------------------------');

// 기존 배열에 저장된 값을 제곱해서 새 배열을 만든다.
const array = [1, 2, 3, 4, 5, 6, 7, 8];
const squared = []; // 빈 배열

for (let i = 0; i < array.length; i++) {
//	squared[i] = array[i] * array[i];
//	squared.push(array[i] ** 2);
	squared.push(Math.pow(array[i]), 2);
}
console.log(squared)
console.log('------------------------');

const squared2 = [];
function square(n) {
	squared2.push(Math.pow(n, 2));	
}

array.forEach(square);
console.log(squared2)
console.log('------------------------');

const squared3 = [];
array.forEach(function (n) {
	squared3.push(Math.pow(n, 2));	
});
console.log(squared3)
console.log('------------------------');

const squared4 = [];
array.forEach(n => squared4.push(Math.pow(n, 2)));
console.log(squared4)
console.log('------------------------');

// map(): 배열의 요소들을 대상으로 인수를 지정한 특정 작업(함수)을 실행한 후 결과를 배열로 리턴한다.
const squared5 = array.map(n => Math.pow(n, 2));
console.log(squared5)
console.log('------------------------');

const squared6 = array.map(function (n) {
	return Math.pow(n, 2)
});
console.log(squared6)
console.log('------------------------');

// 배열 내부의 객체에서 key가 text인 value값만 얻어와서 새 배열을 만든다.
const items = [
	{
		id: 1,
		text: 'hello'
	},
	{
		id: 2,
		text: 'bye'		
	},
];

const text = [];
for (let i = 0; i < items.length; i++) {
	text.push(items[i].text);
}
console.log(text);
console.log('------------------------');

const text2 = [];
function textChoice(item) {
	text2.push(item.text);
}
items.forEach(textChoice);
console.log(text2);
console.log('------------------------');

const text3 = [];
items.forEach(function (item) {
	text3.push(item.text);
});
console.log(text3);
console.log('------------------------');

const text4 = [];
items.forEach(item => text4.push(item.text));
console.log(text4);
console.log('------------------------');

const text5 = items.map(item => item.text);
console.log(text5);
console.log('------------------------');

const text6 = items.map(function (item){
	return item.text	
});
console.log(text6);
console.log('------------------------');

// indexOf(): 배열 전체에서 인수로 지정한 요소를 찾아 index를 리턴한다. 없으면 -1을 리턴한다.
const index = superheroes.indexOf('캡틴 아메리카');
console.log(index);
if (index >= 0) {
	console.log('있음');
} else {
	console.log('없음');	
}
console.log(index >= 0 ? '있음' : '없음'); // 삼항 연산자
console.log('------------------------');

const todos = [
	{
		id: 1,
		test: '자바스크립트 입문',
		done: true
	},
	{
		id: 2,
		test: '함수',
		done: true
	},
	{
		id: 3,
		test: '객체와 배열',
		done: true
	},
	{
		id: 4,
		test: '배열 함수',
		done: false
	},
];

// findIndex(): 배열에서 인수로 지정된 조건을 만족하는 첫 번째 요소의 index를 리턴한다. 없으면 -1을 리턴한다.
const index2 = todos.findIndex(function (todo) {
	return todo.id >= 3;
});
console.log(index2);
console.log('------------------------');

// find(): 배열에서 인수로 지정된 조건을 만족하는 첫 번째 요소를 리턴한다. 없으면 undefined를 리턴한다.
const todo = todos.find(function (todo) {
	return todo.done == true;
})
console.log(todo);

const todo2 = todos.find(function (todo) {
	return todo.done == false;
})
console.log(todo2);

const todo3 = todos.find(function (todo) {
	return todo.done == 'error';
})
console.log(todo3);
console.log('------------------------');

// filter(): 배열에서 인수로 지정된 조건을 만족하는 모든 요소를 배열로 리턴한다.
const todo4 = todos.filter(function (todo) {
	return todo.id >= 3;
});
console.log(todo4);
console.log('------------------------');

const todo5 = todos.filter(function (todo) {
	return todo.done;
});
console.log(todo5);
console.log('------------------------');
















