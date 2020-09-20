package pages;

import io.qameta.allure.Step;
import lib.FileFunctions;
import lib.Services;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import utils.Log;

import java.nio.file.Paths;

public class UploadDownloadPage extends Services {
    private Log logger= new Log();
    Thread t= new Thread();

    private String xpathDownloadUploadHeader="//*[@id=\"app\"]//div[text()='Upload and Download']";
    private String xpathUploadButton="//*[@id=\"uploadFile\"]";
    private String xpathDownloadButton="//*[@id='downloadButton']";
    private String xpathUploadFile ="//*[@id='uploadedFilePath']";



    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify header of Download Upload page")
    public UploadDownloadPage verifyTitle() {
        logger.info("Verify header of Download Upload page");
        waitForElement("xpath",xpathDownloadUploadHeader);
        logger.info("Download Upload Page Loaded");
        return this;
    }

    @Step("Verify Select button is visible")
    public UploadDownloadPage verifySelectPresent()
    {   logger.info("Verify Select button is visible");
        assertElementVisible("xpath",xpathUploadButton,true);
        return this;
    }

    @Step("Verify Download button is visible")
    public UploadDownloadPage verifyDownloadButtonPresent()
    {   logger.info("Verify Download button is visible");
        assertElementVisible("xpath",xpathDownloadButton,true);
        return this;
    }


    @Step("Click on Select")
    public UploadDownloadPage clickOnSelect() throws InterruptedException {
        logger.info("Click on Select");
        Thread.sleep(1000);
        jsClick("xpath",xpathUploadButton);
        return this;
    }

    @Step("Select File to upload")
    public UploadDownloadPage sendKeysToUploadPopUP(String fileName) throws FindFailed, InterruptedException {
        logger.info("Select File to upload");
        s.swait("fileTextArea.PNG");
        s.findImage("fileTextArea.PNG");
        String workingDir = System.getProperty("user.dir");
        String currentPath = Paths.get(workingDir).toAbsolutePath().toString();
        String path=currentPath+"\\src\\main\\resources\\upload\\"+fileName;
        logger.info("Sending path to upload prompt");
        s.sendText("fileTextArea.PNG",path);
        return this;
    }

    @Step("Click on open to upload")
    public UploadDownloadPage clickOpenInUploadPopUP() throws InterruptedException, FindFailed {
        logger.info("Click on open to upload");
        s.swait("open.PNG");
        s.findImage("open.PNG");
        s.clickButton("open.PNG");
        return this;
    }

    @Step("Verify Download button is visible")
    public UploadDownloadPage verifyFilePresentAfterUpload(String Filename) throws InterruptedException {
        logger.info("Verify Download button is visible");
        String xpath=xpathUploadFile+"[contains(text(),'"+Filename+"')]";
        assertElementVisible("xpath",xpathDownloadButton,true);
        return this;
    }

    @Step("Click on Download")
    public UploadDownloadPage clickOnDownload() throws InterruptedException {
        logger.info("Click on Download Button ");
        jsClick("xpath",xpathDownloadButton);
        return this;
    }

    @Step("Verify Download")
    public UploadDownloadPage verifyDownload(String filename) throws InterruptedException {
        t.sleep(3000);
        logger.info("Verify Download");
        String workingDir = System.getProperty("user.dir");
        String currentPath = Paths.get(workingDir).toAbsolutePath().toString();
        String downloadFilepath =currentPath+"\\src\\main\\resources\\download";
        System.out.println(downloadFilepath);
        boolean value=filefunctions.isFileDownloaded(downloadFilepath,filename);
        simpleAssertTrue(value,"File is not downloaded");
        return this;
    }







}
