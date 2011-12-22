Installation
------------

If you have maven installed execute the following on a command line:
   
    mvn clean compile package

You will then find a file called _PegDownConsole.jar_ in the folder _target_.

Usage
------------

You can run the _pegdownconsole_ by executing the jar file on the command line:

    java -jar PegDownConsole.jar

This will print all available options to you.

If you just want to simply convert a Markdown file use the following:
    java -jar PegDownConsole.jar -i "<pathToMarkdownFile>"

This will create a converted Html file in the same directory as the MarkDown file, with the same name as the 
markdown file but with the _.html_ extension. 

Note: If the absolute path to your Markdown file contains spaces, please enclose the path with ".

License
-------

_pegdownconsole_ is licensed under [Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0).
