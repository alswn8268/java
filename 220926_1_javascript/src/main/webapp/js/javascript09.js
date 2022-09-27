const numbers = [10, 20, 30, 40];

// splice(index, 개수): 배열에서 index 번째 위치부터 지정된 개수만큼 추출해서 배열로 리턴한다.
const spliced = numbers.splice(1, 2);
console.log('spliced: ' + spliced);
//	splice() 함수를 실행하면 원본 배열에서 추출된 데이터가 제거된다. 
console.log('numbers: ' + numbers);
console.log('---------------------------');

const numbers2 = [10, 20, 30, 40];

// slice(a, b): 배열에서 a번째 index부터 b - 1번째 index까지 추출해서 배열로 리턴한다.
const sliced = numbers2.slice(1, 3);
console.log('sliced: ' + sliced);
//	slice() 함수는 원본 배열의 데이터가 유지된다. 
console.log('numbers2: ' + numbers2);
console.log('---------------------------');

const numbers3 = [10, 20, 30, 40];

// push(): 배열의 맨 뒤에 인수로 지정한 데이터를 추가한다.
numbers3.push(999);
console.log('numbers3: ' + numbers3);

// unshift(): 배열의 맨 앞에 인수로 지정한 데이터를 추가한다.
numbers3.unshift(777);
console.log('numbers3: ' + numbers3);

// pop(): 배열의 맨 뒤의 데이터를 추출한 후 제거한다.
let value = numbers3.pop();
console.log('pop 데이터: ' + value);
console.log('numbers3: ' + numbers3);

// shift(): 배열의 맨 앞의 데이터를 추출한 후 제거한다.
let value2 = numbers3.shift();
console.log('shift 데이터: ' + value2);
console.log('numbers3: ' + numbers3);
console.log('---------------------------');

const array = [1, 2, 3];
const array2 = [11, 22, 33];

// concat(): 인수로 지정된 배열을 연결해서 리턴한다.
const concatenated = array.concat(array2);
console.log('concatenated: ' + concatenated);
console.log('---------------------------');

const array3 = ['홍길동', '임꺽정', '장길산', '일지매'];

// join(): 배열 요소들 사이에 인수로 지정한 문자열을 삽입해서 문자열로 리턴한다.
console.log(array3.join());	// 인수를 지정하지 않으면 ','가 기본값으로 사용된다.
console.log(array3.join(' '));
console.log(array3.join('!!!!!'));
console.log(array3.join('\n'));
console.log(typeof array3.join('\n'));






















