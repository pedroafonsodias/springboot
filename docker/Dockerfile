#Build stage
FROM gradle:latest AS BUILD

ARG CERT="zscaler.pem"

ADD $CERT $CERT

RUN keytool -importcert -file $CERT -alias $CERT -cacerts -storepass changeit -noprompt
WORKDIR /usr/app/
COPY . .
RUN gradle build

# Package stage
FROM public.ecr.aws/amazoncorretto/amazoncorretto:17
ARG CERT="zscaler.pem"

ADD $CERT $CERT

RUN keytool -importcert -file $CERT -alias $CERT -cacerts -storepass changeit -noprompt
ENV JAR_NAME=springboot-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/build/libs/
COPY --from=BUILD $APP_HOME/$JAR_NAME .
EXPOSE 8080
ENTRYPOINT exec java -jar $JAR_NAME