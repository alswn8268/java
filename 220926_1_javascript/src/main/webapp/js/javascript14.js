const slime = {
	name: '슬라임',
};

const cuteSlime = {
	name: '슬라임',
	attribute: 'cute',
};

const purpleCuteSlime = {
	name: '슬라임',
	attribute: 'cute',
	color: 'purple',
};

console.log(slime);
console.log(cuteSlime);
console.log(purpleCuteSlime);
console.log('------------------------');

// ...(spread 연산자) => ES6 추가
// 객체나 배열 내부의 다른 객체나 배열을 퍼뜨린다.
const slime2 = {
	name: '슬라임',
}

const cuteSlime2 = {
	...slime2,
	attribute: 'cute',
};

const purpleCuteSlime2 = {
	...cuteSlime2,
	color: 'purple',
};

console.log(slime2);
console.log(cuteSlime2);
console.log(purpleCuteSlime2);
console.log('------------------------');

// spread 연산자는 배열에도 사용할 수 있다.
const animals = ['강아지', '고양이', '참새'];
console.log(animals);
const animals2 = animals.concat('비둘기');
console.log(animals2);
const animals3 = [...animals2, '닭둘기'];
console.log(animals3);



































