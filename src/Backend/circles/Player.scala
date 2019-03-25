package Backend.circles

import scala.util.Random


object Player extends Circles {
  this.size = 10  //Initial size for player circle
  def setXLoc(): Int = {
    val xmax = 1000
    val rand = new scala.util.Random
    val xloc = rand.nextInt(xmax)
    xloc
  }
  def setYLoc(): Int = {
    val ymax = 1000
    val rand = new scala.util.Random
    val yloc = rand.nextInt(ymax)
    yloc
  }
  var playerLocationX = setXLoc()
  var playerLocationY = setYLoc() //initializes location at a random (x,y) coordinate

/* def randomColor(): String ={      //Returns the random color for the player circle.
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
*/

  def eatFood(): Int = {
    if(Player.playerLocationX == Food.foodLocationX && Player.playerLocationY == Food.foodLocationY){
      Player.size += Food.size  //Adds to the player's size by the size of the food
      Food.size -= 1  //Subtracts the size of the food which basically destroys the food once its eaten
    }
    Player.size

  }

  def main(args: Array[String]): Unit = {
    //println(randomColor())
  }







}