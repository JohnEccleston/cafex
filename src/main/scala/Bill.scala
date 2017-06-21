import scala.math.BigDecimal.RoundingMode

/**
  * Created by johneccleston on 20/06/2017.
  */
case class Bill(items: Array[String]) {

  val menu = Map(
    ("Cola" -> (BigDecimal(0.50), false, false)),
    ("Coffee" -> (BigDecimal(1.00), false, true)),
    ("Cheese Sandwich" -> (BigDecimal(2.00), true, false)),
    ("Steak Sandwich" -> (BigDecimal(4.50), true, true))
  )

  // Sum menu items input
  def getBill() = { items.flatMap(menu.get).foldLeft(BigDecimal(0.00))((soFar, current) => soFar + current._1) }

  // return true if menu items input contain food
  def isFood(): Boolean = { items.flatMap(menu.get).find(x=> x._2 == true).nonEmpty }

  // return true if menu items input contain hot food
  def isHotFood(): Boolean = { items.flatMap(menu.get).find(x=> x._2 == true && x._3 == true).nonEmpty }

  // return service charge up to a maximum of 20%, service charge is based on whole bill
  def getService(): BigDecimal = {
    // if it is a drink, no service charge
    // if it is cold food add 10% to service charge
    // if it is hot food add 20% service charge
    val servicePercent = if(isFood) if(isHotFood) BigDecimal(0.2) else BigDecimal(0.1) else BigDecimal(0.0)

    // Maximum service charge is 20.00
    if (retBill*servicePercent <= BigDecimal(20.00))
      retBill*servicePercent.setScale(2, RoundingMode.HALF_UP)
    else BigDecimal(20.00)
  }

  val retBill = getBill().setScale(2)
  val retService = getService()
  val retTotal = retBill + retService
}
