tomcat
```
server.port=9999
server.tomcat.connection-timeout=1
```

reactive
```
server.port=8888
trace=true
```

ab -c 10 -n100 http://127.0.0.1:8888/test

```
2020-07-24 22:02:17.912  WARN 53538 --- [or-http-epoll-8] r.netty.http.client.HttpClientConnect    : [id: 0x0733a115, L:/127.0.0.1:60018 ! R:127.0.0.1/127.0.0.1:9999] The connection observed an error

reactor.netty.http.client.PrematureCloseException: Connection prematurely closed BEFORE response
```
