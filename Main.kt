package machine

import java.util.*

var waterAvailable = 400
var milkAvailable = 540
var beansAvailable = 120
var cupsAvailable = 9
var moneyAvailable = 550

fun main() {

    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val input = scanner.next()
        when (input) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> printSupplies()
            "exit" -> return
        }
    }
}

fun printSupplies() {
    println("""
        The coffee machine has:
        $waterAvailable ml of water
        $milkAvailable ml of milk
        $beansAvailable g of coffee beans
        $cupsAvailable disposable cups
        $$moneyAvailable of money
    """.trimIndent())
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val coffeeType = readln()
    when (coffeeType) {
        "back" -> return
        "1" -> makeEspresso()
        "2" -> makeLatte()
        "3" -> makeCappuccino()
    }
}

fun makeCoffee(water: Int = 0, milk: Int = 0, beans: Int = 0, money: Int = 0) {
    if (waterAvailable < water) {
        println("Sorry, not enough water!")
    } else if (milkAvailable < milk) {
        println("Sorry, not enough milk!")
    } else if (beansAvailable < beans) {
        println("Sorry, not enough beans!")
    } else if (cupsAvailable == 0) println("Sorry, not enough cups!")
    else {
        println("I have enough resources, making you a coffee!")
        waterAvailable -= water
        milkAvailable -= milk
        beansAvailable -= beans
        cupsAvailable--
        moneyAvailable += money
    }
}

fun makeEspresso() {
    makeCoffee(water = 250, beans = 16, money = 4)
}

fun makeLatte() {
    makeCoffee(water = 350, milk = 75, beans = 20, money = 7)
}

fun makeCappuccino() {
    makeCoffee(water = 200, milk = 100, beans = 12, money = 6)
}

fun fill() {
    println("Write how many ml of water you want to add:")
    waterAvailable += readln().toInt()
    println("Write how many ml of milk you want to add:")
    milkAvailable += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    beansAvailable += readln().toInt()
    println("Write how many disposable cups you want to add:")
    cupsAvailable += readln().toInt()
}

fun take() {
    println("I gave you $$moneyAvailable")
    moneyAvailable = 0
}