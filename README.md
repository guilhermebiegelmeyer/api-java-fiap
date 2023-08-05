# fiapproject-api
## URL's publicadas:
### GET:
#### http://localhost:8080/student
### POST:
#### http://localhost:8080/student
```
{
    "name": "Guilherme Biegelmeyer"
}
```
### PUT:
#### http://localhost:8080/student/{id}
```
{
    "name": "Guilherme Biegelmeyer"
}
```
### DELETE:
#### http://localhost:8080/student/{id}

## ----###SUPORTE PARA RODAR LOCAL###----

<p>Command create and run Docker:</p>

```docker run -d -p 3306:3306 --name mysql-fiap-dev -e MYSQL_ROOT_PASSWORD=fiap-dev -e MYSQL_DATABASE=fiapprojectsevicedb -e MYSQL_USER=fiap -e MYSQL_PASSWORD=fiap mysql/mysql-server:latest```