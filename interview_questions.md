
## 1) How many thread consumers maintains in Kafka

Heartbeat Thread and Internal Poll Thread

### Heartbeat Thread: 

Heartbeats help to determine consumer liveliness.

1) if consumer is sending heartbeats at regular intervals (setting heartbeat.interval.ms), it is considered to be alive.
2) if consumer stops sending heartbeats for long enough (the session.timeout.ms setting), its session will time out and the group coordinator will consider it dead and trigger a re-balance.
3) The consumer heartbeat thread sends heartbeat messages to the consumer coordinator periodically. This behavior is controlled by two of the consumer configurations:

       heartbeat.interval.ms - (default is 3 seconds) The expected time between heartbeats to the consumer coordinator when using Kafka's group management facilities. 
       Heartbeats are used to ensure that the consumer's session stays active and to facilitate rebalancing when new consumers join or leave the group.

       session.timeout.ms (Kafka v3.0+: 45 seconds, Kafka up to v2.8: 10 seconds) The amount of time a consumer can be out of contact with the brokers while still considered alive. 
       If more than session.timeout.ms passes without the consumer sending a heartbeat to the group coordinator, 
       it is considered dead and the group coordinator will trigger a rebalance of the consumer group to allocate partitions from the dead consumer to the other consumers in the group.

These two properties are typically modified together.
heartbeat.interval.ms must be lower than session.timeout.ms, and is usually set to no more than one-third of the timeout value. 
So if session.timeout.ms is 3 seconds, heartbeat.interval.ms should be at most 1 second.

**max.poll.interval.ms:** (default 5 minutes) The maximum delay between invocations of poll() when using consumer group management.
This places an upper bound on the amount of time that the consumer can be idle before fetching more records.
If poll() is not called before expiration of this timeout, 
then the consumer is considered failed and the group will re-balance in order to reassign the partitions to another member. 
This setting is particularly relevant for frameworks that can take time to process data such as Apache Spark

**max.poll.records: (default 500)**

This controls the maximum number of records that a single call to poll() will return. 
This is useful to help control the amount of data your application will receive in your processing loop. 
A lower max.poll.records ensure you will call you next .poll() before the max.poll.interval.ms delay is reached.




### Internal Poll Thread:

Consumers poll brokers periodically using the .poll() method. 
If two .poll() calls are separated by more than max.poll.interval.ms time, then the consumer will be disconnected from the group.

## 2) What is partitioning key

Kafka uses topic partitioning to improve scalability. In partitioning a topic, Kafka breaks it into fractions and stores each of them in different nodes of its distributed system. 
That number of fractions is determined by us or by the cluster default configurations.


If the destination topic contains multiple partitions, the destination partition is picked according to the hash of the 
message key. If no explicit message key was set, a random one is generated, 
resulting in the messages being randomly spread across the partitions.

You can override this default behavior explicitly setting the target partition in the endpoint. 
The endpoint can be statically defined like in the following snippet or resolved via dynamic routing.

## 3) When we get QueueFullException in producer

whenever the Kafka Producer attempts to send messages at a pace that the Broker cannot handle at that time 
QueueFullException typically occurs. 
However, to collaboratively handle the increased load, users will need to add enough brokers(servers, nodes), 
since the Producer doesn't block.

## 4) Geo-replication in Kafka
## 5) ISR in kafka

ISR refers to the replicas of a partition that are “in sync” with the leader. 
The leader is the replica to which all client and broker requests are directed. 
The replicas that are not the leader are referred to as followers.

## 6) How do consumer consume messages in kafka
## 7) What does follower and leader in kafka mean

There are partitions in kafka. Every partition of a topic has a specified leader and multiple followers. The leader handles all incoming read and write requests for that specific partition, while the followers replicate the data from the leader passively.

## 8) what is role of offset in kafka

Kafka maintains a numerical offset for each record in a partition. This offset acts as a unique identifier of a record within that partition, and also denotes the position of the consumer in the partition.

## 9) can kafka be used without zookeeper

Kafka traditionally relies on Apache ZooKeeper to manage and coordinate distributed systems, including the Kafka brokers that make up a Kafka cluster. However, since version 2.8. 0, Kafka provides an option to run without ZooKeeper, using a feature called Kafka Raft Metadata mode.

## 10) How can kafka cluster be rebalanced
## 11) Maximum message size can a kafka server receive

- Kafka configuration limits the size of messages that it’s allowed to send. 
- By default, this limit is 1MB. However, if there’s a requirement to send large messages, 
we need to tweak these configurations as per our requirements.

![1_interview_questions.png](images%2F1_interview_questions.png)

**Producer Config:** need to update property "max.request.size"

      public ProducerFactory<String, String> producerFactory() {
         Map<String, Object> configProps = new HashMap<>();
         configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
         configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
         configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
         configProps.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "20971520");
         return new DefaultKafkaProducerFactory<>(configProps);
      }


**Topic config:** need to update the “max.message.bytes” property having a default value of 1MB.

      ./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic longMessage --partitions 1 --replication-factor 1 --config max.message.bytes=20971520

**Broker Config:** An optional configuration property, “message.max.bytes“, can be used to allow all topics on a Broker to accept messages of greater than 1MB in size.

Let’s add this property in Kafka Broker’s “server.properties” config file:

      message.max.bytes=20971520

## 12) How we can improve the throughput of consumer
## 13) what does it mean is replica is not an IN_SYNC for a long time
## 14) Kafka Schema registry


## 15) Multi-tenancy in kafka

## 16) Why kafka is pull based

Scalability was the major driving factor when we design such systems (pull vs push). Kafka is very scalable. One of the key benefits of Kafka is that it is very easy to add large number of consumers without affecting performance and without down time.

Kafka can handle events at 100k+ per second rate coming from producers. Because Kafka consumers pull data from the topic, different consumers can consume the messages at different pace. Kafka also supports different consumption models. You can have one consumer processing the messages at real-time and another consumer processing the messages in batch mode.

The other reason could be that Kafka was designed not only for single consumers like Hadoop. Different consumers can have diverse needs and capabilities.

Pull-based systems have some deficiencies like resources wasting due to polling regularly. Kafka supports a 'long polling' waiting mode until real data comes through to alleviate this drawback.


## 17) What do you mean by unbalanced kafka cluster? Leader Skew? Broker Skew?


## 18) BufferExhaustedException
When the producer can't assign memory to a record because the buffer is full, a BufferExhaustedException is thrown. If the producer is in non-blocking mode, and the rate of production exceeds the rate at which data is transferred from the buffer for long enough, the allocated buffer will be depleted, the exception will be thrown.

If the consumers are sending huge messages or if there is a spike in the number of messages sent at a rate quicker than the rate of downstream processing, an OutOfMemoryException may arise. As a result, the message queue fills up, consuming memory space.