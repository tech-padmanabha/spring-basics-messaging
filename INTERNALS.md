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
