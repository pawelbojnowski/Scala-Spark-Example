
import org.apache.log4j._


object SparkExample extends Config {

  // Set the log level to only print errors
  Logger.getLogger("org").setLevel(Level.ERROR)

  def main(args: Array[String]): Unit = {

    val personDF = loadFromCassandra("spark_scala_cassandra", "client")
    personDF.show()


    val billingDF = loadFromMySql("spark_scala_mysql", "billing")
    billingDF.show()

    val personDFWithRenamedColumn = billingDF.withColumnRenamed("form", "phone_number")
    val result = personDF.join(personDFWithRenamedColumn, Seq("phone_number"), "left")
    result.show()


    val personDFCockroach = loadFromCockroach("spark_scala_cockroachdb", "billing")
    personDFCockroach.show()


  }

}
