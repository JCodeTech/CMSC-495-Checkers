// This file is to assist in launching the application for Linux Users that have their IDE Sandboxed.
// This is not needed for the game itself and should not be in the final product.


package com.game.core;

import java.io.IOException;

public class Launcher {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Grabs the username of the current PC user.
        String currentUser = System.getProperty("user.name");

        // Constructs the command to execute the Java application with proper module paths and classpath
        // This command uses flatpak-spawn to run the application outside of the sandboxed environment
        String command =
                "flatpak-spawn --host " +
                        "/home/" + currentUser + "/.jdks/openjdk-26.0.1/bin/java " +
                        "--module-path \"/home/" + currentUser + "/Documents/Java Libraries/Open JavaFX/javafx-sdk-26.0.1/lib\" " +
                        "--add-modules javafx.controls,javafx.fxml " +
                        "--enable-native-access=javafx.graphics " +
                        "-Djava.library.path=\"/home/" + currentUser + "/Documents/Java Libraries/Open JavaFX/javafx-sdk-26.0.1/lib\" " +
                        "-classpath " +
                        "\"/home/" + currentUser + "/Documents/Education/UMGC/CMSC 495 Computer Science Capstone/Checkers/out/production/Checkers:" +
                        "/home/" + currentUser + "/Documents/Java Libraries/Open JavaFX/javafx-sdk-26.0.1/lib/*\" " +
                        "com.game.core.Main";

        // Creates a new ProcessBuilder to execute the bash command
        Process process = new ProcessBuilder("bash", "-c", command)
                .inheritIO()
                .start();

        // Waits for the process to complete and exits
        System.exit(process.waitFor());
    }
}