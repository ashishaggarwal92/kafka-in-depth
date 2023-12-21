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










