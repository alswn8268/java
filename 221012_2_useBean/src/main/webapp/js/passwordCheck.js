function passwordCheck(obj) {

	// 입력한 비밀번호가 8자 이상 12자 이하인지 검사한다.
	let pwd = obj.password.value;
/*	if (pwd.length >= 8 && pwd.length <= 12) {
		console.log(pwd + "는 " + pwd.length + "자입니다.");
	} else {
		console.log("비밀번호를 다시 입력해주세요.")
		obj.password.value = "";
		obj.repassword.value = "";
		obj.password.focus();
		return false;
	}

	// 영문자, 숫자, 특수문자가 각각 1개 이상씩 입력되었는지 검사한다.
	let alphaCount = 0; // 영문자 개수
	let numberCount = 0; // 숫자 개수
	let etcCount = 0; // 특수문자 개수
	// 입력된 비밀번호의 문자 개수만큼 반복하며 영문자, 숫자, 특수문자의 개수를 센다.
	const pw = obj.password.value.trim();
	for (let i = 0; i < pw.length; i++) {
		if (pw.charAt(i) >= 'a' && pw.charAt(i) <= 'z' || pw.charAt(i) >= 'A' && pw.charAt(i) <= 'Z') {
			alphaCount++;
		} else if (pw.charAt(i) >= '0' && pw.charAt(i) <= '9') {
			numberCount++;
		} else {
			etcCount++;
		}		
	}
	console.log('영문자: ' + alphaCount + '개, 숫자:' + numberCount + '개, 특수문자: ' + etcCount + "개");
	
	if (alphaCount == 0 || numberCount == 0 || etcCount == 0) {
		alert("영문자, 숫자, 특수문자를 모두 1개 이상 넣어 입력해주세요.")
		obj.password.value = "";
		obj.password.focus();
		return false;
	}*/
	const pw = obj.password.value.trim();
	// 정규 표현식(정규식)을 사용한 영문자, 숫자, 특수문자가 각각 1개 이상 입력되었고 8자 - 12자로 입력되었는지 검사한다.
	
	// new RegExp('정규식 패턴') => 자바스크립트 정규식 객체를 만든다.
	// . => 모든 문자 1글자를 대신한다.(어떤 문자라도 1글자가 나와야 한다.)
	// * => 모든 문자 0글자 이상을 대신한다. (아무 문자가 나오지 않아도 되고, 여러 개가 나와도 된다.)
	// + => 모든 문자 1글자 이상을 대신한다. (아무 문자나 1글자 이상 나와야 한다.)
	// ^ => 시작하는 
	// $ => 끝나는
	
	// const pattern = new RegExp('^.{8}$') // 글자수 제한 => 8글자
	// const pattern = new RegExp('^.{1,8}$') // 글자수 제한 => 8글자 이내
	// const pattern = new RegExp('^.{8,}$') // 글자수 제한 => 8글자 이상
	// const pattern = new RegExp('^.{8,12}$') // 글자수 제한 => 8글자 이상 12글자 이하
	
	// 허용 가능한 문자를 [] 안에 나열한다.
	// const pattern = new RegExp('^[0123456789]+$') // 숫자만 허용. +를 쓰지 않으면 1글자만 검사
	// const pattern = new RegExp('^[0-9]+$') // 숫자만 허용. +를 쓰지 않으면 1글자만 검사
	//const pattern = new RegExp('^[0-9]{4}$') // 숫자만 허용. 4글자
	// const pattern = new RegExp('^[A-Z]+$') // 영대문자만 허용한다.
	// const pattern = new RegExp('^[a-z]+$') // 영소문자만 허용한다.
	// const pattern = new RegExp('^[A-Za-z]+$') // 영문자만 허용한다.
	// const pattern = new RegExp('^[ㄱ-힣]+$') // 한글만 허용한다.
	// const pattern = new RegExp('^[!@#$%^&*]+$') // 지정된 특수문자만 허용한다.
	
	// 영문자, 숫자, 특수문자만 8자 이상 12자 이하로 입력을 허용한다.
	// const pattern = new RegExp('^[A-Za-z0-9!@#$%^&*]{8,12}$')
	
	// 긍정형 전방 탐색 기능으로, 특정 문자가 포함되어 있는지 검사한다. => (?=.*)
	
	// const pattern = new RegExp('(?=.*[0-9]+)'); // 숫자가 포함되어 있는지 검사한다.
	// const pattern = new RegExp('(?=.*[A-Z]+)'); // 영대문자가 포함되어 있는지 검사한다.
	// const pattern = new RegExp('(?=.*[a-z]+)'); // 영소문자가 포함되어 있는지 검사한다.
	// const pattern = new RegExp('(?=.*[A-Za-z]+)'); // 영문자가 포함되어 있는지 검사한다.
	// const pattern = new RegExp('(?=.*[ㄱ-힣]+)'); // 한글이 포함되어 있는지 검사한다.
	// const pattern = new RegExp('(?=.*[!@#$%^&*]+)'); // 지정된 특수문자가 포함되어 있는지 검사한다.
	
	const pattern = new RegExp('^(?=.*[0-9]+)(?=.*[A-Za-z])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,12}$'); 
	
	// test() 함수는 인수로 지정된 문자열이 정규식 패턴에 만족하는지 검사한다.
	if (!pattern.test(pw)) {
		alert("영문자, 숫자, 특수문자를 모두 1개 이상 넣고, 8글자 이상 12글자 이하로 입력해주세요.")
		obj.password.value = "";
		obj.password.focus();
		return false;
	} 

	// 비밀번호를 확인한다.
	let repwd = obj.repassword.value;
	if (pwd == repwd) {
		console.log('비밀번호가 일치합니다.')
	} else {
		console.log('비밀번호가 일치하지 않습니다. 다시 입력해주세요.')
		obj.password.value = "";
		obj.repassword.value = "";
		obj.password.focus();
	}
	
	return true;
}





















