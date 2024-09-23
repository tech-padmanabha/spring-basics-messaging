# Apache Kafka Server 
## Topics, partitions and offsets
1. Topics: a particular stream of data
   - Similar to a table in a database (without all the constraints)
   - You can have as many topics as you want
   - A topic is identified by its ***name***
2. Topics are split in *partitions*
   - Each partition is ordered
   - Each message within a partition gets an incremental id, called **offset**
3. Offset only have a meaning for a specific partition.
   - E.g. offset 3 in partition 0 doesn't represent the same data as offset 3 in partition I
4. Order is guaranteed only within a partition *(not across partitions)*
5. Data is kept only for a limited time *(default is one week)*
6. Once the data is written to a partition, it can't be changed `#ffffff(immutability)`
7. Data is assigned randomly to a partition unless a key is provided *(more on this later)*
[Folow the diagram](./data/offsets.png)

## Brokers
+ A Kafka cluster is composed of multiple brokers (servers)
+ Each broker is identified with its ID (integer)
+ Each broker contains certain topic partitions
+ After connecting to any broker (called a `bootstrap broker`), you will be connected to the entire cluster
+ A good number to get started is 3 brokers, but some big clusters have over 100 brokers
+ In these examples we choose to number brokers starting at 100 (arbitrary)

## Brokers and topics
+ Example of Topic-A with 3 partitions and Topic-B with 2 partitions

> [!NOTE]
> Data is distrubuted and Broker 103 doesn't have any Topic-B data

## Topic replication factor
+ Topics should have a replication factor > I (usually between 2 and 3)
+ This way if a broker is down, another broker can serve the data
Example: ```Topic-A with 2 partitions and replication factor of 2```

+ Example we lost Broker 102
+ Result: Broker 101 and 103 can still server the data
