package Backend.circles

import gui.GUI.Food
import javafx.scene.shape.Circle
import scalafx.scene.paint.Color


object Food extends Circles {
  this.size = 5     //Food always has the size of 1
  this.color = Color.Green   //Food is always green
  val food = new Food
  var foodLocationX = 0
  var foodLocationY = 0

}