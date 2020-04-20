# demo
simple airport ticket project rest services with spring boot and mysql

Uygulama local'e alındıktan sonra application.properties dosyasında mysql datasource için username ve password set edilmelidir. Proje çalıştırıldığında tablolar ve test kayıtları oluşacaktır.

Aşağıda servisler ve requestler vardır;

http://localhost:8080/api/admin/airport-create

{
	"name":"Dalaman",
	"address":"Muğla"
}



http://localhost:8080/api/user/find-airport

{
	"name":"Dalaman"
}


http://localhost:8080/api/admin/company-create

{
	"name":"Anadolujet"
}



http://localhost:8080/api/user/find-company

{
	"name":"Anadolujet"
}

http://localhost:8080/api/admin/route-create

{
	"flightTime":70,
	
	"boardingAirport":{
		"id":4
	},
	
	"destinationAirport":{
		"id":3
	}
}



http://localhost:8080/api/user/find-route-by-airport-name

{
	"name":"Sabiha Gökçen"
}



http://localhost:8080/api/user/find-route-by-boarding-airport-name

{
	"name":"Sabiha Gökçen"
}


http://localhost:8080/api/user/find-route-by-destination-airport-name

{
	"name":"Sabiha Gökçen"
}


http://localhost:8080/api/admin/flight-create

{
	"date":[  
      2020,
      5,
      21,
      10,
      24
   ],
	
	"route":{
		"id":2
	},
	
	"company":{
		"id":2
	},
	"quota":10,
	"initialPrice":10
}


http://localhost:8080/api/user/find-flight-by-date

{
	"date":[  
      2020,
      5,
      21,
      10,
      24
   ]
}



http://localhost:8080/api/user/find-flight-by-company-name

{
	"name":"Pegasus"
}



http://localhost:8080/api/user/find-flight-by-company-name-and-date

{
	"date":[  
      2020,
      5,
      21,
      10,
      24
   ],
   "name":"THY"
}


http://localhost:8080/api/user/find-flight-by-airport-name

{
	"name":"Sabiha Gökçen"
}


http://localhost:8080/api/user/find-flight-by-date-and-airports

{
	"date":[  
      2020,
      5,
      21,
      10,
      24
   ],
   "boardingAirportName":"Sabiha Gökçen",
   "destinationAirportName":"Adnan Menderes"
}


http://localhost:8080/api/user/ticket-create

{
	"passangerName":"Esat Akacık",
	
	"flight":{
		"id":1
	}
}


http://localhost:8080/api/user/ticket-delete

{
	"id":6
}



http://localhost:8080/api/user/ticket-find

{
	"id":7
}
