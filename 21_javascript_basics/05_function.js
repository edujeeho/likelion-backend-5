// Function
// 함수 자료형 입니다.
// 일반적인 언어와 유사하게 function 키워드를 이용해서 만들 수 있습니다.
// 이를 함수 선언식이라고 합니다.
function add(num1, num2) {
  return num1 + num2
}
console.log(add(10, 20))

// 또는 표현식(값으로 결과가 나타나는 코드)으로 나타낼 수도 있습니다.
const subtract = function (num1, num2) {
  return num1 - num2
}
console.log(subtract(10, 5))

// 선언식의 경우 호이스팅이 일어나지만, 표현식의 경우 호이스팅이 일어나지 않습니다.
hoisted()
function hoisted() {
  console.log('this function is hoisted')
}

notHoisted()  // ReferenceError
const notHoisted = function () {
  console.log('this function is not hoisted')
}


// 화살표 함수
// arrow syntax 로 함수를 정의할수도 있습니다.
const arrowFunction = (arg1, arg2) => {
  console.log(arg1)
  console.log(arg2)
}


// 일급 객체
// Javascript 에서 함수는 일급 객체 입니다.
// 일급객체란, 일반적인 프로그래밍 언어에서,
// 1. 함수의 인자로 전달 가능하고,
// 2. 함수의 반환값으로 반환되고,
// 3. 어떤 변수에 할당이 가능한
// 객체를 일급 객체라고 부릅니다.


// 함수 인자 전달하기
// 1. 함수 기본값
// 함수의 매개변수를 정하면서 기본값을 정의할 수 있습니다.
const greeting = function (name = 'Anonymous') {
  return `Hi ${name}`
}
greeting()

const multiply = function (num1, num2 = 1) {
  return num1 * num2
}
multiply(10)

// 2. 매개변수와 인자의 갯수 불일치 허용
// 기본값이 존재하든 안하든 함수를 호출하는데 있어
// 매개변수의 갯수에 맞춰서 인자를 전달할 필요가 없습니다.
const divide = function (num1, num2) {
  // 이때 전달되지 않은 인자는 undefined,
  // 넘쳐서 전달된 인자는 사용되지 않습니다.
  console.log(num1)
  console.log(num2)
  return num1 / num2
}

console.log(divide())
console.log(divide(1))
console.log(divide(1, 2))
console.log(divide(1, 2, 3))

// 3. Spread Syntax
// `...` 을 순회 가능한 객체와 함께 사용하면 배열의 요소로
// 복수의 요소를 펼칠 수 있으며,
// 함수의 경우 배열 등의 요소를 나누어 인자로 전달할 수 있습니다.
const num = [1, 2]
const numbers = [0, ...num, 3, 4]
console.log(add(...num))
// 또는 복수의 정해지지 않은 갯수의 인자를 받기 위해
// 함수 정의시 매개변수로 활용할 수 있습니다.
const concatStrs = function (base, ...rest) {
  let strBase = String(base)
  for (const arg of rest) {
    strBase += String(arg)
  }
  return strBase
}

console.log(concatStrs(1, 2, 3, 4, 5))

// 객체에서도 사용할 수 있습니다. 이 경우 key: value로 나옵니다.
const name = {
  firstName: 'Jeeho',
  lastName: 'Park'
}

const person = {
  ...name,
  email: 'jeeho.dev@gmail.com'
}
console.log(person)
