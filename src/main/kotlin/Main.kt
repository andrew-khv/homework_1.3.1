fun printSuffixHours (timePiece: Int): String {
    when {
        timePiece > 10 && timePiece <= 19 -> return "ов"
        timePiece % 10 == 0 || (timePiece % 10 >= 5 && timePiece % 10 <= 9) -> return "ов"
        timePiece % 10 >= 2 && timePiece % 10 <= 4 -> return "а"
        else -> return ""
    }
}
fun printSuffixMins (timePiece: Int): String {
    when {
        timePiece > 10 && timePiece <= 19 -> return ""
        timePiece % 10 == 0 || (timePiece % 10 >= 5 && timePiece % 10 <= 9) -> return ""
        timePiece % 10 >= 2 && timePiece % 10 <= 4 -> return "ы"
        else -> return "у"
    }
}
fun agoToText (seconds: Int) {
    when {
        seconds <= 60 -> print("только что")
        seconds > 60 && seconds <= 60*60 -> {
            val minutes = seconds / 60
            print("$minutes минут" + printSuffixMins(minutes) + " назад")
        }
        seconds > 60*60 && seconds <= 24*60*60 -> {
            val hours = seconds/(60*60)
            print ("$hours час" + printSuffixHours(hours) + " назад")
        }
        seconds > 24*60*60 && seconds <= 2*24*60*60 -> print("вчера")
        seconds > 2*24*60*60 && seconds <= 3*24*60*60 -> print("позавчера")
        else -> print("давно")
    }
}
fun main() {
    val timeAgo = 76000
    agoToText(timeAgo)
}