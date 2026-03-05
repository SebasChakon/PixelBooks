# PixelBooks

A virtual library designed for students who need quick access to academic and general reading resources. PixelBooks provides a centralized repository of books across various categories, allowing users to build a personal collection and access digital content seamlessly.

> **Status:** Project complete — a migration to a **distributed system architecture** is planned for the near future.

---

## Features

- **Full Library** — browse the complete catalog of available books, including fiction, non-fiction, and educational materials.
- **Personal Library** — save your favorite books to your own private collection.
- **User Profile** — view and update your personal account information.
- **About Us** — learn about PixelBooks' mission and vision.

---

## 🛠️ Tech Stack

| Layer         | Technology                               |
|---------------|------------------------------------------|
| Frontend      | JSP, HTML, CSS, Bootstrap                |
| Backend       | Java Servlets, JavaScript                |
| Database      | MySQL                                    |
| DB Connector  | MySQL JDBC Driver                        |
| Server        | Apache Tomcat                            |

---

## Installation & Setup

### Prerequisites

- [Java JDK](https://www.oracle.com/java/technologies/downloads/)
- [Apache Tomcat](https://tomcat.apache.org/)
- [MySQL](https://www.mysql.com/)
- MySQL JDBC Driver

### Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/pixelbooks.git
   ```

2. **Set up the database:**
   - Open MySQL and run the `.sql` script included in the project to create the database and its tables.

3. **Configure the JDBC connection:**
   - Follow the driver's instructions to set up the connection to your MySQL instance (host, port, username, and password).

4. **Deploy to Tomcat:**
   - Copy the project into Tomcat's `webapps` directory, or import it into your IDE (Eclipse, IntelliJ, etc.) and run it on the server.

5. **You're all set!** Open your browser and navigate to `http://localhost:8080/pixelbooks` (or whichever port you have configured).

---

## Roadmap

- [ ] Migration to distributed system architecture
- [ ] Performance and scalability improvements
- [ ] Category-based book recommendation system

---

## 📄 License

MIT — free to use, modify, and distribute.
