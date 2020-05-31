Project Title:
This Project is developed by Team Atom for HeadSpin Automation Hackathon. 
MakeMyTrip Review Hotel Booking scenario is automated which verify whether user selections are retained correctly till Booking Summary or not.
Getting Started:
GitHub Repo: https://github.com/atom-mator/atomHack
Clone master using git clone https://github.com/atom-mator/atomHack.git OR alternatively you can clone it directly from GitHub.
Pre-requisite: 
Maven, Cucumber plugin, Eclipse/IntelliJ IDE
Open Project:
Open cloned project in eclipse or Eclipse/IntelliJ IDE
Our Framework has the capability to run on different browsers (googlechrome, phantomjs, internetexplorer, firefox) and different versions however, we developed and tested it on Windows operating system (64bit) and Google Chrome 83. 
You can add more browsers and versions by giving driver details in src\main\resources\browserVersions.xml
Installing:
First you need to install driver files for browser for that use following command in command prompt:
navigate to the folder where you have cloned the repo and give command mvn install .
Wait till it download all files and build should be successful without any error.
Running the tests:
To execute the test open class src\main\java\runner\TestRunner.java and run it as JUnit Test.
Built With:
Java
Selenium
Cucumber
maven-archetype-quickstart template

Authors:
Gaurav Dadhe
Kapilendra Jamkiar
Pritee Sheri
