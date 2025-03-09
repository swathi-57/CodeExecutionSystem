# 🚀 Online Code Execution & Evaluation System

## 📌 Introduction
The **Online Code Execution & Evaluation System** is a web-based platform that allows users to write, compile, and execute code in multiple programming languages. It also provides automated evaluation, real-time feedback, and performance tracking, making it ideal for competitive programming, coding assessments, and technical interviews.

## ✨ Features
- 🖥️ **Multi-Language Support** – Execute code in multiple languages (Java, Python, C++, JavaScript, etc.).
- ⚡ **Real-Time Code Execution** – Instant compilation and execution with output display.
- 📊 **Performance Analysis** – Evaluate execution time and memory usage.
- 📝 **Code Evaluation System** – Automated test cases validation.
- 🔐 **Secure Sandbox Environment** – Prevents malicious code execution.
- 📡 **REST API Integration** – Expose code execution as a service.
- 👤 **User Authentication & Progress Tracking** – Sign in to track submissions.
- 🏆 **Leaderboard & Coding Challenges** – Compete with peers and analyze coding efficiency.

## 🛠 Technologies Used
- ☕ **Java (Spring Boot)** – Backend processing and execution management.
- 🗄 **MySQL** – Database to store code submissions and user data.
- 🌐 **React.js** – Frontend interface for seamless user experience.
- 🐳 **Docker** – Containerized code execution for security.
- 🔐 **JWT Authentication** – Secure user login and session management.
- 📡 **RESTful APIs** – Facilitates communication between frontend and backend.

## 🏗 Installation & Setup
### Prerequisites
- Java 17+
- MySQL Server
- Maven
- Node.js & npm (for frontend)
- Docker (for secure code execution)
- IDE (IntelliJ IDEA, VS Code, or Eclipse)

### Steps to Run the Project
#### Backend (Spring Boot)
1. Clone the repository:
   ```sh
   git clone https://github.com/swathi-57/CodeExecutionSystem.git
   ```
2. Navigate to the backend directory:
   ```sh
   cd code-execution/backend
   ```
3. Configure the **application.properties** file with MySQL credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/code_execution
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
4. Start the backend server:
   ```sh
   mvn spring-boot:run
   ```

#### Frontend (React.js)
1. Navigate to the frontend directory:
   ```sh
   cd code-execution/frontend
   ```
2. Install dependencies:
   ```sh
   npm install
   ```
3. Start the frontend server:
   ```sh
   npm start
   ```

## 🎯 API Endpoints
| Method | Endpoint           | Description                        |
|--------|-------------------|-----------------------------------|
| POST   | `/execute/code`   | Compile & execute submitted code  |
| GET    | `/submissions`    | Fetch user code submissions      |
| POST   | `/evaluate/testcases` | Validate code with test cases |
| GET    | `/leaderboard`    | Retrieve leaderboard rankings    |
| POST   | `/auth/register`  | Register a new user               |
| POST   | `/auth/login`     | User authentication               |

## 📌 Usage Example
```java
@RestController
@RequestMapping("/execute")
public class CodeExecutionController {
    @Autowired
    private CodeExecutionService codeExecutionService;

    @PostMapping("/code")
    public ResponseEntity<ExecutionResult> executeCode(@RequestBody CodeRequest request) {
        return ResponseEntity.ok(codeExecutionService.runCode(request));
    }
}
```

## 🤝 Contributing
We welcome contributions! Feel free to fork this repository and submit a pull request.

## 📜 License
This project is licensed under the MIT License.

