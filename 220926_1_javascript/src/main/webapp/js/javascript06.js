const dog = {
	name: '두부',
	sound: '깡깡',

// 객체의 멤버로 함수를 가질 수 있다.
	say: function say() {
		// 함수에서 객체의 멤버를 참조할 때는 자신의 객체를 의미하는 this를 붙여야 한다.
		console.log(this.sound);
	}
	/*
	say: function () {
		console.log(this.sound);
	}
	*/
	/*
	say: () => { // 화살표 함수에서는 this를 사용할 수 없다.
		console.log(this.sound);
	}
	*/
};

console.log(dog);
console.log(dog.name);
console.log(dog.sound);
dog.say();
console.log('----------------------');

// 객체 외부에서 함수를 객체에 주입할 수 있다.
const cat = {
	name: '고양이',
	sound: '야옹',
};

const say = function say() {
		console.log(this.sound);
	}
// 외부 함수를 객체의 say() 함수로 주입한다.
cat.say = say;
console.log(cat);
cat.say();

// dog 객체의 say() 함수를 cat 객체의 say() 함수로 주입한다.
console.log('----------------------');
cat.say2 = dog.say;
console.log(cat);
cat.say2();

// getter, setter를 사용하면 객체의 값을 얻어오거나 넣어줄 때 일련의 기능을 실행할 수 있다.
const numbers = {
	a: 1,
	b: 2,
	
//	getter: get으로 선언하는 함수
	get sum() {
		// getter는 특정 멤버의 값이나 연산 결과를 얻어와야 하므로, 일반적으로 값을 리턴 시켜야 한다.
		// 값을 리턴시키지 않으면 undefined가 리턴된다.
		console.log('sum() 함수가 실행됩니다.');
		return this.a + this.b;
	}
};
console.log(numbers);

numbers.a = 5;
console.log(numbers);

// numbers.sum(); // numbers.sum is not a function 에러가 발생한다.
// getter를 실행할 때는 함수 이름 뒤에 ()를 붙이면 안 된다.
numbers.sum;
console.log(numbers.sum);
















