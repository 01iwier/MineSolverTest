# Automated Minesweeper Solver

This program automates playing Minesweeper using Selenium automation to create a WebDriver instance preloaded with the [Minesolver Chrome extension](https://chromewebstore.google.com/detail/minesolver/iobegaggjcgmiggimmgocbbenihefagl?hl=en) The bot repeatedly destroys tiles marked as safe and flags tiles that are guaranteed to contain mines, effectively solving games in record time.

<img src="https://github.com/user-attachments/assets/a805b0d6-3c66-4119-8092-3398c7772461" width="650">

## Installation
Download the repository and navigate to selenium_tests/src/test/java/com/website/WebsiteTests.java

## Usage
* Run the test method startGame()

## Troubleshooting
* If the program gets stuck and no tiles are highlighted it means that there are no certain options to be made:
  * Destroy a random unmarked tile
* If you hit a mine and the game ends:
  * close the browser window and re-run startGame()
