// 할당 연산자
// 오른쪽의 결과를 왼쪽에 할당하는 연산자입니다.
// 기본적인 `=` 을 의미하며,
let assign = 0;
// java 와 같이 여러가지 단축 연산이 지원됩니다.
assign += 10
assign -= 3
assign *= 10
console.log(assign++)
console.log(assign--)
console.log(++assign)
console.log(--assign)


// 비교 연산자
// 숫자, 문자등을 비교하여 결과를 Boolean으로 반환합니다.
// java 와 유사합니다. 문자열 간의 검사도 가능합니다.
console.log(3 > 2)
console.log(3 < 2)
// 사전식으로 비교하며, 대문자가 더 앞에 옵니다.
console.log('A' < 'B')
console.log('Z' < 'a')
console.log('가' < '나')


// 일치 연산자
// === 으로 사용, 두 변수의 타입 및 값을 비교합니다.
// 같은 객체이면서 같은 타입일 때 true 가 반환됩니다.
const a = 1
const b = '1'
console.log(a === b)
console.log(a === Number(b))
console.log(a !== Number(b))
// 동등 연산자
// Java 에서 하듯이 `==`를 사용하면 동등 연산자가 됩니다.
// == 는 두 값을 비교할 때 암묵적 형변환이 일어납니다.
console.log(a == b)
console.log(a == true)
// 이는 동등 연산 외에도 일어나는 일이며,
console.log(8 * null)
console.log('5' - 1)
console.log('7' + 1)
console.log('three' * 2)
// 예측하기 어려운 결과를 발생시키기 때문에 권장되지 않습니다.


// 논리 연산자
// Java와 비슷하게 두 Boolean 값을 비교합니다.
console.log(true && false)
console.log(true && true)
console.log(false || true)
console.log(false || false)
// not 연산도 `!` 를 이용합니다.
console.log(!false)


// 삼항 연산자
// 3개의 피연산자를 받아 값을 반환하는 삼항 연산자 입니다.
// Java와 동일하게 사용할 수 있습니다.
console.log(true ? 1 : 2)
console.log(false ? 1 : 2)
const result = Math.PI > 4 ? 'is more' : 'is less'
console.log(result)

