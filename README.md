# Purchase Order Service API

An API that provides information about existing purchase orders.

## Implemented Features

1.  Given a list of purchase order ids calculate either total weight or volume based on the specific id - use asynchronous request, i.e use multiple threads
(../async/totals)
2.  Given a list of purchase order ids calculate either total weight or volume based on the specific id - use parallel processing, i.e use multiple cores (../test)
3. Basic Authentication is enabled for incoming requests: see SecurityConfiguration for the details.
4. Basic Authentication is enabled for outgoing requests: RestTemplete has been configured for the TEST API.

## Usage

Start the application.

Post a request body containing information in this format:
 ```json
 { "purchase_order_ids": [2344, 2345, 2346] }
  ```
You will receive a response body in this format:
 ```json
  {"result": [    {"product_type_id": 1, "total": 41.5},    {"product_type_id": 2, "total": 13.8},    {"product_type_id": 3, "total": 25.0} ] }
```

Note your request must include a basic authentication details and content-type of application/json.

## Technologies

- Java 8
- Spring MVC, Boot
- Maven
- Spock (unit and integration testing framework)
- Groovy 
- Jackson/JSON (under the hood - we are maximising Spring's built in support)

NB: You must have Java 8 to run this application, you must have Maven installed to build this application (mvn package).  I had intended to add a Docker file which would allow you to run anywhere Docker is installed but I ran out of time.

## URLS

### Local

http://localhost:8080/test

http://localhost:8080/async/totals

### Running Locally

From an IDE run the PurchaseorderapiApplication class. 

Note that we are using Spring Profiles for configuration, this means
you will need to make sure "application.properties" is pointing at
"application-local.properties" when running locally.  This is to remind us that all environmental properties are externalised so they can be updated without application re-deployment.

### Run from command line

java -jar purchaseorderapi.jar

## Design Notes

We have attempted to front-load complexity into the design phase - that is we have chosen to design our way around complex issues now rather than deal with complexity via more code later. We are heavily leveraging what we get for free from Spring and Java 8. This is why we have modelled the remote API as a series of Java POJOs so that Jackson will serialise them and de-serialise them for us.

## Additional Notes

This code was written as a solution to a coding challenge. It has a dependency on a Remote API which is no longer available. However the code is a good example of using Spring's Jackson support to map a very complex domain and to extract only the data you need from an API which is not fine grained with one request.  

It also demonstrates taking advantage of multiple cores and coding asynchronous requests in Java 8 using Completable Futures.