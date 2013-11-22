<h2>cloud-yanker-server</h2>
============

Your cut and paste clipboard. In the *cloud*!
Very simple project to allow for copy pasting between multiple computers.
The server is not secured in any way, so use at your own risk.

<h3>Build & run the server:</h3>
mvn clean install
java -jar target/fatjar.jar server


Build & run the client:
The client is simply an AutoHotKey script that talks to your clipboard.
See the cloud-yanker-client repo for it.
