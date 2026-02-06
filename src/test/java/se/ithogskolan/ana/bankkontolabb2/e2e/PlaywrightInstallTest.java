package se.ithogskolan.ana.bankkontolabb2.e2e;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class PlaywrightInstallTest {

    @Test
    void installBrowser() {

        try (Playwright playwright = Playwright.create()) {

            Browser browser =
                    playwright.chromium().launch(
                            new BrowserType.LaunchOptions().setHeadless(true)
                    );

            browser.close();
        }

    }
}
