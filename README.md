<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=0:00FFFF,25:00CED1,50:20B2AA,75:008B8B,100:005F73&height=220&section=header&text=🏨%20Hotel%20Management%20System&fontSize=40&fontColor=ffffff&fontAlignY=38&desc=Java%20Swing%20%7C%20JDBC%20%7C%20MySQL%20%7C%20PDF%20Reports&descAlignY=58&descSize=16&animation=fadeIn" />

# 🏨 Hotel Management System

A fully functional **Hotel Management System** developed using **Java Swing, JDBC, MySQL, and PDFBox** to automate hotel operations such as guest handling, room booking, reservations, payments, and report generation.

</div>

---

## 💡 About the Project

This project is designed to simplify hotel management workflows by automating essential operations including:

- Guest registration
- Room allocation
- Reservation handling
- Payment management
- PDF report generation
- Employee records management
- Dashboard-based navigation

It provides a **user-friendly blue/cyan-themed interface** with real-time database integration.

---

## ✨ Features

### 👤 Guest Management
- Add new guest details
- Update guest information
- Delete guest records
- Search guest details
- Input validation for phone and email

### 🛏 Room Management
- Add and manage rooms
- Update room type and pricing
- Track room availability
- Room status:
  - Available
  - Booked
  - Maintenance
  - Out of Service

### 📅 Reservation Module
- Create room reservations
- Check-in / check-out dates
- Automatic stay duration calculation
- Automatic total amount calculation
- Date validation

### 💳 Payment Management
- Payment records
- Billing details
- Reservation payment tracking
- Customer payment history

### 📄 Report Generation
- PDF report generation using **Apache PDFBox**
- Reservation reports
- Payment reports
- Stay summaries

### 👨‍💼 Employee Management
- Add employee details
- Manage staff records
- Update and delete employee data

### 📊 Dashboard
- Centralized navigation UI
- Quick access to all modules
- Clean Swing-based interface

---

## 🛠 Tech Stack

| Technology | Purpose |
|---|---|
| Java Swing | Frontend UI |
| JDBC | Database Connectivity |
| MySQL | Backend Database |
| PDFBox | PDF Report Generation |
| NetBeans | IDE / Development |

---

## 📂 Project Structure

```bash
jdbc_programs/
│
├── DashboardUi.java
├── LoginUi.java
├── ManaeGuests.java
├── ManageEmployees.java
├── ManageRooms.java
├── PaymentsUI.java
├── ReportPDFBox.java
├── ReservationManagement.java
│
├── README.md
│
├── fontbox-2.0.29.jar
├── mysql-connector-j-9.3.0.jar
├── mysqljdbcdriver.zip
└── pdfbox-app-2.0.29.jar
```

---

## 📁 File Description

| File Name | Description |
|---|---|
| `DashboardUi.java` | Main dashboard screen |
| `LoginUi.java` | Login interface |
| `ManaeGuests.java` | Guest management operations |
| `ManageEmployees.java` | Employee management |
| `ManageRooms.java` | Room management |
| `PaymentsUI.java` | Payment handling |
| `ReportPDFBox.java` | PDF report generation |
| `ReservationManagement.java` | Reservation system |

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone <your-repository-link>
```

### 2️⃣ Open in NetBeans / IDE

Open the `jdbc_programs` folder in **NetBeans IDE**

### 3️⃣ Add Required JAR Files

Make sure these dependencies are added:

- `mysql-connector-j-9.3.0.jar`
- `pdfbox-app-2.0.29.jar`
- `fontbox-2.0.29.jar`

### 4️⃣ Configure MySQL Database

Create database in MySQL:

```sql
CREATE DATABASE hotel_management;
```

Update JDBC connection details in your Java files:

```java
String url = "jdbc:mysql://localhost:3306/hotel_management";
String user = "root";
String password = "your_password";
```

### 5️⃣ Run the Project

Start with:

```java
LoginUi.java
```

---

## 🎯 What This Project Demonstrates

✔ Real-time CRUD operations  

✔ Relational database handling  

✔ Form validation  

✔ Automated calculations  

✔ PDF report generation  

✔ Modular Java architecture  

✔ Scalable project structure  

✔ Real-world hotel workflow logic  

---

## 🚀 Future Enhancements

- Online booking integration
- Admin role management
- Email invoice system
- Customer check-in QR code
- Web version using Spring Boot
- Analytics dashboard

---

<div align="center">

### 💠 Built with Java + JDBC + MySQL

</div>
