# Apache Kafka Server 
## Topics, partitions and offsets
1. Topics: a particular stream of data
  - Similar to a table in a database (without all the constraints)
  - You can have as many topics as you want
  - A topic is identified by its ***name***
2. Topics are split in *partitions*
  - Each partition is ordered
  - Each message within a partition gets an incremental id, called **offset**
