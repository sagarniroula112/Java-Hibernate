# Simplified Documentation of Your Hibernate Journey

This project documents my journey with Hibernate in Java, detailing the setup, configuration, and steps I took to get everything running. Below is a breakdown of the process.

## 1. Setup Process

### Created a Maven Project
- Started a new project using Maven, a powerful dependency management and build tool.
- Maven automatically handles downloading and updating project dependencies, which simplifies the setup process.

### Added Dependencies
- **MySQL Connector**: Added the MySQL Connector dependency to facilitate the connection to the MySQL database.
- **Hibernate Core ORM**: Added the Hibernate Core ORM dependency to leverage Hibernate's powerful Object-Relational Mapping (ORM) capabilities.

### Organized Files
- Located `App.java` under the path `src/main/java/com.telusko.DemoHib`. This file became the main test ground for writing the initial Hibernate code.

### Hibernate Tools
- Installed the **JBoss Tools** plugin in Eclipse, version 4.29.1.Final, to simplify generating and managing the `hibernate.cfg.xml` configuration file.
  
---

## 2. Configuration

### Created Configuration File: `hibernate.cfg.xml`
- The configuration file (`hibernate.cfg.xml`) was created to define the following settings:
  - **Database connection**: Configured the connection details, such as URL, username, and password.
  - **Hibernate Properties**: Specified Hibernate-related settings such as dialect, driver class, and other important configurations that influence the ORM behavior.

---

## 3. Created POJO

### Created the `Alien` Class
- The `Alien` class was created as a Plain Old Java Object (POJO) to represent a table in the database. 
- **Annotations used**:
  - `@Entity`: Marks the class as an entity that Hibernate should map to a database table.
  - `@Id`: Marks the field `aid` as the primary key for the `Alien` table.
  - `@Transient`: Marks the `aname` field as a non-persistent field, meaning it will not be mapped to the database.

Here is the code for the `Alien` POJO:

```java
@Entity  // Marks the class as an entity
public class Alien {

    @Id  // Marks 'aid' as the primary key
    private int aid;

    @Transient  // Marks 'aname' as not to be mapped to the database
    private String aname;

    @Column(name = "alien_color")  // Maps the 'color' field to 'alien_color' column in the database
    private String color;

    // Getters and setters for the fields
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
