package sampletests

import org.scalatest.junit.AssertionsForJUnit
import scala.collection.mutable.ListBuffer
import org.junit.Assert._
import org.junit.Test
import org.junit.Before
import org.junit.runner.Result
import org.scalatest.enablers.Length
import com.abhi.stringcompression.StringCompression
import org.scalatest.FlatSpec
import scala.xml.dtd.MIXED
import org.scalatest.Fact

// http://scalatest.org/getting_started_with_junit_4
class ScalaTestSamples extends FlatSpec{

  @Test
  def assertionTest(){
  assert(StringCompression.compressStr("QQQFAAABEEEDFFC", 2) == "3QF3AB3ED2FC")
    
  assert(StringCompression.compressStr("ABBCDD", 2) == "A2BC2D")
    
  assert(StringCompression.compressStr("ABBBCCDDD", 3) == "A3BCC3D")
  
  }
  
  "String compressor program" should "convert (QQQFAAABEEEDFFC, 2) == 3QF3AB3ED2FC " in  {
    var compressedStr = StringCompression.compressStr("QQQFAAABEEEDFFC", 2)
    assert(compressedStr == "3QF3AB3ED2FC")
  }
  
  "String compressor program" should "convert (ABBCDD, 2) == A2BC2D " in  {
    var compressedStr = StringCompression.compressStr("ABBCDD", 2)
    assert(compressedStr == "A2BC2D")
  }
  
}
