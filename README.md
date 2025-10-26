# 🧾 Check Application - Employee Task Manager

## 🚀 Project Overview
**CHECK** is a backend application built using **Spring Boot + MySQL** that allows managers to assign tasks to employees, and employees to update their task progress. It supports real-time task tracking, notifications, and analytics summary for managers.

👨‍💼 **Manager** can:
- View all employees
- Assign and track tasks
- View dashboard analytics (total, completed, pending tasks)
- Receive notifications when tasks are completed

👷‍♂️ **Employee** can:
- View assigned tasks
- Update task status (In Progress / Completed)
- Receive new task notifications

---

## 🧱 Tech Stack Used
| Layer | Technology |
|--------|-------------|
| Backend Framework | Spring Boot 3.5.7 |
| Language | Java 23 |
| Database | MySQL |
| ORM | Spring Data JPA |
| API Format | REST (JSON) |
| Build Tool | Maven |
| IDE | IntelliJ IDEA  |

---

## 📂 Project Structure
```
com.example.Check
 ├── controller/
 │    ├── AuthController.java
 │    ├── EmployeeController.java
 │    ├── TaskController.java
 │    ├── DashboardController.java
 │    └── NotificationController.java
 │
 ├── entity/
 │    ├── User.java
 │    ├── Employee.java
 │    ├── Task.java
 │    ├── Notification.java
 │    ├── Role.java
 │    └── TaskStatus.java
 │
 ├── repository/
 │    ├── UserRepository.java
 │    ├── EmployeeRepository.java
 │    ├── TaskRepository.java
 │    └── NotificationRepository.java
 │
 ├── service/
 │    ├── AuthService.java
 │    ├── EmployeeService.java
 │    ├── TaskService.java
 │    ├── NotificationService.java
 │    └── DashboardService.java
 │
 └── CheckApplication.java
```

---

## ⚙️ Setup Instructions

### 🧩 1. Clone the Repository
```bash
git clone https://github.com/LOGESHWARAN-2/check.git
cd check
```

### 🧩 2. Configure MySQL
```sql
CREATE DATABASE emp;
```

### 🧩 3. Configure `application.properties`
```properties
spring.application.name=Check
spring.datasource.url=jdbc:mysql://localhost:3306/emp
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 🧩 4. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

### 🧩 5. Test Using Postman
---

- **POST** `/api/auth/login` – User login (Manager/Employee)
- **GET** `/api/employees` – View all employees
- **GET** `/api/employees/{id}` – Get specific employee details
- **POST** `/api/employees` – Add new employee
- **GET** `/api/tasks` – View all tasks
- **GET** `/api/tasks/employee/{empId}` – View tasks for specific employee
- **POST** `/api/tasks` – Assign new task
- **PUT** `/api/tasks/{id}/status?status={STATUS}` – Update task status
- **DELETE** `/api/tasks/{id}` – Remove task
- **GET** `/api/notifications/{role}` – View notifications for role
- **POST** `/api/notifications` – Create new notification
- **GET** `/api/dashboard/summary` – View task analytics

---


## 📈 Sample Workflow

```
             ┌───────────────────────────────┐
             │         LOGIN PAGE            │
             │User selects: Manager/Employee │
             └──────────────┬────────────────┘
                            │
                            ▼
        ┌───────────────────────────────┐
        │      AUTHENTICATION SERVICE   │
        │  (Validates username/password)│
        └──────────────┬────────────────┘
                       │
          ┌────────────┴──────────────┐
          │                           │
   ┌──────▼───────┐           ┌───────▼────────┐
   │ MANAGER ROLE │           │ EMPLOYEE ROLE  │
   └──────┬───────┘           └───────┬────────┘
          │                            │
          │                            │
┌─────────▼─────────────┐     ┌────────▼──────────────┐
│  MANAGER DASHBOARD    │     │  EMPLOYEE DASHBOARD   │
│  - View Employees     │     │  - View Assigned Tasks│
│  - Assign Tasks       │     │  - Update Status      │
│  - View Analytics     │     │  - Mark Completed     │
│  - View Notifications │     └────────┬──────────────┘
└─────────┬─────────────┘              │
          │                            │
          │ Assign Task (POST /tasks)  │
          │────────────────────────▶  │
          │                            │
          │  Employee Completes Task   │
          │◀──────────────────────────│
          │                            │
          │ Creates Notification       │
          │ (Stored in DB)             │
          │                            │
┌─────────▼─────────────┐              │
│ MANAGER NOTIFICATION  │              │
│ "Task Completed"      │              │
└─────────┬─────────────┘              │
          │                            │
          ▼                            ▼
 ┌────────────────────────┐    ┌────────────────────────┐
 │ DASHBOARD ANALYTICS    │    │  NOTIFICATIONS MODULE  │
 │ - Total Tasks          │    │  (for both roles)      │
 │ - Completed Tasks      │    └────────────────────────┘
 │ - Pending Tasks        │
 └────────────────────────┘
```

---
## Screenshots

1. Login

<img width="1375" height="728" alt="image" src="https://github.com/user-attachments/assets/a2355ea0-63f7-43bc-aa93-eb90703d5060" />

2. Get All Employees

<img width="1396" height="978" alt="image" src="https://github.com/user-attachments/assets/ebf97c7f-251d-4819-bf4c-7c91dbee1b18" />

<img width="1377" height="911" alt="image" src="https://github.com/user-attachments/assets/30a12818-0201-4fb7-974f-a116b4515d4e" />








---
## 🧑‍💻 Author
**Logeshwaran S**  
📧 logeshwarans2910@gmail.com
💻 [github.com/Logeshwaran](https://github.com/LOGESHWARAN-2)
