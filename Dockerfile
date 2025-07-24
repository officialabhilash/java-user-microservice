FROM eclipse-temurin:23-jdk AS dev

RUN echo "User service Base"

RUN apt-get update && apt-get install -y maven

WORKDIR /app

RUN java -version

COPY pom.xml /app

COPY src /app/src

RUN mvn install -DskipTests

# Production stage
FROM eclipse-temurin:23-jdk AS prod

RUN echo "User service Production"

RUN apt-get update && apt-get install -y maven

WORKDIR /app

COPY pom.xml /app

COPY src /app/src

# Run tests in production build
RUN mvn clean install

# Run the application
CMD ["mvn", "spring-boot:run"]
