class PhoneNumberTransform {

  type Letters = List[Char]

  def toPossibleChars(phoneNumber: List[Int]): List[String] = {
    if (phoneNumber.isEmpty) List() else {
      val numberToLetters: List[Letters] = phoneNumber.map(toChar)
      val initialLetters: List[Letters] = numberToLetters.head.map(List(_)) // WHY???
      val letterCombinations: List[Letters] = letterListBuilder(numberToLetters.tail, initialLetters)
      letterCombinations.map(_.mkString(""))
    }
  }

  def letterListBuilder(numbersAsLetters: List[Letters], possibleLetters: List[Letters]): List[Letters] = {
    numbersAsLetters match {
      case Nil => possibleLetters
      case currentLetters::tail =>
        val newLetters: List[Letters] = currentLetters.flatMap(letter => possibleLetters.map (existingWord => existingWord :+ letter))
        letterListBuilder(tail, newLetters)
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
