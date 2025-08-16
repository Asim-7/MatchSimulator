# Match Simulator

A modern Android app for simulating matches, built with Jetpack Compose and following best practices.

## Screenshots
### Match Screen
<div style="display: flex; justify-content: space-around;">
  <img src="https://github.com/Asim-7/MatchSimulator/blob/master/screenshots/match_day_light.png" alt="Screenshot 1" width="48%">
  <img src="https://github.com/Asim-7/MatchSimulator/blob/master/screenshots/match_day_dark.png" alt="Screenshot 1" width="48%">
</div>

### Table Screen
<div style="display: flex; justify-content: space-around;">
  <img src="https://github.com/Asim-7/MatchSimulator/blob/master/screenshots/standings_light.png" alt="Screenshot 1" width="48%">
  <img src="https://github.com/Asim-7/MatchSimulator/blob/master/screenshots/standings_dark.png" alt="Screenshot 1" width="48%">
</div>

### Simulation Screen
<div style="display: flex; justify-content: space-around;">
  <img src="https://github.com/Asim-7/MatchSimulator/blob/master/screenshots/simulation_light.png" alt="Screenshot 1" width="48%">
  <img src="https://github.com/Asim-7/MatchSimulator/blob/master/screenshots/simulation_dark.png" alt="Screenshot 1" width="48%">
</div>

## Getting Started

1. **Clone the repository**
2. **Open in Android Studio**
3. **Build and run on emulator or device**

## Project Structure

- `data/`: Data models, Room database and repositories.
- `di/`: Hilt modules for dependency injection.
- `ui/`: UI screens, there components and ViewModels for state management.
- `utils/`: Utility functions and extensions.
- `repository/`: Data sources and business logic.
- `navigation/`: Navigation graph and routes.

## Tech Stack

- Kotlin
- Jetpack Compose
- Hilt
- Navigation Compose
- Room Database
- Lottie
- JUnit, Espresso, Compose Test

## Features

- **MVVM Architecture**: Separation of concerns using ViewModel, Repository, and UI layers.
- **Jetpack Compose**: Declarative UI for fast and flexible development.
- **Navigation**: Compose Navigation for seamless screen transitions.
- **Hilt**: Dependency injection for scalable and testable code.
- **Room Database**: Local data storage with a robust SQLite database.
- **State Management**: ViewModel and StateFlow for reactive UI updates.
- **Coroutines**: Asynchronous programming for smooth performance.
- **Material Design**: Modern UI components and themes.
- **Dark Mode Support**: Automatic theme switching based on system settings.
- **Animations**: Smooth transitions and animations using Jetpack Compose.
- **Lottie Animation**: Rich animated UI elements for enhanced user experience.
- **Unit Tests**: Business logic tested with JUnit.
- **UI Tests**: Compose UI tests for user interface validation.
- **Integration Tests**: End-to-end flow verification.

## Testing

- **Unit Tests**: Located in `test/`
- **UI Tests**: Located in `androidTest/`
- **Integration Test**: Located in `androidTest/`

## License

MIT License

---

For more details, see the source code and documentation in each module.
