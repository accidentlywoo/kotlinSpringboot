#!/usr/bin/env bash
echo "hello maeve"

echo "mysql image download & run"

sudo docker pull mysql

sudo docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 --name mysqlTest mysql:latest --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

sudo docker ps -a

exit 0