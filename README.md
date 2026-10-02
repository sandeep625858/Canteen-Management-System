# Canteen Management System

A web-based canteen management application developed during an internship at **NRI FinTech**. The system provides separate workflows for users and administrators, covering menu management, food ordering, payments, wallet handling, feedback, user administration, order delivery, and report generation.

## Project Overview

The Canteen Management System is designed to digitize day-to-day canteen operations through role-based dashboards.

Users can register, log in, browse the menu, place or cancel orders, make payments, manage their wallet, submit feedback, and update their profile.

Administrators can manage menu items, users, orders, feedback, and generate downloadable reports.

## Key Features

### User Features

- User registration and login
- Role-based user dashboard
- View available menu items
- Place food orders
- Opt out of ordering for a day
- View current and previous orders
- Cancel placed orders
- View pending payments and payment status
- Pay for an individual order or multiple pending orders
- Wallet balance management
- Add money to wallet
- Submit feedback
- Update profile details
- Change/reset password

### Admin Features

- Secure admin login
- Admin dashboard
- View and manage menu items
- Add new food items
- Update existing menu items
- Mark menu items as unavailable
- View all orders
- Mark orders as delivered
- View and manage registered users
- Activate inactive users
- Update user details
- Mark users as inactive
- View submitted feedback
- Generate downloadable reports for:
  - Menu data
  - User data
  - Order data
- Update admin profile
- Change/reset password


## My Contributions

This project was developed as a team internship project. My assigned responsibilities focused primarily on the **user-side ordering and payment flow**, together with profile-management functionality.

### Features I Developed

- Implemented the **user food viewing and ordering flow**, allowing users to browse available food items and place orders.
- Worked on the **order payment functionality** for user orders.
- Implemented **user profile update** functionality.
- Worked on **admin profile update** functionality.
- Used **Spring Boot, SQL, JavaScript, Bootstrap, Thymeleaf and JPA Repository** as part of these assigned features.
- Investigated and handled implementation issues including:
  - Filtering logic while displaying/ordering food items.
  - A Spring Boot **Whitelabel Error** encountered during Thymeleaf integration.

### Internship Task Breakdown

| Feature | Status | Time Taken | Key Issue Faced | Technologies / Approach |
| --- | --- | ---: | --- | --- |
| View and order food items for user | Completed | 4 days | Filtering | Spring Boot, SQL, JavaScript |
| Order payment | Completed | 2 days | Whitelabel Error during Thymeleaf integration | Spring Boot, Bootstrap, SQL |
| Update user and admin profile | Completed | 1 day | — | Spring Boot, JavaScript, JPA Repository |

> The contribution details above are based on the original internship project allocation and delivery documentation.


## Technology Stack

| Layer | Technologies |
| --- | --- |
| Language | Java 11 |
| Backend | Spring Boot |
| Security | Spring Boot Security |
| Architecture | Spring MVC |
| Persistence | Hibernate, JPA |
| Database | Oracle SQL |
| Frontend | Thymeleaf, HTML5, CSS3, JavaScript |
| UI Framework | Bootstrap |
| Reporting | Apache POI |
| Build Tool | Apache Maven |
| Version Control | Git, GitLab |
| UI Icons | Font Awesome |

## Application Architecture

The application follows the **Spring MVC (Model-View-Controller)** design pattern.

```text
Browser
   |
   v
Spring MVC Controllers
   |
   v
Business / Application Logic
   |
   v
JPA / Hibernate
   |
   v
Oracle Database
```

Authentication and authorization are handled using Spring Boot Security, while Thymeleaf is used to render server-side views.

## Functional Flow

### User Flow

```text
Register / Login
      |
      v
User Dashboard
      |
      +--> View Menu --> Place Order / Opt Out
      |
      +--> View Orders --> Cancel Order
      |
      +--> Payments --> Pay Order(s) --> Update Wallet / Payment Status
      |
      +--> Wallet --> Add Money
      |
      +--> Feedback
      |
      +--> Profile / Password Management
```

