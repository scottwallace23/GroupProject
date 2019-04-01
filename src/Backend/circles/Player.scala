package Backend.circles

import gui.GUI.Player
import javafx.scene.input.KeyCode
import scalafx.scene.paint.Color

import scala.util.Random

object Player extends Circles {

  val player = new Player
  this.size = 20  //Initial size for player circle
  var playerLocationX = player.centerX.value
  var playerLocationY = player.centerX.value

  def randomColor(): Color = {      //Returns the random color for the player circle.
    val arrayColors: Array[Int] = Array(0,1,2,3,4,5,6,7)
    val randomNum = Random.shuffle(arrayColors.toList).head
    if(randomNum == 0){
      this.color = Color.Red
    }
    else if(randomNum == 1){
      this.color = Color.Blue
    }
    else if(randomNum == 2){
      this.color = Color.Brown
    }
    else if(randomNum == 3){
      this.color = Color.FireBrick
    }
    else if(randomNum == 4){
      this.color = Color.DeepSkyBlue
    }
    else if(randomNum == 5){
      this.color = Color.Gold
    }
    else if(randomNum == 6){
      this.color = Color.DarkGreen
    }
    else if(randomNum == 7){
      this.color = Color.LawnGreen
    }
    this.color
  }

  def eatFood(): Double = {
    if (Food.size <= 0) {
      Food.size = 0
      Food.size
    }
    if (Player.playerLocationX == Food.foodLocationX && Player.playerLocationY == Food.foodLocationY) {
      Player.size += Food.size //Adds to the player's size by the size of the food
      Food.size -= Food.size //Subtracts the size of the food which basically destroys the food once its eaten
    }
    Player.size
  }





}