package model


import play.api.libs.json._

object SongJsonProtocol {
  implicit val songWriter = Json.writes[Song]
  implicit val songReader = Json.reads[Song]
}


case class Song(id: Long, name: String, votes: Long)

object Song