function openWin() {
//	window.open();
//	window.open(url, title, option);
let url = './20_javascript윈도우2.html'; // 새로 띄울 창에 표시할 페이지 이름
let title = '아이디 중복 검사'; // 윈도우 이름
//	새 윈도우를 현재 브라우저에 새 탭으로 띄우려면 option을 생략한다.
let option = 'top=50px, left=100px, width=500px, height=600px'; // 윈도우 옵션
window.open(url, title, option);
};

function registerForm() {
//	id 속성이 register고 감춰 놓은 div 태그를 화면에 보이게 한다.
	document.getElementById('register').style.display = 'block';
	document.body.style.backgroundColor = 'lightgray';
	
	// 로그인 버튼을 비활성화 시킨다.
	// 비활성화시킬 버튼이 1개일 때
	// document.getElementsByName('btn')[1].disabled = 'disabled';

	// 비활성화시킬 버튼이 여러 개일 때
	// name 속성이 btn인 모든 버튼을 배열로 얻어온다.
	let btns = document.getElementsByName('btn');
	
// 일반 for
	// for (let i = 0; i < btns.length; i++) {
	// 	btns[i].disabled = 'disabled';
	// }

// 향상된 for => of
	// for (let btn of btns) {
	// 	btn.disabled = 'disabled';
	// }
	
// 향상된 for => in
	// in 뒤의 요소가 객체라면 key가 in 앞의 변수로 차례대로 전달되며 반복한다.
	// in 뒤의 요소가 배열이라면 index가 in 앞의 변수로 차례대로 전달되며 반복한다.
	// for (let btn in btns) {
	// 	btns[btn].disabled = 'disabled';
	// }

	// input 태그를 비활성화 시킨다.
	let inputs = document.getElementsByTagName('input');
	for (let i = 0; i < 6; i++) {
		inputs[i].disabled = 'disabled';
	}
}

function closeWin() {
	//	id 속성이 register인 div 태그를 화면에서 사라지게 한다.
	document.getElementById('register').style.display = 'none';	
	document.body.style.backgroundColor = 'white';

	// input 태그를 활성화시킨다.
	let inputs = document.getElementsByTagName('input');
	for (let i = 0; i < inputs.length -1; i++) {
		inputs[i].disabled = '';
	}
}

function idChk() {
	alert('중복 체크를 해주세요.')
}

function idCheck() {
	let url = './21_javascript윈도우3.html'; 
	let title = '아이디 중복 검사';  
	let option = 'top=50px, left=100px, width=500px, height=300px';
	window.open(url, title, option);
}