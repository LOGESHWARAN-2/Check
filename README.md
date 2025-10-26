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
---

## 📸 Screenshots

### 🔐 1. Login
<img width="1375" alt="Login API" src="https://github.com/user-attachments/assets/a2355ea0-63f7-43bc-aa93-eb90703d5060" />

---

### 👥 2. Employee Management

#### Get All Employees
<img width="1396" alt="Get All Employees" src="https://github.com/user-attachments/assets/ebf97c7f-251d-4819-bf4c-7c91dbee1b18" />

<img width="1377" alt="Employee List Response" src="https://github.com/user-attachments/assets/30a12818-0201-4fb7-974f-a116b4515d4e" />

#### Get Employee By ID
<img width="1357" alt="Get Employee By ID" src="https://github.com/user-attachments/assets/07511ed0-e9db-4d50-ab78-0c1228010e71" />

#### Create Employee
<img width="1385" alt="Create Employee" src="https://github.com/user-attachments/assets/8e5a6a32-4623-4073-b259-00313f0398a1" />

#### Delete Employee By ID
<img width="1362" alt="Delete Employee" src="https://github.com/user-attachments/assets/8add0fc2-3216-4190-90f0-413f43d20ae6" />

---

### 📝 3. Task Management

#### Get All Tasks
<img width="1376" alt="Get All Tasks" src="https://github.com/user-attachments/assets/59b9413f-851a-4a9f-9a40-715bf0b4bc1c" />

#### Check Assigned Tasks By Employee ID
<img width="1345" alt="Tasks By Employee" src="https://github.com/user-attachments/assets/2df67ec8-0c5e-435e-ab13-c84aa519a7e3" />

#### Create Task
<img width="1369" alt="Create Task" src="https://github.com/user-attachments/assets/eb77a021-a80a-44ec-bbd1-c4d983e9355a" />

#### Update Task Status
<img width="1441" alt="Update Task Status" src="https://github.com/user-attachments/assets/b32a05ae-746c-43d8-8821-0851893da225" />

---

### 🔔 4. Notifications

#### Manager Notifications
<img width="1354" alt="Manager Notifications" src="https://github.com/user-attachments/assets/4ae21410-d5cf-4dc1-9d15-04ffb41a6805" />

#### Employee Notifications
<img width="1354" alt="Employee Notifications" src="https://github.com/user-attachments/assets/1fec2a8e-cfac-4bbf-ab1c-79b2e077ab5c" />

---

### 📊 5. Dashboard Analytics
<img width="1382" alt="Dashboard Summary" src="https://github.com/user-attachments/assets/6bb95d19-0bc4-4fbb-b3cf-71819425ec41" />

---

## 🧑‍💻 Author
**Logeshwaran S**  
📧 logeshwarans2910@gmail.com
💻 [github.com/Logeshwaran](https://github.com/LOGESHWARAN-2)
