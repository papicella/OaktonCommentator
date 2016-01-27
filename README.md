<h1>Oakton Commentator Application</h1>

Access deployed application as follows which refreshes every 3 seconds

```
http://oakton-commentator.au-syd.mybluemix.net/
```

Screen Shot:

![alt tag](https://dl.dropboxusercontent.com/u/15829935/bluemix-docs/images/oakton-comm-1.png)

<h3> Bluemix Dashboard </h3>

![alt tag](https://dl.dropboxusercontent.com/u/15829935/bluemix-docs/images/oakton-comm-2.png)

<h3> Feed Data Into Application </h3>

- Data will look as follows

```
{
  "Timestamp": "1437736287",
  "Riders": [
    {
      "RiderId": "1",
      "Cadence": "90",
      "Speed": "23",
      "HeartRate": "176"
    },
	{
	  "RiderId": "2",
      "Cadence": "80",
      "Speed": "27",
      "HeartRate": "160"

	},
	{
	  "RiderId": "4",
      "Cadence": "80",
      "Speed": "22",
      "HeartRate": "170"

	}
  ]
}
```

- Load data as follows

```
pasapicella@Pas-MacBook-Pro:~$ curl -i -H "Accept: application/json" -H "Content-Type: application/json" 
http://oakton-commentator.au-syd.mybluemix.net/riderDataLoad -d @Sample_Cadel.json
HTTP/1.1 200 OK
X-Backside-Transport: OK OK
Connection: Keep-Alive
Transfer-Encoding: chunked
Content-Type: application/json;charset=UTF-8
Date: Mon, 25 Jan 2016 01:41:03 GMT
Server: Apache-Coyote/1.1
X-Cf-Requestid: 4e29acb0-c4d1-4342-45d7-844eea1542ee
X-Client-IP: 110.175.56.52
X-Global-Transaction-ID: 528299743

Data Loaded successfully...
```

<h3> Application Properties </h3>

```
pasapicella@pas-macbook-pro:~$ cf app oakton-commentator
Showing health and status for app oakton-commentator in org pasapi@au1.ibm.com / space oakton as pasapi@au1.ibm.com...
OK

requested state: started
instances: 2/2
usage: 512M x 2 instances
urls: oakton-commentator.au-syd.mybluemix.net
last uploaded: Wed Jan 27 02:07:28 UTC 2016
stack: cflinuxfs2
buildpack: java_buildpack

     state     since                    cpu    memory           disk           details
#0   running   2016-01-27 01:08:15 PM   0.1%   427.4M of 512M   146.8M of 1G
#1   running   2016-01-27 01:08:16 PM   0.1%   448M of 512M     146.8M of 1G

pasapicella@pas-macbook-pro:~$ cf services
Getting services in org pasapi@au1.ibm.com / space oakton as pasapi@au1.ibm.com...
OK

name              service           plan     bound apps           last operation
Cloudant-Oakton   cloudantNoSQLDB   Shared   oakton-commentator   create succeeded

```

<hr />
Pas Apicella [pasapi at au1.ibm.com] is a Bluemix Technical Specialist at IBM Australia 