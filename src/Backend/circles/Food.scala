package Backend.circles

import scalafx.scene.paint.Color
import scalafx.scene.shape.Circle

import scala.collection.mutable.ListBuffer


class Food extends Circle {
  centerX = Math.random() * 600
  centerY = Math.random() * 600
  radius = 2
  fill = Color.Green

  def multipleFood(): ListBuffer[Food] = {
    val thing = true
    val lim: Int = 100
    var x: Int = 1
    val one = new Food
    var food: ListBuffer[Food] = ListBuffer(one)
    while(x < lim){
      val others = new Food
      food += others
      x += 1
    }
    food
  }

}