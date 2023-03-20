**My Webhook App**

This is a Java application that sets up a webhook listener and exposes a public endpoint using ngrok. The application uses Java 17, Apache HttpComponents library, and Maven for dependency management.

**Usage**

To use this application, follow these steps:

1. Clone the repository to your local machine.
2. Make sure you have Java 17 and Maven installed.
3. Install and run ngrok in a separate terminal window by running the following command:
`./ngrok http 8080`
4. In the project directory, run the following Maven command to build and run the application:
`mvn clean compile exec:java -Dexec.mainClass="com.example.Main"`
5. The application will start and listen for incoming webhook requests on port 8080. The ngrok URL will be displayed in the console output.
6. To send a sample webhook request, run the following cURL command in a separate terminal window:
   `curl -X POST -H "Content-Type: application/json" -d '{"name": "Suraj Bothale", "email": "sbothale.official@gmail.com", "message": "Hello World"}' https://<ngrok-url>/webhook`
7. The application will receive the webhook request and print the payload to the console.

**About Webhooks**

Webhooks are a way for web applications to receive real-time notifications when specific events occur. The application can register a URL endpoint to receive these notifications, and when an event occurs, the application will receive a POST request with a payload containing relevant data.

**Functionality of Each Class**

WebhookListener: This class sets up the HTTP server and registers the /webhook endpoint. When a request is received, it passes the request to the MyHttpHandler class.
MyHttpHandler: This class handles the incoming webhook request, extracts the payload, and prints it to the console.
Main: This class is the entry point for the application. It starts the server and listens for incoming requests.


**Installing and Running ngrok**

Ngrok is a tool that allows you to expose a web server running on your local machine to the internet. You can use it to create a public URL for your webhook listener so that it can receive requests from external services.

To install ngrok, follow these steps:

1. Go to the ngrok website and sign up for an account.
2. Download the ngrok client for your operating system.
3. Extract the ngrok executable from the archive and place it in a directory that is in your system's PATH.
4. Open a terminal window and run the following command to authenticate your account:
   `./ngrok authtoken <your-auth-token>`
5. You can now run ngrok by running the following command:
   `./ngrok http 8080`



### **Basic steps without NGROK** 

`git clone git@github.com:sbothaleOfficial/my-webhook-app.git
`

`mvn clean compile exec:java -Dexec.mainClass="com.webhook.Main"
`

`curl -X POST -H "Content-Type: application/json" -d '{"name": "Suraj Bothale", "email": "sbothale.official@gmail.com", "message": "Hello World"}' http://localhost:8000/webhook
`
