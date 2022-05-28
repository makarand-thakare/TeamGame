package shuffle_game

import fourth_number.Difficulty

class ShuffleGame(
    private val difficulty: Difficulty = Difficulty.EASY,
    private val countDownTimeInSeconds: Int = 7
) {
    private lateinit var selectedWord: String

    fun start() {
        printShuffledWord()
        startTimer()
        printOriginalWord()
    }


    private fun printShuffledWord() {
        val words = WordBank().giveMeWords()

        if (difficulty == Difficulty.EASY) {
            do {
                val randomNum = (0 until words.size).random()
                selectedWord = words[randomNum]
            } while (selectedWord.length > 3)
        } else if (difficulty == Difficulty.NORMAL) {
            do {
                val randomNum = (0 until words.size).random()
                selectedWord = words[randomNum]
            } while (selectedWord.length > 4)
        } else if (difficulty == Difficulty.HARD) {
            do {
                val randomNum = (0 until words.size).random()
                selectedWord = words[randomNum]
            } while (selectedWord.length > 5)
        } else if (difficulty == Difficulty.BERSERKER) {
            val randomNum = (0 until words.size).random()
            selectedWord = words[randomNum]
        } else if (difficulty == Difficulty.GOD_MODE) {
            do {
                val randomNum = (0 until words.size).random()
                selectedWord = words[randomNum]
            } while (selectedWord.length < 10)
        } else {
            val randomNum = (0 until words.size).random()
            selectedWord = words[randomNum]
        }

        println(shuffle(selectedWord))
    }

    private fun startTimer() {
        Thread.sleep(1000)
        for (i in 1..countDownTimeInSeconds) {
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