# kafka

## Compatibility

java jdk 11

## Installation

cd kafka_2.13-2.6.0 (depending on the version of Kafka)

## Start Zookeeper
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

## Read
bin/kafka-console-consumer.sh --topic streams-pipe-output --from-beginning --bootstrap-server localhost:9092

## Coding a Stream application
https://github.com/charroux/kafka/tree/main/stream
