function strTest1() {
	let str1 = 'string';
	let str2 = 'function';
	let str3 = str1 + str2;
	console.log(str3);

	// concat(): 함수를 실행한 문자열에 인수로 지정한 문자열을 합친다.
	let newStr = str1.concat(str2);
	console.log(newStr);

	// join(): 함수를 실행한 배열 요소에 인수로 저장한 문자열을 사이사이에 삽입한다.
	let joinStr = ['java', 'script', '짱'].join('\t');
	console.log(joinStr);
}

function strTest2() {
	let num = 12.34;
	let bool = true;
	let str = '문자열';
	// 연산자 우선 순위에 의해 num + bool을 먼저 연산한다.
	// boolean 타입의 데이터는 숫자와 연산하면 true는 1, false는 0으로 취급되어 연산된다. => 13.34 + 문자열
	console.log(num + bool + str); // 13.34문자열
	// boolean 타입의 데이터는 문자열과 연산하면 true, false가 문자열료 연산된다. => 12.34문자열 + true
	console.log(num + str + bool);
}

function strTest3() {
	let str = prompt('이름을 입력하세요.', '숫자는 입력하지 마세요.');
	// console.log(typeof str);

	// isNaN(): 인수로 지정된 값이 숫자가 아니면 true, 숫자면 false를 리턴한다.
	// console.log(isNaN(str));
	
	if (!isNaN(str)) {
		alert('숫자를 입력했습니다.');
	} else if (str == '홍길동') {
		alert(str + '님 안녕하세요?');
	} else {
		alert(str + '님은 누구세요?');
	}
	console.log('------------------');
	
	// '==', '!='는 데이터만 비교하고, '===', '!=='는 데이터 타입과 데이터를 모두 비교한다.
	let num = 10;
	console.log(typeof num);
	str = '10';
	console.log(typeof str);
	
	if (num == str) {
		console.log('데이터 타입은 비교하지 않고 데이터만 비교하므로 같다.');
	} else {
		console.log('데이터 타입과 데이터 모두 비교하므로 다르다.');
	}
	
	if (num === str) {
		console.log('데이터 타입은 비교하지 않고 데이터만 비교하므로 같다.');
	} else {
		console.log('데이터 타입과 데이터 모두 비교하므로 다르다.');
	}
	console.log('------------------');

	let oldName = '홍길동';
	console.log(typeof oldName);
	let newName = new String('홍길동');
	console.log(typeof newName);

	console.log(oldName == newName ? '같다' : '다르다');
	console.log(oldName === newName ? '같다' : '다르다');
}

function strTest4() {
	// indexOf(): 문자열 앞쪽부터 인수로 지정한 문자열을 찾아 index를 리턴한다.
	// lastIndexOf(): 문자열 뒤쪽부터 인수로 지정한 문자열을 찾아 index를 리턴한다.
	// indexOf(), lastIndexOf() 모두 인수로 지정한 문자열이 없으면 -1을 리턴한다.
	let name = '홍길동 임꺽정 장길산 일지매 홍길동'
	let str = prompt('검색할 이름을 입력하세요.'); 
	if (name.indexOf(str) == -1) {
		console.log(str + '(이)라는 이름은 존재하지 않습니다.')
	} else {
		console.log('indexOf() 함수로 검색한 index: ' + name.indexOf(str));
		console.log('lastIndexOf() 함수로 검색한 index: ' + name.lastIndexOf(str));
	}
	console.log(str);
}

function strTest5() {
// substring(a): 문자열에서 index가 a인 문자부터 끝까지 추출한다.
// substring(a, b): 문자열에서 index가 a인 문자부터 b-1번째 문자까지 추출한다.
	let today = '2022-09-29 (목) 2022-09-04';

	let solar = today.substring(0, today.indexOf(' '));
	let lunar = today.substring(today.lastIndexOf(' ')+1);

	console.log('양력 ' + solar + '는 음력으로 ' + lunar + '입니다.');
}

function strTest6() {
	let today = '2022-09-29 (목) 2022-09-04';
// split(): 인수로 지정된 구분자를 경계로 문자열을 나눠서 배열로 리턴한다.
	let array = today.split(' ');
	console.log(array);
	console.log('양력 ' + array[0] + array[1] + '는 음력으로 ' + array[2] + '입니다.');

}
