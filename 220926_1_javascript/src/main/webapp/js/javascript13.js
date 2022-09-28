// falsy: 무조건 거짓이 되는 값 => undefined, null, 0, '', NaN

// 단축 평가(short-circuit evaluation) 논리 계산법
// '&&' 논리 연산에서 앞의 조건이 true면 '&&' 뒤의 내용이 출력된다.
console.log(true && 'hello');
// '&&' 논리 연산에서 앞의 조건이 false면 false가 출력된다.
console.log(false && 'hello');
console.log('-----------------------');

const dog = {
	name: '멍멍이'
};

/*
function getName(animal) {
	console.log(animal);
	if (animal) {
		return animal.name;
	}
}
*/
function getName(animal) {
	console.log(animal);
	return animal && animal.name;
}

const name = getName(dog);
console.log(name);
const name2 = getName();
console.log(name2);

// '||' 논리 연산에서 앞의 조건이 true면 true가 출력된다.
console.log(true || 'hello');
// '||' 논리 연산에서 앞의 조건이 false면 '||' 뒤의 내용이 출력된다.
console.log(false || 'hello');
console.log('-----------------------');

const cat = {
	name: '야옹이'
};

function getName2(animal) {
	const name = animal || animal.name;
	console.log(name);
	if (name) {
		return name.name;
	} else {
		return '누구세요'
	}
}

const name3 = getName2(cat);
console.log(name3);
const name4 = getName2();
console.log(name4);













