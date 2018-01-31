# Hadoop-Basic-Codes
This repo contains basic Hadoop Codes written in Java.

### Usage

Run commands mentioned below in terminal,

1) Start Hadoop
```
>> sudo systemctl start sshd
>> start-dfs.sh
>> start-yarn.sh
```

2) Execute below command to see the working nodes in the system
```
>> jps
```

3) Make new directory for the every hadoop program
```
>> hdfs dfs -mkdir /wordCount
```

4) Now, add input file into the directory made above
```
>> hdfs dfs -put /home/vitchennai/Desktop/input.txt /wordCount/input.txt
```

5) Finally, run the hadoop program by entering the command mentioned below
```
>> hadoop jar Desktop/wordCount.jar Driver /wordCount/input.txt /wordCount/output
```
