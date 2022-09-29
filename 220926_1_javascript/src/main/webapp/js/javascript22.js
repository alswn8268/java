function searchID() {
	let doc = document.getElementById('test');
	doc.innerHTML = 'getElementById() 함수는 DOM에서 id 속성을 탐색한다.'
	doc.style.background = 'skyblue';
}

function searchName() {
	let docs = document.getElementsByName('test');
//	console.log(docs);

//	docs[0].value = '홍길동';
//	docs[1].value = '임꺽정';
//	docs[2].value = '장길산';

	const names = ['홍길동', '임꺽정', '장길산'];
//	for (let i = 0; i < docs.length; i++) {
//		docs[i].value = names[i];
//	}
	
//	let i = 0;
//	for (let name of names) {
//		docs[i++].value = name;
//	}

//	for (let i in names) {
//		docs[i].value = names[i];
//	}

	let i = 0;
//	docs.forEach(function (doc) {
//		doc.value = names[i++];
//	})

	docs.forEach(doc => doc.value = names[i++]);

}

function searchTagName() {
	let docs = document.getElementsByTagName('p');
	for (let doc of docs) {
		doc.style.color = 'salmon';
	}
	let doc = document.getElementsByTagName('p')[2];
	doc.style.color = 'orange';
}

function searchClass() {
	let docs = document.getElementsByClassName('test');
	for (let doc of docs) {
		doc.style.color = 'olive';
	}
}

function searchCSSSelector() {
	// querySelector(): css 선택자를 이용해서 첫 번째 요소를 찾는다. => id 탐색에 주로 사용된다.
	// querySelectorAll(): css 선택자를 이용해서 모든 요소를 찾는다.
	// querySelector(), querySelectorAll() 함수의 인수로 id는 '#', class는 '.', 태그는 아무 것도 붙이지 않고 지정한다.

	// id 속성값으로 탐색
	let doc = document.querySelector('#test');
	doc.innerHTML = 'querySelector() 함수를 이용한 선택';
	doc.style.color = 'lemonchiffon';
	doc.style.backgroundColor = 'navy';

	// class 속성값으로 탐색
	let docs = document.querySelectorAll('.test');
	for (doc of docs) {
		doc.style.fontSize = '20px';
	}
	// class 속성값으로 탐색
	docs = document.querySelectorAll('p');
	for (doc of docs) {
		doc.style.border = '2px solid red';
	}

	// id 탐색: getElementById('id속성값'), querySelector('#id속성값')
	// class 탐색: getElementsByClassName('class속성값'), querySelectorAll('.class속성값')
	// tag 탐색: getElementsByTagName('Tag이름'), querySelectorAll('Tag이름')
	// name 속성 탐색: getElementsByName('name속성값')
}