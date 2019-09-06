package Base;

import java.io.IOException;

public class GenerateAllureReport {

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("cmd.exe /c start cmd /k \" cd src\\main\\resources\\allure\\bin && allure serve "+Helper.rootPath+"\\allure-results \"");
    }

}


