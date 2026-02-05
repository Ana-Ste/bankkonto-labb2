package se.ithogskolan.ana.bankkontolabb2.e2e;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalanceE2ETest {

    static Playwright playwright;
    static Browser browser;

    BrowserContext context;
    Page page;

    @BeforeAll
    static void startBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @AfterAll
    static void stopBrowser() {
        browser.close();
        playwright.close();
    }

    @BeforeEach
    void setUp() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void tearDown() {
        context.close();
    }

    @Test
    void pageLoads() {
        page.navigate("http://localhost:8080/");
        assertTrue(page.locator("text=My Account").isVisible());
    }

    @Test
    void balanceIsZero() {
        page.navigate("http://localhost:8080/");
        assertEquals("0", page.locator("#balance").innerText().trim());
    }
}
