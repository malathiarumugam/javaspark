Tomcat application bundle - Test App
====================================================
Sample application using gradle with tomcat plugin and spark endpoint. This is
not a production grade application, it's a simple test app. If you would like to
contribute simple do a PR.

## Todo:
  [X] Create app HTML layout
  [X] Mock HTML
  [X] Generate simple WAR file to start with
     [X] Create api with an echo functionality "http://localhost:8080/api/echo/"
     [X] Create api that returns users ip "http://localhost:8080/api/my_ip/[json,plan]"
  [ ] Service REST Service "http://localhost:8080/service"
     [ ] Add Services - "http://localhost:8080/service/add"
     [ ] Delete Service - "http://localhost:8080/service/Delete"
     [ ] Test Service - "http://localhost:8080/service/test/[Service Name]"

## Development
This test app uses the spark framework.

### Requiremts
  * Java
  * gradle

## Gradle information
You can generate IDEA project files with:
```
    gradle idea
```
You can create a war file with:
**You can find the war file in build/libs/**
```
    gradle war
```

You can instantiate a tomcat server and run it on port 8080 with:
```
    gradle tomcatRunWar
```
and then hit these urls:

- [http://localhost:9090/myapp/](http://localhost:9090/myapp/)  - serves up html5 boilerplate html file
- [http://localhost:9090/myapp/api/hello/ted](http://localhost:9090/myapp/api/hello/ted)  - hello world for "ted" served by java spark application, you can change the name
