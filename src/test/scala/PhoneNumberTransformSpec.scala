import org.scalatest.{Matchers, FlatSpec}

class PhoneNumberTransformSpec extends FlatSpec with Matchers {
 "PhoneNumberTransform" should "work" in {
   val transformer = new PhoneNumberTransform()
   val result1 = transformer.toPossibleChars(List(1,2))
   println(result1)
   result1.contains("ad") shouldBe true

   val result2 = transformer.toPossibleChars(List(1,2,3,4))
   println(result2)
   result2.contains("agdj") shouldBe false
   result2.contains("adgj") shouldBe true
 }

  "testSliding" should "work" in {
    val transformer = new PhoneNumberTransform()

    val testList = List(List('a','b','c'), List('d','e','f'), List('g','h','i') )
    println((transformer.testSliding(testList)).toList)
  }
}
