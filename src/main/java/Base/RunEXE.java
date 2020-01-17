package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class RunEXE {
    public static DesktopOptions options = new DesktopOptions();
    public static WiniumDriver winDriver;

    @Test
    public static void sikulixTest() throws FindFailed, InterruptedException {
        Screen s = new Screen();
        s.type("d", Key.WIN);
        Thread.sleep(3000);
        //s.click(Helper.rootPath+"\\src\\main\\resources\\sikulixImages\\file.png");
        s.doubleClick(Helper.rootPath + "\\src\\main\\resources\\sikulixImages\\file.png");
    }

//    @Test
//    public static void calculatorTest() throws MalformedURLException {
//        startProgram("C:\\Windows\\System32\\calc.exe");
//        WebElement test = winDriver.findElement(By.id("num7Button"));
//        test.click();
//        WebElement resultText = winDriver.findElementById("CalculatorResults");
//        resultText.sendKeys("123456789");
//        //winDriver.findElementById("").click();
//        String result = resultText.getAttribute("Name");
//        result = result.replace("Display is ","");
//        if(result.equalsIgnoreCase("7")){
//            System.out.println("Result " + result + " is correct");
//        } else {
//            System.out.println("Result " + result + " is not correct");
//        }
//    }

//    @Test
//    public static void notePadTest() throws MalformedURLException {
//        startProgram("C:\\Users\\Edi\\Desktop\\test text.txt");
//        String textInBox = "";
//        WebElement textBox = winDriver.findElementByName("Text Editor");


//        if(textInBox.equalsIgnoreCase(textBox.getAttribute("Text"))){
//            System.out.println("Passed");
//        } else {
//            System.out.println("Failed, text should be " + textInBox);
//        }

//        textInBox = "Hello World";
//
//
//        textBox.sendKeys(textInBox);
//
//        WebElement fileMenu = winDriver.findElementById("Item 1");
//        fileMenu.click();
//        WebElement saveMenu = winDriver.findElementByName("Save");
//        saveMenu.click();
//        WebElement exit = winDriver.findElementByName("Exit");
//
//
//        fileMenu.click();
//        exit.click();
//        startProgram("C:\\Users\\Edi\\Desktop\\test text.txt");
//        if(textInBox.equalsIgnoreCase(textBox.getAttribute("Text"))){
//            System.out.println("Passed");
//        } else {
//            System.out.println("Failed, text should be " + textInBox);
//        }
//    }

    public static void startProgram(String programPath) throws MalformedURLException {
        options.setApplicationPath(programPath);
        winDriver = new WiniumDriver(new URL("http://localhost:9999"), options);
    }

}
