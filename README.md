# workflowAPI

A web application to expose a REST API for workflows. 

# Installation 

## Step 1 : Install *MySQL* 

Follow this documentation : https://dev.mysql.com/downloads/installer/

## Step 2 : Create a database under MySQL named 'ncq'

## Step 3 : Download *Tomcat server* last version 

Follow this link : https://tomcat.apache.org/download-70.cgi

## Step 4 : Clone the project

## Step 5 : Build the project 

Build the project with `mvn clean install` 

## Step 6 : Copy the war package 
Copy the war package workflowAPI.war to the folder *$apache-tomcat_home/webapps*

## Step 7 : Start *tomcat* server

Execute `startup` command located in *$apache-tomcat_home/bin*

# Rest API is now reachable under www.localhost:8080/
