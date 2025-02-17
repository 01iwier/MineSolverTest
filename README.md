# Automated Minesweeper Solver

This program automates playing Minesweeper using Selenium automation to create a WebDriver instance preloaded with the [Minesolver Chrome extension](https://chromewebstore.google.com/detail/minesolver/iobegaggjcgmiggimmgocbbenihefagl?hl=en) The bot repeatedly destroys tiles marked as safe and flags tiles that are guaranteed to contain mines, effectively solving games in record time.

## Demo
https://github.com/user-attachments/assets/37733288-5ec8-4e4c-b0c3-1f8271112326

## Installation
Download the repository and navigate to selenium_tests/src/test/java/com/website/WebsiteTests.java

## Usage
* Run the test method startGame()

## Troubleshooting
* If the program gets stuck and no tiles are highlighted it means that there are no certain options to be made:
  * Destroy a random unmarked tile
* If you hit a mine and the game ends:
  * close the browser window and re-run startGame()
