package com.alex.storm.bolt

import backtype.storm.topology.base.BaseRichBolt
import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.tuple.{Values, Fields, Tuple}
import java.util
import backtype.storm.task.{OutputCollector, TopologyContext}
import com.alex.storm.util.Exclaimer

class ExclamationBolt extends BaseRichBolt {

  var collector: OutputCollector = _

  override def prepare(config: util.Map[_, _], context: TopologyContext, collector: OutputCollector): Unit = {
    this.collector = collector
  }

  override def execute(tuple: Tuple): Unit = {
    this.collector.emit(tuple, new Values(Exclaimer.exclaim(tuple.getString(0))))
  }

  override def declareOutputFields(declarer: OutputFieldsDeclarer): Unit = {
    declarer.declare(new Fields("word"))
  }
}
