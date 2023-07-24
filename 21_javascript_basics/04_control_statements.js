// 조건문
// Java 에서 사용하듯 if, else if, else를 사용합니다.
const someNumber = 10.01
if (someNumber % 2 === 0) {
  console.log(`${someNumber} is even`)
} else if (someNumber % 2 === 1) {
  console.log(`${someNumber} is odd`)
} else {
  console.log(`${someNumber} is decimal`)
}

// 반복문
// while 반복
// 괄호 안의 조건이 참일 동안 반복하는 반복문 입니다.
// java 와 동일합니다.
let i = 0
while (i < 5) {
  console.log(i)
  i += 1
}

// for 반복
// 괄호 안에 3가지 표현을 기준으로 동작하는 반복문 입니다.
// for (초기문; 조건문; 증감문)으로, java 와 동작이 유사합니다.
let result = ''
for (let i = 0; i < 5; i++) {
  result += `${i} `
}
console.log(result)


// for ... in
// 객체(Object)를 순회할 때 사용할 수 있는 반복문입니다.
const person = {
  firstName: 'Jeeho',
  lastName: 'Park',
  'phone number': '010-1234-5678'
}
for (const key in person) {
  console.log(key)
  console.log(person[key])
  // 아래는 undefined 입니다.
  console.log(person.key)
}


// for ... of
// 반복 가능한 객체를 순회할때, 주로 배열을 순회할 때 사용됩니다.
const numbers = [10, 20, 30]
for (const number of numbers) {
  console.log(number)
}

// for ... in, for ... of 비교
// 배열을 for ... in 으로
for (const number in numbers) {
  console.log(number)
}
// 객체를 for ... of 으로
for (const number of numbers) {
  console.log(number)
}

// 객체를 for ... in 으로
for (const key in person) {
  console.log(key)
}
// 객체를 for ... of 으로 (TypeError)
for (const item of person) {
  console.log(item)
}


// 반복문 제어
// break, continue를 지원합니다.
let i = 0;
while (i < 10) {
  i += 1
  if (i % 2 == 0) continue
  if (i == 7) break
  console.log(i)
}
