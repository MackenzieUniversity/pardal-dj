package controllers

import play.api.mvc._

class DjController extends Controller {


  def play = Action {
    Ok("play")
  }

  def songs = Action {
    Ok("songs")
  }

  def vote = Action {
    Ok("vote")
  }



}
