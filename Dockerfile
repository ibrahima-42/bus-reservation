# Étape 1 : Utiliser une image avec Java
FROM openjdk:17-jdk-alpine

# Étape 2 : Ajouter un argument pour le jar
ARG JAR_FILE=target/*.jar

# Étape 3 : Copier le jar dans le conteneur
COPY ${JAR_FILE} app.jar

# Étape 4 : Lancer l'application
ENTRYPOINT ["java","-jar","/app.jar"]
