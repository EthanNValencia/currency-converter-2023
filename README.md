# Plan

## Goal  

Migrate my old currency conversion tool into a web-based tool. 

## Tech Stack - Incomplete  

Front: React, Material UI, Axios, SciChart(?), amCharts5(?),  

Back: Spring Boot, Spring Actuator, Spring Security, Spring Cloud, Resilience4J, Devtools, OpenFeign, SLF4J, JUnit, Mockito, Kafka(?), Docker, Kubernetes, MongoDB, ~~MySQL~~(I want thinking about using MySQL for user credentials, like how Keycloak uses Postgres, but why not not just use Mongo?), 

## Deployment Environments - Complete  

Front: Firebase 

Back: Google Kubernetes Engine 

## Components - Incomplete  

Front: Login, Account Recovery, Charting(how many charts?), Conversions,  

Back: Authentication (authenticate user, create user, will access MySQL DB), Recover User Account (handle account recovery, will need to connect to MySQL DB) Chart Data (retrieve data for charts), WebScraper (gather currency related data), Database Generators (insert currency related data into MongoDB), Convert Data (conduct currency conversions, will need to access MongoDB for rates), MongoDB (will hold currency related data), MySQL DB (will hold user data),  

## Research

I need to decide on a specific charting library to use. It will need to be able to handle a significant number of data points. 

Implement some sort of testing on the front-end. 

I want to see if I can use Kafka to setup a data stream that will show users who and what conversions were conducted in real time. I think this could look like a smaller banner that stretches across the bottom of the UI with conversions slowly moving across the screen. I'd probably want to limit this feature to the most recent 100(ish) conversions. 

# TODO: Determine entity structures, determine how componenets will communicate with each other, get a rough idea of what http requests will be needed, ?