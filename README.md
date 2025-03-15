# JetpackCompose
#API List Viewer with Clean Architecture
This project demonstrates a modern Android app following Clean Architecture principles. It retrieves a list of data from a remote API using Retrofit, displays the list in a Jetpack Compose UI, and stores the list locally in a Room database. The app uses Dagger Hilt for dependency injection to manage dependencies efficiently.
Key Features:
    Clean Architecture: The app is structured into layers, separating concerns and making the codebase scalable and maintainable.
    Jetpack Compose: Utilizes Jetpack Compose to build the UI in a declarative and modern way.
    Retrofit: Fetches data from a remote API.
    Dagger Hilt: Manages dependency injection to ensure the app’s components are loosely coupled.
    Room Database: Caches the fetched data locally in a Room database, and the app retrieves the list from the database when available.
    Repository Pattern: The data is pulled from the repository, which abstracts data sources (API and database) for easier management and testing.

Architecture
Clean Architecture Layers:
    Presentation Layer: Handles the UI, built using Jetpack Compose. This layer interacts with the ViewModel to display data.
    Domain Layer: Contains business logic and use cases. This layer is independent of any framework and is only concerned with the core functionality.
    Data Layer: Responsible for data operations, interacting with both the API (Retrofit) and Room Database for storing and retrieving data.

The app communicates between these layers, making it easy to manage and test individual components.
Tech Stack
    Jetpack Compose: For building modern, declarative UIs.
    Retrofit: For API calls and data fetching.
    Room Database: To persist data locally on the device.
    Dagger Hilt: For dependency injection, making components more modular and easier to test.
    Kotlin: The programming language used to build the app.

Installation

    Clone the repository:

    bash

    git clone https://github.com/yourusername/sample-project.git

    Open the project in Android Studio.

    Make sure to update your API endpoint in the Retrofit client if necessary.

    Sync the project with Gradle files.

    Run the app on your emulator or physical device.

How It Works

    The MainActivity calls the ViewModel, which initiates the process of fetching data.
    The ViewModel interacts with the Repository, which fetches data either from the Room Database or the APIdepending on the availability of data.
    If data is not available in the database, it will fetch from the API and store it in the database for later use.
    Dagger Hilt handles all dependencies, including the Retrofit service, Room database, and Repository.

Example
Repository Flow:

    Data Fetching: The app first attempts to pull data from the Room database. If no data is available, it calls the Retrofit API to fetch data from the remote server.
    Room Caching: Once data is fetched from the API, it's stored in the Room database for offline use.
    UI Update: The UI listens for data updates and reflects them instantly using Jetpack Compose.

Testing
This project follows a clean architecture, which makes unit testing easier. You can write tests for each layer independently:

    Domain Layer: Test use cases.
    Data Layer: Test repositories for data fetching and caching.
    Presentation Layer: Use Jetpack Compose Test APIs for UI testing.


