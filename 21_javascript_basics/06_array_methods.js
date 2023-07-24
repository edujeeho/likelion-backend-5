// reverse
// 원본 배열의 요소들을 반대 순서로 정렬합니다.
const numbers = [0, 1, 2, 3, 4]
numbers.reverse()
console.log(numbers)

const cities = ['서울', '대구', '대전', '부산', ]
cities.reverse()
console.log(cities)


// push & pop
// push : 배열의 가장 뒤에 요소를 추가합니다.
const likeStack = [0, 1, 2, 3, 4]
likeStack.push(5)
likeStack.push(6)

// pop : 배열의 가장 뒤에서 요소를 꺼냅니다.
console.log(likeStack.pop())
console.log(likeStack)

// unshift & shift
// unshift : 배열의 제일 앞에 요소를 추가합니다.
const likeQueue = [2, 3, 4]
likeQueue.unshift(1)
likeQueue.unshift(0)
// shift : 배열의 앞에서 요소를 꺼냅니다.
console.log(likeQueue.shift())


// includes & indexOf
// includes : 배열에 특정 값이 존재하는지를 판단합니다.
console.log(cities.includes('서울'))
console.log(numbers.includes('0'))

// indexOf : 배열의 특정 값이 어떤 index 에 있는지 반환합니다.
// 없을 경우 -1 을 반환합니다.
console.log(cities.indexOf('대구'))
console.log(numbers.indexOf(10))


// Array Helper Methods
// 배열을 순회하며 특정 로직을 수행하는 메소드 입니다.
// Java Stream API와 유사하게 작동합니다.
// 이때 어던 로직을 수행할지는 함수를 인자로 전달합니다.
// 이런식으로 인자로 전달되는 함수를 callback 함수라고 부릅니다

const action = function (target) {
  console.log(target + target)
}
const apply = function (target, action) {
  action(target)
}
apply(10, action)


// forEach
// 각 배열의 요소에 대해 한번씩 함수를 실행합니다.
numbers.forEach(function (element, index, array) {
  // 지금 사용중인 요소
  console.log(`element: ${element}`)
  // 지금 사용중인 요소의 인덱스
  console.log(`index: ${index}`)
  // 호출한 array
  console.log(`array: ${array}`)
})

// map
// 각 배열의 요소에 대해 콜백 함수를 실행하고,
// 콜백 함수의 반환값으로 이뤄진 새로운 배열을 반환합니다.
const doubled = numbers.map(function (element, index, array) {
  return element * 2
})


// filter
// 각 배열의 요소에 대해 콜백 함수를 실행하고,
// 콜백 함수의 반환값이 true 인 요소들로 이뤄진 새로운 배열을 반환합니다.
const even = numbers.map(function (element, index, array) {
  return element % 2 === 0
})


// reduce
// 각 배열의 요소에 대해 콜백 함수를 실행하고,
// 최종적으로 하나의 값을 반환합니다.
// 총합, 평균 등을 구하기 위해 사용할 수 있습니다.
const scores = [90, 90, 80, 77]
// 콜백함수의 첫번째 인자는 이전 요소를 기준으로 동작한 콜백함수의 반환값이 들어갑니다.
// 콜백함수 뒤의 두번째 인자는 초기값으로, 선택사항입니다. 없을 경우 배열의 첫번째 요소입니다.
const sum = scores.reduce(function (acc, element, index, array) {
  return acc + element
}, 0)

console.log(sum) // 337


// find
// 각 배열의 요소에 대해 콜백 함수를 실행하고,
// 콜백의 반환 값이 true 인 첫번째 요소를 반환합니다.
const ninety = scores.find(function (element, index, array) {
  return element === 90
})


// some
// 각 배열의 요소에 대해 콜백 함수를 실행하고,
// 하나의 요소에 대해서라도 true 가 반환되면 결과도 true 가 됩니다.
// 빈 배열로 실행하면 항상 false 입니다.
const oneOverEighty = scores.some(function (element, index, array) {
  return element > 80
})


// every
// 각 배열의 요소에 대해 콜백 함수를 실행하고,
// 모든 요소가 true 를 반환해야만 true 가 됩니다.
// 빈 배열로 실행하면 항상 true 입니다.
const allOverEighty = scores.every(function (element, index, array) {
  return element > 80
})

