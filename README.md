Index:

Goto ./kafka-concepts-coding/1_concepts_learning.md for individual topic list

# [Concept Learning](./kafka-concepts-coding/1_concepts_learning.md)

1) [Introduction To Kafka](./kafka-concepts-coding/src/main/learning/1_introduction)
2) [Kafka Architecture and Features](./kafka-concepts-coding/src/main/learning/2_architecture)
3) [Installation and setup](./kafka-concepts-coding/src/main/learning/3_InstallationAndSetup)
4) [Topic creation | console Producers | console consumers](./kafka-concepts-coding/src/main/learning/4_TopicAndConsoleProducerConsumer)
5) [Zookeeper Cluster Setup | 3 ZK Node Cluster | Local machine](./kafka-concepts-coding/src/main/learning/5_ZK_Cluster_Setup)
6) [Kafka Cluster Setup | 3 Kafka Node Cluster | Local machine](./kafka-concepts-coding/src/main/learning/6_Kafka_Cluster_Setup)
7) [Internals of Topics, Partitions and Replication](./kafka-concepts-coding/src/main/learning/7_InternalsOfTopicsPartitionsAndReplication)
8) [Internals of Kafka Producer | Offsets in Kafka](./kafka-concepts-coding/src/main/learning/8_Internals_of_Kafka_Producer_Offsets_in_Kafka)
9) [Internals of Kafka Consumer](./kafka-concepts-coding/src/main/learning/9_Internals_of_kafka_Consumer)
10) [Internals_of_Consumer_Group](./kafka-concepts-coding/src/main/learning/10_Internals_of_Consumer_Group)
11) [Demo_Producers_Consumers](./kafka-concepts-coding/src/main/learning/11_Demo_Producers_Consumers)
12) [Producer_Configs](./kafka-concepts-coding/src/main/learning/12_Producer_configs)
13) [Consumer_Configs](./kafka-concepts-coding/src/main/learning/13_Consumer_configs)
14) [Troubleshooting_Issues](./kafka-concepts-coding/src/main/learning/14_troubleshooting_issues)


# Quick commands:

1) Start zookeeper: zkServer.cmd

2) Start Kafka: D:\kafka\Kafka_node-1\bin\windows\kafka-server-start.bat D:\kafka\Kafka_node-1\config\server.properties

3) Create Topic: kafka-topics.bat --bootstrap-server localhost:9092 --create --topic myTopic --partitions 1 --replication-factor 1

4) Start Producer: kafka-console-producer.bat --bootstrap-server localhost:9092  --topic myTopic

5) Start console consumer: kafka-console-consumer.bat --bootstrap-server localhost:9092  --topic myTopic --from-beginning


# Coding

1) [Create Topic from Bean config](./kafka-concepts-coding/src/main/java/com/home/kafka/learning/config/KafkaTopicConfig.java)
2) [SSL Config](./kafka-concepts-coding/src/main/java/com/home/kafka/learning/actual/project/config/KafkaSslConfig.java)
3) [Consumer Code](./kafka-concepts-coding/src/main/java/com/home/kafka/learning/consumer)
4) [Producer Code](./kafka-concepts-coding/src/main/java/com/home/kafka/learning/producer)
5) [Application Properties](./kafka-concepts-coding/src/main/resources/application.properties)
6) [Post endpoint to publish Json Message](./kafka-concepts-coding/src/main/java/com/home/kafka/learning/controller/JsonMessageController.java)
7) [Get endpoint to publish String Message](./kafka-concepts-coding/src/main/java/com/home/kafka/learning/controller/MessageController.java)

# Real-World Project to stream data

Read data from Wikimedia
Link : https://stream.wikimedia.org/v2/stream/recentchange
