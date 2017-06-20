import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by johneccleston on 20/06/2017.
  */
class BillTest extends FlatSpec with Matchers {


  "A Bill" should "return 0.5 for Cola" in {
    val input = Array("Cola")
    val bill = new Bill(input)
    bill.retBill should be (0.50)
    bill.retService should be (0.00)
    bill.retTotal should be (0.50)
  }

  it should "return 1.0 for Coffee" in {
    val input = Array ("Coffee")
    val bill = new Bill(input)
    bill.retBill should be (1.00)
    bill.retService should be (0.00)
    bill.retTotal should be (1.00)
  }

  it should "return 2.0 for Cheese Sandwich" in {
    val input = Array("Cheese Sandwich")
    val bill = new Bill(input)
    bill.retBill should be (2.00)
    bill.retService should be (0.20)
    bill.retTotal should be (2.20)
  }

  it should "return 4.5 for Steak Sandwich" in {
    val input = Array("Steak Sandwich")
    val bill = new Bill(input)
    bill.retBill should be (4.50)
    bill.retService should be (0.90)
    bill.retTotal should be (5.40)
  }

  it should "return 1.5 for Cola and Coffee" in {
    val input = Array("Cola", "Coffee")
    val bill = new Bill(input)
    bill.retBill should be (1.50)
    bill.retService should be (0.00)
    bill.retTotal should be (1.50)
  }

  it should "return 3.5 for Cola, Coffee and Cheese Sandwich" in {
    val input = Array("Cola", "Coffee", "Cheese Sandwich")
    val bill = new Bill(input)
    bill.retBill should be (3.50)
    bill.retService should be (0.35)
    bill.retTotal should be (3.85)
  }

  it should "return 8.0 for Cola, Coffee, Cheese Sandwich, and Steak Sandwich" in {
    val input = Array("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich")
    val bill = new Bill(input)
    bill.retBill should be (8.00)
    bill.retService should be (1.60)
    bill.retTotal should be (9.60)
  }

  it should "return 0.0 when no items" in {
    val input : Array[String] = Array()
    val bill = new Bill(input)
    bill.retBill should be (0.00)
    bill.retService should be (0.00)
    bill.retTotal should be (0.00)
  }

  it should "return 0.0 when invalid item" in {
    val input = Array("Banana")
    val bill = new Bill(input)
    bill.retBill should be (0.00)
    bill.retService should be (0.00)
    bill.retTotal should be (0.00)
  }

  it should "return 20.00 as service charge maximum" in {
    val input = Array("Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich")
    val bill = new Bill(input)
    bill.retBill should be (126.00)
    bill.retService should be (20.00)
    bill.retTotal should be (146.00)

  }

}
