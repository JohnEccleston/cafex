import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by johneccleston on 20/06/2017.
  */
class BillTest extends FlatSpec with Matchers {


  "A Bill" should "return 0.5 for Cola" in {
    val input = Array("Cola")
    val bill = new Bill(input)
    bill.retVal should be (0.50)
  }

  it should "return 1.0 for Coffee" in {
    val input = Array ("Coffee")
    val bill = new Bill(input)
    bill.retVal should be (1.0)
  }

  it should "return 2.0 for Cheese Sandwich" in {
    val input = Array("Cheese Sandwich")
    val bill = new Bill(input)
    bill.retVal should be (2.0)
  }

  it should "return 4.5 for Steak Sandwich" in {
    val input = Array("Steak Sandwich")
    val bill = new Bill(input)
    bill.retVal should be (4.5)
  }

  it should "return 1.5 for Cola and Coffee" in {
    val input = Array("Cola", "Coffee")
    val bill = new Bill(input)
    bill.retVal should be (1.5)
  }

  it should "return 3.5 for Cola, Coffee and Cheese Sandwich" in {
    val input = Array("Cola", "Coffee", "Cheese Sandwich")
    val bill = new Bill(input)
    bill.retVal should be (3.5)
  }

  it should "return 3.5 for Cola, Coffee, Cheese Sandwich, and Steak Sandwich" in {
    val input = Array("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich")
    val bill = new Bill(input)
    bill.retVal should be (8.0)
  }

  it should "return 0.0 when no items" in {
    val input : Array[String] = Array()
    val bill = new Bill(input)
    bill.retVal should be (0.0)
  }

  it should "return 0.0 when invalid item" in {
    val input = Array("Banana")
    val bill = new Bill(input)
    bill.retVal should be (0.0)
  }
}
