# Prerequisites:

- Start zookeeper cluster
- Start kafka cluster
- Create Topic

![1_Create_topic.png](1_Create_topic.png)

- Describe topic

![img.png](2_Describe_Topic.png)


- Create producer and consumer with consumer group myGroup:

![img.png](3_Create_Producer_Consumer.png)

- publish messages from producer and consumed by consumer

![img.png](4_Publish_messages.png)

- Describe consumer group - Same consumer id is subscribing to all partition as we have only one consumer running 

![img.png](5_Describe_CG.png)

- create one more consumer under same CG

![img.png](6_Create_2-Consumer.png)

- describe CG - in this first consumer(1f) is subscribing 2 partition 0,1 and new consumer(a5) is subscribing partition 2

![img.png](7_describe_consumer_group.png)

- start 3rd  consumer(b7) and describe it

![img.png](8_3rd_consumer.png)


- publish more message and see whether it is consumed in round-robin fashion to all consumers
- first 3 message were published when only 1 consumer was active

![img.png](9_check_message_consumer_in_round_robin.png)


- start 4th consumer so that 1 will sit ideal(it can be existing one) and describe it



