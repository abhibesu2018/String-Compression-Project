package com.abhi.stringcompression

import org.junit.runner.Result
import org.scalatest.enablers.Length

object StringCompression {

  def main(args: Array[String]): Unit = {
    
    if(args.length!=2){
      println("Need proper input .. e.g. : AAABVVV 2")
      System.exit(1)
    }
    val compressedString = compressStr(args(0),args(1).toInt)
    println("For input string: "+args(0)+" .The compressed string is : "+compressedString)
}

  def compressStr(str: String, minOccurence: Int): String = {
    val matchingCharacterSequenceList:List[String] = charactersList(str)
    
    val compressedString = matchingCharacterSequenceList.map(uniqueCharacter => {
      val length = uniqueCharacter.length
      if (length >= minOccurence) {
        length + uniqueCharacter.head.toString
      } else {
        uniqueCharacter
      }
    })
    compressedString.mkString("")
  }

  def charactersList(str: String): List[String] = {
    if (str.length <= 0) {
      return Nil
    }
    val charAtStarting = str.charAt(0)
    val matchingCharacterSequence = str.takeWhile(_ == charAtStarting)
    matchingCharacterSequence :: charactersList(str.drop(matchingCharacterSequence.length))
  }
}
