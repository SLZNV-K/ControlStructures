package ru.netology

fun main() {
    println(agoToText(36000))
    calculateCommission(currentTransfer = 10000)
}

//  Задача №1:
fun agoToText(second: Int): String {

    val str = when {
        second < 60 -> "Был(а) только что"

        second in 600..1259 -> "Был(а) в сети ${second / 60} минут назад"

        second in 60..3599 -> {
            when (second / 60 % 10) {
                1 -> "Был(а) в сети ${second / 60} минуту назад"
                2, 3, 4 -> "Был(а) в сети ${second / 60} минуты назад"
                else -> "Был(а) в сети ${second / 60} минут назад"
            }
        }

        second in 39600 .. 50400 -> "Был(а) в сети ${second / 3600} часов назад"

        second in 3600..86400 -> {
            when (second / 3600 % 10) {
                1 -> "Был(а) в сети ${second / 3600} час назад"
                2, 3, 4 -> "Был(а) в сети ${second / 3600} часа назад"
                else -> "Был(а) в сети ${second / 3600} часов назад"
            }
        }

        second in 86401..172800 -> "Был(а) в сети вчера"
        second in 172801..259200 -> "Был(а) в сети позавчера"

        else -> {
            "Был(а) в сети давно"
        }
    }
    return str
}

//    Задача №2:
fun calculateCommission(cardType: String = "VK Pay", transferAmount: Int = 0, currentTransfer: Int) {
    val commission = when (cardType) {
        "MasterCard", "Maestro" -> {
            when {
                currentTransfer > 300 && transferAmount < 75_000  && transferAmount + currentTransfer < 75_000 -> 0
                else -> 0.006 * currentTransfer + 20
            }
        }

        "Visa", "Мир" -> if (currentTransfer * 0.0075 > 35) currentTransfer * 0.0075 else 35
        else -> 0
    }

    when (cardType){
        "VK Pay" -> if (
            currentTransfer > 15_000 ||
            transferAmount > 40_000 ||
            transferAmount + currentTransfer > 40_000) println("Перевод невозможен, превышен лимит на счете $cardType")
        else println("Комиссия за перевод с помощью $cardType не взимается")
        else -> if (
            currentTransfer > 150_000 ||
            transferAmount > 600_000 ||
            transferAmount + currentTransfer > 600_000) println("Перевод невозможен, превышен лимит по вашей карте $cardType")
        else println("Комиссия за перевод $currentTransfer с помощью $cardType составит $commission")
    }

}
