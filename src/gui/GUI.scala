package gui

import Backend.circles.{Food, Player}
import javafx.scene.input.{KeyCode, KeyEvent}
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.scene.paint.Color
import scalafx.{application, scene}
import scalafx.scene.shape.Circle
import scalafx.scene.{Group, PerspectiveCamera, Scene}

object GUI extends JFXApp {
  class Player extends Circle {
    centerX = Math.random() * 300
    var cenX = centerX.toDouble
    centerY = Math.random() * 300
    var cenY = centerY.toDouble
    radius = Player.size
    var rad = radius.toDouble
    fill = Player.randomColor()
  }

  class Food extends Circle {
    centerX = Math.random() * 300
    var cenX = centerX.toDouble
    centerY = Math.random() * 300
    var cenY = centerY.toDouble
    radius = Food.size
    var rad = radius.toDouble
    fill = Food.color
  }
  val player = new Player
  val player2 = new Player

  def movePlayer(key: KeyCode): Unit = { //This moves the player
    key.getName match {
      case "W" => player.centerY.value -= 10
      case "S" => player.centerY.value += 10
      case "A" => player.centerX.value -= 10
      case "D" => player.centerX.value += 10
      case _ =>
    }
  }
  val food1 = new Food
  val food2 = new Food

  stage = new application.JFXApp.PrimaryStage {
    title = ""
    scene = new Scene(600, 600) {
      var food = List(food1, food2)
      var players = List(player, player2)
      content = List(food1, food2, player, player2)
      addEventHandler(KeyEvent.KEY_PRESSED, (event: KeyEvent) => movePlayer(event.getCode))
      var lastUpdateTime = 0
      val timer = AnimationTimer(t => {
        if (lastUpdateTime > 0) {
          val delta = (t - lastUpdateTime) / 100
          for (f <- food) {
            f.fill = Color.Green
            val dx = player.centerX.value - f.centerX.value
            val dy = player.centerY.value - f.centerY.value
            val dist = Math.sqrt((dx * dx) + (dy * dy))
            if (dist < 10) {
              player.radius.value += f.radius.value
              f.radius.value = 0
            }
          }
          val pdx = player.centerX.value - player2.centerX.value
          val pdy = player.centerY.value - player2.centerY.value
          val pdist = Math.sqrt((pdx * pdx) + (pdy * pdy))
          if (pdist < 10){
            if(player.radius.value > player2.radius.value){
              player.radius.value += player2.radius.value
              player2.radius.value = 0
            }
            else if(player.radius.value < player2.radius.value){
              player2.radius.value += player.radius.value
              player.radius.value = 0
            }
          }
        }
        lastUpdateTime = t.toInt
      })
      timer.start()
    }

  }
}
