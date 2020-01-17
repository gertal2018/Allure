package WindowsPages;

import Base.Helper;
import Base.SikulixBaseUI;

public class RightClickMenu {
    static String copy = Helper.imageRoot + "\\rightClickMenu\\copy.png";
    static String paste = Helper.imageRoot + "\\rightClickMenu\\paste.png";
    static String cut = Helper.imageRoot + "\\rightClickMenu\\cut.png";
    static String delete = Helper.imageRoot + "\\rightClickMenu\\delete.png";
    static String rename = Helper.imageRoot + "\\rightClickMenu\\rename.png";

    public static void copy(){
        SikulixBaseUI.clickElement(copy);
    }

    public static void paste(){
        SikulixBaseUI.clickElement(paste);
    }

    public static void cut(){
        SikulixBaseUI.clickElement(cut);
    }

    public static void delete(){
        SikulixBaseUI.clickElement(delete);
    }

    public static void rename(){
        SikulixBaseUI.clickElement(rename);
    }
}
