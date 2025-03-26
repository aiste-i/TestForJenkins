1.  **Java Development Kit (JDK):** Version **17** or higher.
    *   This project is configured to use Java 17 (as specified in the `pom.xml`).
    *   You can download the JDK from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or use distributions like [OpenJDK](https://openjdk.java.net/install/).
    *   Verify your installation by running `java -version` and `javac -version` in your terminal. The output should indicate version 17 or greater.
  
2.  **Apache Maven:** This project uses Maven for building and managing dependencies.
    *   Download Maven from the [Apache Maven Project](https://maven.apache.org/download.cgi).
    *   Follow their installation instructions for your operating system.
    *   Verify your installation by running `mvn -version` in your terminal.
    *   *(Optional: If this project includes the Maven Wrapper (`mvnw` or `mvnw.cmd` files in the root), you can use `./mvnw` (Linux/macOS) or `.\mvnw.cmd` (Windows) instead of `mvn`, and you won't need a system-wide Maven installation.)*

### Using Maven


```bash
# Clean previous builds and run all tests
mvn clean test
