function randomNumber(number) {
	// random(): 0 이상, 1 미만인 무작위 수를 발생시킨다.
	for (let i = 0; i < 6; i++) {
		console.log(parseInt(Math.random() * number) + 1 + '-' + i + '번');
	}

	// ceil(): 올림, floor(): 내림, round(): 반올림
	console.log('올림: ' + Math.ceil(3.14));
	console.log('내림: ' + Math.floor(3.14));
	console.log('내림: ' + Math.round(3.14));
}

function