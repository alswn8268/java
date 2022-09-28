function openWin() {
//	window.open();
//	window.open(url, title, option);
	let url = './20_javascript윈도우2.html'; // 새로 띄울 창에 표시할 페이지 이름
	let title = '아이디 중복 검사'; // 윈도우 이름
//	새 윈도우를 현재 브라우저에 새 탭으로 띄우려면 option을 생략한다.
	let option = 'top=50px, left=100px, width=500px, height=600px'; // 윈도우 옵션
	window.open(url, title, option);
};
