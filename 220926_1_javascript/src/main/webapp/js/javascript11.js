// 클래스
function Animal(type, name, sound) {
	// 멤버 변수 초기화
	this.type = type;
	this.name = name;
	this.sound = sound;
	// 멤버 함수
	// 함수를 클래스 내부에서 선언하면 클래스 객체가 생성될 때마다 함수가 매번 만들어진다.
	this.say = function () {
		console.log(this.sound);
	};
};

// 클래스 객체 생성
const dog = new Animal('개', '두부', '알알');
dog.say();
const cat = new Animal('고양이', '블리', '야옹');
cat.say();
console.log('-----------------');

function Animal2(type, name, sound) {
	this.type = type;
	this.name = name;
	this.sound = sound;
};

// 함수를 클래스 내부에서 선언하면 객체가 생성될 때마다 같은 함수가 만들어지고, prototype으로 함수를 선언하면 함수가 한 번만 만들어진다.
Animal2.prototype.say = function() {
	console.log(this.sound);
};

const dog2 = new Animal2('개', '두부', '알알');
dog.say();
const cat2 = new Animal2('고양이', '블리', '야옹');
cat.say();
console.log('-----------------');

function Animal3(type, name, sound) {
	this.type = type;
	this.name = name;
	this.sound = sound;
};

console.log('-----------------');
const dog3 = new Animal3('개', '두부', '알알');
const cat3 = new Animal3('고양이', '블리', '야옹');

// prototype으로 함수를 선언하지 않으면 클래스 외부에서 함수를 만들어서 각 객체에 넣어줘야 한다.
function say() {
	console.log(this.sound);
}

dog3.say = say; // 함수 이름 뒤에 ()를 쓰지 않는다.
cat3.say = say;

// 상속
function Animal4(type, name, sound) { // 부모 클래스
	this.type = type;
	this.name = name;
	this.sound = sound;	
}

// 부모 클래스의 prototype에 say() 함수를 추가한다.
Animal4.prototype.say = function() {
	console.log(this.sound);

}

// Animal4(부모) 클래스를 상속받는 Dog(자식) 클래스를 정의한다.
function Dog(name, sound) {
// 부모 클래스 Animal4를 호출해서 자식 클래스를 초기화할 데이터를 전달한다.
	Animal4.call(this, '개', name, sound);
}

function Cat(name, sound) {
	Animal4.call(this, '고양이', name, sound);	
}

// 부모 클래스의 prototype을 자식 클래스의 prototype에 넣어준다. => 상속
// 자식 클래스를 선언하고 자식 클래스의 객체를 생성하기 전에 실행한다.
Dog.prototype = Animal4.prototype;
Cat.prototype = Animal4.prototype;

const dog4 = new Dog('몽몽이', '몽몽');
console.log(dog4);
console.log(dog4.type);
console.log(dog4.name);
console.log(dog4.sound);
dog4.say();

const cat4 = new Cat('어흥이', '어흥');
console.log(cat4);
console.log(cat4.type);
console.log(cat4.name);
console.log(cat4.sound);
cat4.say();





























