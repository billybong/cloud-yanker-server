cloud-yanker
============

Your cut and paste clipboard. In the *cloud*!
Very simple project to allow for copy pasting between multiple computers.
The server is not secured in any way, so use at your own risk.

Build & run the server:
mvn clean install
java -jar target/fatjar.jar server


Build & run the client:
The client is simply an AutoHotKey script that talks to your clipboard.
Edit the script cloudyanker.aht and supply the server url as well as a user.
Run the script with ahk and use CTRL+ALT+Y to copy to the cloud, CTRL+ALT+P to paste from it.
