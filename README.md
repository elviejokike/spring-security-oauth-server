### Spring Security OAuth - Authorization Server

### Introduction

The Authorization Server is a simple implementation of the OAuth2 Authorization server based on Spring Boot.
This application can be used as a reference of how to use Spring Boot capabilities for rapid prototyping / development
of server based applications.

In addition to the  [Spring boot OAuth2](https://spring.io/projects/spring-boot)  framework, this project also features:

- [Redis](https://redis.io/) for Token Store
- [Flywaydb](https://flywaydb.org/) for DB migration
- [JPA Data](https://spring.io/guides/gs/accessing-data-jpa) for data management

In addition, this authorization server works also as a OAuth Resource Server allowing client applications to use
the users and client management REST API.


#### Configuration

| Name | Description | Default value |
|------|-------------|---------|
| service.admin.password | Default admin password | s3cr3To!  |


