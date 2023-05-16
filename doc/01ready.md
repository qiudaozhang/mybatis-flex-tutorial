



准备一个数据，假设还没有，这里以mysql为例



```
docker run -itd --name mysql_demo -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e TZ=Asia/Shanghai  mysql   --default-authentication-plugin=mysql_native_password
```



