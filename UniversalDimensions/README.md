# 🌍 Universal Dimensions: A Study in Geometry

An exploration of geometry through the lens of the everyday—and the extraordinary. This project utilizes **inheritance** and **polymorphism** to calculate the physical properties of three distinct objects: a planet, a power cell, and a piece of folklore.

## 🛠️ The Objects
Instead of generic shapes, this project implements specific real-world (and imaginary) entities:

* **The Sphere (Planet Earth):** Calculates the vast surface area and volume of our home using an average radius of 6,371 km.
* **The Cylinder (AA Battery):** A precision calculation of a standard power cell (14.5mm x 50.5mm).
* **The Cone (Gnome Hat):** A whimsical addition that calculates the dimensions of a tall, pointy felt hat.

## 💻 Technical Architecture
This project demonstrates core **Object-Oriented Programming (OOP)** principles:

1. **Abstraction:** The base `Shape` class defines the contract for all 3D objects, requiring them to have area and volume logic.
2. **Inheritance:** Specific classes extend `Shape` to implement unique geometric formulas for spheres, cylinders, and cones.
3. **Polymorphism:** A single `ShapeArray` stores and iterates through different object types, dynamically calling the correct overridden methods for each instance.

## 📊 Sample Output
```text
=== Universal Dimensions Project Output ===

Object: Planet Earth | Radius: 6371.00 km
Surface Area: 510064471.91 sq km | Volume: 1083206916845.75 cubic km
--------------------------------------------------
Object: AA Battery | Radius: 7.25 mm | Height: 50.50 mm
Surface Area: 2630.01 sq mm | Volume: 8338.99 cubic mm
--------------------------------------------------
Object: Gnome's Pointy Hat | Base Radius: 10.00 cm | Height: 25.00 cm
Surface Area: 1160.01 sq cm | Volume: 2617.99 cubic cm
--------------------------------------------------

## 💡 Project Reflection: Why These Objects?

The goal of this project was to move beyond abstract mathematical shapes and see how **Object-Oriented Programming** can model the real world. By choosing these three objects, I wanted to demonstrate the scale and versatility of the code:

* **The Macro (Earth):** Shows how the `Sphere` class handles massive, planetary-scale data.
* **The Micro (Battery):** Shows how the `Cylinder` class applies to precise, everyday engineering.
* **The Imaginative (Gnome Hat):** Shows that `Cone` logic can be applied to anything, even objects from folklore.

This approach made the implementation of **polymorphism** much more intuitive—even though these objects have nothing in common in the "real world," they all share the same geometric "DNA" defined in the `Shape` base class.

**Developed as part of the CSC372 Module 4 Critical Thinking Assignment.**