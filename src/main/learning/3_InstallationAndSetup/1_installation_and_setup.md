### Kafka Installation

Require java 8 or higher version
Minimum RAM 512 mb
Kafka is written in JAVA and scala
We need JAVA and scala binary
Current version as of Dec, 2023 is 3.6.1

Download Apache Kafka from official page

![img.png](1_version_info.png)

Step 1: Download Scala 2.13 binary and check release notes for stable zookeeper version

Step 2: Download compatible zookeeper version 3.8.3 (Download bin.tar.gz file)

We first need to setup zookeeper then kafka cluster

from command line use command tar -xf filename

![img.png](2_zookeeper_folder_contents.png)

After extracting we need to start zookeeper server.

goto bin/zkServer.sh or bin/zkServer.cmd -> used for starting zookeeper server

It searches for config file in location conf/zoo.cfg

We need to create that file from sample

add property 4lw.commands.whitelist=* -> 4 letter words

Property meaning - 

clientPort=2181 (if any clients wants to connect zookeeper then it will use this port)
dataDir=tmp/zookeeper (whatever data zookeeper keep related to cluster resides in this. tmp is volatile dir so data removed after restart)


Now start zookeeper using bin/zkServer.sh start-foreground

this command takes other param like start/stop/start-foreground/restart/status/print-cmd




