

object SparkExample extends Config{

  def main(args: Array[String]): Unit = {

    val personDF = loadFromCassandra("spark_scala_cassandra", "client")
    personDF.show()


    val billingDF = loadFromMySql("spark_scala_mysql", "billing")
    billingDF.show()

    val personDFWithRenamedColumn = billingDF.withColumnRenamed("form", "phone_number")
    val result = personDF.join(personDFWithRenamedColumn, Seq("phone_number"), "left")
    result.show()

    sc.stop()

  }

}
