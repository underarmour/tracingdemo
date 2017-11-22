# Tracing Demo
This Spring Boot app reproduces the issue with the grpc lightstep tracer as we intend to use it with our Spring Boot apps.

## Prereqs
* gradle 4
* java 8+

## To run
1. clone this repo
2. execute `gradle bootRun`
3. curl requests: `curl -i http://localhost:8080/greeting` (you'll get an empty response, but you should see traces coming through)