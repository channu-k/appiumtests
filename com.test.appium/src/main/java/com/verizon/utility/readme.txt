Steps to configure xml file and running test scripts as jar file.
--------------------------------------------------------------------

1. Common properties for configuring capabilities and other device specific element properties are kept in 'capabilities.xml' file, which is located in the utilities folder. This has be to kept locally and the path of this file needs to added in the 'APIConstants.java' file.

2. For all the new properties that are to be introduced should be made an entry in the xml file, with respecitive property value and a 		  repective entry with name of the property in 
   'ConfiguredCapabilities.java' file', and generate getters and setters method to set and get value of a specific property in the test script.
   
3. In all test script files, the value of all the capabilities and the elements properties to be read from beans by using getters method. 

4. To run scripts as a jar file, the project needs to be exported as a runnable jar file with all the dependent files locally, and run jar file by using the java -jar 'jarname'.jar command.


