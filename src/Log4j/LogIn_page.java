package Log4j;
//import org.openqa.selenium.*;

//import utility.Log;

public class LogIn_page {

	//static WebElement element = null;

public void txtbx_UserName(){

    //element = driver.findElement(By.id("log"));

	Log.info("Username text box found");

    //return element;

    }

public void txtbx_Password(){

    //element = driver.findElement(By.id("pwd"));

	Log.error("Password text box found");

    //return element;

    }

public void  btn_LogIn(){

    //element = driver.findElement(By.id("login"));

	//Log.fatal("Submit button found");
	//Log.trace("Trace Message!");
    Log.debug("Debug Message!");
    Log.info("Info Message!");
    Log.warn("Warn Message!");
    Log.error("Error Message!");
    Log.fatal("Fatal Message!");

    //return element;

    }

public static void main(String args[])

{
	LogIn_page lp= new LogIn_page();
	lp.txtbx_UserName();
	lp.txtbx_Password();
	lp.btn_LogIn();
}
}


