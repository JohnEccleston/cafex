import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by johneccleston on 20/06/2017.
  */
class BillTest extends FlatSpec with Matchers {


  "A Bill" should "return 0.5 for Cola" in {
    val input = List("Cola")
    val bill = new Bill(input)
    bill.getBill should be (0.50)
    bill.getService should be (0.00)
    bill.getTotal should be (0.50)
  }

  it should "return 1.0 for Coffee" in {
    val input = List ("Coffee")
    val bill = new Bill(input)
    bill.getBill should be (1.00)
    bill.getService should be (0.00)
    bill.getTotal should be (1.00)
  }

  it should "return 2.0 for Cheese Sandwich" in {
    val input = List("Cheese Sandwich")
    val bill = new Bill(input)
    bill.getBill should be (2.00)
    bill.getService should be (0.20)
    bill.getTotal should be (2.20)
  }

  it should "return 4.5 for Steak Sandwich" in {
    val input = List("Steak Sandwich")
    val bill = new Bill(input)
    bill.getBill should be (4.50)
    bill.getService should be (0.90)
    bill.getTotal should be (5.40)
  }

  it should "return 1.5 for Cola and Coffee" in {
    val input = List("Cola", "Coffee")
    val bill = new Bill(input)
    bill.getBill should be (1.50)
    bill.getService should be (0.00)
    bill.getTotal should be (1.50)
  }

  it should "return 3.5 for Cola, Coffee and Cheese Sandwich" in {
    val input = List("Cola", "Coffee", "Cheese Sandwich")
    val bill = new Bill(input)
    bill.getBill should be (3.50)
    bill.getService should be (0.35)
    bill.getTotal should be (3.85)
  }

  it should "return 8.0 for Cola, Coffee, Cheese Sandwich, and Steak Sandwich" in {
    val input = List("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich")
    val bill = new Bill(input)
    bill.getBill should be (8.00)
    bill.getService should be (1.60)
    bill.getTotal should be (9.60)
  }

  it should "return 0.0 when no items" in {
    val input : List[String] = List()
    val bill = new Bill(input)
    bill.getBill should be (0.00)
    bill.getService should be (0.00)
    bill.getTotal should be (0.00)
  }

  it should "return 0.0 when invalid item" in {
    val input = List("Banana")
    val bill = new Bill(input)
    bill.getBill should be (0.00)
    bill.getService should be (0.00)
    bill.getTotal should be (0.00)
  }

  it should "return 20.00 as service charge maximum" in {
    val input = List("Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich",
                      "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich")
    val bill = new Bill(input)
    bill.getBill should be (126.00)
    bill.getService should be (20.00)
    bill.getTotal should be (146.00)
  }

}
