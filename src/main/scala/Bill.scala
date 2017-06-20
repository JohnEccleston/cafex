/**
  * Created by johneccleston on 20/06/2017.
  */
case class Bill(items: Array[String]) {

  private var total = 0.0

  if(items.nonEmpty || items == null) {
    for (item <- items) {
      item match {
        case "Cola" => total += 0.5
        case "Coffee" => total += 1.0
        case "Cheese Sandwich" => total += 2.0
        case "Steak Sandwich" => total += 4.5
        case default => println(s"Invalid Menu Item: $default")
      }
    }
  } else {
    println("No Items in Menu")
    val retVal = total
  }

  val retVal = total
}
