package pizza.summersolutions.swipequiz

data class QuizQuestion(
    var question: String,
    var isTrue: Boolean
){
    companion object{
        val QUESTIONS = arrayOf(
            "A 'val' and 'var' are the same.",
            "Mobile Application Development grants 12 ECTS.",
            "A Unit in Kotlin corresponds to a void in Java.",
            "In Kotlin 'when' replaces the 'switch operator in Java."
        )

        val ANSWERS = arrayOf(
            false,
            true,
            false,
            true
        )
    }
}