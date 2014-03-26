package heuristic2048.javascript

import scala.scalajs.js
import js.Dynamic.{ global => g }
import js.annotation.JSExport
import heuristic2048._

@JSExport
class GameStateJS(state: GameState) {
  @JSExport
  def this() = this(new GameState())
  
  @JSExport
  def getCell(x: Int, y: Int) = {
    state.cells(x)(y) match {
      case EmptyCell => 0
      case BlockCell(v) => v 
    }
  }
  
  @JSExport
  def move(move: String) = {
    new GameStateJS(state.move(move match {
      case "up" => MoveUp
      case "down" => MoveDown
      case "left" => MoveLeft
      case "right" => MoveRight
      case _ => error("undefined move")
    }))
  }
  
  @JSExport
  def setBlock(x: Int, y: Int, v: Int) = {
    new GameStateJS(state.setBlock(x, y, v))
  }
}