# Basics of work with messaging service `Apache-Kafka`

## First Work with Apache-Server and Zookeper

### Apache-Server start process

**Run the apache-kafka in docker**
+ Get the Docker image of Apache Kafka Docker Image from docker hub.

```command
$docker pull apache/kafka:3.8.0
```

+ Run the Apache-kafka (Zookeper will run there)

```
docker run -p 9092:9092 apache/kafka:3.8.0
```

> [!NOTE]
> download apache-kafka tar file and set the apache kafka bin into `classpath` then directly run this commands

**To create a toppic**

> $kafka-topics --create --topic quickstart-events --bootstrap-server localhost:9092

**To describe the toppic**

> $kafka-topics --describe --topic quickstart-events --bootstrap-server localhost:9092

**Produce the toppic**

> $kafka-console-producer --topic quickstart-events --bootstrap-server localhost:9092 (run on one terminal)

**Consume the toppic**

> $kafka-console-consumer --topic quickstart-events --from-beginning --bootstrap-server localhost:9092(run on another terminal)

Now we are going to use groups to read the messages

**Read the from Starting**

> $kafka-console-consumer --bootstrap-server localhost:9092 --topic quickstart-events --group application_group --from-beginning

**Read from current message**

> $kafka-console-consumer --bootstrap-server localhost:9092 --topic quickstart-events --group application_group

**To see List of groups**

> $kafka-consumer-groups --bootstrap-server localhost:9092 --list

**To describe about the group**

> $kafka-consumer-groups --bootstrap-server localhost:9092 --group second-group --describe

** Consumer group `second-group` has no active members.**

|GROUP |TOPIC |PARTITION |CURRENT-OFFSET | LOG-END-OFFSET| LAG | CONSUMER-ID | HOST | CLIENT-ID |
|---|---|---|---|---|---|---|---|---|
|second-group |quickstart-events | 0 |26 | 28 | 2 | - | - | - |

> [!NOTE]

> here lag-2 means we din't read 2 messages now we can read,if we run the second-group the two LAG will print there

+ here if we run the describe group second-group then the LAG will 0
+ we can --reset the groups as well

## Java

Kafka Producer ->  configuration
i. key.serializer
ii.value.serializer
iii. bootstrap.servers
iv. buffer.memory
v. compression.type
