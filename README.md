# 1.Description

Final project for Kodilla Course. Backend mechanics for aircraft turnaround routine program. 
Program is implemented in REST architecture and imports data from 2 APIs - AviationStack and OpenWeatherMap.

# 2.Demo

Project is not publicly aviable at this moment, and exists only in this GitHub repo.


# 3.Requirements

- Java 8
- MySQL 8 server
- SpringBoot 2.3.7
- Lombok 1.18
- Swagger2 2.7.0
- Active internet connection for API pursposes

# 4.Application Startup
Project can be launched locally by executing KodillaFinalProjectApplication. 
While running, program can be accessed under [localhost](http://localhost:8080/), or tested via Postman.

# 5.Endpoint description

Full endpoints description is avaiable [here](http://localhost:8080/swagger-ui.html) 
when the application is running.

# 6.Usage

At this point project imports real-time data of landed aircrafts on Keflavik Airport, 
and real-time weather information from the same area, to determine possibilities for aviation operation. 
Project covers (simplyfied) working daily basis routine at the airport, and covers following departments 
- Ground, Cleaning, Catering, Fueling, Passeneger and Maintenance. After creating a Loading Supervisor in DB,
it is possible to assign specific aircraft to turnaround, which leads to sending to assigned Loading Supervisor an e-mail
notification about aircraft information. If the aircraft is ready to be push back onto taxiway, program automatically 
checks latest weather to specify if further aviation operations are possible. Due to used Scheduler, weather is 
updated every 5 minutes to provide always most accurate weather. 

Further developing of the application covers following:

- Frontend layer in Vaadin
- Solving problems connected to importing real-time flight data only from current day, 
not also from day before today, which further leads to duplicate flight numbers (yesterday's and today's flight)
- Separting application into independent microservises, each for every department
- Preparing wider tests to cover all controllers and services

# 7.Troubleshooting

Due to bug - when importing latest information about landed planes, API returns landed planes from current day, 
and the day before, which are not filtered during saving to the DB - which may leads to duplication of flight 
number in DB, and can cause problems during assigning aircraft with duplicated flight numbers to Loading Supervisor. 
For testing purposes it is recommended to use unique flight numbers only. Problem will be solved in latest versions. 
