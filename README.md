### How to run this.

1- Run the server class

2- Run the client class

#### Output of the script.
- Final Price = 
- count of accepted bids = 
- Count of dealers = 

#### 2 metric measurements to monitor the reliability of the service

- Number of Active Threads
  
  > this metric is too important, if the number of threads is high it means we will get spike in the CPU utilization, which will make the performance bad.
  
  
- Garbage collection Overhead
  > Frequent GC can mean poor performance as GC is a resource intensive process. It can also mean an underlying memory leak that needs to be addressed quickly.
     