# ErrorLogger[ ![Download](https://api.bintray.com/packages/chathurahettiarachchi/maven/ErrorLogger/images/download.svg) ](https://bintray.com/chathurahettiarachchi/maven/ErrorLogger/_latestVersion)
This library will help to track down error logs by creating a database record. This will mainly used in industry based application testing environment. User of the application can generate list of errors that have occurred during time period 

<img width="1024" alt="libintro" src="https://cloud.githubusercontent.com/assets/13764097/22591401/56bec14e-ea3a-11e6-9afa-a36888dc5405.png">

This library contain following functions,

* ErrorLogger - add
* ErrorLogger - gerRecord
* ErrorLogger - getAllRecords
* ErrorLogger - getMostRecent
* ErrorLogger - clear

####Let's take a look how to add this to your project

For the android project just include the following dependency inside you build.gradle's depedency list.

Gradle
------
```
repositories {
  jcenter()
}

dependencies {
    ...
    compile 'com.chootdev:errorlogger:1.1.1'
}
```

if you using maven use following
Maven
------
```
<dependency>
  <groupId>com.chootdev</groupId>
  <artifactId>errorlogger</artifactId>
  <version>1.1.1</version>
  <type>pom</type>
</dependency>
```

After setup installing lib to your project you just need only to call it using just few lines of code. It will return you a string with the results.

Usage
-----
First to use this ErrorLogger we need to initialize it on our application class. For an example i'll add sample application class
```java
public class SampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ErrorLogger.init(this);
    }
}

// ErrorLogger.init(this);
// will create the errorLogger db inside your application
```

Let's add a new record to created Logger,
```java
ErrorLogger.with(getApplicationContext())
           .add(new LoggerModel("Test title " + i + 1, "Test message " + i + 1));
```

To get a record from our recorded logs and to get all logs, we can use following functions respectively,
```java
// to get a record
LoggerModel model = ErrorLogger.with(getApplicationContext())
                               .getLogRecord(ID_OF_THE_NEEDED_RECORD);
                               
// to get all records
List<LoggerModel> loggerModels = ErrorLogger.with(getApplicationContext()).getAllRecords();
```

This will have a clear function to clear data,
```java
ErrorLogger.with(getApplicationContext()).clearLogger();
```

and to get most recent records, or to get first set of records, you can use this function,
```java
// to get most recent records
List<LoggerModel> loggerModels = ErrorLogger.with(getApplicationContext()).getMostRecent(20,true);

// to get very first set of records
List<LoggerModel> loggerModels = ErrorLogger.with(getApplicationContext()).getMostRecent(20,false);
```

Limitations
-----------
* Currently min SDK is set to 14

Output Generated
----------------
NOTE: Inserting and getting data take time in this generated output. This is not happening when using real world. Just for the demostration

![ezgif com-video-to-gif 2](https://cloud.githubusercontent.com/assets/13764097/22592009/a84c26de-ea3d-11e6-9f3d-cfa09411c90d.gif)


Changelog
---------
* **1.1.1**
    * Fixed crash on log
* **1.1.0**
    * Fixed crashed with getMostRecentRecords
* **1.0.0**
    * Added release v1.0.0

## Author

Chathura Hettiarachchi, chathura93@yahoo.com

# License
Copyright 2016 Chathura Hettiarachchi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
