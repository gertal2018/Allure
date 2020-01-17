package PlayNitePages;

import Base.Helper;
import Base.SikulixBaseUI;

public class GameDetails {

    //Global elements
    static String saveButton = Helper.imageRoot + "\\PlayNite\\editGameSaveButton.png";
    static String cancelButton = Helper.imageRoot + "\\PlayNite\\editGameCancelButton.png";

    // General Tab elements
    static String gameNameField = Helper.imageRoot + "\\PlayNite\\gameNameField.png";

    public static void clickSaveButton(){
        SikulixBaseUI.clickElement(saveButton);
    }

    public static void clickCancelButton(){
        SikulixBaseUI.clickElement(cancelButton);
    }

    public static void enterGameName(String gameName){
        SikulixBaseUI.clickElement(gameNameField);
        SikulixBaseUI.selectAll();
        SikulixBaseUI.enterText(gameName);
    }
}
