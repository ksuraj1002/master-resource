FROM openjdk:8
EXPOSE 9087
ADD feign-client-child/target/feign-client-children.jar feign-client-children.jar
ENTRYPOINT [ "java","-jar", "/feign-client-children.jar" ]
