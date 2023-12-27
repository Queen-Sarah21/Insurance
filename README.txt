Insurance Management System
The Insurance Management System is a Java program designed to simulate the management of insurance agreements and financial transactions between a user and an insurance company. The system utilizes the Builder and Factory design patterns to create various types of insurance agreements and manage their lifecycle.

Table of Contents
•	Overview
•	Features
•	Getting Started
•	Usage
•	Code Structure
•	How to Run
•	Contributing
•	License

Overview
The system consists of multiple classes and interfaces, including Engineer, IBuilder, PremiumInsBuilder, RegularInsBuilder, Factory, InsuranceAgreement, User, and ManagerSoftware. The primary functionalities include creating insurance agreements, processing financial transactions, and simulating the passage of time to observe the financial status of the user.

Features
Insurance Agreement Creation: Utilizes the Builder pattern to create different types of insurance agreements, such as regular and premium.
Financial Transactions Simulation: Simulates financial transactions, including collecting yearly fees, handling claims, and processing cancellations.
Time Progression: Allows the system to progress by one year, updating financial statistics and net profits.
User Interaction: Utilizes a console-based interface in ManagerSoftware for users to interact with the system, accept new insurance applications, view current agreements, and manage their financial breakdown.

Getting Started
Prerequisites
Ensure you have a Java development environment set up (e.g., JDK installed).
A Java IDE (e.g., IntelliJ IDEA, Eclipse) is recommended for easier code navigation.
Installation
Copy the provided Java code into a new or existing Java project.
Set up the project in your preferred Java IDE.
Build and run the Main class to start the simulation.

Usage
Run the ManagerSoftware class to initiate the system.
Interact with the console menu to perform actions such as receiving new applications, viewing current agreements, observing financial breakdown, breaking agreements, and progressing time.
Follow on-screen instructions to navigate through the simulation.

Code Structure
Builder Package: Contains classes and interfaces related to the Builder pattern for creating insurance agreements.
Factory Package: Implements the Factory pattern for creating different types of insurance agreements.
Insurance Package: Defines the InsuranceAgreement class and the User class representing a user in the system.
Main Class: The ManagerSoftware class serves as the entry point, providing the main menu for user interaction.
Other Classes and Interfaces: Support the overall structure, including Engineer for managing agreement creation.

How to Run
Ensure you have Java installed on your system.
Copy the provided Java code into a new or existing Java project in your preferred IDE.
Build and run the Main class to start the simulation.
Contributing
Feel free to contribute to the project by submitting issues or pull requests. Contributions are welcome!

License
This project is licensed under the MIT License - see the LICENSE file for details.
