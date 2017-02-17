import org.scalatest.{Matchers, FlatSpec}

class PhoneNumberTransformSpec extends FlatSpec with Matchers {
 "PhoneNumberTransform" should "work" in {
   val transformer = new PhoneNumberTransform()
   val result1 = transformer.toPossibleChars(List(1,2))
   println("TEST ONE " + result1)
   result1.contains("ad") shouldBe true
 }

  it should "work for three" in {
    val transformer = new PhoneNumberTransform()

    val result2 = transformer.toPossibleChars(List(1,2,3,4))
    println("TEST TWO" + result2)
    result2.contains("agdj") shouldBe false
    result2.contains("adgj") shouldBe true
  }
}
