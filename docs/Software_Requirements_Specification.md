                               
<h1> Software Requirements Specification </h1>
For ChatSiGira, version 1.0 approved <br>

Team 1:

- Edoardo Allari 
- Abreham Bologna
- Pietro Nicolis
- Jonathan Pollinari
- Nicolò Zerbato
  



---

# 1  Introduction

## 1.1  Overview

ChatSiGira is a client application that allows, thanks to the presence of a centralized server, communication with other clients connected to the same server. The application will provide login via a graphical interface by choosing your username and then it will connect to the global room to start talking with the other connected users. Users will be free to choose whether to write a message in the global chat or start a private conversation with a single user.

This document provides information about the requirements for the ChatSiGira software application. The objectives of the project are reported in the introduction.

## 1.2 Goals and Objectives

The main objective of this project is to allow users to communicate each other over a LAN using a centralized server that allows the interconnection of different clients. The ChatSiGira application should:

1. provide a login interface to log in and start chatting with other users; 
2. work in a simple and intuitive way;
3. provide the ability to change the alias;
4. Being able to start a private conversation.

## 1.3 Scope

ChatSiGira application provides users the access to a public chat with the list of users connected and and allows communication between users via a central server. Users can change their alias or log out whenever they want.

## 1.4 Product functions

Our product allows to:

- Chat with another user connected on the same server;
- Chat with a group of user connected to the same server;
- Change the alias during the execution of the application;
- Choose an icon as avatar;

# 2  General Design Constraints

  

## 2.1 ChatSiGira Application Environment

The application was developed in Java and runs in the Java Virtual Machine environment

## 2.2 User Characteristics

**ChatSiGira** **Users:** students of I.T.I.S. Marconi, teachers and anyone with a working computer.

# 3 Nonfunctional Requirements

  

## 3.1 Operational Requirements

Usability: [GitHub](https://github.com/teddyedo/2020_5EI_team1_Allari/blob/master/docs/index.md) documentation has been created for the operation of both the server application and the client, but testing it is very simple and completely guided.

## 3.2 Performance Requirements

Maintainability: changes made to the server do not affect clients and the same applies to clients.

## 3.3 Security Requirements

ChatSiGira does not have any specification from a security point of view.
  
## 3.4 Documentation and Training

The ChatSiGira application must be started from the NetBeans platform. A user guide and system documentation can be found online on [GitHub](https://github.com/teddyedo/2020_5EI_team1_Allari/blob/master/docs/index.md).

For a depth explanation of the functioning of our application, please check [this presentation](https://github.com/teddyedo/2020_5EI_team1_Allari/blob/master/docs/Software%20Project%20Documentation.pptx)

## 3.5 External Interface

### 3.5.1 User Interface

The user interface will be visibly pleasant with attractive and non-tiring colors. When we are logged in we find ourselves in the main interface, we can decide to move by clicking on the icons so it will be very simple and intuitive to navigate within it. We have created a third interface for private chat where only 2 clients can communicate with each other. 


# 4 Functional Requirements

  

## 4.1 Required Features

### 4.1.1 Use Case: 1

  

**Description: User Login**

Actors: student or any user.

  

**Basic Path**

1. the client opens the login interface;

2. The user enters the username they want;

3. when we click on the login button the server receives the request;

4. The server verifies that the alias is available and that it respects the restrictions;

5. The server then sends the list of people connected to the public room to the client;

6. The user clicks Disconnect;

7. The system exits.

  

### 4.1.2 Use Case: 2

  

**Description: Change Alias / Start a private conversation**

  

**Basic Path**

1. the client opens the login interface;

2. The user enters the username they want;

3. the user clicks on the avatar icon and will be able to see who the users are and can
request to start a private conversation with the client concerned;

4. the server will manage and allow the connection between the two clients;

5. by clicking on the settings icon users can decide to change aliases as they wish;

6. To disconnect from the global chat just click on the "disconnect" button;

7. The system exits.
                                          
