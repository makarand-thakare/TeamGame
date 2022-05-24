package fourth_number

class FourthNumber {

    // todo clean code
    // todo if division by 9 odd number then decimal??
    // todo create builder
    // todo update difficulty as per selected mode - check all ranges accordingly

    // operations + - * / %

    // easy medium hard god-mode

    fun start() {

        //// Perform operations and print numbers

        // How many operations to perform- generate random no
        val numberOfOperations = (1..2).random() // Check both limits?? update according to mode

        var operations = mutableMapOf<String, Int>()
        val allOperations = Operations().getAllOperations()
        for (i in 0 until numberOfOperations) {

            // Find a random operation
            val operationIndex = (0 until allOperations.size).random()
            val operation = allOperations[operationIndex]

            operations[operation] = numberForOperation(operation)
        }

        // Generate 1st random number
        var firstNumber = (1..10).random() // Check both limits??
        println("1st number:: $firstNumber")

        // Only for 2nd and 3rd position
        for (operationNum in 2..3) {
            var result = 0
            for ((operation, number) in operations) {
                result = performOperation(firstNumber, operation, number)
                firstNumber = result
            }
            val outputString = outputString(firstNumber, operationNum)
            println(outputString)
        }

        println("4th number:: ?")

        startTimer()

        println("\nOperations performed were:: ")
        for ((operation, number) in operations) {
            println("$operation $number")
        }

        // Fourth number
        var result = 0
        for ((operation, number) in operations) {
            result = performOperation(firstNumber, operation, number)
            firstNumber = result
        }

        val outputString = outputString(firstNumber, 4)
        println(outputString)

        // 5 2 -1 ?
        // sub 3

        // 1 6 16 ?
        // add 2 | mul 2
    }

    private fun startTimer() {

        Thread.sleep(1000)
        val waitForTime = 10
        for (i in 1..waitForTime) {
            println(i)
            Thread.sleep(1000)
        }
    }

    // Get random number to perform operation with
    private fun numberForOperation(operation: String) :Int{
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