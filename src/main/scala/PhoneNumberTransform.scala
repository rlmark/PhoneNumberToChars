class PhoneNumberTransform {
  type Letters = List[Char]
  def toPossibleChars(phoneNumber: List[Int]): List[String] = {
    val nToChars: List[Letters] = phoneNumber.map(toChar)
    val initialLetters = nToChars.head.map(List(_))
    val words = charListBuilder(nToChars.tail, initialLetters).map(_.mkString(""))
    words
  }

  def charListBuilder(numbersAsLetters: List[Letters], possibleLetters: List[Letters]): List[Letters] = {
    numbersAsLetters match {
      case Nil => possibleLetters
      case currentLetters::tail =>
        println("current letters" + currentLetters)
        val newLetters: List[Letters] = currentLetters.flatMap(char => possibleLetters.map (existingWord => existingWord :+ char))
        println("interim list" + newLetters)
        charListBuilder(tail, possibleLetters ++ newLetters)
    }
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

}
