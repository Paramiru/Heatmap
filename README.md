# Informatics Large Practical - CW 2 (2020 - 2021)

<b>Course Name:</b> Informatics Large Practical
<br><b>Coursework Name:</b> Air Quality Map - Aqmaps
<br><b>Objective:</b> Program a drone so that it can read information from several sensors and come back to the starting location.
<br><b>Programming Language:</b> Java 11 - Latest version with long term support available.
<br><b>Final Mark:</b> N/A
<br><b>Overall Course Mark:</b> N/A

## Files
<ul>
  <li> <a href="./coursework-document.pdf">coursework-document.pdf</a> --> This pdf file contains the description followed to complete the project.
  <li> <a href="./heatmap">heatmap</a> --> This directory contains the whole <em>heat map</em> project.
</ul>

## Brief description of the heat map
The purpose of this project is to create a heat map in which data values are represented as colours across a surface or area. The intention of this heat map is to visualise the predictions that the project researchers have made for the highest sensor reading which will be seen in each area of the drone confinement area, partitioned into a regular 10 × 10 grid.

The predictions of the researchers are input into the heat map application as a text file with 10 lines of text, each of which has 10 integer values separated by commas, as seen in the example file (which can be found inside the heatmap directory) <a href="./heatmap/predictions.txt">predictions.txt</a>. The values are understood to be in the order of the most northerly values down to the most southerly values, reading each row of data containing the values from the west to the east, in order. These values are to be used to generate an output file in the default output directory called heatmap.geojson.

The output Geo-JSON document will use the values from the input to produce a 10 × 10 grid which covers the drone confinement area whose dimensions were specified in the coursework document. Each of the rectangles in the grid is represented as a Geo-JSON Polygon with properties:
<ul>
  <li>"fill-opacity" being 0.75</li>
  <li>"rgb-string" and "fill" both being the colour specified for the relevant input prediction for this area</li>
</ul>

It is to mention that the polygons will be coloured according to the colour mapping which is specified in the coursework document.

Consequently, there is only one argument required for the heat map application to run:
<ul>
  <li>predictions.txt</li>
 </ul>
  
## Getting Started

These subsections will help you get a copy of the project and understand how to run it on your local machine for development and testing purposes.
I will discuss how to clone this repository and set it up in any IDE of your choice. Furthermore, instructions on how to run the server will be given as well as how to build & run the project from the terminal.

### How to Install

The first thing you should do is clone this repository into your local machine. You can do this with the following command:
```
git clone https://github.com/Paramiru/Heatmap
```
Once you have cloned the repository, you should check your current version of Java. I used Java 11 (LTS) for the project. You can check the version you are currently using running this command in the terminal.
```
java --version
```
It is worth mentioning that you do not have to worry about the dependencies since they are in the file pom.xml, which you can find inside the heatmap directory. Maven will take care of downloading anything you do not currently have so that you can run the project.

If you have a previous version of Java 11, you can download it from Oracle's website.

Once you have cloned the repository, you can import the Maven project to your preferred IDE. I used Eclipse, but feel free to use whichever you are most comfortable with. 
You can check the Java version you are using for the project. In order to do that, find "JRE System Library" in the Package Explorer and select "Properties". Change "Execution environment" to be "JavaSE-11".

## Building the Project

Since I used Maven to automate the build procedure the only thing you have to do to build the project is to run the following two commands provided by Maven. If you are doing it from the terminal remember you must do so from the heatmap directory:
```
mvn clean
mvn package
```
Otherwise, if you are doing it from Eclipse, you can right click <em>heatmap</em> folder and you will see 
Maven > Maven clean  
Maven > Maven build (by doing this you will have to specify the goal of the build. Write "package")

## Running the Project 

Having built the project, you will see a runnable file inside the heatmap/target folder <b>heatmap-0.0.1-SNAPSHOT.jar</b>
Run the .jar file using:
```
java -jar heatmap-0.0.1-SNAPSHOT.jar ../predictions.txt
```
where ../predictions.txt correspond to the text file which sould be in the heatmap directory.

## Built With

* [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) - Latest Java version with Long Term Support.
* [Maven](https://maven.apache.org/) - Dependency Management

## Maven Dependencies

* [Mapbox Java SDK](https://docs.mapbox.com/android/java/guides/)


## Screenshots

<p align="center">
  <img width="460" src="./screenshot/rendered-heatmap.png">
  <br>
  Rendered heatmap from given predictions in coursework document
</p>

## Authors

* **Pablo Miró** - [Paramiru](https://github.com/Paramiru)

