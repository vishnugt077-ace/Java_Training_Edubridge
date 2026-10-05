# Library Management System 📚
A comprehensive Java-based Library Management System designed to handle item management, member registrations, borrowing workflows, fines, and waitlists using Object-Oriented Programming (OOP) concepts and data structures.
---
## 📌 Project Overview
The **Library Management System** automates library operations previously tracked on paper. It supports multi-type item tracking (Books, Magazines, and DVDs), auto-generated member IDs, fine calculations for overdue returns, maximum borrow limits, and an automated queue-based waitlist system.
- **Estimated Completion Time:** 10–12 Hours
- **Difficulty Level:** Moderate
---
## ✨ Features
- **Item Management:** Add and track different library items:
  - **Books** (Loan Period: 14 days | Fine: Rs. 2/day)
  - **Magazines** (Loan Period: 7 days | Fine: Rs. 2/day)
  - **DVDs** *(Bonus)* (Loan Period: 3 days | Fine: Rs. 10/day)
- **Member Management:** Register new members with auto-generated Member IDs and track their active loans.
- **Borrowing System:**
  - Strict borrowing limit: **Maximum 3 items** per member.
  - Automatic status updates (`Available` / `Issued`).
- **Return & Fine Calculation:** Calculates late fines automatically based on item type and days kept.
- **Automated Waitlist & Auto-Issue:**
  - FIFO Waitlist using `Queue` when an item is currently issued.
  - Automatic re-issuing to the next person in line upon item return.
- **Search & Reports:**
  - Case-insensitive search by title or author.
  - Comprehensive catalog report showing total, issued, and available items.
- **Bonus Capabilities:**
  - Most borrowed item tracking.
  - Ability for members to leave a waitlist.
---
## 🛠️ Concepts & Data Structures Used

| Concept / Data Structure | Usage in Project |
| :--- | :--- |
| **Abstract Class** | `LibraryItem` acts as the base template for common fields (`id`, `title`, `isAvailable`, `waitlist`). |
| **Inheritance & Polymorphism** | Subclasses (`Book`, `Magazine`, `DVD`) override methods (`getType()`, `getLoanDays()`, `getFineRatePerDay()`) dynamically without using `if-else` type checking. |
| **Encapsulation** | Private attributes with public getters/setters ensuring data security. |
| **`HashMap<K, V>`** | Provides fast lookups for items by ID (`HashMap<String, LibraryItem>`) and members by ID (`HashMap<Integer, Member>`). |
| **`ArrayList<T>`** | Tracks the dynamic list of borrowed items for each member. |
| **`Queue<T>` (`LinkedList`)** | Manages first-come, first-served waitlists for unavailable items using `offer()` and `poll()`. |

---
Member:
NAME: Vishnu K (solo)
USN : 1VJ25CS073
---
