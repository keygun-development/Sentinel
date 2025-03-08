# **Meteor Addon: Sentinel**

A custom addon for the **Meteor Client** with additional modules and features that the default meteor client is lacking.

## **Installation**
1. Download the latest build from [releases](#) *(update this link)*.
2. Place the `.jar` file in the `mods` folder of your Minecraft installation.
3. Launch the game and enjoy your new modules!

## **Modules Overview**

| Module Name        | Category | Description                                         |
|--------------------|----------|-----------------------------------------------------|
| **FriendNotifier** | Misc     | Notifies you when a friend joined the server.       |

## **Project Structure**

```text
.
│── .github
│   ╰── workflows
│       │── dev_build.yml
│       ╰── pull_request.yml
│── gradle
│   ╰── wrapper
│       │── gradle-wrapper.jar
│       ╰── gradle-wrapper.properties
│── src
│   ╰── main
│       │── java
│       │   ╰── com
│       │       ╰── example
│       │           ╰── addon
│       │               │── commands
│       │               │   ╰── CommandExample
│       │               │── hud
│       │               │   ╰── HudExample
│       │               │── modules
│       │               │   ╰── FriendNotifier
│       │               ╰── Sentinel
│       ╰── resources
│           │── assets
│           │   ╰── template
│           │       ╰── icon.png
|           |── fabric.mod.json
│           ╰── sentinel.mixins.json
│── .editorconfig
│── .gitignore
│── build.gradle
│── gradle.properties
│── gradlew
│── gradlew.bat
│── LICENSE
│── README.md
╰── settings.gradle
```

## **How to Build**
1. Clone this repository.
2. Modify the template to add new modules.
3. Build using Gradle:
   ```sh
   ./gradlew build
   ```
4. Find the compiled `.jar` file in the `/build/libs` directory.  
