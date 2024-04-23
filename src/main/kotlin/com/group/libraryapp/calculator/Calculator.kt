package com.group.libraryapp.calculator

class Calculator(
    var number: Int
) {

    // setter를 막고 싶을 때 사용하는 방법
//    val number: Int
//        get() = this._number

    fun add(operand: Int) {
        this.number += operand
    }

    fun minus(operand: Int) {
        this.number -= operand
    }

    fun multiply(operand: Int) {
        this.number *= operand
    }

    fun divide(operand: Int) {
        if (operand == 0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다")
        }
        this.number /= number
    }
}