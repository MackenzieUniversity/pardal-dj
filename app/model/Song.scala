package model


import org.joda.time.DateTime
import play.api.libs.json._
import anorm._
import anorm.SqlParser._
import play.api.db.DB
import play.api.Play.current


object SongJsonProtocol {
  implicit val songWriter = Json.writes[Song]
  implicit val songReader = Json.reads[Song]
}

case class Song(id: Option[Long], name: String, author: String, votes: Long)
object Song {

  val simple = {
      get[Option[Long]]("songs.id") ~
      get[Long]("songs.votes") ~
      get[String]("songs.name") ~
      get[String]("songs.author") map {
      case id ~ votes ~ name ~ author => Song(id,name,author,votes)
    }
  }

  def findById(id: Long): Option[Song] = {
    DB.withConnection { implicit connection =>
      SQL("select * from songs where id = {id} ")
        .on('id -> id).as(Song.simple.singleOpt)
    }
  }

  def findAll: List[Song] = {
    DB.withConnection { implicit connection =>
      SQL("select * from songs order by votes desc ").as(simple *)
    }
  }

  def vote(id: Long) = {
    DB.withConnection { implicit connection =>
      SQL(" update songs set votes = votes + 1 where id = {id} ").on('id -> id).executeInsert()
    }
  }

  def next(): Option[Song] = {
    DB.withConnection { implicit connection =>
      val song = SQL("select * from songs order by votes desc limit 1 ").as(Song.simple.singleOpt)
      song.foreach{ s =>
        SQL(" update songs set votes = 0 where id = {id} ").on('id -> s.id).executeInsert()
      }
      song
    }
  }





}

