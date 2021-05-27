package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        return sadArray.returnToHappy()
    }
}

private fun IntArray.returnToHappy(): IntArray {
    var firstArray = this
    var secondArray = arrayListOf<Int>()
    val mBoolean = true
    while (mBoolean) {
        for (i in firstArray.indices) {
            if (i == 0 || i == firstArray.lastIndex) {
                secondArray.add(firstArray[i])
            } else {
                val value = firstArray[i]
                val pastValue = firstArray[i - 1]
                val nextValue = firstArray[i + 1]
                if (value <= (pastValue + nextValue)) {
                    secondArray.add(firstArray[i])
                }
            }
        }
        if (firstArray.size == secondArray.size) {
            return secondArray.toIntArray()
        }
        firstArray = secondArray.toIntArray()
        secondArray = arrayListOf()
    }
    return firstArray
}