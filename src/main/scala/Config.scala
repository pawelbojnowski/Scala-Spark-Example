import org.apache.spark.sql.cassandra._
import org.apache.spark.sql.{DataFrame, SparkSession}

import java.util.Properties

class Config {


  def loadFromCockroach(keyspace: String, table: String): DataFrame = {
    sparkSession
      .getOrCreate().read.format("jdbc")
      .option("url", "jdbc:postgresql://localhost:26257/defaultdb?user=root&password=rootPort=26257")
      .option("dbtable", s"${keyspace}.${table}")
      .option("driver", "org.postgresql.Driver")
      .load()
  }

  def loadFromMySql(keyspace: String, table: String): DataFrame = {
    val url = "jdbc:mysql://localhost:3306/"
    val propertiesMySQL = new Properties()
    propertiesMySQL.put("user", "root")
    propertiesMySQL.put("password", "root")
    sparkSession
      .getOrCreate()
      .read.jdbc(url + keyspace, table, properties = propertiesMySQL)
  }

  def loadFromCassandra(keyspace: String, table: String): DataFrame = {
    sparkSession
      .config("spark.cassandra.connection.host", "localhost")
      .getOrCreate()
      .read
      .cassandraFormat(table, keyspace)
      .load()
  }

  private def sparkSession = {
    SparkSession.builder()
      .appName("Spark Cassandra Example App")
      .config("spark.master", "local[*]")
      .config("spark.app.name", "sparkCassandraExampleApp")
  }
}
