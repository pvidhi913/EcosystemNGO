# Communication Ecosystem for Multi-Party Applications

## Executive Summary
This project develops a digital platform to enable a collaborative ecosystem that connects NGOs, hospitals, educational institutions, logistics, and government agencies to provide comprehensive services to the needy.

...

## Core Implementation - Main Application Frame

The `MainJFrame` class is the main entry point of the Swing application. It initializes the system and provides the login and logout functionalities.

Here's a snippet from the `MainJFrame.java`:

```java
package UserInterface;

import Business.ConfigureASystem;
import Business.DB4O.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainJFrame extends javax.swing.JFrame {

    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    public MainJFrame() {
        // Initialization code here...
    }
    
    // Additional methods and event handlers...
    
    public static void main(String args[]) {
        /* Set the look and feel */
        // Look and feel setting code here...
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration...
}

Java Development Kit (JDK):

Ensure that you have the Java Development Kit (JDK) installed on your computer. The JDK is necessary to compile and run Java applications.
If you do not have the JDK installed, download and install it from the Oracle website or use OpenJDK.
Integrated Development Environment (IDE):

An IDE like IntelliJ IDEA, Eclipse, or NetBeans can simplify the process of managing your project and dependencies.
Download and install an IDE of your choice. Eclipse and NetBeans can be downloaded from their respective websites: Eclipse, NetBeans.
jBCrypt:

Download the jBCrypt library jar file from a trusted source or use a build tool like Maven or Gradle to include it in your project.

For manual download, you can find the jar file from repositories like MVNRepository.

If using Maven, add the following dependency in your pom.xml:

xml
Copy code
<dependency>
    <groupId>org.mindrot</groupId>
    <artifactId>jbcrypt</artifactId>
    <version>0.4</version>
</dependency>
AbsoluteLayout:

AbsoluteLayout jar can usually be found within the NetBeans IDE installation directory, but it can also be downloaded from the internet if needed.
If you are using NetBeans, the AbsoluteLayout library is already included and can be added to your project by right-clicking on the "Libraries" folder in your project, then "Add Library" -> "Absolute Layout".
DB4O:

Download the DB4O jar from its official website or a repository.
For manual installation, save the downloaded .jar file to a known location on your computer.
Setting Up the Project:

Open your IDE and create a new Java project.
Copy the source code into the src folder of your new project.
Adding Libraries to the Project:

In your IDE, add the downloaded jBCrypt, AbsoluteLayout, and DB4O jar files to your project's classpath.
This can typically be done by right-clicking on the "Libraries" folder in your project's structure and selecting "Add JAR/Folder", then navigating to and selecting the jar files you downloaded.
Running the Application:

After setting up the project and adding the necessary libraries, locate the MainJFrame file in your project.
Right-click on the file and select "Run" to start the application.
Troubleshooting:

If you encounter any errors, check that all libraries are correctly added to the classpath.
Ensure that your JDK version matches the project's requirements and that your IDE is properly configured to use that JDK.

Testing the Application
[Provide instructions and examples on how to test the application]

...

Collaborators
Rama Chandra Kashyap Mamidipalli (002812095)
Vidhi Patel (002641341)
Vaibhavee Gamit (002821886)

[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/2lpnXVPO)
