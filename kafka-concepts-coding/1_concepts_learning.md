# kafka-in-depth
Repository For Kafka Understanding

1) [Introduction To Kafka](./src/main/learning/1_introduction)

- What is kafka
- Centralize vs Distributed
- Message streaming platform
- Messaging System
- Point to Point vs Publish Subscribe

2) [Kafka Architecture and Features](./src/main/learning/2_architecture)

3) [Installation and setup](./src/main/learning/3_InstallationAndSetup)
- Kafka Installation
- Zookeeper Installation
- Running single node Kafka CLuster
- Running single node zookeeper cluster
- sample zoo.cfg file for zookeeper
- sample server.properties file for kafka

4) [Topic creation | console Producers | console consumers](./src/main/learning/4_TopicAndConsoleProducerConsumer)
- Topic creation
- Validate/List Topic
- Describe Topic
- Create console Producer
- Create console Consumer
- Describe consumer group
- Kafka Consumer Offset Topic - Topic create dby Kafka to store consumer offset
- Create multiple producers and consumers on myTopic
- Create consumers on myTopic with custom consumer group

5) [Zookeeper Cluster Setup | 3 ZK Node Cluster | Local machine](./src/main/learning/5_ZK_Cluster_Setup)
- ZK Cluster Architecture
- ZK Cluster requirement
- Setting up ZK CLuster with 3 nodes
- Sample zoo.cfg for all 3 nodes of cluster
- Setting up unique id for each zk node

6) [Kafka Cluster Setup | 3 Kafka Node Cluster | Local machine](./src/main/learning/6_Kafka_Cluster_Setup)
- Basic
- System prerequisites
- Setting up kafka cluster with 3 nodes
- Properties change in order to setup kafka cluster
- Use cases
- Check Controller Node

7) [Internals of Topics, Partitions and Replication](./src/main/learning/7_InternalsOfTopicsPartitionsAndReplication)
- Controller Node in Kafka
- State of Partition
- State of Replica
- Increasing partitions of a topic(we cant decrease it)
- Reassigning partitions
- Move partition across brokers
- Change replication(Increase replication)
- Selectively move replica of a partition to a specific set of brokers

8) [Internals of Kafka Producer | Offsets in Kafka](./src/main/learning/8_Internals_of_Kafka_Producer_Offsets_in_Kafka)
- Internals when producer sends message
- Offset and types
- Metadata of message

9) [Internals of Kafka Consumer](./src/main/learning/9_Internals_of_kafka_Consumer)
- Consumer internals
- Current offset
- Committed offset
- Types of acknowledgement| Auto commit| manual commit

10) [Internals_of_Consumer_Group](./src/main/learning/10_Internals_of_Consumer_Group)
- Consumer Group Internals
- Use cases
- Consumer Group Re-balancing
- Process involved in consumer group rebalancing
- Group coordinator (Broker in kafka cluster)
- Group Leader
- What happens when a consumer join Consumer Group


11) [Demo_Producers_Consumers](./src/main/learning/11_Demo_Producers_Consumers)
- Internals of Producers Demo
- Internals of Consumers Demo
- Internals of Consumer Group Demo

12) [Producer_Configs](./src/main/learning/12_Producer_configs)
- bootstrap
- client.id
- key&value Serializer
- connections.max.idle.ms
- acks config
- compression.type
- batch.size
- linger.ms
- buffer.memory
- max.request.size


13) [Consumer_Configs](./src/main/learning/13_Consumer_configs)

- bootstrap.server
- client.id
- key & value Deserializer
- group.id
- fetch.min.bytes
- heartbeat interval
- session timeout
- max.partition.fetch.bytes
- fetch.max.bytes

14) [Troubleshooting_Issues](./src/main/learning/14_troubleshooting_issues)


# Quick commands:

1) Start zookeeper: zkServer.cmd

2) Start Kafka: D:\kafka\Kafka_node-1\bin\windows\kafka-server-start.bat D:\kafka\Kafka_node-1\config\server.properties

3) Create Topic: kafka-topics.bat --bootstrap-server localhost:9092 --create --topic myTopic --partitions 1 --replication-factor 1

4) Start Producer: kafka-console-producer.bat --bootstrap-server localhost:9092  --topic myTopic

5) Start console consumer: kafka-console-consumer.bat --bootstrap-server localhost:9092  --topic myTopic --from-beginning


# Coding

1) [Create Topic from Bean config](./src/main/java/com/home/kafka/learning/config/KafkaTopicConfig.java)
2) [SSL Config](./src/main/java/com/home/kafka/learning/actual/project/config/KafkaSslConfig.java)
3) [Consumer Code](./src/main/java/com/home/kafka/learning/consumer)
4) [Producer Code](./src/main/java/com/home/kafka/learning/producer)
5) [Application Properties](./src/main/resources/application.properties)
6) [Post endpoint to publish Json Message](./src/main/java/com/home/kafka/learning/controller/JsonMessageController.java)
7) [Get endpoint to publish String Message](./src/main/java/com/home/kafka/learning/controller/MessageController.java)









