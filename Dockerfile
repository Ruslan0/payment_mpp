FROM maven:3-alpine

WORKDIR /payment-gateway-api/

ADD docker/settings.xml /root/.m2/settings.xml
ADD pom.xml pom.xml

RUN mvn clean verify spring-boot:help surefire:help

ADD src src
RUN rm -rf src/*/resources/application-*.* && mvn clean package

ENTRYPOINT mvn swagger:generate spring-boot:run #-Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"

EXPOSE 8080