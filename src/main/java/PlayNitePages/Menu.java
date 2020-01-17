package PlayNitePages;

import Base.Helper;
import Base.SikulixBaseUI;

public class Menu {

    static String icon = Helper.imageRoot + "\\PlayNite\\icon.png";
    static String logo = Helper.imageRoot + "\\PlayNite\\logo.png";
    static String fileMenu_Manually = Helper.imageRoot + "\\PlayNite\\manually.png";
    static String fileMenu_NewGame = Helper.imageRoot + "\\PlayNite\\addGame.png";

    public static void startPlayNite(){
        SikulixBaseUI.goToDesktop();
        try {
            Thread.sleep(3000);
        } catch (Exception e){

        }
        SikulixBaseUI.clickElement(icon);
    }

    public static void clickLogo(){
        SikulixBaseUI.clickElement(logo);
    }

    public static void clickNewGame(){
        SikulixBaseUI.clickElement(fileMenu_NewGame);
    }

    public static void clickManually(){
        SikulixBaseUI.clickElement(fileMenu_Manually);
    }

}
