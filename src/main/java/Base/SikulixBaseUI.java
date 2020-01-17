package Base;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;

public class SikulixBaseUI {

    public static Screen s = new Screen();

    public static void goToDesktop(){
        s.type("d", Key.WIN);
    }

    public static void doubleClickElement(String fileName) {
        try {
            s.doubleClick(fileName);
        } catch (Exception e) {
            System.out.println("File not found at location: " + fileName);
        }
    }

    public static void doubleClick(){
        s.doubleClick();
    }

    public static void clickElement(String fileName){
        try {
            s.click(fileName);
        } catch (Exception e) {
            System.out.println("File not found at location: " + fileName);
        }
    }

    public static void click(){
        s.click();
    }

    public static void rightClickElement(String fileName){
        try {
            s.rightClick(fileName);
        } catch (Exception e){
            System.out.println("File not found at location: " + fileName);
        }
    }

    public static void rightClick(){
        s.rightClick();
    }

    public static void enterText(String text){
        s.type(text);
    }

    public static void clickEnter(){
        s.type(Key.ENTER);
    }

    public static void testFunction(){
        try {
            System.out.println(s.waitText("Makarony"));
        } catch (Exception e) {
            System.out.println("OMG");
        }
    }

    public static void selectAll(){
        try {
            s.type("a", Key.CTRL);
        } catch (Exception e) {
            System.out.println("ERROR trying to CTRL+A");
        }
    }

    public static void clickBackspace(){
        s.type(Key.BACKSPACE);
    }
}
