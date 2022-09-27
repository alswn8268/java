// 클래스
class Food {
	// 생성자: 객체가 생성될 때 멤버 변수를 선언하고 초기화한다.
	// 클래스 멤버 함수 선언시 앞에 function을 붙이지 않는다.
	constructor(name) {
		this.name = name; // 멤버 변수 선언 및 초기화
		this.brands = [];	
	}
	// 멤버 함수를 선언한다.
	// 인수로 음식 브랜드를 넘겨받아 배열에 추가하는 함수
	addBrands(brand) {
		this.brands.push(brand);
	}
	// 배열에 저장된 브랜드를 출력하는 함수
	print() {
		console.log(`${this.name}을(를) 파는 음식점들: ` + this.brands.join(', '));
	}
};

// 클래스 객체 생성
const pizza = new Food('피자');
console.log(pizza);
pizza.addBrands('피자헛');
pizza.addBrands('미스터 피자');
pizza.addBrands('도미노 피자');
pizza.addBrands('피자스쿨');
pizza.print();

const chicken = new Food('치킨');
chicken.addBrands('굽네치킨');
chicken.addBrands('네네치킨');
chicken.addBrands('교촌치킨');
chicken.print();

// 상속
class Animal { // 부모 클래스
	constructor(type, name, sound) {
		this.type = type;
		this.name = name;
		this.sound = sound;
	}
// 클래스에 멤버 함수를 만들면 자바스크립트가 자동으로 prototype에 등록한다.
	say() {
		console.log('부모 클래스의 say() 함수 실행: ' + this.sound);
	}
}
// console.log(Animal.prototype.say);

const dog = new Animal('강아지', '두부', '왈왈');
const cat = new Animal('고양이', '블리', '야옹');

dog.say();
cat.say();
console.log('---------------------------')

// 상속은 java와 같이 extends 예약어를 사용한다.
class Dog extends Animal {
	constructor (name, sound, age) {
		// 부모 클래스에서 상속받은 멤버 변수를 초기화하기 위해서 부모 클래스의 생성자를 호출한다.
		super('개', name, sound);
		this.age = age;
	}
	// 함수 override
	say() {
		console.log(this.age + '살 짜리 강아지가 ' + this.sound + '합니다.');
	}	
}

const dog2 = new Dog('멍멍이', '멍멍', 2);
dog2.say();

class Cat extends Animal {
	constructor (name, sound, age) {
		super('고양이', name, sound);
		this.age = age;
	}
	say() {
		console.log(this.age + '살 짜리 고양이가 ' + this.sound + '합니다.');
	}	
}

const cat2 = new Cat('야옹이', '야옹', 10);
cat2.say();















