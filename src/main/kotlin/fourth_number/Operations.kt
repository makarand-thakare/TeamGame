package fourth_number

class Operations {

    private var operationsList = arrayListOf<String>()

    init {
        operationsList.add("ADDITION")
        operationsList.add("SUBTRACTION")
        operationsList.add("MULTIPLICATION")
        operationsList.add("DIVISION")
    }

    fun getAllOperations() = operationsList

}
// Add MODULO in god-mode
