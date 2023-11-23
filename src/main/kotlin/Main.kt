import IDrink
import kotlin.system.exitProcess

fun main()
{
    val pizzaSPb = PizzaSPb(
        175.3, 241.5,
        167.5, 215.0
    )
    val pizzaMSK = PizzaMoscow(
        215.0, 250.5,
        180.5, 240.0
    )
    val pizzaKotlas = PizzaKotlas(
        100.0, 200.0,
        120.5, 99.99
    )
    //main objects

    var currentPizzaCity: PizzaCity //holder for a city
while (true) //main cycle
{
    println("Добро пожаловать в пиццерию! Выберите город")
    println("1. Москва \n2. Санкт-Петербург\n3. Котлас\n  0. Выход")
    val city = readln()
    when (city) { //place an object in the holder
        "1" -> currentPizzaCity = pizzaMSK
        "2" -> currentPizzaCity = pizzaSPb
        "3" -> currentPizzaCity = pizzaKotlas
        "0" -> break
        else -> {
            println("ERROR")
            continue
        }
    }
    currentPizzaCity.clientCount++ //increment client count
    println("Выберите пиццу:")
    println(
        "1. Неаполитанская\n2. Римская\n" +
                "3. Сицилийская\n4. Тирольская\n0. Показать статистику "
    )
    selectPizzaType(currentPizzaCity)
    println("\n\n\n")
    }
}

private fun selectPizzaType(currentPizzaCity: PizzaCity) { //pizza chooser
    when (readln()) {
        "1" -> {
            currentPizzaCity.neapolitanPizzaSell(); selectAddService(currentPizzaCity)
        }

        "2" -> {
            currentPizzaCity.romanPizzaSell(); selectAddService(currentPizzaCity)
        }

        "3" -> {
            currentPizzaCity.sicilianPizzaSell(); selectAddService(currentPizzaCity)
        }

        "4" -> {
            currentPizzaCity.tyroleanPizzaSell(); selectAddService(currentPizzaCity)
        }

        "0" ->{ currentPizzaCity.clientCount--; currentPizzaCity.showStats() }
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}


fun selectAddService(currentPizzaCity:PizzaCity) //additional service chooser
{  
    if (currentPizzaCity is IDrink)
            {currentPizzaCity.drinkSale()}
    if (currentPizzaCity is ISauce)
            {currentPizzaCity.SauceSale()}
    if (currentPizzaCity is IReceiptPhoto)
            {currentPizzaCity.showReceiptPhoto()}
}
fun calcPercent(Amain: Int, Apart: Int):String //calculates a percent of an integer
{
    if (Amain==0) return "0.0"
    return     String.format("%.2f",     ((Apart.toDouble()/Amain.toDouble())*100)    )
}
