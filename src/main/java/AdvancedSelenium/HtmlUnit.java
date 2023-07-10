package AdvancedSelenium;

import org.htmlunit.BrowserVersion;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HtmlUnit {
    @Test
    public void homePage() throws Exception {
        //HTML unit
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("https://htmlunit.sourceforge.io/");
            Assert.assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());
            System.out.println(page.getTitleText());

        }
    }

    @Test
    public void headlessMode(){
        //HTML unit driver
        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://htmlunit.sourceforge.io/");
        System.out.println(driver.getTitle());
    }
}
