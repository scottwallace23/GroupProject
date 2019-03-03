import org.scalatest._
import Backend.circles.{Player,Food}

class TestCircles extends FunSuite {

  Player.playerLocationY = 5
  Player.playerLocationX = 10


  test(testName = "Move Player Test Vertical"){

    assert(Player.moveVertical(Up = "W", Down = "") == 6)
    Player.playerLocationY = 5
    assert(Player.moveVertical(Up ="", Down = "S") == 4)

  }

  test(testName = "Move Player Test Horizontal"){

    assert(Player.moveHorizontal("A", "")== 9)
    Player.playerLocationX = 10
    assert(Player.moveHorizontal(Left = "", Right = "D") == 11)

  }

  test(testName = "eatFood Test"){
    Player.size = 10
    Player.playerLocationX = 5
    Player.playerLocationY = 6      // Location is exactly the same, therefore adds one to the player's size
    Food.foodLocationX = 5
    Food.foodLocationY = 6
    assert(Player.eatFood() == 11)
    Player.size = 10              // I reset the players size for the next assertion, it would save 11 if I didn't
    Player.playerLocationX = 5
    Player.playerLocationY = 3
    Food.foodLocationX = 2
    Food.foodLocationY =1
    assert(Player.eatFood() == 10)
  }








}
