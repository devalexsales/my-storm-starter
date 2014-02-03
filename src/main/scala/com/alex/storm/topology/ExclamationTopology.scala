package com.alex.storm.topology

import backtype.storm.testing.TestWordSpout
import backtype.storm.topology.TopologyBuilder
import com.alex.storm.bolt.ExclamationBolt
import backtype.storm.{LocalCluster, Config}
import backtype.storm.utils.Utils

object ExclamationTopology {
  def main(args: Array[String]) {
    val builder = new TopologyBuilder

    builder.setSpout("word", new TestWordSpout(), 10)
    builder.setBolt("exclaim", new ExclamationBolt(), 3).shuffleGrouping("word")

    val config = new Config()
    config.setDebug(true)

    val cluster = new LocalCluster()

    cluster.submitTopology("ExclamationTopology", config, builder.createTopology())
    Utils.sleep(5000)
    cluster.killTopology("ExclamationTopology")
    cluster.shutdown()

  }
}
