FROM maven:3.8.1-adoptopenjdk-15-openj9
COPY . /app
RUN cd /app/lib && mvn install:install-file -DgroupId=domainapp -DartifactId=domainapp -Dversion=5.2 -Dpackaging=jar -Dfile="./domainapp.jar" && mvn install:install-file -DgroupId=domainapp -DartifactId=domainapp-mccl -Dversion=5.2 -Dpackaging=jar -Dfile="./modules-mccl-core.jar" && mvn install:install-file -DgroupId=domainapp -DartifactId=domainapp-commons -Dversion=5.2 -Dpackaging=jar -Dfile="./modules-common.jar" 
CMD cd /app && mvn spring-boot:run