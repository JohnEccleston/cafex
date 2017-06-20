/**
  * Created by johneccleston on 20/06/2017.
  */
object Main extends App {

  override def main(args: Array[String]): Unit = {
      val totalBill = Bill(args)
      println("Bill: " + totalBill.retBill)
      println("Service Charge: " + totalBill.retService)
      println("Total Bill: " + totalBill.retTotal)
    }
}
