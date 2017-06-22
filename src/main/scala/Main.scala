/**
  * Created by johneccleston on 20/06/2017.
  */
object Main extends App {

  override def main(args: Array[String]): Unit = {
      val input = args.toList
      val totalBill = Bill(input)
      println("Bill: " + totalBill.getBill)
      println("Service Charge: " + totalBill.getService)
      println("Total Bill: " + totalBill.getTotal)
    }
}
