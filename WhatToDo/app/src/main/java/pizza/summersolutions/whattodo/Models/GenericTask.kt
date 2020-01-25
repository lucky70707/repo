package pizza.summersolutions.whattodo.Models

import java.util.*


//likely unnecessary class
class GenericTask (
    var name: String,
    var deadline: Date,
    var difficulty: Int,
    var isCompleted: Boolean,
    var dateCompleted: Date,
    var categoryId: Int
)