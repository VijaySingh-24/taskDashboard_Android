Android Task Manager App (Clean Architecture + MVVM + Kotlin)

A beautifully designed task dashboard application built with Clean Architecture, MVVM, Kotlin. The app allows users to manage and track tasks across various projects with intuitive progress tracking and clean UI.

Architecture Overview

The project follows Clean Architecture principles:

📦 com.example.taskdashboard
├── data                # Local DB, network, DTOs, repositories
├── domain              # UseCases, Entities, Repository Interfaces
├── presentation        # ViewModels, UI (Activity/Fragment/Compose), Mappers
└── di                  # Dependency Injection (Hilt)

Tech Stack
Layer	      Tools
Language   	Kotlin
Architecture	MVVM + Clean Architecture
Dependency   Injection	Hilt
Networking	Retrofit + OkHttp
Coroutines	Coroutines
UI	        XML Layouts

Modules
data: Retrofit API

domain: Business logic (UseCases), pure Kotlin

presentation: ViewModels, UI State, XML

di: Hilt Modules


Fetch Tasks
UI triggers ViewModel.getTasks()

ViewModel calls GetTasksUseCase

UseCase calls TaskRepository

Repository fetches from RemoteDataSource (Retrofit)

DTOs are mapped to domain models

LiveData emits the tasks back to UI


MVVM Best Pratice:

Avoid references to Views in ViewModels.
Instead of pushing data to the UI, let the UI observe changes to it.
Distribute responsibilities, add a domain layer if needed.
Add a data repository as the single-point entry to your data.
Expose information about the state of your data using a wrapper or another LiveData.
Consider edge cases, leaks and how long-running operations can affect the instances in your architecture.
Don’t put logic in the ViewModel that is critical to saving clean state or related to data. Any call you make from a ViewModel can be the last one.

LiveData:

Yes , liveData is easy , powerful , but you should know how to use.
For livedate which will emit data stream , it has to be in your data layer , and don't inform those observables any thing else like in which thread those will consume , cause it is another
For livedata which will emit UI binding events, it has to be in your ViewModel Layer.
Coroutines:
It is light wight threads for asynchronous programming, Coroutines not only open the doors to asynchronous programming, but also provide a wealth of other possibilities such as concurrency, actors, etc.

Coroutines benefits:

Writing an asynchronous code is sequential manner.
Costing of create coroutines are much cheaper to crate threads.
Don't be over engineered to use observable pattern, when no need to use it.
Parent coroutine can automatically manage the life cycle of its child coroutines for you.
