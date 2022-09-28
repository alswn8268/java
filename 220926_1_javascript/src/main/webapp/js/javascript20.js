function requestID() {
	// 부모 창(opener)의 데이터를 가져온다.
	let parentID = opener.document.getElementById('parentID').value;
	console.log(parentID);
	// 부모 창에서 얻어온 데이터를 자식 창의 객체에 넣어준다.
	document.getElementById('childID').value = parentID;
}

function sendID1() {
	// 부모 창으로 넘겨줄 자식 창의 데이터를 가져온다.
	let childID = document.getElementById('childID').value
	console.log(childID);
	// 부모 창으로 데이터를 보낸다.
	opener.document.getElementById('requestID').value = childID;
}

function sendID2() {
	let childID = document.getElementById('childID').value
	opener.document.getElementById('requestID').value = childID;

	// id가 아닌 name 속성이나 tag 이름으로 얻어오려면, ~Elements~처럼 복수형을 사용한다.
	// getElementsByName(), getElementsByTagName()은 여러 개를 배열로 얻어오기 때문에 index를 지정해야 한다.
	// getElementsByName(): 인수로 지정된 name 속성을 가지는 태그들을 얻어온다.
	opener.document.getElementsByName('requestID')[0].value = childID;
	// getElementsByTagName(): 인수로 지정된 태그들을 얻어온다.
	opener.document.getElementsByTagName('input')[4].value = childID;

	// 자식 창의 데이터를 부모 창으로 전송한 후 자식 창을 닫는다.
	self.close(); // 현재 창을 닫는다.
}