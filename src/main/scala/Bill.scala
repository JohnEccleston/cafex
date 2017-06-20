import scala.math.BigDecimal.RoundingMode

/**
  * Created by johneccleston on 20/06/2017.
  */
case class Bill(items: Array[String]) {

  private var bill = BigDecimal(0.00)
  private var serviceCharge = BigDecimal(0.00)
  private var servicePercent = BigDecimal(0.00)
  private var isFood = false
  private var isHot = false

  private val menu = Map(
    ("Cola" -> (BigDecimal(0.50), false, false)),
    ("Coffee" -> (BigDecimal(1.00), false, true)),
    ("Cheese Sandwich" -> (BigDecimal(2.00), true, false)),
    ("Steak Sandwich" -> (BigDecimal(4.50), true, true))
  )

  private def getTotal(price: BigDecimal, food: Boolean, hot: Boolean) = (price, food, hot) match {

    case (p, false, _) => bill += p
    case (p, true, false) => bill += p; isFood = true
    case(p, true, true) => bill += p; isFood = true; isHot = true
  }

  private def getService(): BigDecimal = {
    // if it is a drink, no service charge
    // if it is cold food add 10% to service charge
    // if it is hot food add 20% service charge
    if(isFood) servicePercent = if(isHot) BigDecimal(0.2) else BigDecimal(0.1)

    serviceCharge = bill*servicePercent
    // Maximum service charge is 20.00
    if (serviceCharge <= BigDecimal(20.00))
      serviceCharge.setScale(2, RoundingMode.HALF_UP)
    else BigDecimal(20.00)
  }

  if(items.nonEmpty || items == null) {
    for (item <- items) {
      try {
        val full = menu(item)
        getTotal(full._1, full._2, full._3)
      } catch {
        case nse: NoSuchElementException => println(s"Invalid Menu Item: $item")
      }
    }
  } else {
    println("No Items in Menu")
    val retBill = bill.setScale(2)
    val retService = getService()
    val retTotal = bill + retService
  }

  val retBill = bill.setScale(2)
  val retService = getService()
  val retTotal = bill + retService
}
