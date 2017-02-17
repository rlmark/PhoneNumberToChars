import org.scalatest.{Matchers, FlatSpec}

class PhoneNumberTransformSpec extends FlatSpec with Matchers {
 "PhoneNumberTransform" should "work" in {
   val transformer = new PhoneNumberTransform()
   val result = transformer.toPossibleChars(List(1,2))
   println("TEST ONE " + result)
   result.contains("ad") shouldBe true
 }

  it should "work for three" in {
    val transformer = new PhoneNumberTransform()

    val result = transformer.toPossibleChars(List(1,2,3,4))
    println("TEST TWO " + result)
    result.contains("agdj") shouldBe false
    result.contains("adgj") shouldBe true
  }

  it should "work for one" in {
    val transformer = new PhoneNumberTransform()

    val result = transformer.toPossibleChars(List(1))
    println("TEST THREE " + result)
    result.contains("a") shouldBe true
    result.contains("b") shouldBe true
    result.contains("c") shouldBe true
  }

  it should "not blow up when given an empty list" in {
    val transformer = new PhoneNumberTransform()
    val result = transformer.toPossibleChars(List())
    result shouldBe List()
  }
}
