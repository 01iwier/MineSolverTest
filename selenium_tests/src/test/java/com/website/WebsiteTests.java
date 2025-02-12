package com.website;

import org.testng.annotations.Test;
import com.BaseTest;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebsiteTests extends BaseTest {
    
    @Test
    public void test() {
        // Accept cookies
        basePage.click(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]"));
        basePage.delay(1);

        // Press middle value 5_5 for beginner or 9_15 for expert
        basePage.click(By.xpath("//*[@id=\"9_15\"]"));

        revealTiles();
    }

    private void revealTiles() {
        long startTime = System.currentTimeMillis();
        long maxRunTime = 5 * 60 * 1000; // Run for 5 minutes

        while (System.currentTimeMillis() - startTime < maxRunTime) {

            if (isGameOver()) {
                System.out.println("GAME OVER");
                basePage.delay(10000);
                break;
            }

            boolean changesMade = false;

            List<WebElement> tiles = driver.findElements(By.cssSelector(".square"));
            List<WebElement> blankTiles = new ArrayList<>();

            for (WebElement tile : tiles) {
                try {
                    String className = tile.getDomAttribute("class");

                    if (className != null && className.contains("green")) {
                        tile.click();
                        changesMade = true;
                    } else if (className != null && className.contains("red")) {
                        rightClick(tile);
                        changesMade = true;
                    } else if (className != null && className.contains("blank")) {
                        blankTiles.add(tile);
                    }
                } catch (Exception e) {
                    System.out.println("Element no longer available: " + e.getMessage());
                }
            }
        }
    }

    private void rightClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    private boolean isGameOver() {
        WebElement minesTens = driver.findElement(By.id("mines_tens"));
        WebElement minesOnes = driver.findElement(By.id("mines_ones"));

        // Get the class attribute of both elements
        String tensClass = minesTens.getDomAttribute("class");
        String onesClass = minesOnes.getDomAttribute("class");

        // Check if both have the class "time0"
        return tensClass.contains("time0") && onesClass.contains("time1");
    }

}
