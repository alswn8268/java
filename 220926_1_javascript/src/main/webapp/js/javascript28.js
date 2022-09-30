function randomNumber(number) {
	// random(): 0 이상, 1 미만인 무작위 수를 발생시킨다.
	for (let i = 0; i < 6; i++) {
		console.log(parseInt(Math.random() * number) + 1);
	}

	// ceil(): 올림, floor(): 내림, round(): 반올림
	console.log('올림: ' + Math.ceil(3.14));
	console.log('내림: ' + Math.floor(3.14));
	console.log('반올림: ' + Math.round(3.14));
}

function randomColor() {
	// let r = Math.floor((Math.random() * 256));
	// let g = Math.floor((Math.random() * 256));
	// let b = Math.floor((Math.random() * 256));
	// document.body.style.backgroundColor = `rgb(${r}, ${g}, ${b})`;
	
	// let ren = function () {
	// 	return Math.floor((Math.random() * 256));
	// }
	
	let ren = () => Math.floor((Math.random() * 256));
	document.body.style.backgroundColor = `rgb(${ren()}, ${ren()}, ${ren()})`;	
};

function randomCircle() {
	let r = Math.floor((Math.random() * 100) + 1);
	let circle = document.getElementById('circle');

	circle.style.width = r*2 + 'px';	// div 태그의 폭
	circle.style.height = r*2 + 'px';	// div 태그의 너비
	circle.style.border ='4px solid skyblue'; 

	circle.style.borderRadius = '50%';
}

function rCal() {
	let w = document.getElementById('circle').style.width;
	const r = w.substring(0, w.length - 2) / 2;

	document.getElementById('area').innerText = Math.round(r*2*Math.PI) +'px';
	document.getElementById('len').innerText = Math.round(r*r*Math.PI) + 'px';
}