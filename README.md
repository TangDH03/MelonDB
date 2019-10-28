##MelonDB

A database project implemented by Java,it's not complicated and not very fast.

I used this project to familiar with Java,so it may be useless.

##Quick start

1. create the table
```java
DB db = new MelonDB();
db.creatingMelon("User");
```
2. using table
```java
DB db = new MelonDB();
db.usingMelon("Item");
```
3. delete table
```java
db.deleteMelon("Item");
```
4. add some data into database
>the data in database was prensented by Json,such as
>{"name":"hello,world"}
>Key is String type, value is String,Integer,Double,Boolean.
```java
DB db = new MelonDB();
db.usingMelon("User");
String s1 = "{\"name\":\"tangdh\",\"age\":13}";
db.add(s1);
//Or you can add data like below
db.add("\"name\"","\"tangdh\"","\"age\"","13);
```
5. delete data
```java
db.delete("\"name\"","\"tangdh\"","\"age\"","13");
//Or you can delete data like below
db.delete("\"name\"","\"tangdh\"","\"age\"","13);
```
6. search
```java
//you can search the data with field,it will return List<Json>
db.search("\"name\"","\"tangdh\"");
```
7. change
you can only change data with specified json,not field,later i will add the function to support it.
```java
String s1 = "{\"name\":\"tangdh\",\"age\":13}";
String s3 = "{\"tall\":18.189,\"age\":16}";
db.change(s1,s3);
```
TODO
- [ ] add support of field search
- [ ] add annotation support of data
- [ ] add a Thread to save data
- [ ] make it faster
- [ ] make it easy to use
- [ ] still thinking

If you think it's interesting,star it
##Welcome to issue and PR