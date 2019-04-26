
package server

import akka.actor.Actor

case object Update

case object movePlayer

class GameActor(username: String) extends Actor {

  override def receive: Receive = {
    case movePlayer =>

  }

}
