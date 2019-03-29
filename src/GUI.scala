
import Backend.circles.{Food, Player}
import javafx.scene.input.{KeyCode, KeyEvent}
import scalafx.animation.AnimationTimer
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.paint.Color
import scalafx.scene.shape.{Circle, Shape}
import scalafx.scene.{Group, Scene}

object GUI extends JFXApp {

  var sceneWidth: Double = 500
  var sceneHeight: Double = 500

  var playerCircleRadius: Double = 20
  val playerSpeed: Double = 10


  var g: Group = new Group {}

  val player: Circle = new Circle {
    centerX = Math.random() * sceneWidth
    centerY = Math.random() * sceneHeight
    radius = Player.size
    fill = Color.Blue
  }
  val food: Circle = new Circle {
    centerX = Math.random() * sceneWidth
    centerY = Math.random() * sceneHeight
    radius = Food.size
    fill = Color.Green
  }
  g.children.addAll(food)
  g.children.add(player)


  def keyPressed(key: KeyCode): Unit = {
    key.getName match {
      case "W" => player.translateY.value -= playerSpeed
      case "A" => player.translateX.value -= playerSpeed
      case "S" => player.translateY.value += playerSpeed
      case "D" => player.translateX.value += playerSpeed
      case _ =>
    }


  }


  this.stage = new PrimaryStage {
    this.title = "Agar.io"
    scene = new Scene(sceneWidth, sceneHeight) {
      content = List(g)

      // add an EventHandler[KeyEvent] to control player movement
      addEventHandler(KeyEvent.KEY_PRESSED, (event: KeyEvent) => keyPressed(event.getCode))

      // define a function for the action timer (Could also use a method)
      // Rotate all rectangles (relies on frame rate. lag will slow rotation)
      val update: Long => Unit = (time: Long) => {
      }

      // Start Animations. Calls update 60 times per second (takes update as an argument)
      AnimationTimer(update).start()
    }

  }
}