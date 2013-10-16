package com.ogrodnek.headon

import org.junit.Test

class TableTest {
  @Test
  def test() {
    val table = Table.withColumnNames("col a", "b1234567890", "col c", "col d")
    
    table += ("this", "a", "a", "test")
    table += ("And", "b", "test", "hellohello")
    
    println(table.toString)
    println()
    println(table.take(1).toString)
  }
}