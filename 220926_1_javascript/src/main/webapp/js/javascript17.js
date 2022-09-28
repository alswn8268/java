function alertTest() {
	// alert('메시지');
	alert('단순한 메시지를 출력하는 대화창')
}

function confirmTest() {
	// confirm('메시지');
	// 확인 버튼을 클릭하면 true, 취소 버튼을 클릭하면 false를 리턴한다.
	if (confirm('배경색을 어둡게 변경할까요?')) {
		document.body.style.backgroundColor = 'black';
		document.body.style.color = 'white'; 
	} else {
		document.body.style.backgroundColor = 'white';
		document.body.style.color = 'black'; 		
	}
}

function promptTest() {
	// prompt('메시지');
	// prompt('메시지', '안내 메시지');
	// prompt() 함수는 데이터를 입력하고 확인 버튼을 클릭하면 입력한 데이터가 리턴되고, 취소 버튼을 클릭하면 null이 리턴된다.
	// 리턴되는 데이터의 타입은 string이다.
	let menu = prompt('점심은 뭘 먹을까요?\n(1.짜장면, 2.양장피, 3.팔보채)', '난 짜장면');
	console.log(menu);
	console.log(typeof menu);
	
	switch (menu) {
		case '1':
			console.log('짜장면을 골랐습니다.');
			break;
		case '2':
			console.log('양장피를 골랐습니다.');
			break;
		case '3':
			console.log('팔보채를 골랐습니다.');
			break;
	}
}