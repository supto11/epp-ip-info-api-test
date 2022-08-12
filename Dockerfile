FROM openjdk

EXPOSE 9999

ADD ./build/libs/spring-boot-with-k8s-0.0.1-SNAPSHOT.jar /spring-boot-with-k8s-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "spring-boot-with-k8s-0.0.1-SNAPSHOT.jar"]