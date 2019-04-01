package Backend.circles

import scalafx.scene.paint.Color

import scala.util.Random


object Player extends Circles {
  this.size = 20  //Initial size for player circle
  var playerLocationX = centerX
  var playerLocationY = centerY

  def randomColor(): Color = {      //Returns the random color for the player circle.

    val arrayColors: Array[Int] = Array(0,1,2,3)
    val randomNum = Random.shuffle(arrayColors.toList).head

    if(randomNum == 0){
      this.color = Color.Red
    }
    else if(randomNum == 1){
      this.color = Color.Blue
    }
    else if(randomNum == 2){
      this.color = Color.Green
    }
    else if(randomNum == 3){
      this.color = Color.Yellow
    }
    this.color
  }

  def eatFood(): Int = {
    if(Food.size <= 0){
      Food.size = 0
      Food.size
    }
    if(Player.playerLocationX == Food.foodLocationX && Player.playerLocationY == Food.foodLocationY){
      Player.size += Food.size  //Adds to the player's size by the size of the food
      Food.size -= Food.size  //Subtracts the size of the food which basically destroys the food once its eaten
    }
    Player.size
  }










}