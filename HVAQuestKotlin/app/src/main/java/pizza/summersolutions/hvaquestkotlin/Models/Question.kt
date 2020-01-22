package pizza.summersolutions.hvaquestkotlin.Models

data class Question(
    var question: String,
    var choices: Array<String>,
    var correctAnswer: String,
    var clue: Int
)
