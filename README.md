# kafka

## Compatibility

java jdk 11

## Installation

Download Kafka: https://www.apache.org/dyn/closer.cgi?path=/kafka/2.6.0/kafka_2.13-2.6.0.tgz

tar -xzf kafka_2.13-2.6.0.tgz

cd kafka_2.13-2.6.0

## Start Zookeeper
ZooKeeper allows distributed processes to coordinate with each other through a shared hierarchical name space of data registers (we call these registers znodes), much like a file system. Unlike normal file systems ZooKeeper provides its clients with high throughput, low latency, highly available, strictly ordered access to the znodes. The performance aspects of ZooKeeper allow it to be used in large distributed systems. The reliability aspects prevent it from becoming the single point of failure in big systems. Its strict ordering allows sophisticated synchronization primitives to be implemented at the client.

bin/zookeeper-server-start.sh config/zookeeper.properties

Ctr-c to stop

## Start Kafka broker
bin/kafka-server-start.sh config/server.properties

Ctr-c to stop

If the broker hasn't been stoped properly stop it with: 
bin/kafka-server-stop.sh
Then restart it.

## Create topics
bin/kafka-topics.sh --create --topic streams-plaintext-input --bootstrap-server localhost:9092

bin/kafka-topics.sh --create --topic streams-pipe-output --bootstrap-server localhost:9092
 
## Write 
bin/kafka-console-producer.sh --topic streams-plaintext-input --bootstrap-server localhost:9092

Ctlr-c to stop.

## Read
bin/kafka-console-consumer.sh --topic streams-pipe-output --from-beginning --bootstrap-server localhost:9092

Ctrl-c to stop.

## Coding a Stream application
https://github.com/charroux/kafka/tree/main/stream

Ctrl-c to stop.

## Coding a consumer application
https://github.com/charroux/kafka/tree/main/consumer

Ctlr-c to stop.

## Coding a producer application
https://github.com/charroux/kafka/tree/main/producer


