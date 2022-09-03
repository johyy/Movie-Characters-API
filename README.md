# Assignment 3: Create a Web API and databse with Spring - Movie Characters API

[![standard-readme compliant](https://img.shields.io/badge/standard--readme-OK-green.svg?style=flat-square)](https://github.com/RichardLitt/standard-readme)
[![Java](https://img.shields.io/badge/-Java-red?logo=java)](https://www.java.com)
[![Spring](https://img.shields.io/badge/-Spring-white?logo=spring)](https://spring.io/)

This is a Spring Boot Application using a PostgreSQL database. This application is the third assignment
of the backend part of the [Noroff](https://www.noroff.no/en/) Full-Stack developer course.  
 
## Table of Contents

- [Background](#background)
- [Install](#install)
- [Maintainers](#maintainers)

## Background

The task was to create a datastore and interface to store and manipulate movie characters. This application was to be constructed in Spring Web and comprise of a datamase made in PostgreSQL through Hibernate with a RESTful API to allow users to manipulate the data.

### Business rules and requirements

Rules:
1. The database should store inofrmation about characters, movies they appear in, and the franchises these movies belong to.
2. One movie could contain many characters, and a character could play in multiple movies. 
2. One movie should belong to one franchise, but a franchise could contain many movies.
3. Full CRUD is excpected for Movies, Characters, and Franchises.
4. It should be also be possible to update characters in a certain movie, and movies in a certain franchise.
5. It should be possible to get all the movies in a franchise, all the characters in a movie and all the characters in a franchise.
6. Domain and business logic should be encapsulated in Services and Repositories.
7. Documentation should be created usinf Swagger / Open API.
8. A CI/CD pipeline should be built as a Docker artifact, and a second job should be added to deploy the application to Heroku with a manual trigger.

Data requirements:

_Character:_
- Autoincremented Id
- Full name
- Alias (if applicable)
- Gender
- Picture (URL to photo)

_Movie:_
- Autoincremented Id
- Movie title
- Genre (just a simple string of comma separated genres)
- Release year
- Director (just a string name, no director modelling required as a base)
- Picture (URL to a movie poster)
- Trailer (YouTube link most likely)

_Franchise:_
- Autoincremented Id
- Name

## Install

This project was generated with OpenJDK version 17.0.4.1 through Spring Initializr and Gradle build system. 
Clone repository via `git clone`.

## Maintainers

[@Joni Kokko](https://gitlab.com/joniko)
[@Jonna Hyypiä](https://gitlab.com/johyy)
