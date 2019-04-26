package gui

import Backend.circles.{Food, Player}
import javafx.scene.input.KeyEvent
import scalafx.application
import scalafx.application.JFXApp
import scalafx.scene.Scene

object GUI extends JFXApp {
  val player = new Player
  val player2 = new Player
  player2.radius.value = 4
  val f = new Food
  val food = f.multipleFood()
  stage = new application.JFXApp.PrimaryStage {
    title = "CSE116.io"
    scene = new Scene(600, 600) {
      var players = List(player, player2)
      content = players
      addEventHandler(KeyEvent.KEY_PRESSED, (event: KeyEvent) => player.movePlayer(event.getCode))
      player.eat()
    }
  }
}