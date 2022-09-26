// 선언하지 않은 변수를 사용하면 에러가 발생된다.
'use strict'; // ECMA Script 5에서 추가

console.log('안녕하세요?');

// js는 변수를 선언할 때 앞에 자료형을 쓰지 않는다.
// 변수에 대입되는 데이터의 형태에 따라서 자동으로 변수의 자료형이 결정된다.
// int a = 100;(X) / a = 100;(O, but 과거에 사용하던 방식)

// ECMA Script 5부터 변수를 선언할 때 앞에 var를 붙인다.
var a = 200;
console.log('a = ' + a);
// 먼저 선언한 변수를 다시 선언할 수 있는 문제점이 있다.
var a = '웩';
console.log('a = ' + a);

// ECMA Script 6부터 let이나 const를 붙여서 선언하기 시작했다.
let b = 300;
console.log('b = ' + b);
// 먼저 선언한 변수를 다시 선언하면 에러가 발생된다.
// let b = "??"(x) / b = "??"(O)
b = '??';
console.log('b = ' + b);

const c = 400;
console.log('c = ' + c);
// const는 상수를 의미하므로 같은 변수를 다시 선언할 수 없고, 값도 할당할 수 없다.
// const c = '!!';(X) c = '!!';(X)