/* AUTHOR: Marcus Tierney
*Javascript - Node.js
*This program creates a server, controlled by the terminal.
* Hostname: Localhost/127.0.0.1
*Port: 2018
*/

//Normal start
const http = require('http');
const hostname = '127.0.0.1'
const port = 2018;
const url = require('url');


//create server
const server = http.createServer((req, res) => {
  const {headers, method, url} = req

  if(url == '/hw') {
    //Hello world!
    res.statusCode = 200;
    res.end("Hello, World!\n");
  }
  else if( url.substring(0,6) == '/greet') {
    //Greet!
    res.statusCode = 200
    var queryData = require('url').parse(req.url, true).query;
    var name = queryData.name

    var date = new Date();
    var time = date.getHours();
    var part_of_day;

    //Find time of day
    if( time >= 5 && time < 12) { part_of_day = 'morning';}
    else if( time >= 12 && time < 17 ) {part_of_day = 'afternoon'}
    else if( time>= 17 && time < 23 ) { part_of_day = 'evening'}
    else if( time >= 23 && time < 5) {part_of_day = 'night'}

    console.log("Time detected: " + time);
    res.end("Good " + part_of_day + ", " +  name + "!");
  }
  else{
  //Not found - 404
  res.statusCode = 404;
  res.end();
  }
});

//Listen
server.listen(port, hostname, () => {
  console.log(`Server is up at http://${hostname}:${port}`);
});
