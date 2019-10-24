#FROM oracle/graalvm-ce:19.2.0.1 as graalvm
#COPY . /home/app/cal-util
#WORKDIR /home/app/cal-util
#RUN gu install native-image
#RUN native-image --no-server -cp build/libs/cal-util-*-all.jar

#FROM frolvlad/alpine-glibc
#EXPOSE 8080
#COPY --from=graalvm /home/app/cal-util .
#ENTRYPOINT ["./cal-util"]


FROM adoptopenjdk:11.0.4_11-jre-openj9-0.15.1

EXPOSE 8080

COPY build/libs/cal-util-0.1-all.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]