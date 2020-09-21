package pages;

import lib.Services;
import org.openqa.selenium.WebDriver;
import utils.Log;

public class CheckBoxPage extends Services {
    private Log logger= new Log();
    private String xpathToggleButton ="//*[@id=\"tree-node\"]//button[@aria-label='Toggle']";
    private String xpathBoxList ="//*[@id=\"tree-node\"]//ol/li";
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

}
