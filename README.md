# codefellowship

This repo holds a "RESTful" spring server with multiple get routes.

## Architecture

#### Main Files
  * [Controllers](.src/main/java/com/chidrome/codefellowship/Controllers)
  * [Models](.src/main/java/com/chidrome/codefellowship/Models)
  * [Main](./src/main/java/com/chidrome/codefellowship)
  
## Usage
-`git clone repo`
- Open terminal, and run this command: `./gradlew bootRun`
  
#### Routes
* `/`: will return `Home Route`
* `/login`: will take you to the login page.
* `/signup`: will take you to the signup page.
    * includes POST route that takes you to the `/profile` page to display users info
* `/profile`: will display the currently logged in users profile.
