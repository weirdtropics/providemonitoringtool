# Provide Monitoring Web Tool

This program is developed to check if your websites are up and running.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


### Installing

First at all you need JDK installed .
Next download application [build.zip](https://drive.google.com/open?id=1IEfgTCPWByWID-TyyYTjI8C-hEDwjUfw)
Extract and run: run-monitoring.sh :


```
unzip build.zip
sh ./run-monitoring.sh
```
After that you can open app on your local server(localhost:8080) or [webserver](https://providemonitoringtool.herokuapp.com) 

### How to use
Next, let's check if some websites works. 
First at all, you can add any website.You need to fill url and excepted http response inputs, also,you can set expected response size in bytes(min to max).
After filling fields press 'Add' button; 

As you can see, there is a table with your url ,expected response size and website status which updating every 2 seconds.
Status takes 2 values - OK - that means that your website is running and CRITICAL - means that your website is down;
Application will notify you with a ‘beep’ sound if status value is CRITICAL;

Interface allows you to add, delete, activate and deactivate urls.

App is connected to PostgreSQL database hosted on Heroku platform. 

Database credentials are harcoded as environment variables in run-monitoring.sh launch script

To run from source code open(sources.zip) or [download source code](https://drive.google.com/open?id=1HisVptiww-8yzX7Ile2Xd5QONEKZfUi4)
```
sh ./build-and-run.sh

```

## Built With

* [Spring](https://spring.io) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [JQuery](https://jquery.com) - JavaScript library designed to simplify the client-side scripting of HTML
* [PostgreSQL](https://www.postgresql.org) - Project database
* [Heroku](https://providemonitoringtool.herokuapp.com) - project on heroku server
* [IntelliJIDEA](https://www.jetbrains.com/idea/) - Project IDE 