# k8s-spring-hazlecast

## Once the hazlecast svc is up along with app pods you will be able to see the logs in app as below
```
021-01-14 22:54:49.873  INFO 1 --- [.IO.thread-in-0] c.h.internal.nio.tcp.TcpIpConnection     : [172.17.0.7]:5701 [dev] [4.0.2] Initialized new cluster connection between /172.17.0.7:33421 and /172.17.0.6:5701
2021-01-14 22:54:55.817  INFO 1 --- [ration.thread-0] c.h.internal.cluster.ClusterService      : [172.17.0.7]:5701 [dev] [4.0.2] 

Members {size:3, ver:3} [
	Member [172.17.0.6]:5701 - 94191eb4-f0d5-49b5-8ba8-df3d260bd6fb
	Member [172.17.0.7]:5701 - 109804e8-fbe9-49e8-a5c4-3b7496c91c0f this
	Member [172.17.0.5]:5701 - 55452869-ba6b-4977-8ec4-1e1f1975f104
]
```

