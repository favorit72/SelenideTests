package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyzerCount implements IRetryAnalyzer {
    private int nowCount = 0;
    private int maxCount = 1;

    @Override
    public boolean retry(ITestResult result) {

        if (nowCount < maxCount) {
            nowCount++;
            return true; //пока истина перезапускаем
        }
        System.out.println("Тест завален дважды");
        nowCount = 0;
        return false;
    }

}