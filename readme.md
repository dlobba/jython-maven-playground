# Jython Maven Playground

Simple projects to showcase the use of Maven to collect Java dependencies
and package them into a single Jar, which can be later used in Jython scripts.

Maven integration was made possible thanks to jython-compile-maven-plugin.

I was not able to follow the accompanied [tutorials](http://mavenjython.sourceforge.net/compile/)
due to Python packages not being available through easy install,
I therefore decided to create these projects to focus on the Java/Jython use case.

I am no Jython expert but Jython easy_install was acting funny as of 2022, probably
due to Python 2.7 being EOL for quite some time... Go Figure!

## Requirements

Maven, JDK (tested on 1.7).

## Build

Top-level folder are individual projects:

* enter the project directory (notice `pom.xml`)
* Create single Jar `mvn clean package`
* Run the main Jython script `java -jar .\target\<the-project-name>-<project-ver>-jar-with-dependencies.jar run`

## Use as template

Consider project `jython-maven-base` (same logic applies to others).

Java files `AbstractJythonInit.java` and `InitJython.java` are the project entry point.
You don't want to change them, likely.

These instruct the maven project to act as following:

* when executing with the `run` command the main python script defined at `src/main/resources/__run__.py`
  gets executed;
* when executing with no command argument, the Jython interactive console is launched and allows
  you to play with dependencies installed.

**TLDR:**
Write your Jython code in `src/main/resources` considering `__run__.py`
to be the app entry point, in case you need some Java support write it down to
`src/main/java/<my>/<long>/<package>/<name>` folder.