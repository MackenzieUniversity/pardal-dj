package controllers

import model.Song
import play.api.libs.json.Json
import play.api.mvc._

class DjController extends Controller {

  import model.SongJsonProtocol._

  def play = Action {
    val song = Song(1,"We are the champions",10)
    Ok(Json.toJson(song).toString)
  }

  def songs = Action {
    val songs = List(Song(1,"We are the champions",15),
      Song(2,"Bohemian Rapsody",10),
      Song(3,"Supervisor",9))
    Ok(Json.toJson(songs).toString)
  }

  def vote = Action {
    Ok(
      """{ "result" : "ok" }""")
  }



}
