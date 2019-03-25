package controller


import Backend.circles.Player
import javafx.event.EventHandler
import javafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode

abstract class Actions() extends EventHandler[KeyEvent] {
  override def handle(event: KeyEvent): Unit = {
    KeyCode.getClass.getName match{
      case "W" => Player.playerLocationY -= 1
      case "A" => Player.playerLocationX -= 1
      case "S" => Player.playerLocationY += 1
      case "D" => Player.playerLocationX += 1
      case _ =>
    }
  }
}
