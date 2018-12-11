Run instructions:
 * Install newman
	```npm install newman```
 * Run
	```newman run -r html,cli -e AuthWS.postman_environment.json -g AuthWS.postman_globals.json AuthWS.MASTER.postman_collection.json --reporter-html-export report.html```

To specify URL for current test run use just add: <br>
    ``` --global-var URL="{your URL here}"```
