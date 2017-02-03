class PhoneNumberTransform {
  def toPossibleChars(phoneNumber: List[Int]): List[Any] = {
    val nToChars: List[List[Char]] = phoneNumber.map(toChar)
    val y = charListBuilder(nToChars).map{ case chars: List[Char] => chars.mkString("")}
    y
  }

  def charListBuilder(nToCharSegment: List[List[Char]]): List[List[Char]] = {
    nToCharSegment match {
      case Nil => List()
      case lastSeg::Nil => List(lastSeg)
      case seg1::seg2::tail =>
        val newCharList: List[List[Char]] = seg1.flatMap(c1 => seg2.map (c2 => List(c1, c2)))
        newCharList ++ charListBuilder(tail)
    }
  }

  def testSliding(nToCharSegment: List[List[Char]]) = {
    nToCharSegment.sliding(2)
  }


  private def toChar(i : Int): List[Char] = {
    i match {
      case 1 => List('a', 'b', 'c')
      case 2 => List('d', 'e', 'f')
      case 3 => List('g', 'h', 'i')
      case 4 => List('j', 'k', 'l')
      case 5 => List('m', 'n', 'o')
      case 6 => List('p', 'q', 'r')
      case 7 => List('s', 't', 'u')
      case 9 => List('v', 'w', 'x')
      case 0 => List('y', 'z')
    }
  }

  private  def toStringList(i : Int): List[String] = {
}
