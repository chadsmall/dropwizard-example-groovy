# Introduction

The drop wizard example application was developed to, as its name implies, provide examples of some of the features
present in drop wizard.

# Overview

Included with this application is an example of the optional db API module. The examples provided illustrate a few of
the features available in (JDBI)[http://jdbi.org], along with demonstrating how these are used from within dropwizard.

This database example is comprised of the following classes.

* The `PersonDAO` illustrates using the [SQL Object Queries](http://jdbi.org/sql_object_api_queries/) and string template
features in JDBI.

* The `PeopleDAO.sql.stg` stores all the SQL statements for use in the `PersonDAO`, note this is located in the
src/resources under the same path as the `PersonDAO` class file.

* The `SetupDatabaseCommand` illustrates building a "setup" command which can create your database prior to running
dropwizard your application for the first time.

* The `PersonResource` and `PeopleResource` are the REST resource which use the PersonDAO to retrieve data from the database, note the injection
of the PersonDAO in their constructors.

As with all the modules the db example is wired up in the `initialize` function of the `HelloWorldService`.

# Running The Application

To test the example application run the following commands.

* To package the example run.

        mvn package

* To setup the h2 database run.

        java -jar target/dropwizard-example-0.6.0-SNAPSHOT.jar db migrate example.yml 

* To run the server run.

        java -jar target/dropwizard-example-0.6.0-SNAPSHOT.jar server example.yml

* To test the server after it has been started run.

        curl  -H "Content-Type: application/json" -H "Accept: application/json"  -X POST -d @src/test/resources/fixtures/contact.json http://localhost:8080/contacts
        curl http://localhost:8080/contacts
