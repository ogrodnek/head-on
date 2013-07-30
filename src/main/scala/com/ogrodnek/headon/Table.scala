package com.ogrodnek.headon

import scala.collection.mutable.ArrayBuffer

class Table(
  columns: Seq[Column]
) {
  val headerCharacter = "="
    
  val rows = new ArrayBuffer[Seq[String]]
  
  def +=(row: String*): Unit = {
    rows += row
  }
  
  def getMaxLengths(): Seq[Int] = {
    // initialize lengths to column names
    val max = ArrayBuffer(columns.map(_.name.size):_*)
    
    rows.foreach { r =>
      for (i <- 0 until r.size) {
        if (max.length <= i) {
          max += r(i).length
        } else {
          if (r(i).length() > max(i)) {
            max(i) = r(i).length()
          }
        }
      }
    }
    
    max
  }
  
  override def toString(): String = {
    val max: Seq[Int] = getMaxLengths()

    formatHeader(max) ++
    (rows map { row => 
      formatRow(row, max)
    }).mkString("\n")
  }
  
  def formatHeader(size: Seq[Int]) = {
    Seq(formatRow(columns.map(_.name), size),
      size.map(headerCharacter * _).mkString(" ") + "\n").mkString("\n")
  }
  
  def formatRow(row: Seq[String], size: Seq[Int]): String = {
    ((0 until row.size) map { i => 
        ("%%%ds".format(size(i))).format(row(i))
    }).mkString(" ")    
  }
}

object Table {
  def withColumnNames(names: String*) = {
    new Table(names.map(Column(_)))
  }
}

case class Column(
  name: String
)  