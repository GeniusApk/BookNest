# BookNest

BookNest is an Android application built using Jetpack Compose that allows users to read PDF books and download them. The app features a clean UI, uses the MVVM architecture, and integrates Firebase.

## Download

You can download the latest version by clicking the button below.

<a href="https://github.com/your-username/BookNest/releases/download/v1.1/app-debug.apk" download>
  <img src="https://img.shields.io/badge/download-latest-blue" alt="Download">
</a>

## Screenshots

<img src="https://github.com/your-username/BookNest/assets/101592615/screenshot1.png" alt="Screenshot 1" width="200" height="400"> <img src="https://github.com/your-username/BookNest/assets/101592615/screenshot2.png" alt="Screenshot 2" width="200" height="400"> <img src="https://github.com/your-username/BookNest/assets/101592615/screenshot3.png" alt="Screenshot 3" width="200" height="400"> <img src="https://github.com/your-username/BookNest/assets/101592615/screenshot4.png" alt="Screenshot 4" width="200" height="400">

## Features

- **Read PDF Books:** Seamless reading experience for PDF books.
- **Download PDFs:** Download books for offline reading.
- **Clean UI:** Intuitive and user-friendly interface.
- **MVVM Architecture:** Ensures a clear separation of concerns.
- **Firebase Integration:** For authentication and database management.

## Technologies Used

- Jetpack Compose
- Firebase Authentication
- Firebase Firestore
- PDF Viewing Library (bouquet)
- Retrofit for network calls
- Room for local database

## Dependencies

```gradle
dependencies {
    implementation "androidx.compose.ui:ui:1.0.0"
    implementation "androidx.compose.material3:material3:1.0.0"
    implementation "com.google.firebase:firebase-auth:21.0.1"
    implementation "com.google.firebase:firebase-firestore:24.0.1"
    implementation "org.bouquet:bouquet:1.2.0"
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "androidx.room:room-runtime:2.3.0"
    kapt "androidx.room:room-compiler:2.3.0"
}
```

## Getting Started

To get started with BookNest, follow these steps:

1. **Clone this repository:**

    ```sh
    git clone https://github.com/your-username/BookNest.git
    ```

2. **Open the project in Android Studio.**

3. **Set up your Firebase project:**

    - Go to the [Firebase Console](https://console.firebase.google.com/).
    - Create a new project and add your Android app.
    - Download the `google-services.json` file and place it in the `app` directory.

4. **Build and run the project** on an emulator or a physical device.

## How to Contribute

If you'd like to contribute to BookNest, follow these steps:

1. **Fork this repository.**

2. **Create a new branch:**

    ```sh
    git checkout -b feature/your-feature
    ```

3. **Make your changes and commit them:**

    ```sh
    git commit -m 'Add some feature'
    ```

4. **Push to the branch:**

    ```sh
    git push origin feature/your-feature
    ```

5. **Submit a pull request.**

## Acknowledgements

- [Jetpack Compose](https://developer.android.com/jetpack/compose) for the modern UI toolkit.
- [Firebase](https://firebase.google.com/) for authentication and database services.
- [Bouquet](https://github.com/bbougot/AndroidPdfViewer) for PDF viewing.
- [Retrofit](https://square.github.io/retrofit/) for network requests.
- [Room](https://developer.android.com/training/data-storage/room) for local database management.

## Contact

For any inquiries or feedback, please contact us at mohd.aakib208381@gmail.com.

