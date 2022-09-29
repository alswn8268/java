// 객체 선언 => function 사용
function Class(name) {
	// 객체를 구성하는 멤버를 선언할 때 앞에 this를 붙여주면 객체 외부에서 접근이 가능하다.
	this.name = name;
	// 객체를 구성하는 멤버를 선언할 때 앞에 this를 붙이지 않으면 객체 외부에서 접근이 불가능하다.
	age = 20;
	// this로 선언하지 않은 데이터를 얻어내려면 함수로 처리한다.
	this.getAge = function () {
		return age;
	}
}

function objectFunction() {
	// function으로 선언한 객체는 new를 사용해서 생성한다.
	const obj = new Class('홍길동'); 
	console.log(obj);
	// 객체의 멤버에 접근하려면 "."을 찍는다.
	console.log(obj.name);
	console.log(obj.age); // 접근 불가능
	console.log(obj.getAge()); // 함수를 통해 접근한다.
}

// 객체 선언 => class 사용
// class를 사용해서 객체를 선언할 때는 멤버 변수 앞에 this를 붙여서 선언해야 한다.
class Class2 {
	constructor(name) {
		this.name = name;
		this.age = 20;
	}
	getAge() {
		return this.age;
	}
}

function objectClass() {
	// class를 사용해서 선언한 객체도 new를 사용해서 생성한다.
	const obj2 = new Class2('임꺽정');
	console.log(obj2);
	console.log(obj2.name);
	console.log(obj2.age);
	console.log(obj2.getAge());
}

// 객체 선언 => json => key 부분을 반드시 큰따옴표로 묶어야 한다.
const Class3 ={
	"name" : '장길산',
	"age" : '45',
	"getAge" : function () {
		// 함수 내부에서 json 형식을 사용한 객체의 key를 참조하려면 반드시 객체 이름에 '.'을 찍어서 접근해야 한다.
		return Class3.age;
	}

}
function objectJSON() {
	// function이나 class를 사용해서 선언한 객체는 new를 사용해서 객체를 생성하고 사용한다.
	let clas = new Class('홍길동')
	console.log('clas.name: ' + clas.name);
	console.log('clas.age: ' + clas.age);
	console.log('clas.age: ' + clas.getAge());
	console.log('---------------------');

	let clas2 = new Class2('임꺽정')
	console.log('clas2.name: ' + clas2.name);
	console.log('clas2.age: ' + clas2.age);
	console.log('clas2.age: ' + clas2.getAge());
	console.log('---------------------');
	
	// json 형식으로 선언한 객체는 별도의 선언 과정 없이 사용할 수 있다.
	console.log('Clas3.name: ' + Class3.name);
	console.log('Clas3.age: ' + Class3.age);
	console.log('Clas3.age: ' + Class3.getAge());
	console.log('---------------------');

	// json을 가장한 문자열 => key 부분은 반드시 문자열로 만든다.
	let myJson = '{"name" : "일지매", "age": 41}';
	console.log(myJson);
	console.log(typeof myJson);

	// JSON.parse(): 인수로 지정된 json을 가장한 문자열을 json 객체로 변환한다.
	let jsonObj = JSON.parse(myJson);
	console.log(jsonObj);
	console.log(typeof jsonObj);
	console.log(jsonObj.name);
	console.log(jsonObj.age);
	console.log('---------------------');

	// JSON.stringity(): 인수로 지정된 json 객체를 json을 가장한 문자열로 변환한다.
	let jsonStr = JSON.stringify(jsonObj);
	console.log(jsonStr)
	console.log(typeof jsonStr)
}

