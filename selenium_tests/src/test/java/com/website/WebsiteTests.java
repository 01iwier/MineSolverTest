package com.website;

import org.testng.annotations.Test;
import com.BaseTest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebsiteTests extends BaseTest {
    
    @Test
    public void startGame() {
        // Accept cookies
        basePage.click(By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]"));
        basePage.delay(1);

        // Press a random middle tile
        basePage.click(By.xpath("//*[@id=\"9_15\"]"));
        // Set xpath value to 5_5 for beginner or 9_15 for expert)

        revealTiles();
    }

    private void revealTiles() {
        long startTime = System.currentTimeMillis();
        long maxRunTime = 600_000; // Run for 10 minutes

        // Set holds all unrevealed tiles, revealed tiles removed from set
        Set<WebElement> unprocessedTiles = new HashSet<>(driver.findElements(By.cssSelector(".square")));

        while (System.currentTimeMillis() - startTime < maxRunTime) {

            if (isGameOver()) {
                System.out.println("FINISHED");
                basePage.delay(10000);
                break;
            }

            // Use iterator to avoid indexing errors when items removed from set
            Iterator<WebElement> iterator = unprocessedTiles.iterator();
            while (iterator.hasNext()) {
                WebElement tile = iterator.next();
                try {
                    String className = tile.getDomAttribute("class");

                    if (className == null) continue;

                    if (className.contains("green")) {
                        basePage.click(tile);
                        iterator.remove();
                    } else if (className.contains("red")) {
                        basePage.rightClick(tile);
                        iterator.remove();
                    }
                } catch (Exception e) {
                    System.out.println("Element no longer available: " + e.getMessage());
                    iterator.remove();
                }
            }
        }
    }

    // Check whether the mines left display is 0, value extracted from class name
    private boolean isGameOver() {
        WebElement minesTens = driver.findElement(By.id("mines_tens"));
        WebElement minesOnes = driver.findElement(By.id("mines_ones"));
        String tensClass = minesTens.getDomAttribute("class");
        String onesClass = minesOnes.getDomAttribute("class");
        return tensClass.contains("time0") && onesClass.contains("time0");
    }

}
