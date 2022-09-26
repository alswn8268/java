// 객체
const dog = {
	// key : value
	name : '두부',
	age : 5
}

console.log(dog);
console.log(dog.name);
console.log(dog.age);
dog.name = '두비두바';
console.log(dog);
console.log('---------------');

const ironMan = {
	name: '토니 스타크',
	actor: '로버트 다우니 주니어',
	alias: '아이언맨'
};

const captainAmerica = {
	name: '스티븐 로저스',
	actor: '크리스 에반스',
	alias: '캡틴 아메리카'	
}

function print(hero) {
	const str = `${hero.alias}(${hero.name}) 역할을 맡은 배우는 ${hero.actor} 입니다.`;
	console.log(str);
}

const print2 = hero => {
	const str = `${hero.alias}(${hero.name}) 역할을 맡은 배우는 ${hero.actor} 입니다.`;
	console.log(str);
}

/* const print = obj => console.log(obj.alias + '(' + obj.name + ')' + '역할을 맡은 배우는 ' + obj.actor + '입니다.')
print(ironMan);
print(captainAmerica); */
console.log('---------------');

// 비구조화 할당 => 객체 구조 분해
function heroPrint(hero) {
	// 인수 hero로 받은 객체 내부의 값을 외부로 꺼내온다.
	// 비구조화 할당을 통해서 객체 내부의 값을 꺼내서 저장할 변수의 이름은 객체에서 사용한 key 이름과 반드시 같아야 한다.
	// const {key, ...} = 객체;
	const {name, actor, alias} = hero;
	const str = `${alias}(${name}) 역할을 맡은 배우는 ${actor} 입니다.`;
	console.log(str);	
}
heroPrint(ironMan);
heroPrint(captainAmerica);
console.log('---------------');

// 객체를 인수로 받을 때 비구조화 할당을 할 수 있다.
function heroPrint({name, actor, alias}) {
	const str = `${alias}(${name}) 역할을 맡은 배우는 ${actor} 입니다.`;
	console.log(str);	
}
heroPrint(ironMan);
heroPrint(captainAmerica);

// 비구조화 할당은 함수 외부에서도 가능하다.
const {name, actor, alias} = ironMan;
console.log(name);
console.log(actor);
console.log(alias);











