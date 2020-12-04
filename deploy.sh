mv src/main/resources/META-INF/persistence.xml src/main/resources/META-INF/persistence-test.xml
mv src/main/resources/META-INF/persistence-prod.xml src/main/resources/META-INF/persistence.xml
mvn clean heroku:deploy -Dmaven.test.skip=true
mv src/main/resources/META-INF/persistence.xml src/main/resources/META-INF/persistence-prod.xml
mv src/main/resources/META-INF/persistence-test.xml src/main/resources/META-INF/persistence.xml
