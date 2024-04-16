# 기본 이미지로 OpenJDK 11 사용
FROM openjdk:20-jdk

WORKDIR /usr/src/app

ARG JAR_PATH=./build/libs

COPY ${JAR_PATH}/pro-0.0.1-SNAPSHOT.jar ${JAR_PATH}/pro-0.0.1-SNAPSHOT.jar

CMD ["java","-jar","./build/libs/pro-0.0.1-SNAPSHOT.jar"]