# Android TODO Application 

This repository contains a project built using Compose framework, ROOM Database, Clean Architecture, and MVVM design pattern.

Project Overview
The project aims to demonstrate the implementation of modern Android development practices and architectural patterns to create a robust and maintainable application. It leverages the following key technologies:

Compose framework: Jetpack Compose is Android's modern toolkit for building native UI. It simplifies and accelerates UI development by using a declarative approach.

ROOM Database: ROOM is a persistence library that provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.

Clean Architecture: The project follows the principles of Clean Architecture, which promotes separation of concerns, testability, and maintainability by dividing the application into distinct layers: Domain, Data, and Presentation.

MVVM Design Pattern: MVVM (Model-View-ViewModel) is used to separate the presentation layer from the business logic. It promotes a clear separation of concerns and facilitates easier testing and maintenance.

Project Structure
The project is structured following Clean Architecture principles:

domain: Contains the business logic or domain layer of the application. This layer includes entities, use cases, and any business rules.

data: This layer is responsible for interacting with external data sources such as databases or APIs. It contains repository implementations and data sources.

presentation: This layer handles the UI logic and presentation of data. It contains the ViewModels, UI components, and navigation logic.



![Screenshot_20240511-115858_TODO](https://github.com/sunil553/TODO-Room/assets/10163144/f19cb143-51c0-4459-a14e-08a8d035dba8)
![Screenshot_20240511-115901_TODO](https://github.com/sunil553/TODO-Room/assets/10163144/9d70ef3c-0386-4c1f-ac25-3364f590c0ad)
![Screenshot_20240512-154938_TODO](https://github.com/sunil553/TODO-Room/assets/10163144/4e8e60f4-a7a4-42b8-8e90-c22f31d2d9a8)
