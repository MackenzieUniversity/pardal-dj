package controllers

import model.Song
import play.api.libs.json.Json
import play.api.mvc._

class DjController extends Controller {

  import model.SongJsonProtocol._

  def play = Action {
    val song = Song.next()
    Ok(Json.toJson(song).toString)
  }

  def songs = Action {
    val songs = Song.findAll
    Ok(Json.toJson(songs).toString)
  }

  def vote(id: Long) = Action {
    Song.vote(id)
    Ok(
      """{ "result" : "ok" }""")
  }



}
