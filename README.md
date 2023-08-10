# Plan

## Goal  

Migrate my old currency conversion tool into a web-based tool. 

## Tech Stack - Incomplete  

Front: React, Material UI, Axios, SciChart(?), amCharts5(?),  

Back: Spring Boot, Spring Actuator, Spring Security, Spring Cloud, Resilience4J, Devtools, OpenFeign, SLF4J, JUnit, Mockito, Kafka(?), Docker, Kubernetes, database? 

MongoDB? - I've been learning a lot about MongoDB. I wanted to use it for retrieving large amounts of currency data, particularly data that will be used to populate graphs on the front-end. It would probably work great for that. However, I think it will cause problems in terms of the other ways that data can be used. A possible solution that includes the use of Mongodb is that I could use Postgres or MySQL to store all my data and then generate the graphh data and store it into MongoDB. I really want to use MongoDB (as a personal challenge), but I want to use it in a way that makes sense and doesn't cause problems. 

## Deployment Environments - Complete  

Front: Firebase

Back: Google Kubernetes Engine 

## Components - Incomplete  

Front: Login, Account Recovery, Charting(how many charts?), Conversions,  

Back: Authentication (authenticate user, create user, will access MySQL DB), Recover User Account (handle account recovery, will need to connect to MySQL DB) Chart Data (retrieve data for charts), WebScraper (gather currency related data), Database Generators (insert currency related data into MongoDB), Convert Data (conduct currency conversions, will need to access MongoDB for rates), MongoDB (hold and retrieve currency data), MySQL DB (will hold user data),  

## Research

Learn Spring Data for MongoDB. (in progress)

I need to decide on a specific charting library to use. It will need to be able to handle a significant number of data points. 

Implement some sort of testing on the front-end. 

I want to see if I can use Kafka to setup a data stream that will show users who and what conversions were conducted in real time. I think this could look like a smaller banner that stretches across the bottom of the UI with conversions slowly moving across the screen. I'd probably want to limit this feature to the most recent 100(ish) conversions. 

# TODO: Determine entity structures, determine how componenets will communicate with each other, get a rough idea of what http requests will be needed, ?