# MensaSaver

MensaSaver is an Android application designed to help users manage their cafeteria (mensa) experience, track leftovers, earn rewards, and receive notifications. The app features user authentication, account management, and a modern UI with bottom navigation.

## Features

- **User Authentication:** Sign up and log in securely with email and password.
- **Admin Support:** Special admin access for designated users.
- **Bottom Navigation:** Easily switch between Home, Account, Leftovers, Rewards, and Notifications.
- **Fragment-based UI:** Each section is modular and managed via fragments.
- **Data Persistence:** User data is stored locally using SQLite via a custom `DatabaseHelper`.
- **Responsive UI:** Edge-to-edge layouts and adaptive icons for modern Android devices.

## Screenshots

## Getting Started

### Prerequisites

- Android Studio (Meerkat Feature Drop | 2024.3.2 or later)
- Android device or emulator (API 26+ recommended)
- Gradle

### Installation

1. **Clone the repository:**

2. Open Android Studio.
Select Open an existing project and choose the cloned folder.
Build the project:


Let Gradle sync and resolve dependencies.
Build and run on your device or emulator.
Project Structure
app/src/main/java/com/example/mensasaver/
MainActivity.kt - Handles user login.
SignUpActivity.kt - Handles user registration.
HomeActivity.kt - Main navigation activity after login.
DatabaseHelper.kt - SQLite database helper for user data.
fragments/ - Contains HomeFragment, AccountFragment, LeftoversFragment, RewardsFragment, NotificationsFragment.
app/src/main/res/layout/ - XML layout files for activities and fragments.
app/src/main/res/drawable/ - App icons and images.
app/src/main/res/mipmap-anydpi-v26/ - Adaptive launcher icons.


## Usage
-Sign Up:
Create a new account using your name, email, and password. 

-Log In:
Enter your registered email and password to log in.

-Navigate:
Use the bottom navigation bar to switch between Home, Account, Leftovers, Rewards, and Notifications.

-Database
Uses SQLite for local data storage.
User credentials and roles (admin/user) are stored securely.
Customization
Icons:
Adaptive icons are defined in mipmap-anydpi-v26/ic_launcher_round.xml and related drawable resources.
Fragments:
Add or modify fragments for new features.
Contributing
Contributions are welcome! Please open issues or submit pull requests for improvements or bug fixes.
