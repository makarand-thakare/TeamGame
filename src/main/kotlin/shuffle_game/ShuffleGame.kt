package shuffle_game

class ShuffleGame {
    private val waitForTime = 10
    private lateinit var selectedWord: String

    fun start() {
        printShuffledWord()
        startTimer()
        printOriginalWord()
    }


    private fun printShuffledWord() {
        val words = WordBank().giveMeWords()

        val randomNum = (0 until words.size).random()

        selectedWord = words[randomNum]

        println(shuffle(selectedWord))
    }

    private fun startTimer() {
        Thread.sleep(1000)
        for (i in 1..waitForTime) {
            println(i)
            Thread.sleep(1000)
        }
    }

    private fun printOriginalWord() {
        println("it was:: $selectedWord")
    }

    private fun shuffle(input: String): String {
        val characters: MutableList<Char> = ArrayList()
        for (c in input.toCharArray()) {
            characters.add(c)
        }
        val output = StringBuilder(input.length)
        while (characters.size != 0) {
            val randomIndex = (0 until characters.size).random()
            output.append(characters.removeAt(randomIndex))
        }
        return output.toString()
    }

}