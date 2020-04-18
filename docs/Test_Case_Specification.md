# Test Case Specification


## INTRODUCTION
This document provides the test cases to be carried out for the Chat Application.  Each item to be tested is represented by an individual test case.  Each case details the input and expected outputs.

___
## Test Cases: Chat Application

|              |                                                                                               |
| ------------ | --------------------------------------------------------------------------------------------- |  
| Test ID      | 100                                                                                           |
| Titles       | Correct Login                                                                                 |
| Features     | Login to [https://jitpack.io/JacopoWolf/PotatoChatProtocol](https://jitpack.io/#JacopoWolf/PotatoChatProtocol) with Chat App |
| Objective    | Confirm that proper user's information yields access to the server as expected.. |
| Test Data    | Login information: User Name = Pippo; Room = school|
| Expected Results | The system displays the user interface with the option to log out, to create a new room or to scroll through the list of all users connected to the server and chat with anyone. The list of users and rooms must match the one found on [https://jitpack.io/JacopoWolf/PotatoChatProtocol](https://jitpack.io/#JacopoWolf/PotatoChatProtocol).|
| Test Actions    
    1. Start Chat application; 
    2. Enter login information
___

|              |                                                                                               |
| ------------ | --------------------------------------------------------------------------------------------- |  
| Test ID      | 101                                                                                            |
| Titles       | Incorrect Username                                                                                 |
| Features     | Login to [https://jitpack.io/JacopoWolf/PotatoChatProtocol](https://jitpack.io/#JacopoWolf/PotatoChatProtocol) with Chat App                                                     |
| Objective    | Confirm that valid user id with an invalid username denies access to the server without leaving the user stranded. |
| Test Data    | Correct User ID, incorrect Username: Username = Peppo; Room = school|
| Expected Results    | System displays error message with option to try again.                                           |
| Test Actions    
    1. Start Chat application; 
    2. Enter invalid login information

___

|              |                                                                                               |
| ------------ | --------------------------------------------------------------------------------------------- |  
| Test ID      | 102                                                                                            |
| Titles       | Invalid room name                                                                                 |
| Features     | Login to [https://jitpack.io/JacopoWolf/PotatoChatProtocol](https://jitpack.io/#JacopoWolf/PotatoChatProtocol) with Chat App                                                     |
| Objective    | Confirm that invalid room name denies access to the server without leaving the user stranded. |
| Test Data    | Incorrect Username, Incorrect room name: Username = Peppo; Room = school|
| Test Actions    | Start Chat application; Enter invalid login information|
| Expected Results    | System displays error message with option to try.                                           |

___

|              |                                                                                               |
| ------------ | --------------------------------------------------------------------------------------------- |  
| Test ID      | 000                                                                                            |
| Titles       | Malformed package                                                                                 |
| Features     | Login to [https://jitpack.io/JacopoWolf/PotatoChatProtocol](https://jitpack.io/#JacopoWolf/PotatoChatProtocol) with Chat App                                                     |
| Objective    | Warn that malformed package can't be read by clients. server without leaving the user stranded. |
| Test Data    | Login information: User Name = Pippo; Room = school                                           |
| Expected Results    | System displays error message.                                           |
| Test Actions |
    
    1. Start Chat application; 
    2. Select View Locations option; 
    3. Select a user with whom we want to chat; 
    4. Enter an amount of data greater than 256 bytes
___

|              |                                                                                               |
| ------------ | --------------------------------------------------------------------------------------------- |  
| Test ID      | 11                                                                                            |
| Titles       | Disconnection                                                                                 |
| Features     | Allow users to disconnect from the server                                                     |
| Objective    | Confirm that the disconnection had happen properly. server without leaving the user stranded. |
| Test Data    | Login information: User Name = Pippo; Room = school                                           |
| Expected Results    | System disconnect user properly from [https://jitpack.io/JacopoWolf/PotatoChatProtocol](https://jitpack.io/JacopoWolf/PotatoChatProtocol).                                           |
| Test Actions |
    
    1. Start Chat application; 
    2. Select Account option; 
    3. Select Disconnection option; 


---

### **Team:**

    - Allari Edoardo
    - Bologna Abreham
    - Nicolis Pietro
    - Pollinari Jonathan
    - Zerbato Nicolò


