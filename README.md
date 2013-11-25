<h2>cloud-yanker-server</h2>
============

Your cut and paste clipboard. In the *cloud*!
Very simple project to allow for copy pasting between multiple computers.
The server is not secured in any way, so use at your own risk.

<h3>Build & run the server:</h3>
mvn clean install
java -jar target/fatjar.jar server


<h3>Build & run the client:</h3>
The client is simply an AutoHotKey script that talks to your clipboard.
See the cloud-yanker-client repo for it.

<h3>TODOS:</h3>
<ul>
  <li>Fix security, at least SSL against the server</li>
  <li>Healthcheck against server on script startup using Dropwizard healthcheck page</li>
</ul>
