import org.apache.spark.sql.cassandra._
import org.apache.spark.sql.{DataFrame, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

import java.util.Properties

object Config {

  //config
  val conf = new SparkConf().setAppName("SparkCassandraExampleApp")
  conf.set("spark.master", "local[*]")
  conf.set("spark.app.name", "exampleApp")


  //mysql
  val url = "jdbc:mysql://127.0.01:3306/"
  val properties = new Properties()
  properties.put("user", "root")
  properties.put("password", "root")


  //cassandra
  conf.set("spark.cassandra.connection.host", "127.0.0.1")
  val sc = new SparkContext(conf)
  val sqlContext = new SQLContext(sc)

  def loadFromMySql(keyspace: String, table: String): DataFrame = {

    sqlContext.read.jdbc(url + keyspace, table, properties = properties)
  }

  def loadFromCassandra(keyspace: String, table: String): DataFrame = {

    sqlContext
      .read
      .cassandraFormat(table, keyspace)
      .load()
  }
}