### Admin Flow

```text
Admin Login
     |
     v
Admin Dashboard
     |
     +--> Menu Management
     |      +--> Add
     |      +--> Update
     |      +--> Mark Unavailable
     |
     +--> Order Management --> Mark Delivered
     |
     +--> User Management
     |      +--> View / Update
     |      +--> Activate / Deactivate
     |
     +--> Feedback
     |
     +--> Report Generation
            +--> Menu Report
            +--> User Report
            +--> Order Report
```

## Major Application Routes

### General

| Endpoint | Purpose |
| --- | --- |
| `/` | Landing page |
| `/register` | User registration |

### Admin

| Endpoint | Purpose |
| --- | --- |
| `/admin/` | Admin dashboard |
| `/admin/menu` | View menu |
| `/admin/addItemForm` | Add food item form |
| `/admin/update/{foodId}` | Update food item |
| `/admin/viewAllUser` | View users |
| `/admin/userDetails/{id}` | View/update a user |
| `/admin/userActivate/{id}` | Activate a user |
| `/admin/DeliverOrder` | View orders for delivery |
| `/admin/exportOptions` | Report generation options |
| `/admin/menuReport` | Download menu report |
| `/admin/userReport` | Download user report |
| `/admin/orderReport` | Download order report |
| `/admin/feedback` | View submitted feedback |

### User

| Endpoint | Purpose |
| --- | --- |
| `/user/` | User dashboard |
| `/user/menu` | View menu |
| `/user/menu/selection` | Select food items for an order |
| `/user/menu/optOut` | Opt out for the day |
| `/user/payment` | View pending payments |
| `/user/viewuserorder` | View user orders |
| `/user/cancelorder` | Cancel an order |
| `/user/feedbackform` | Submit feedback |
| `/user/add` | Add money to wallet |
| `/user/details` | View user profile |

## Reporting

The application uses **Apache POI** to generate Microsoft Excel reports. Administrators can generate reports for:

- Menu information
- Registered users
- Orders

## Security

The application uses **Spring Boot Security** to support authenticated access and separate user/admin workflows.

> The original project documentation does not specify the detailed security configuration, password-encoding strategy, or authorization rules, so those implementation details are intentionally not claimed here.

## Frontend

The frontend is server-rendered using **Thymeleaf** and styled with **Bootstrap**, HTML5, CSS3, JavaScript, and Font Awesome.

The landing page includes:

- Navigation bar
- Image carousel
- Login/registration section
- Services section
- Footer with social/contact links

## Project Documentation

A project presentation is available on Canva:

[View the Canteen Management System presentation](https://www.canva.com/design/DAFW49T9MXs/fh_I2pElVeYhFSlW10YHIg/edit)

## Possible Future Enhancements

These are suggested improvements rather than features documented in the original project:

- REST API-based backend
- React frontend
- Containerization with Docker
- Automated tests with JUnit and Mockito
- CI/CD pipeline
- Email or push notifications for order status
- Centralized exception handling and validation
- Audit logging
- Improved payment integration
- Dashboard analytics
- Deployment to a cloud platform

## Resume-Friendly Project Summary

**Canteen Management System — NRI FinTech Internship Project**

Contributed to a team-developed canteen management web application built with Java 11, Spring Boot, Spring Security, Hibernate/JPA, Oracle, Thymeleaf and Bootstrap. Personally developed user-side food viewing and ordering, order payment, and user/admin profile update functionality. Worked with Spring Boot, SQL, JavaScript, Bootstrap, Thymeleaf and JPA repositories, while troubleshooting filtering logic and Thymeleaf integration issues.

## Note on Source Code

If this project was developed as part of an employer internship, confirm that you have permission before publishing company-owned source code, internal assets, credentials, or proprietary material in a public repository. A project description, architecture overview, and screenshots can still be used in a portfolio when permitted.
