# **Identity Service for PEC University of Technology** 

## **Aim**

The main aim of this project is automation and digitalization of day-to-day work of college, which are at present done manually. We aim to build a identity and database service as a base service which could be used later as open-end APIs for scaling and development of various other modules to be made under PEC Automation and Digitalization initiative.

The identity service is the service that is responsible for maintaining the identity or the basic information about any person, be it a student or a teacher. The main aim of this service is to retrieve the information about a person as required. This will be used by most of the other services. Additionally, it will give a functionality to store and update the information after proper authorisation of the person with this access. 

We plan to make a information hub using this service. This will later help other services and applications to get the required information about the users from services provided by our project.

We will build secure RESTful web services and API end-points which other applications can use. 


## **Technology**

The service will be implemented using Python as the main coding language.
We tend to use Flask micro-framework of python.


## **API Specification**

The service will have multiple API end points depending upon the requirement. There will be a generic API to retrieve the basic information about any person without any specification of the person type. Another set of API end points will be used for interacting with only the information about the students. Another set of API end points for data related to the faculty. The API end points will be as follows:

### **Get any specific user's information**

To get the information about a specific user. This can be anyone including students and faculty. The proposed end point is

```
GET /users/{userId}
```

### **Students information**

#### Get 

To get the list of students. This is a bulk API that can be used to fetch the required information using various filters provided. The API end-point is:

```
GET /students
```

Various Filters to be provided are:

| Filter | Description |
|--------|-------------|
|department| Filter on the Department of the person |
|year|Filter on the Joining year|
|programme|Filter on programme be/me/phd|
|sortBy|Sort result by specified filter out of name/sid/CGPA|
|minCgpa|Return list with CGPA greater than specified number|
|maxCgpa|Return list with CGPA less than specified number|
| limit | Limit the maximum number of output entries |
| start | Starting entry's number from where the entries are to be fetched from database |

#### Post

```
POST /students
```

### **Faculty information**

#### Get

To get the list of faculty. This is a bulk API that can be used to fetch the required information using various filters provided. The API end-point is:

```
GET /faculty
```

Various Filters to be provided are:

| Filter | Description |
|--------|-------------|
| department | Filter on the Department of the person |
| joiningBefore | Joining date before the specified date |
| joiningAfter | Joining date after the specified date |
| designation | Filter on the Designation specified |
| limit | Limit the maximum number of output entries |
| start | Starting entry's number from where the entries are to be fetched from database |

#### Post

```
POST /faculty
```
