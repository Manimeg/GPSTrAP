GPSTrAP is a vehicle tracking application using Google Maps on Android.


Problem Definition
-------------------
A newcomer to a city would be puzzled to determine which bus to take so as to reach a particular destination. It would be useful for him if he could simply enter his source and desired destination into his mobile device and could get the details of the bus nearby which he could safely take to travel to his destination. It would only prove more beneficial if he could determine the current location of the bus too.


Existing System
   ----------------
In the conventional scenario, a user would have to either wait for a bus for indefinite period of time or  has to call the bus transportation enquiry personnel who only have to guess the bus's probable current location. 


** Drawbacks of Existing System
   -----------------------------
As mentioned above the preciseness with which the authorities at the enquiry can guess the location of the bus too would be very small.
If the person is a newcomer to the city, then the things would be too worse as he might not be aware of the bus routes available.


PROPOSED SYSTEM
----------------
This application provides for tracking a user and deliver relevant data to the user. The application would receive source and destination locations from user and pass it to the database server. 
It then passes the received coordinates of locations to a maps provider through their API calls.


Selection of S/W & H/W Structure
---------------------------------
The software selected for completing this project are as follows:

-> Eclipse IDE with ADT plug-in installed for android application development.
-> Android Development kit with AVD Manager and SDK Manager and a minimum SDK of Android 2.2 with Google API’s.
-> Postgresql for creating and managing the database.


The hardware components used are as follows:

-> A GPS/GSM Transmitter for sending its current location.
-> A GSM Transceiver for receiving this data and sending to databse.


System Requirements Specification
----------------------------------
HARDWARE REQUIREMENTS

	PROCESSOR : PENTIUM IV
	SYSTEM BUS : 32 BIT
	RAM : 128 MB	
	HDD : 5GB	
	MONITOR : SVGA COLOR
	KEY BOARD : 108 KEYS
	MOUSE : SERIAL
	Ports: COM
	A GPS/GSM Transmitter
	A GSM Transceiver
	Mobile Device with Android 2.3.6(or higher) support

SOFTWARE REQUIREMENTS

Operating Environment:-
	Operating System: GNU/Linux distributions, Windows XP (or higher) Operating System
	Database Server: PostgreSQL 9.1

DEVELOPMENT TOOLS:-
       *    IDE: Eclipse IDE with JDK6 (or) openJDK-6 & ADT plug-in
       *    Android SDK:  Android SDK  20.0.1 with Gogle APIs (minimum)
