### host配置

```properties
# cas-server地址
127.0.0.1 login.cas.com
# 服务1地址
127.0.0.1 client1.cas.com
# 服务2地址
127.0.0.1 client2.cas.com
```

### nginx配置

```nginx
    server {
        listen       80;
        server_name  login.cas.com;
        
        location / {
            proxy_pass http://127.0.0.1:8443/;
        }
    }

    server {
        listen       80;
        server_name  client1.cas.com;
        
        location / {
            proxy_pass http://127.0.0.1:8080/;
        }
    }
    
    server {
        listen       80;
        server_name  client2.cas.com;
        
        location / {
            proxy_pass http://127.0.0.1:8081/;
        }
    }
```

### 启动cas-sever

```bash
# 在终端中使用build.cmd run运行cas-server
E:\IDE\IdeaProjects\myDemo\cas-demo-all\cas-server>build.cmd run
```

### 参考

https://blog.csdn.net/oumuv/article/details/83377945

