Index:

# [Concept Learning](./1_concepts_learning.md)

1) [Introduction To Kafka](./src/main/learning/1_introduction)
2) [Kafka Architecture and Features](./src/main/learning/2_architecture)
3) [Installation and setup](./src/main/learning/3_InstallationAndSetup)
4) [Topic creation | console Producers | console consumers](./src/main/learning/4_TopicAndConsoleProducerConsumer)
5) [Zookeeper Cluster Setup | 3 ZK Node Cluster | Local machine](./src/main/learning/5_ZK_Cluster_Setup)
6) [Kafka Cluster Setup | 3 Kafka Node Cluster | Local machine](./src/main/learning/6_Kafka_Cluster_Setup)
7) [Internals of Topics, Partitions and Replication](./src/main/learning/7_InternalsOfTopicsPartitionsAndReplication)
8) [Internals of Kafka Producer | Offsets in Kafka](./src/main/learning/8_Internals_of_Kafka_Producer_Offsets_in_Kafka)
9) [Internals of Kafka Consumer](./src/main/learning/9_Internals_of_kafka_Consumer)
10) [Internals_of_Consumer_Group](./src/main/learning/10_Internals_of_Consumer_Group)
11) [Demo_Producers_Consumers](./src/main/learning/11_Demo_Producers_Consumers)
12) [Producer_Configs](./src/main/learning/12_Producer_configs)
13) [Consumer_Configs](./src/main/learning/13_Consumer_configs)
14) [Troubleshooting_Issues](./src/main/learning/14_troubleshooting_issues)


# Coding

Quick commands:

1) Start zookeeper: zkServer.cmd

2) Start Kafka: D:\kafka\Kafka_node-1\bin\windows\kafka-server-start.bat D:\kafka\Kafka_node-1\config\server.properties

3) Create Topic: kafka-topics.bat --bootstrap-server localhost:9092 --create --topic myTopic --partitions 1 --replication-factor 1

4) Start Producer: kafka-console-producer.bat --bootstrap-server localhost:9092  --topic myTopic

5) Start console consumer: kafka-console-consumer.bat --bootstrap-server localhost:9092  --topic myTopic --from-beginning
