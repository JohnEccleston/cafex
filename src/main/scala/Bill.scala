import scala.math.BigDecimal.RoundingMode

/**
  * Created by johneccleston on 20/06/2017.
  */
case class Bill(items: List[String]) {

  val menu = Map(
    "Cola" -> (BigDecimal(0.50), false, false),
    "Coffee" -> (BigDecimal(1.00), false, true),
    "Cheese Sandwich" -> (BigDecimal(2.00), true, false),
    "Steak Sandwich" -> (BigDecimal(4.50), true, true)
  )

  // Sum menu items input
  val getBill = items.flatMap(menu.get).foldLeft(BigDecimal(0.00))((soFar, current) => soFar + current._1).setScale(2, RoundingMode.HALF_UP)

  // return true if menu items input contain food
  val isFood= items.flatMap(menu.get).exists(_._2)

  // return true if menu items input contain hot food
  val isHotFood= items.flatMap(menu.get).exists(x=> x._2 == true && x._3)

  // if it is a drink, no service charge
  // if it is cold food add 10% to service charge
  // if it is hot food add 20% service charge
  val servicePercent =
    (isFood, isHotFood) match {
      case (true, false) => BigDecimal(0.1)
      case (_, true) => BigDecimal(0.2)
      case (_,_) => BigDecimal(0.0)
    }

  // return service charge up to a maximum of £20, service charge is based on whole bill
  val getService = (getBill*servicePercent).setScale(2,RoundingMode.HALF_UP).min(20.00)

  val getTotal = getBill + getService
}
