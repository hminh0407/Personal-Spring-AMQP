# Personal-Spring-AMQP
Personal usages - Spring AMQP example

## Spring Integration AMQP Basic
### Workers

**Description**

Basic example that using Spring integration and AMQP as round robin load balance.
Using multiple workers listen to one queue

**Run with mvn execute plugin**
* Run publisher: mvn exec:java -Dexec.args=publisher
* Run worker1  : mvn exec:java -Dexec.args=subscriber
* Run worker2  : mvn exec:java -Dexec.args=subscriber

**Example output**

publisher's console input:
* 1
* 2
* 3
* 4
* 5

worker1 console output:
* 1
* 3
* 4

worker2 console output:
* 2
* 5
