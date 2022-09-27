// 배열에 저장된 모든 데이터의 합계
const numbers = [1, 2, 3, 4, 5];
let sum = 0;

for (let i = 0; i < numbers.length; i++) {
	sum += numbers[i];
}
console.log(sum);

sum = 0;
function total(n) {
	sum += n;
}
numbers.forEach(total);
console.log(sum);

sum = 0;
numbers.forEach(function (n) {
	sum += n;
})
console.log(sum);

sum = 0;
numbers.forEach(n => sum += n)
console.log(sum);
console.log('----------------------')

// 배열.reduce(function (accumulator[, currentValue, currentIndex, array]) {
//		실행할 문장;
//		...;		
//		return 값; // 현재 실행한 return 값이 다음 실행의 accumulator에 저장된다.
// }[, accumulator의 초기치]); 

// 배열.reduce((accumulator[, currentValue, currentIndex, array]) => {
//		실행할 문장;
//		...;		
//		return 값;
// }[, accumulator의 초기치]); 

// accumulator: 연산 결과가 저장될 기억장소
// accumulator의 초기치를 생략하면 reduce() 함수를 실행하는 배열의 0번째 index 값이 초기치로 지정된다.
// currentValue: reduce() 함수를 실행하는 배열의 값이 차례대로 넘어와 저장되는 변수
// currentIndex: currentValue로 넘어오는 값의 index가 저장되는 변수
// array: reduce() 함수를 실행하는 배열 자신을 의미한다.

// 최초 실행시 accumulator의 초기치를 accumulator에 저장한 후 반복이 시작되고, 그 이후에는 현재 실행하는 return 값이 다음 실행의 accumulator에 저장되며 끝까지 반복한다.

sum = numbers.reduce(function (accumulator, currentValue, currentIndex, array) {
	console.log(accumulator, currentValue, currentIndex, array);	
	return accumulator + currentValue;
}, 0);
console.log(sum);

sum = numbers.reduce((accumulator, currentValue) => {
	accumulator + currentValue;
}, 0);
console.log(sum);

sum = numbers.reduce((accumulator, currentValue) => accumulator + currentValue, 0);
console.log(sum);
console.log('----------------------')

// 배열에 저장된 데이터 중에서 10보다 큰 데이터의 개수
const numbers2 = [1, 2, 3, 4, 5, 10, 20, 30, 40, 50, 60];

let count = 0;
for (let i = 0; i < numbers2.length; i++) {
	if (numbers2[i] > 10) {
		count++;
	}
}
console.log(count);
function tenOverNumber(number) {
	let count = 0;
	number.forEach(n => {
		if (n > 10) {
			count++;
		}
	});
	return count;
}
count = tenOverNumber(numbers2);

console.log('----------------------')
/* const n = numbers2.filter(number => number > 10)
count = n.length; */

function tenOverNumber2(numbers) {
	return numbers.filter(n => n > 10).length;
}
count = tenOverNumber2(numbers2);
console.log(count);
console.log('----------------------')

/* numbers2.reduce((accumulator, currentValue) => {
	if (currentValue > 10) {
		count++;
	}
}) */
function tenOverNumber3(numbers) {
	return numbers.reduce((acc, curr) => {
		if (curr > 10) {
			// 조건을 만족하면 10 초과인 경우이므로 현재 acc값에 1을 더해서 다음으로 넘겨준다.
			// acc++을 사용하면 현재 acc 값인 0을 다음 실행의 acc에 넣어주기 때문에 최종 결과가 0이 나온다. (++acc는 가능)
			return acc + 1;
		} else {
			// 조건을 만족하지 않으면 10 이하인 경우이므로 현재 acc값을 그대로 다음으로 넘겨준다.
			return acc;
		}
	}, 0)
}
count = tenOverNumber3(numbers2);
console.log(count);
console.log('----------------------')

// 배열에 저장된 문자 개수 세기
const alpha = ['a', 'a', 'a', 'b', 'c', 'c', 'd', 'e'];

const alphaCount = alpha.reduce(function (acc, curr) {
	if (acc[curr]) { // 객체에 curr에 저장된 key가 있는가?
		// key가 있으면 문자의 개수를 증가시킨다.
		acc[curr] += 1;
	} else {
		// key가 없으면 1로 초기화시킨다.
		acc[curr] = 1;
	}
	return acc;
}, {}); // acc를 빈 객체로 초기화 한다.
console.log(alphaCount);
































