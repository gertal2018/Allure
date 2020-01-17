package PlayNiteTests;

import PlayNitePages.GameDetails;
import PlayNitePages.Menu;
import org.testng.annotations.Test;

public class AddingNewGame {

    @Test
    public static void addingNewGameTest(){
        Menu.startPlayNite();
        Menu.clickLogo();
        Menu.clickNewGame();
        Menu.clickManually();
        GameDetails.enterGameName("00 Test game");
        GameDetails.clickSaveButton();
    }
}
