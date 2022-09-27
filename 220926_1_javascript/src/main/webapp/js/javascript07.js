const objects = [
	{
		name: '멍멍이',
	},
	{
		name: '야옹이',
	}
];

console.log(objects);
console.log(objects.length);
console.log(objects[0]);
console.log(objects[1]);
console.log(objects[2]); // undefined, 배열의 인덱스 범위를 벗어남
console.log(objects[0].name);
console.log(objects[1].name);
console.log('------------------------');

// push(): 배열에 데이터를 추가한다.
const hong = {
	name: '길동이',
};
objects.push(hong);
console.log(objects);

objects.push({
	name: '꺽정이',
});
console.log(objects);
console.log('------------------------');

const doggo = {
	name: '멍멍이',
	sound: '멍멍',
	age: 2
};

// Object.values(): 인수로 지정된 객체의 key에 할당된 value값을 배열로 묶어서 얻어온다.
const values = Object.values(doggo);
console.log('Object.values(doggo): ' + values);
console.log(values.length);

for (let i = 0; i < values.length; i++) {
	console.log(values[i]);
}

// Object.keys(): 인수로 지정된 객체의 key값을 배열로 묶어서 얻어온다.
const keys = Object.keys(doggo);
console.log('Object.keys(doggo): ' + keys);
console.log(keys.length);

for (let key of keys) { // 향상된 for
	console.log(key);	
}
console.log('------------------------');

// Object.entries(): 인수로 지정된 객체의 key와 value 값을 한 쌍으로 묶어 배열로 얻어온다.
const entries = Object.entries(doggo);
console.log('Object.entries(doggo): ' + entries);
console.log(entries.length);

// in을 사용하는 for는 in 뒤에 배열이 나오면, 배열의 인덱스가 변수에 저장되어 반복된다.
for (let entry in entries) { 
	console.log(entries[entry]);	
}

// in을 사용하는 for는 in 뒤에 객체가 나오면, 객체의 key가 변수에 저장되어 반복된다.
console.log('------------------------');
for (let d in doggo) { 
	console.log(d);	
}

console.log('------------------------');

// 객체의 멤버에 접근하는 방법은 객체 이름에 '.'을 찍는 방법과 []안에 key를 사용해서 접근하는 방법이 있다.
console.log(doggo.name); // '.'으로 접근
console.log(doggo['name']); // [key]로 접근

console.log('------------------------');
for (let key of keys) {
	console.log(doggo[key]);	
}

