package gui

import Backend.circles.{Food, Player}
import javafx.scene.input.{KeyCode, KeyEvent}
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.shape.Circle
import scalafx.scene.{Group, Scene}

object GUI extends JFXApp {
  var sceneWidth: Double = 500
  var sceneHeight: Double = 500
  var g: Group = new Group {}

  class Player extends Circle{
    centerX = Math.random() * sceneWidth
    centerY = Math.random() * sceneHeight
    radius = Player.eatFood()
    fill = Player.randomColor()
  }
  class Food extends Circle{
    centerX = Math.random() * sceneWidth
    centerY = Math.random() * sceneHeight
    radius = Food.size
    fill = Food.color
  }

  val player = new Player

  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(new Food)
  g.children.add(player)

  def movePlayer(key: KeyCode): Unit = { //This moves the player
    key.getName match {
      case "W" => player.translateY.value -= 10
      case "S" => player.translateY.value += 10
      case "A" => player.translateX.value -= 10
      case "D" => player.translateX.value += 10
      case _ =>
    }
  }



    this.stage = new PrimaryStage {
      this.title = "CSE116.io"
      scene = new Scene(sceneWidth, sceneHeight) {
        content = List(g)
        addEventHandler(KeyEvent.KEY_PRESSED, (event: KeyEvent) => movePlayer(event.getCode))
        val update: Long => Unit = (time: Long) => {
        }
        AnimationTimer(update).start()
      }

    }

}
