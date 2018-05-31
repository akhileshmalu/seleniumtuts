package Retry;

import org.testng.*;
/**
 * @author: Akhilesh Maloo
 * @date: 2/4/18.
 */
public class RetryFailedTestCases implements IRetryAnalyzer{
    private  int retryCount = 0;

    private int maxCount = 2;

    public boolean retry(ITestResult iTestResult) {

        if(retryCount < maxCount) {
            System.out.println("Retrying "+ (retryCount+1) +"st time in " + iTestResult.getName());
            retryCount++;
            return true;
        }

        return false;
    }
}
