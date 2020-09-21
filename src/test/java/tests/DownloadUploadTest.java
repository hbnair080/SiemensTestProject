package tests;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

public class DownloadUploadTest extends BaseTest {

    @Test
    public void verifyDownloadUploadPage() throws InterruptedException {
        homepage
                .clickOnElementCard()
                .clickOnUploadDownloadMenu()
                .verifyTitle()
                .verifySelectPresent()
                .verifyDownloadButtonPresent();

    }

    @Test
    public void verifyUploadFunction() throws FindFailed, InterruptedException {
        homepage
                .clickOnElementCard()
                .clickOnUploadDownloadMenu()
                .verifyDownloadButtonPresent()
                .clickOnSelect()
                .sendKeysToUploadPopUP("UploadTest.txt")
                .clickOpenInUploadPopUP()
                .verifyFilePresentAfterUpload("UploadTest.txt");

    }

    @Test
    public void verifyDownloadFunction() throws FindFailed, InterruptedException {
        homepage
                .clickOnElementCard()
                .clickOnUploadDownloadMenu()
                .clickOnSelect()
                .sendKeysToUploadPopUP("UploadTest.txt")
                .clickOpenInUploadPopUP()
                .verifyFilePresentAfterUpload("UploadTest.txt")
                .clickOnDownload()
                .verifyDownload("sampleFile");

    }

}
