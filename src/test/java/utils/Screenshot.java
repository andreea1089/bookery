//package utils;
//
//import com.google.common.io.Files;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.TestWatcher;
//import org.junit.platform.engine.TestExecutionResult;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import java.io.File;
//import java.io.IOException;
//import java.util.Optional;

//public class Screenshot implements TestWatcher {
//
//
//    @Override
//    public void testFailed(ExtensionContext context, Throwable cause) {
//        System.out.println("YESSSSSSS");
//        System.out.println(context.getDisplayName());
//    }
//
//    @Override
//    public void testDisabled(ExtensionContext context, Optional<String> reason) {
//
//    }
//
//    @Override
//    public void testSuccessful(ExtensionContext context) {
//
//    }
//
//    @Override
//    public void testAborted(ExtensionContext context, Throwable cause) {
//
//    }
//}
