package Backend.circles

import scala.util.Random


object Player extends Circles {
  this.size = 10  //Initial size for player circle
  var playerLocationX = 0
  var playerLocationY = 0 //initializes location at (0,0)

  def randomColor(): String ={      //Returns the random color for the player circle.

    val arrayColors: Array[Int] = Array(0,1,2,3)
    val randomNum = Random.shuffle(arrayColors.toList).head

    if(randomNum == 0){
      this.color = "red"
    }
    else if(randomNum == 1){
      this.color = "blue"
    }
    else if(randomNum == 2){
      this.color = "green"
    }
    else if(randomNum == 3){
      this.color = "yellow"
    }
   this.color
  }

  def eatFood(): Int = {
    if(Player.playerLocationX == Food.foodLocationX && Player.playerLocationY == Food.foodLocationY){
      Player.size += 1  //Adds to the player's size by the size of the food
      Food.size -= 1  //Subtracts the size of the food which basically destroys the food once its eaten
    }
    Player.size

  }

  def moveVertical(Up:String,Down:String):Int = {   //Location moving on the Y axis

    if(Up == "W"){
      playerLocationY += 1
    }
    else if(Down == "S"){
      playerLocationY -= 1
    }
    playerLocationY

  }
  def moveHorizontal(Left: String, Right:String): Int = {  // Location moving on the Y axis
    if(Left == "A"){
      playerLocationX -= 1
    }
    else if(Right == "D"){
      playerLocationX += 1
    }

    playerLocationX
  }







}