// 주석은 java와 유사하게 진행합니다.
// single line comment
/*
multi line comment
 */

// 변수 선언은 타입을 지정하지 않습니다.
// 다만 변수를 선언하는 방식이 다양하며 그에 따른 성질이 조금씩 다릅니다.

// let 으로 선언합니다.
let foo = 'a let variable'
// let 으로 선언한 변수는 재할당이 가능합니다.
foo = 'let variables can be reallocated'

// const 으로 선언합니다.
const bar = 'a const variable'
// const 으로 선언한 변수는 다시 할당하지 못합니다.
// bar = 'const variables cannot be reallocated'


// var 으로 선언합니다.
var baz = 'a var variable'
baz = 'var can be reallocated to'
// 본래 javascript 에서 사용하던 let과 비슷한 변수이지만,
// 호이스팅이라는 특수한 현상으로 인해 현재는 비권장 되는 형태입니다.
// 호이스팅은 선언 이전에 참조할 수 있는 현상으로, Javascript 에서 선언된 var 변수는
// 실행되기 전에 전부 코드 최상단에서 undefined 로 초기화 됩니다.
console.log(hoisted)
var hoisted = 'hoisted variable'
// 코드의 논리적 흐름을 깨뜨리기 때문에 더이상 사용하지 않습니다.

// 만약 let, const 등을 사용하지 않으면 자동으로 var 가 됩니다.
console.log(qux)
qux = 'this is var'