<div align="center">

<!-- 💠 ANIMATED CYAN HEADER -->
<img src="https://capsule-render.vercel.app/api?type=waving&color=0:00FFFF,25:00CED1,50:20B2AA,75:008B8B,100:005F73&height=220&section=header&text=🏨%20Hotel%20Management%20System&fontSize=40&fontColor=ffffff&fontAlignY=38&desc=Java%20Swing%20%7C%20JDBC%20%7C%20MySQL%20%7C%20PDF%20Reports&descAlignY=58&descSize=16&animation=fadeIn" />

<br/>

<!-- 💠 TYPING ANIMATION -->
[![Typing SVG](https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=20&pause=1000&color=00FFFF&center=true&vCenter=true&width=750&lines=🏨+Complete+Hotel+Management+System;💠+Java+Swing+%7C+JDBC+%7C+MySQL;📄+PDF+Reports+with+PDFBox;🛏️+Reservations+%7C+Guests+%7C+Payments;💳+Real-Time+CRUD+Operations)](https://git.io/typing-svg)

<br/>

<!-- 💠 BADGES -->
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-00CED1?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-005F73?style=for-the-badge&logo=mysql&logoColor=white)
![PDFBox](https://img.shields.io/badge/PDFBox-20B2AA?style=for-the-badge)
![NetBeans](https://img.shields.io/badge/NetBeans-008B8B?style=for-the-badge)

<br/>

![Status](https://img.shields.io/badge/Status-Active-00FFFF?style=flat-square)
![Database](https://img.shields.io/badge/Database-MySQL-20B2AA?style=flat-square)
![Reports](https://img.shields.io/badge/PDF-Enabled-00CED1?style=flat-square)
![UI](https://img.shields.io/badge/UI-Java%20Swing-008B8B?style=flat-square)

# 🏨 Hotel Management System

A fully functional **Hotel Management System** developed using **Java Swing, JDBC, MySQL, and PDFBox** to automate hotel operations such as guest handling, room booking, reservations, payments, and report generation.

</div>

---

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

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

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

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

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

## 🛠 Tech Stack

| Technology | Purpose |
|---|---|
| Java Swing | Frontend UI |
| JDBC | Database Connectivity |
| MySQL | Backend Database |
| PDFBox | PDF Report Generation |
| NetBeans | IDE / Development |

---

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

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

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

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

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone <your-repository-link>
```

### 2️⃣ Open in NetBeans / IDE

Open the `jdbc_programs` folder in **NetBeans IDE**

### 3️⃣ Add Required JAR Files

- `mysql-connector-j-9.3.0.jar`
- `pdfbox-app-2.0.29.jar`
- `fontbox-2.0.29.jar`

### 4️⃣ Configure MySQL Database

```sql
CREATE DATABASE hotel_management;
```

```java
String url = "jdbc:mysql://localhost:3306/hotel_management";
String user = "root";
String password = "your_password";
```

### 5️⃣ Run the Project

```java
LoginUi.java
```

---

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

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

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

## 🚀 Future Enhancements

- Online booking integration
- Admin role management
- Email invoice system
- Customer check-in QR code
- Web version using Spring Boot
- Analytics dashboard

---

<div align="center">

> *"Smart hospitality begins with smart systems."* 💠

<br/>

<!-- 💠 CYAN FOOTER -->
<img src="https://capsule-render.vercel.app/api?type=waving&color=0:005F73,25:008B8B,50:20B2AA,75:00CED1,100:00FFFF&height=120&section=footer&animation=fadeIn" />

</div>
