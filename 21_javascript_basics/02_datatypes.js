// Number
// 기본적인 숫자를 표현하기 위한 자료형 입니다.
const length = 5
const size = 10

// 실수형 데이터도 Number 자료형 입니다.
const temperature = 36.5
const distance = 3.4

// 부동 소숫점 표현도 가능합니다.
const floatPoint = 2.998e8

// 무한대, 숫자 아님(NaN) 데이터도 있습니다.
const infinite = Infinity
const infNegative = -Infinity
// Not a Number 는 숫자가 표현되어야 하는 계산 또는 함수의
// 결과가 숫자가 아닐때 주로 활용합니다.
const notANumber = NaN
// parseInt: 문자열을 정수로
const parseFail = parseInt('a')
// Math.sqrt: 제곱근 함수
const sqrtNegative = Math.sqrt(-1)
// NaN과 계산한 결과
const calculateNan = 7 + NaN


// String
// 문자열을 나타내는 자료형 입니다.
// 따옴표 쌍따옴표 둘다 활용 가능합니다.
const singleQuote = 'Hello Javascript'
const doubleQuote = "!!!"
// 덧샘을 통해 문자열을 연결할 수 있습니다.
const greeting = singleQuote + doubleQuote
console.log(greeting)

const firstName = 'Jeeho'
const lastName = 'Park'
const fullName = firstName + ' ' + lastName
console.log(fullName)

// 일반적인 문자열 표현은 중간에 줄바꿈이 들어갈 수 없습니다.
/*
const sentence = 'this cannot
be done'
 */
// 대신 escape sequence를 통해 표현 가능합니다.
const paragraph = 'this \nis \nbetter'
console.log(paragraph)

// Backtick 을 사용하면 Template Literal 을 사용할 수 있습니다.
// Template Literal 은 내부에 줄바꿈도 표현할 수 있고,
// ${} 를 사용하면 변수의 값을 표현하는데 활용할 수 있습니다.
const name = 'Jeeho'
const message = `Hello, ${name}!!
Welcome to Javascript!!!`


// Boolean
// 참거짓을 나타내는 자료형입니다.
const isNumber = true
const isString = false


// null & undefined
// 값이 없음을 표현하기 위한 null과 undefined가 있습니다.
// 어떤 값이 비어있다고 표현, 즉 명시적으로 빈 값일 경우 null을 사용합니다.
let answer = null
console.log(answer)

// 값이 정의되지 않았다, 즉 암시적으로 빈 값일 경우 undefined가 됩니다.
let answerNotDefined
console.log(answerNotDefined)

// 굳이 비슷한 역할을 하는 두가지 자료형이 있는것은 단순한 설계 오류 입니다.
// typeof 연산을 이용해 null을 확인하면 'object'가 됩니다.
console.log(typeof null)
// typeof 연산을 이용해 undefined를 확인하면 'undefined'가 됩니다.
console.log(typeof undefined)
// null은 원시 타입임에도 불구하고 null이 object로 나오는 이유는 구현 오류입니다.
// 하지만 이미 많은 코드가 이에 대한 의존성이 있기 때문에 해결하기 어렵습니다.

// 형변환
console.log(Number('1'))
console.log(Number('a'))
console.log(String(1123))
console.log(Boolean(0))
console.log(Boolean(10))


// Object
// JSON 에서 나오는 JavaScript Object Notation의 Object 형 입니다.
// 중괄호를 이용해 정의, key 와 value의 쌍을 `:`을 통해 구분합니다.
// 각 key: value 를 , 로 구분합니다.
// key 는 문자열, value는 어떤 타입이든 가능합니다.
// key를 정의할 때 따옴표는 생략하지만, 띄어쓰기 등의 특수문자를 포함하고 싶은 경우 필요합니다.
const person = {
  firstName: 'Jeeho',
  lastName: 'Park',
  'phone number': '010-1234-5678'
}

// 객체의 요소에 접근할때는 `.` 또는 `[]` 로 접근합니다.
// 띄어쓰기 등의 특수문자는 대괄호를 사용해야 합니다.
console.log(person.firstName)
console.log(person['lastName'])
console.log(person['phone number'])


// Array
// 순서가 보장되는 배열 타입입니다.
// 대괄호를 이용해 정의합니다.
const numbers = [1, 2, 3, 4, 5]
// 대괄호에 index를 통해 접근하는 점이 Java와 유사합니다.
console.log(numbers[0])
console.log(numbers[2])
// .length 를 통해 길이를 가져오는 것도 유사합니다.
console.log(numbers[numbers.length - 2])



