
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
## 8) what is role of offset in kafka
## 9) can kafka be used without zookeeper
## 10) How can kafka cluster be rebalanced
## 11) Maximum message size can a kafka server receive
## 12) How we can improve the throughput of consumer
## 13) what does it mean is replica is not an IN_SYNC for a long time
## 14) Kafka Schema registry
## 15) Multi-tenancy in kafka
## 16) Why kafka is pull based
## 17) What do you mean by unbalanced kafka cluster? Leader Skew? Broker Skew? 
## 18) BufferExhaustedException