<h1>Oakton Commentator Application</h1>

Access deployed application as follows which refreshes every 3 seconds

```
http://oakton-commentator.au-syd.mybluemix.net/
```

Screen Shot:

![alt tag](https://dl.dropboxusercontent.com/u/15829935/bluemix-docs/images/oakton-comm-1.png)


<h2> Feed Data Into Application <h2>

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
pasapicella@Pas-MacBook-Pro:~$ curl -i -H "Accept: application/json" -H "Content-Type: application/json" http://oakton-commentator.au-syd.mybluemix.net/riderDataLoad -d @Sample_Cadel.json
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

<hr />
Pas Apicella [pasapi at au1.ibm.com] is a Bluemix Technical Specialist at IBM Australia 