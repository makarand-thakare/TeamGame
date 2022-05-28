package fourth_number

class FourthNumber(private val difficulty: Difficulty = Difficulty.EASY) {

    private val waitForTimeSecond: Int = 2

    /**
     * How to play?
     * When the game is started, you will be presented with 3 numbers
     * which will have some relation,
     * and you have to find the fourth number. Simple.
     * */
    // todo if division by 9 odd number then decimal??
    // todo update difficulty as per selected mode - check all ranges accordingly

    // operations + - * / %

    // easy medium hard god-mode

    // ex:
    // 5 2 -1 ?
    // sub 3

    // 1 6 16 ?
    // add 2 | mul 2

    private var thirdNumber: Int = 0

    fun start() {
        val operations = operationsToPerform()

        val firstNumber = firstNumber()

        println("1st number:: $firstNumber")

        printSecondAndThirdNumber(firstNumber, operations)

        println("4th number:: ?")

        startTimer()

        println("\nOperations performed were:: ")

        printOperations(operations)

        printFourthNumber(operations)
    }

    private fun printFourthNumber(operations: MutableMap<String, Int>) {
        var firstNumber = thirdNumber
        var result = 0
        for ((operation, number) in operations) {
            result = performOperation(firstNumber, operation, number)
            firstNumber = result
        }

        val outputString = outputString(firstNumber, 4)
        println("\n$outputString")
    }

    private fun printOperations(operations: MutableMap<String, Int>) {
        for ((operation, number) in operations) {
            if (operation == "SUBTRACTION" && number < 0) {
                println("$operation -($number)")
            } else {
                println("$operation $number")
            }
        }
    }

    private fun printSecondAndThirdNumber(fn: Int, operations: MutableMap<String, Int>) {
        var firstNumber = fn
        for (operationNum in 2..3) {
            var result = 0
            for ((operation, number) in operations) {
                result = performOperation(firstNumber, operation, number)
                firstNumber = result
            }
            val outputString = outputString(firstNumber, operationNum)
            println(outputString)
        }
    }

    private fun firstNumber(): Int {
        // Generate 1st random number
        return (1..10).random()
    }

    private fun operationsToPerform(): MutableMap<String, Int> {

        var maxNumberOfOperations = 1
        if (difficulty == Difficulty.EASY) {
            maxNumberOfOperations = 1
        } else if (difficulty == Difficulty.GOD_MODE) {
            maxNumberOfOperations = 4
        } else {
            maxNumberOfOperations = 2
        }

        val numberOfOperations = (1..maxNumberOfOperations).random() // Check both limits?? update according to mode

        val operations = mutableMapOf<String, Int>()
        val allOperations = Operations().getAllOperations()
        for (i in 0 until numberOfOperations) {

            // Find a random operation
            val operationIndex = (0..lastIndexForOperations()).random()
            val operation = allOperations[operationIndex]

            operations[operation] = numberForOperation(operation)
        }
        return operations
    }

    private fun lastIndexForOperations(): Int {
        var lastIndex = 0
        if (difficulty == Difficulty.EASY) {
            lastIndex = (0..1).random()
        } else if (difficulty == Difficulty.GOD_MODE) {
            lastIndex = Operations().getAllOperations().size - 1
        } else {
            lastIndex = 1
        }
        return lastIndex
    }

    private fun startTimer() {

        Thread.sleep(1000)
        val waitForTime = waitForTimeSecond
        for (i in 1..waitForTime) {
            println(i)
            Thread.sleep(1000)
        }
    }

    // Get random number to perform operation with
    private fun numberForOperation(operation: String): Int {
        var newNum = (-10..10).random()
        if (operation == "DIVISION") {
            while (newNum == 0) {
                newNum = (-10..10).random() // Check both limits?? update according to mode
            }
        }
        return newNum
    }

    private fun outputString(result: Int, positionOfNumber: Int): String {
        when (positionOfNumber) {
            2 -> {
                return "2nd number:: $result"
            }
            3 -> {
                thirdNumber = result
                return "3rd number:: $result"
            }
            4 -> {
                return "4rd number:: $result"
            }
        }
        return "-"
    }

    // todo update comparison - make efficient - use int constants??
    private fun performOperation(previousNumber: Int, operation: String, number: Int): Int {
        when (operation) {
            "ADDITION" -> {
                return previousNumber + number
            }
            "SUBTRACTION" -> {
                return previousNumber - number
            }
            "MULTIPLICATION" -> {
                return previousNumber * number
            }
            "DIVISION" -> {
                return previousNumber / number
            }
        }
        return 0
    }

}