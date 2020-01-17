package WinApps;

import Base.SikulixBaseUI;
import org.testng.annotations.Test;

public class firstTest {

    @Test
    public static void myTest() throws InterruptedException {
        SikulixBaseUI.goToDesktop();
        Thread.sleep(3000);
        SikulixBaseUI.clickElement("PLayNite\\playNiteIcon.png");
        Thread.sleep(1000);
        SikulixBaseUI.clickElement("PlayNite\\playNiteLogo.png");
        SikulixBaseUI.clickElement("PlayNite\\addGame.png");
        SikulixBaseUI.clickElement("PlayNite\\manually.png");
        SikulixBaseUI.clickElement("PlayNite\\gameNameField.png");
        Thread.sleep(1000);
        SikulixBaseUI.selectAll();
        Thread.sleep(1000);
        SikulixBaseUI.enterText("My Automation game");
    }
}
