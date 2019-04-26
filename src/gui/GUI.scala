package gui

import Backend.circles.{Food, Player}
import javafx.scene.input.{KeyCode, KeyEvent}
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color
import scalafx.{application, scene}
import scalafx.scene.shape.Circle
import scalafx.scene.{Group, PerspectiveCamera, Scene}

import scala.collection.mutable.ListBuffer

object GUI extends JFXApp {
  class Player extends Circle {
    centerX = Math.random() * 600
    centerY = Math.random() * 600
    radius = Player.size
    fill = Player.randomColor()
  }

  class Food extends Circle {
    centerX = Math.random() * 600
    centerY = Math.random() * 600
    radius = Food.size
    fill = Food.color
  }
  val player = new Player
  val player2 = new Player
  player2.radius.value = 30
  def movePlayer(key: KeyCode): Unit = { //This moves the player
    key.getName match {
      case "W" => player.centerY.value -= 10
      case "S" => player.centerY.value += 10
      case "A" => player.centerX.value -= 10
      case "D" => player.centerX.value += 10
      case _ =>
    }
  }
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
  val food1, food2, food3, food4, food5, food6, food7, food8, food9, food10 = new Food
  stage = new application.JFXApp.PrimaryStage {
    title = "CSE116.io"
    scene = new Scene(1200, 1200) {
      var players = List(player, player2)
      content = {
        food
        players
      }
      addEventHandler(KeyEvent.KEY_PRESSED, (event: KeyEvent) => movePlayer(event.getCode))
      var lastUpdateTime = 0
      val timer = AnimationTimer(t => {
        if (lastUpdateTime > 0) {
          val delta = (t - lastUpdateTime) / 100
          for (f <- food) {
            f.fill = Color.Green
            f.setVisible(true)
            val dx = player.centerX.value - f.centerX.value
            val dy = player.centerY.value - f.centerY.value
            val dist = Math.sqrt((dx * dx) + (dy * dy))
            if (dist < player.radius.value) {
              player.radius.value += f.radius.value
              f.radius.value = 0
            }
          }
          val pdx = player.centerX.value - player2.centerX.value
          val pdy = player.centerY.value - player2.centerY.value
          val pdist = Math.sqrt((pdx * pdx) + (pdy * pdy))
          if (pdist < player.radius.value){
            if(player.radius.value > player2.radius.value){
              player.radius.value += player2.radius.value
              player2.radius.value = 0
            }
            else if(player.radius.value < player2.radius.value){
              player2.radius.value += player.radius.value
              player.radius.value = 0
            }
          }
          else if(pdist < player2.radius.value){
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
