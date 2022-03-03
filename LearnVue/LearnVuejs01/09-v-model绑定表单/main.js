const nums = [10, 20, 111, 222, 444, 40, 50]
/*filter中的回调函数必须返回boolean值
* 返回true时 函数内部会自动将这次回调的n加入到新的数组中
* 返回false时， 函数内部会过滤掉n*/
let newNums = nums.filter(function (n) {
    return n <= 100;
})
console.log(newNums);

let newNums2 = newNums.map(function (n) {
    return n * 2;
})

/*3. reduce  对数组中所有内容进行汇总*/
newNums2.reduce(function (preValue, n) {
    return preValue + n;
}, 0)
// 第一次 preValue: 0  n: 20
// 第二次 preValue: return的返回值 n: 40
