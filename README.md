# Servlet webapp

Для сборки необходим [mvn](https://maven.apache.org/download.cgi) или [gradle](https://gradle.org/gradle-download/)

### maven
```sh
$ mvn clean install
$ mvn jetty:run # для остановки Ctrl+C
```
### gradle
```sh
$ ./gradlew build
$ ./gradlew jettyRunWar  # для остановки Ctrl+C и выполнить ./gradlew jettyStopWar
```
приложение доступно по адресу [http://127.0.0.1:8080/](http://127.0.0.1:8080/)
