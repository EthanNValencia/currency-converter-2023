# Plan

## Goal  

Migrate my old currency conversion tool (https://github.com/EthanNValencia/Currency_Converter) into a web-based tool. 

## Tech Stack - Incomplete  

Front: React, Material UI, Axios, SciChart(?), amCharts5(?),  

Back: Spring Boot, Spring Actuator, Spring Security, Spring Cloud, Resilience4J, Devtools, OpenFeign, SLF4J, JUnit, Mockito, Kafka(?), Docker, Kubernetes, MySQL, MongoDB

MongoDB? - I've been learning a lot about MongoDB. I wanted to use it for retrieving large amounts of currency data, particularly data that will be used to populate graphs on the front-end. It would probably work great for that. However, I think it will cause problems in terms of the other ways that data can be used. A possible solution that includes the use of Mongodb is that I could use Postgres or MySQL to store all my data and then generate the graph data and store it into MongoDB. I really want to use MongoDB (as a personal challenge), but I want to use it in a way that makes sense and doesn't cause problems. 

## Deployment Environments - Complete  

Front: Firebase

Back: Google Kubernetes Engine 

## Components - Incomplete  

Front: Login, Account Recovery, Charting(how many charts?), Conversions,  

Back: Authentication (authenticate user, create user, will access MySQL DB), Recover User Account (handle account recovery, will need to connect to MySQL DB) Chart Data (retrieve data for charts), WebScraper (gather currency related data), Database Generators (insert currency related data into MongoDB), Convert Data (conduct currency conversions, will need to access MongoDB for rates), MongoDB (hold and retrieve charting data), MySQL (will hold user and currency data),  

## Research

Learn Spring Data for MongoDB. (in progress)

I need to decide on a specific charting library to use. It will need to be able to handle a significant number of data points. 

Implement some sort of testing on the front-end (Selenium?). 

I want to see if I can use Kafka to setup a data stream that will show users who and what conversions were conducted in real time. I think this could look like a smaller banner that stretches across the bottom of the UI with conversions slowly moving across the screen. I'd probably want to limit this feature to the most recent 100(ish) conversions. 

# TODO: Determine entity structures, determine how componenets will communicate with each other, get a rough idea of what http requests will be needed, ?

## Project Progress Report (7-8-2023 to 11-8-2023)

8100(cc-mongo-entry) serves as an entry point for 8000(cc-mongo-crud), 8001(cc-mongo-crud), 8002(cc-mongo-crud). Kubernetes will faciliate load balancing. I am planning on creating a webscraper to get historical currency exchange rates. That data will be stored in a MySQL database (review previous project). I want to create a charting data generator (review previous project). The generator will store the charting data in MongoDB through the cc-mongo-crud-service. 

Database: I just want to use MongoDB to retrieve datasets. Based on my limited experience with MongoDB, if I have to make complex commands -- it'll turn MongoDB into a OmgnoDb pretty quick. I just want to use MongoDB to pull that data and throw it at the front-end as fast as possible. So my idea is create a webscraper to get the data and store it in MySQL, to leverage the power of MySQL queries as much as possible, and to generate data that will be stored in Mongo. 

Current pathway(s): 

http://localhost:8100/cc-mongo-entry-feign/from/usd/to/eur/period/days <-> http://localhost:8000/cc-mongo-crud/from/usd/to/eur/period/days  <-> MongoDB 

Produced dataset: 
```
{
  "id": "string",
  "fromName": "string",
  "toName": "string",
  "calendricalPeriod": "string",
  "description": "string",
  "environment": "string",
  "currency": [
    {
      "fromRate": 0,
      "toRate": 0,
      "date": "2023-08-11"
    }
  ]
}
```