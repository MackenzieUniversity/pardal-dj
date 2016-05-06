package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(
      """
        |This app contains 3 web-services for the mobile development class.
        |
        |GET /songs returns songs
        |GET /play returns the song that is going to play next
        |POST /vote/:id vote on the song with the given id to be the next to be played
      """.stripMargin)
  }


}
