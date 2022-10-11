onload = function () {
	document.getElementsByName('j1')[0].focus();
};

// 이벤트가 실행되는 객체에 입력 가능한 최대 글자수 만큼 문자가 입력되면 다음 객체로 포커스를 넘겨주는 함수
// moveNext(이벤트가 실행되는 객체, 최대 글자수, 포커스를 넘겨줄 객체)
function moveNext(obj, len, nextObj) {
	if (obj.value.length == len) {
		nextObj.focus();
	}
}

// 인수로 넘어온 form의 유효성을 검사하고 정상이면 true를, 오류가 발생하면 오류 메시지를 출력하고 false를 리턴하는 함수
function formCheck(obj) {
	// obj로 this(form)가 넘어오므로 obj에는 document.juminForm이 저장된다.
	// 주민등록번호 앞 자리에 아무것도 입력되지 않았거나, 공백이거나, 6자리가 아니거나, 숫자만 입력되지 않았으면 오류 메시지를 출력하고 false를 리턴시킨다.
	// isNaN(): 인수로 지정된 데이터가 숫자가 아니면 true, 숫자면 false를 리턴한다.
	
	//console.log(obj.j1.value);
	
	if (!obj.j1.value || obj.j1.value.trim().length != 6 || isNaN(obj.j1.value)) {
		alert('주민등록번호 앞 자리를 정확히 입력해주세요.');
		// document.getElementsByName('j1')[0].value = '';
		obj.j1.value = '';
		obj.j1.focus();
		return false;
	}
	if (!obj.j2.value || obj.j2.value.trim().length != 7 || isNaN(obj.j2.value)) {
		alert('주민등록번호 뒷 자리를 정확히 입력해주세요.');
		obj.j2.value = '';
		obj.j2.focus();
		return false;
	}
	// 여기까지 주민등록번호가 13자리의 숫자인지 확인 완료
	// 주민등록번호 유효성을 검사한다.
	// 주민등록번호 유효성을 검사하기 위해 따로 입력된 주민등록번호를 하나의 문자열로 이어준다.
	// 자바스크립트는 문자열끼리 + 연산을 하면 문자열을 연결하지만, -, *, /은 숫자로 바꿔 연산한다.
	// 문자열로 구성된 숫자의 + 연산을 하려면 Number() 함수를 이용해 숫자로 변환한 뒤 연산한다.  	

	// 가중치 => 234567892345
		
	let jumin = obj.j1.value.trim() + obj.j2.value.trim();
	const a = [2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5]
	let sum = 0;
	for (i = 0; i < jumin.length - 1; i++) {
		sum += jumin[i]*a[i]; // a[i] => i < 8 ? i + 2 : i - 6 // a[i] => (i % 8 + 2);
	}
	// sum에 저장된 값을 11로 나눈 나머지를 11에서 뺀 결과가 주민등록번호의 마지막 자리와 같아야 한다.
	// 11로 나눈 나머지를 11에서 뺀 결과가 10이상일 경우 10을 빼거나 10으로 나눠서 마지막 자리와 비교한다.
	let s = 11 - sum % 11;
	let t = s >= 10 ? s % 10 : s;
	if (jumin[12] != t) {
		alert('유효하지 않은 주민등록번호입니다.')
		obj.j1.value = '';
		obj.j2.value = '';
		obj.j1.focus();
		return false;
	}
	
	// 모든 유효성 검사를 통과하면 마지막에 true를 리턴시킨다.
	return true;
}

































