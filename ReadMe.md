# Demo Project Book API

### Intro
Demo POC project for GraphQl + Spring Boot. 
The project uses graphql to create a simple book and author schema to demonstrate the use of GraphQl
Query, Mutation functionality.

### Requirements
- Java 11
- Basic Knowledge of GraphQl and Spring boot
- Intellij or IDE of your choice
- Postman for testing the API

### What is GraphQl?

GraphQl is a query language that can be used to develop APIs which uses a different approach than the trditional
REST APIs. Unlike traditional REST APIs GraphQl allows the client to specify which data required and thus allowing multiple 
queries in a single request. This helps to develop light weight manageable APIs. 

Official documentation: [GraphQL](https://graphql.org/)

### How to execute
To run the project and execute queries follow below steps:
 * maven clean build
 * 
``
mvn clean build
 ``
 * In terminal cd the Root folder of project where we have docker-compose.yml
 * 
``
docker-compose up -d
 ``
 * the endpoint exposed at : [localhost](http://localhost:8080/graphql)
 * postman or any Http client can be used to test the graphql queries

To stop all containers

``
docker-compose down
``

 
 ###  Example of some queries/mutations:
Note all queries and mutations in GraphQl are post Http requests.

#### Why only Post?
Well, there are few reasons:
* GraphQl itself is transport-agnostic, it's not specific to HTTP. A GraphQl service can execute documents outside the context of network requests.
* There is no body in a GET request, which means the query, variables and operation name all have to be set through query parameters which
  can easily cause server to return 414 status(URI too long)


##### Query example 
 get all books
 ```
  query {
  allBook{
    id
    name
    pageCount
  }
  }
```

get book with author
``` 
{
  allBook{
    id
    name
    pageCount
    author(order:DESC) {
        firstName
        starRating
    }

  }
  }
```

* Mutation example

create new book
```
mutation{
    newBook(input: {
        name: "Java World v3",
        pageCount: "200"
    }){
        name
        pageCount
    }
}
``` 

delete book
```
mutation{
    deleteBook(input: {
        id: 3
    }){
        name
        pageCount
    }
}
```
