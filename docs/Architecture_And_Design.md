# Architecture and Design

## ChatSiGira v 1.0


Team:

- Allari Edoardo
- Bologna Abreham
- Nicolis Pietro
- Pollinari Jonathan
- Zerbato Nicolò

---

## Purpose

This document describes the architecture and design for the **ChatSiGira** application being developed for a school project. 

The ChatSiGira project is an implementation of a client software that allow people to communicate with text messages inside the same network, through a main server that manage all the clients connected.

The purpose of this document is to describe the architecture and design of the **ChatSiGira** application in a way that addresses the interests and concerns of all major stakeholders. For this application the major stakeholders are:

- **Users and customer** (Students and teachers): they want assurances that the architecture will provide for system functionality and exhibit desirable non-functional quality requirements such as usability, reliability, etc;

- **Developers:** they are the people listed at the beginning of this document and they want an architecture that will minimize complexity and development effort;

- **Project Manager:** in this case this figure is Allari Edoardo, that is responsible for assigning tasks and coordinating development work. He wants an architecture that divides the system into components of roughly equal size and complexity that can be developed simultaneously with minimal dependencies.


## Logical and Process View

![](https://github.com/teddyedo/2020_5EI_team1_Allari/blob/master/docs/Immagini/process%20view.png?raw=true)

- The **Reader** class is a thread which has the task of waiting for input messages from the server;
- The **Executor** class is a thread that has the task of take the message red by the Reader and pass it to the interpreter; after the interpretation the executor (that now knows what to do) consults the **WhatToDo** class;
- The **Interpreter** class has the task of take the message received and understand what type of packet is arrived; after that it returns the packet to the executor;
- The **WhatToDo** class contains a list of methods, one for every possibile packet that is implemented in PCP

## Use Case View
For this view, please consult the User Guide.

## Architecture view

![](https://github.com/teddyedo/2020_5EI_team1_Allari/blob/master/docs/Immagini/architecture.png?raw=true)

## Design Goals
The design priorities for the ChatSiGira application are:

- Easy to mantain and update;
- Attractive graphics;
- Similar to the most famous chat application (everyone know how to use them).

## Detailed class design 
To know how our class works, please consult the *javadoc* present in our github repository, under the *docs* folder.
