# OCR Jetpack compose app

![android](https://img.shields.io/badge/Android-OCR%20ID%20Card%20Passport-blue)

## Table of Contents

- [Project Description](#project-description)
- [Features](#features)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)
- [Project Structure](#project-structure)
- [Screenshots](#screenshots)

## Project Description

HamzaOCR is a real-time Optical Character Recognition (OCR) application built using Kotlin and Jetpack Compose. It leverages the CameraX library for camera functionality and ML Kit for text recognition. The application scans documents and extracts ID numbers in real-time.

## Features

- Real-time text recognition using ML Kit
- Camera preview using CameraX
- Extracts ID numbers from scanned text
- User-friendly interface with Jetpack Compose

## Setup Instructions

### Prerequisites

- Android device or emulator with camera support
- Minimum SDK version 24

### Installation

1. **Clone the repository:**
   ```sh
   git clone https://github.com/hamza-ezzahiry/HamzaOCR.git
   cd HamzaOCR
   ```

2. **Open the project in Android Studio:**
   - Open Android Studio.
   - Select `Open an existing project`.
   - Navigate to the cloned repository and select it.

3. **Build the project:**
   - Click on `Build` > `Make Project` or press `Ctrl+F9`.

4. **Run the application:**
   - Connect your Android device or start an emulator.
   - Click on `Run` > `Run 'app'` or press `Shift+F10`.

## Usage

1. **Launch the application on your device.**
2. **Point the camera at a document containing an ID number.**
3. **The application will automatically detect and display the ID number.**

## Contributing

We welcome contributions to HamzaOCR! To contribute:

1. **Fork the repository.**
2. **Create a new branch:**
   ```sh
   git checkout -b feature/your-feature-name
   ```
3. **Make your changes and commit them:**
   ```sh
   git commit -m 'Add some feature'
   ```
4. **Push to the branch:**
   ```sh
   git push origin feature/your-feature-name
   ```
5. **Open a pull request.**

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or feedback, please contact:

- **Hamza Ezzahiry**
- **GitHub:** [hamza-ezzahiry](https://github.com/hamza-ezzahiry)

## Project Structure

| Directory/File                | Description                                      |
|-------------------------------|--------------------------------------------------|
| `app/src/main/java/ma/cires/hamzaocr` | Main source code directory                     |
| `app/src/main/res`             | Resource files (layouts, strings, etc.)          |
| `gradle/libs.versions.toml`    | Dependency versions configuration                |
| `app/build.gradle.kts`         | Module-level Gradle configuration                |
| `build.gradle.kts`             | Project-level Gradle configuration               |

## Screenshots

I will add them sooner :)
