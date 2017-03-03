/*
Feb 25, 2017
FXMLDocumentController.java, FXMLDocumentController, Joni Sikiö <joni.sikio@student.lut.fi> 
Kuvaus sisällöstä: 
Kehitysympäristö: NetBeans
Muutoshistoria:
Lisenssi: default

 */
package tppcbot;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Joni Sikiö <joni.sikio@student.lut.fi>
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    CaptchaBreaker cb;
    @FXML
    private Button button;
    WebDriver driver;
    @FXML
    private ImageView imageView;
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    String trainerid;
    String acc;
    String pass;
    WebElement element;
    boolean FightBreaker;
    @FXML
    private TextField trainingAccountField;
    @FXML
    private Label tokenLabel;
    @FXML
    private Label captchaLabel;
    @FXML
    private ListView<trainer> trainingListView;
    trainerManager tm;
    @FXML
    private Label levelLabel;
    private Label accountInfoLabel;
    @FXML
    private ImageView pokeImageView;
    @FXML
    private ProgressBar LevelProgress;
    @FXML
    private Label playerLevelLabel;
    int startLevel;
    int currLevel;
    @FXML
    private TextField timeToRest;
    @FXML
    private TextField timeToRestRandom;
    @FXML
    private TextField timeBetweenRest;
    @FXML
    private TextField fightSleepTimeField;
    @FXML
    private TextField fightSleepRandomField;
    @FXML
    private TextField timeBetweenRestRandom;
    long startBigTime;
    long currBigTime;
    long estimatedTime;
    long random;
    @FXML
    private Label pokeLabel1;
    @FXML
    private ImageView pokeImage1;
    @FXML
    private ImageView pokeImage2;
    @FXML
    private Label pokeLabel2;
    @FXML
    private ImageView pokeImage3;
    @FXML
    private Label pokeLabel3;
    @FXML
    private ImageView pokeImage4;
    @FXML
    private Label pokeLabel4;
    @FXML
    private ImageView pokeImage5;
    @FXML
    private Label pokeLabel5;
    @FXML
    private ImageView pokeImage6;
    @FXML
    private Label pokeLabel6;
    @FXML
    private Label pokeLevelLabel1;
    @FXML
    private Label pokeLevelLabel2;
    @FXML
    private Label pokeLevelLabel3;
    @FXML
    private Label pokeLevelLabel4;
    @FXML
    private Label pokeLevelLabel5;
    @FXML
    private Label pokeLevelLabel6;
    ArrayList<Label> pokeLabel;
    ArrayList<ImageView> pokeImage;
    ArrayList<Label> pokeLevelLabel;
    ArrayList<TextField> pokeBreakLabel;
    ArrayList<Label> pokeItemLabel;
    int updateCalc;
    @FXML
    private TextField breakField3;
    @FXML
    private TextField breakField1;
    @FXML
    private TextField breakField4;
    @FXML
    private TextField breakField6;
    @FXML
    private TextField breakField5;
    @FXML
    private TextField breakField2;
    @FXML
    private CheckBox breakEnabled;
    boolean breaker;
    @FXML
    private Label pokeItemLabel1;
    @FXML
    private Label pokeItemLabel2;
    @FXML
    private Label pokeItemLabel3;
    @FXML
    private Label pokeItemLabel4;
    @FXML
    private Label pokeItemLabel5;
    @FXML
    private Label pokeItemLabel6;
    @FXML
    private ComboBox<?> pokemonHuntComboBox;
    @FXML
    private TextField accountNumberField;
    @FXML
    private TextField accountGmailField;
    @FXML
    private TextField accountPrefixField;
    @FXML
    private TextField accountPasswordField;
    @FXML
    private ComboBox<String> accountTeamCombo;
    @FXML
    private RadioButton fPokeRadio;
    @FXML
    private RadioButton sPokeRadio;
    @FXML
    private RadioButton tPokeRadio;
    String starterSelection;
    ArrayList<Account> accList;
    @FXML
    private ComboBox<Account> accountCombo;
    @FXML
    private TextField listToTradeAccount;
    @FXML
    private TextField accountGmailPassField;
    @FXML
    private TextField listToCatchAmount;
    boolean manualBoolean;
    @FXML
    private Button continueManual;
    @FXML
    private Button manual;
    @FXML
    private ProgressBar multiProgressBar;
    float multiProgress;
    int imageCalc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageCalc = 0;
        multiProgress = 0;
        multiProgressBar.setProgress(multiProgress);
        listToCatchAmount.setText("5");
        Account.loadLogFromFile();
        listToTradeAccount.setText("3458642");
        accList = Account.getAccList();
        accountCombo.getItems().setAll(accList);
        accountCombo.getSelectionModel().select(0);
        updateCalc = 0;
        //LevelProgress.setBlen
        pokeLabel = new ArrayList(Arrays.asList(pokeLabel1,pokeLabel2,pokeLabel3,pokeLabel4,pokeLabel5,pokeLabel6));
        pokeImage = new ArrayList(Arrays.asList(pokeImage1,pokeImage2,pokeImage3,pokeImage4,pokeImage5,pokeImage6));
        pokeLevelLabel = new ArrayList(Arrays.asList(pokeLevelLabel1,pokeLevelLabel2,pokeLevelLabel3,pokeLevelLabel4,pokeLevelLabel5,pokeLevelLabel6));
        pokeBreakLabel = new ArrayList(Arrays.asList(breakField1,breakField2,breakField3,breakField4,breakField5,breakField6));
        pokeItemLabel = new ArrayList (Arrays.asList(pokeItemLabel1,pokeItemLabel2,pokeItemLabel3,pokeItemLabel4,pokeItemLabel5,pokeItemLabel6));
        
        startBigTime = System.currentTimeMillis();
        Time t = Time.getInstance(); 
        t.loadLogFromFile();
        for (int i=0; i<6;i++){
            pokeLabel.get(i).setText("");
            pokeLevelLabel.get(i).setText("");
        }
        
        timeBetweenRest.setText(""+t.getFightSleepRandom());
        timeBetweenRestRandom.setText(""+t.getFightSleepTime());
        timeToRest.setText(""+t.getTimeBetweenRest());
        timeToRestRandom.setText(""+t.getTimeBetweenRestRandom());
        
        fightSleepTimeField.setText(""+t.getTimeToRest());
        fightSleepRandomField.setText(""+t.getTimeToRestRandom());
        accountTeamCombo.getItems().add("Team TPPC");
        accountTeamCombo.getItems().add("Team Rocket");
        accountTeamCombo.getItems().add("Team Magma");
        accountTeamCombo.getItems().add("Team Aqua");
        accountTeamCombo.getItems().add("Team Galactic");
        accountTeamCombo.getSelectionModel().select(0);
        
        accountGmailField.setText("tppcaccmaster");
        
        
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        tm = trainerManager.getInstance();
        tm.setDriver(driver);
        FightBreaker = false;
        cb = CaptchaBreaker.getInstance();
        usernameField.setText("ScankHunt42");
        passwordField.setText("ScankHunt42qwe");
        trainingListView.getItems().setAll(tm.getList());
        trainingListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<trainer>() {
    @Override
    public void changed(ObservableValue<? extends trainer> observable, trainer oldValue, trainer newValue) {
        // Your action here
        trainingAccountField.setText(newValue.getAccountNumber());
        tm.setSelected(newValue);
        levelLabel.setText("Level: "+tm.getSelected().getLevel());
    }
});
        
        trainingListView.getSelectionModel().select(tm.getSelected());
        
        
    }    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        
        Task task = new Task<Void>() {
            @Override public Void call() {
                
                FightBreaker = false;
                driver.get("http://www.tppcrpg.net/battle.php?Battle=Trainer&Trainer="+trainingAccountField.getText());
                long startTime = System.currentTimeMillis();
                startBigTime = System.currentTimeMillis();
                random = (long) Math.random()*Integer.valueOf(timeBetweenRestRandom.getText()); //minutes
                while (true){
                    bigSleep();
                    if (FightBreaker){
                        break;
                    }
                    estimatedTime  = System.currentTimeMillis() - startTime;
                    if (estimatedTime > 10000){
                        driver.get("http://www.tppcrpg.net/battle.php?Battle=Trainer&Trainer="+trainingAccountField.getText());
                        startTime = System.currentTimeMillis();
                    }
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                           /*String playerLevel = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@class='lvlitem']")).getText();
                           playerLevel = (playerLevel.substring(7, 14)).replaceAll(" ", "");
                           currLevel = Integer.valueOf(playerLevel);*/

                           updateUI();
                           System.out.println("HELLO3");
                           
                        }
                    });
                    System.out.println("HELLO1");
                    if (breakEnabled.isSelected() && breaker){
                        System.out.println("Stopping.");
                        breaker = false;
                        break;
                    }
                    System.out.println("HELLO2");
                    
                    if (driver.findElements(By.id("Validate")).size() != 0 ){
                        startTime = System.currentTimeMillis();
                        //Captcha
                        updateMessage("Captcha: "+solveCaptcha("Congratulations!"));
                        //defSleep(1000);
                        driver.get("http://www.tppcrpg.net/battle.php?Battle=Trainer&Trainer="+trainingAccountField.getText());
                        startTime = System.currentTimeMillis();
                    }else if(driver.findElements(By.linkText("Restart Battle")).size() != 0){
                        startTime = System.currentTimeMillis();
                        driver.findElement(By.linkText("Restart Battle")).click();
                    } else if (driver.findElements(By.className("submit")).size() != 0){
                        startTime = System.currentTimeMillis();
                        driver.findElement(By.className("submit")).click();
                    }
                    /*Platform.runLater(new Runnable() {
                        @Override public void run() {
                           updateUI();
                        }
                    });*/
                    defSleep();

                }  
                
            return null;
        }

    };
        
    captchaLabel.textProperty().bind(task.messageProperty());
    new Thread(task).start();
    }  


    @FXML
    private void StopBotAction(ActionEvent event) {
        FightBreaker = true;
    }

    @FXML
    private void loginButtonAction(ActionEvent event) {
        
        Task task = new Task<Void>() {
        @Override public Void call() {
        driver.get("http://www.tppcrpg.net/login.php");
        element = driver.findElement(By.name("LoginID"));
        element.sendKeys(usernameField.getText());
        
        element = driver.findElement(By.name("NewPass"));
        element.sendKeys(passwordField.getText());
        
        if(driver.findElements(By.name("Validate")).size() > 0){
                solveCaptcha("Validation Image");
        }
        if(driver.findElements(By.className("submit")).size() > 0){
                driver.findElement(By.className("submit")).click();
        }
        
        Platform.runLater(new Runnable() {
            @Override public void run() {
                String playerLevel = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@class='lvlitem']")).getText();
                playerLevel = (playerLevel.substring(7, 14)).replaceAll(" ", "");
                startLevel = Integer.valueOf(playerLevel);

                String imageString = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@class='pb']")).getAttribute("style");
                imageString = imageString.substring(23, imageString.length()-3);
                pokeImageView.setImage(new Image(imageString));
               
                updateUI();
                //pokeLabel = new ArrayList(Arrays.asList(pokeLabel1,pokeLabel2,pokeLabel3,pokeLabel4,pokeLabel5,pokeLabel6));
                //pokeImage = new ArrayList(Arrays.asList(pokeImage1,pokeImage2,pokeImage3,pokeImage4,pokeImage5,pokeImage6));
                //pokeLevelLabel = new ArrayList(Arrays.asList(pokeLevelLabel1,pokeLevelLabel2,pokeLevelLabel3,pokeLevelLabel4,pokeLevelLabel5,pokeLevelLabel6));
                /*for(int i=0;i<6;i++){
                    //int rlevel;
                    String tempLevel;
                    String tempNumber;
                    if(i<3){
                        tempLevel = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[1]/img["+(i+1)+"]")).getAttribute("onclick");
                        tempNumber = tempLevel.substring(tempLevel.indexOf("level: '")+8, tempLevel.indexOf("'", tempLevel.indexOf("level: '")+8));
                        pokeImage.get(i).setImage(new Image(driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[1]/img["+(i+1)+"]")).getAttribute("src")));
                        pokeLabel.get(i).setText(driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[1]/img["+(i+1)+"]")).getAttribute("title").replaceAll("Shiny", "S.").replaceAll("Dark", "D.").replaceAll("Golden", "G."));
                        pokeLevelLabel.get(i).setText("Lv: "+tempNumber);
                   
                    } else if (i <6){
                        tempLevel = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[2]/img["+(i-2)+"]")).getAttribute("onclick");
                        tempNumber = tempLevel.substring(tempLevel.indexOf("level: '")+8, tempLevel.indexOf("'", tempLevel.indexOf("level: '")+8));
                        pokeImage.get(i).setImage(new Image(driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[2]/img["+(i-2)+"]")).getAttribute("src")));
                        pokeLabel.get(i).setText(driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[2]/img["+(i-2)+"]")).getAttribute("title").replaceAll("Shiny", "S.").replaceAll("Dark", "D.").replaceAll("Golden", "G."));
                        pokeLevelLabel.get(i).setText("Lv: "+tempNumber);
                    }
                }*/

            }
        });
        

        
        return null;
    }
};
    

    new Thread(task).start();
    }

    public void updateUI(){
        updateCalc = 0;
        imageCalc++;
        if(imageCalc > 50){
            System.out.println("Updating images");
        }
        while(updateCalc++ < 3){
            try {
                if (driver.findElements(By.xpath("/html/body/div[@id='right']/ul/li[@class='hpSide']/img")).size() > 0){// && updateCalc > 6){
                    //System.out.println("Updating!");
                    updateCalc = 0;
                    //String imageString = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@class='pb']")).getAttribute("style");
                    //imageString = imageString.substring(23, imageString.length()-3);
                    //pokeImageView.setImage(new Image(imageString));
                    String progress = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@class='hpSide']/img")).getAttribute("title");
                    progress = progress.substring(26, progress.length()-1);
                    double hello = Double.valueOf(progress)/100;
                    LevelProgress.setProgress(hello);
                    String playerLevel = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@class='lvlitem']")).getText();
                    playerLevel = (playerLevel.substring(7, 14)).replaceAll(" ", "");
                    currLevel = Integer.valueOf(playerLevel);
                    //playerLevelLabel.setText(playerLevel.substring(0, playerLevel.length()));
                    int levelDiff = currLevel - startLevel;
                    playerLevelLabel.setText("Level: "+currLevel+" (" + levelDiff+")");

                    ArrayList<Integer> pokeList = new ArrayList();

                    for(int i=0;i<6;i++){
                        //int rlevel;
                        String tempLevel;
                        String tempNumber = "";

                        String tempItem = "";
                        if(i<3){
                            tempLevel = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[1]/img["+(i+1)+"]")).getAttribute("onclick");
                            tempNumber = tempLevel.substring(tempLevel.indexOf("level: '")+8, tempLevel.indexOf("'", tempLevel.indexOf("level: '")+8));
                            tempItem = tempLevel.substring(tempLevel.indexOf("item: '")+7, tempLevel.indexOf("'", tempLevel.indexOf("item: '")+7));
                            if(imageCalc > 50){
                                pokeImage.get(i).setImage(new Image(driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[1]/img["+(i+1)+"]")).getAttribute("src")));
                                pokeLabel.get(i).setText(driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[1]/img["+(i+1)+"]")).getAttribute("title").replaceAll("Shiny", "S.").replaceAll("Dark", "D.").replaceAll("Golden", "G."));
                            }
                            pokeLevelLabel.get(i).setText("Lv: "+tempNumber);
                            pokeItemLabel.get(i).setText(tempItem);

                        } else if (i <6){
                            tempLevel = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[2]/img["+(i-2)+"]")).getAttribute("onclick");
                            tempNumber = tempLevel.substring(tempLevel.indexOf("level: '")+8, tempLevel.indexOf("'", tempLevel.indexOf("level: '")+8));
                            tempItem = tempLevel.substring(tempLevel.indexOf("item: '")+7, tempLevel.indexOf("'", tempLevel.indexOf("item: '")+7));
                            if(imageCalc > 50){
                                pokeImage.get(i).setImage(new Image(driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[2]/img["+(i-2)+"]")).getAttribute("src")));
                                pokeLabel.get(i).setText(driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@id='rs']/div[2]/img["+(i-2)+"]")).getAttribute("title").replaceAll("Shiny", "S.").replaceAll("Dark", "D.").replaceAll("Golden", "G."));
                            }
                            pokeLevelLabel.get(i).setText("Lv: "+tempNumber);
                            pokeItemLabel.get(i).setText(tempItem);
                        }

                        if(!pokeBreakLabel.get(i).getText().isEmpty() && i < 6 && i != 0 && tempItem.equals("Exp Share") && breakEnabled.isSelected()){
                            if (Integer.valueOf(pokeBreakLabel.get(i).getText()) <= Integer.valueOf(tempNumber)){
                                pokeList.add(i+1);

                                //System.out.println("If "+pokeBreakLabel.get(i).getText() +"<= "+ Integer.valueOf(tempNumber));
                                //System.out.println("Break condition true.");
                                //breaker = true;
                            }
                        } else if (!pokeBreakLabel.get(0).getText().isEmpty() && breakEnabled.isSelected()){
                            if(Integer.valueOf(pokeBreakLabel.get(i).getText()) <= Integer.valueOf(tempNumber)){
                                System.out.println("Breaker enabled");
                                breaker = true;
                            }
                        }
                    }
                    
                    if(imageCalc > 50){
                            imageCalc = 0;
                    }
                    
                    //pokeList
                    if (pokeList.size() > 0){
                        System.out.println("Pokelist size: " + pokeList.size());
                        driver.get("http://www.tppcrpg.net/configure_roster.php");
                        for (int i=0;i<pokeList.size();i++){
                            System.out.println("Doing The Thing");
                            if((pokeList.get(i))%2 == 0){
                                driver.findElement(By.xpath("/html/body/div[@id='body']/div[@id='inner']/form/ul[@id='configure']/li[@class='right']["+(pokeList.get(i)/2)+"]/p[1]/input")).click();
                                Select select = new Select(driver.findElement(By.xpath("/html/body/div[@id='cBox']/p[@class='center'][1]/select[@id='ItemA']")));
                                select.selectByIndex(0);
                                //driver.findElement(By.xpath("/html/body/div[@id='cBox']/p[@class='center'][2]/input[@class='submit']")).submit();
                                driver.findElement(By.xpath("/html/body/div[@id='cBox']/p[@class='center'][2]/input")).click();


                            } else {
                                System.out.println(pokeList.get(i));
                                if(pokeList.get(i) == 1){
                                    driver.findElement(By.xpath("/html/body/div[@id='body']/div[@id='inner']/form/ul[@id='configure']/li["+(pokeList.get(i))+"]/p[1]/input")).click();
                                } else if (pokeList.get(i) == 3){
                                    //System.out.println("/html/body/div[@id='body']/div[@id='inner']/form/ul[@id='configure']/li["+(pokeList.get(i)+1)+"]/p[1]/input");
                                    driver.findElement(By.xpath("/html/body/div[@id='body']/div[@id='inner']/form/ul[@id='configure']/li["+(pokeList.get(i)+1)+"]/p[1]/input")).click();
                                } else if (pokeList.get(i) == 5){
                                    driver.findElement(By.xpath("/html/body/div[@id='body']/div[@id='inner']/form/ul[@id='configure']/li["+(pokeList.get(i)+2)+"]/p[1]/input")).click();
                                }
                                Select select = new Select(driver.findElement(By.xpath("/html/body/div[@id='cBox']/p[@class='center'][1]/select[@id='ItemA']")));
                                select.selectByIndex(0);
                                //driver.findElement(By.xpath("/html/body/div[@id='cBox']/p[@class='center'][2]/input[@class='submit']")).submit();
                                driver.findElement(By.xpath("/html/body/div[@id='cBox']/p[@class='center'][2]/input")).click();
                            }
                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        System.out.println("Time to continue");
                        driver.findElement(By.xpath("/html/body/div[@id='body']/div[@id='inner']/form/p[@class='center f']/input[@class='submit']")).click();
                        driver.get("http://www.tppcrpg.net/battle.php?Battle=Trainer&Trainer="+trainingAccountField.getText());
                        

                    }
                }
                break;
            } catch(NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
                System.out.println("Stale element exception " + updateCalc);
            }
        }
    }
    
    public int startDonate(int tokens){
        int errorcalc = 0;
        driver.get("http://www.tppcrpg.net/donation_center.php");
        while(true){

            while(true){
                if(driver.findElements(By.id("donatePoke")).size() == 0 && errorcalc<10){
                    errorcalc++;
                    driver.get("http://www.tppcrpg.net/donation_center.php");
                } else {
                    break;
                }
                if(FightBreaker){
                    break;
                }
            }

            if(FightBreaker){
                break;
            }
            if (driver.findElements(By.id("donatePoke")).size() > 0 ){
                tokens++;
                Select select = new Select(driver.findElement(By.id("donatePoke")));
                select.selectByIndex(1);
                driver.findElement(By.className("submit")).click();
                driver.switchTo().alert().accept();
            } else {
                break;
            }
        }
        return tokens;
    }            
            
    public void battleMap(){
        driver.findElement(By.linkText("Lets Battle!")).click();
        while(true){
            if(FightBreaker){
                break;
            }    

            if (driver.findElements(By.id("Validate")).size() != 0 ){
                solveCaptcha("Congratulations!");
            }

            if (driver.findElements(By.className("hpBar")).size() > 0) {

                if (driver.findElement(By.className("hpBar")).getAttribute("title").equals("0% HP Remaining")){
                    driver.findElement(By.linkText("Leave Battle")).click();
                    break;
                }
            }
            defSleep();
            if (driver.findElements(By.className("submit")).size() > 0){
                driver.findElement(By.className("submit")).click();

            } else {
                break;
            }
        }
    }
    
    public void bigSleep(){
        currBigTime = System.currentTimeMillis();
        long timeElapsed = (long)((currBigTime - startBigTime)/ 1000); //seconds

        if ( timeElapsed>  ((random + Integer.valueOf(timeBetweenRest.getText()))*60)){ //converted to seconds
            System.out.println("Time elapsed: " + timeElapsed);
            
            try {
                double random = Integer.valueOf(timeToRestRandom.getText())*Math.random(); //minutes
                long sleepv = (long) (Double.valueOf(timeToRest.getText())+Math.ceil(random))*60*1000; //millisecond

                System.out.println("Sleeping for: " + Math.ceil(sleepv/1000) + " seconds");
                Thread.sleep(sleepv);
            } catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            random = (long) Math.ceil(Math.random()*Integer.valueOf(timeBetweenRestRandom.getText())); //minutes
            startBigTime = System.currentTimeMillis();
        }
        
}
    
    public void defSleep(){
        try {
            long sleepv = (long) (Integer.valueOf(fightSleepTimeField.getText()) + Math.ceil(Integer.valueOf(fightSleepRandomField.getText())*Math.random()));
            //System.out.println(sleepv);
            Thread.sleep(sleepv);
        } catch (InterruptedException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void startSwapTokensAction(ActionEvent event) {
        
        
        
    Task task = new Task<Void>() {
        @Override public Void call() {
        FightBreaker = false;
        int mapid = 1;
        int tokens = 0;
        tokens = startDonate(tokens);
        updateMessage("Tokens: " + tokens);
        driver.get("http://www.tppcrpg.net/map.php?Map="+mapid);
        int caught =0;
        while(true){
            driver.findElement(By.name("Find")).click();
            if (driver.findElements(By.name("Catch")).size() > 0 ){
                caught++;
                driver.findElement(By.name("Catch")).click();
                if (driver.findElements(By.className("success")).size() > 0){
                } else {
                    System.out.println("Poke Escaped");
                    tokens = startDonate(tokens);
                    updateMessage("Tokens: " + tokens);
                    driver.get("http://www.tppcrpg.net/map.php?Map="+mapid);

                    caught = 0;
                }
                driver.findElement(By.partialLinkText("Return To")).click();
 
            } else if (driver.findElements(By.linkText("Lets Battle!")).size() > 0 ){
                battleMap();
                driver.get("http://www.tppcrpg.net/map.php?Map="+mapid);
            }

            if (caught > (10*mapid)){
                    mapid++;
                if (mapid > 14){
                    mapid = 1;
                }
                
            }
            if(caught > 139){
                caught = 0;
                tokens = startDonate(tokens);
                driver.get("http://www.tppcrpg.net/map.php?Map="+mapid);
            }
            if (FightBreaker){
                break;
            }
            defSleep();
            
        }

        return null;
    }

        };
    
    tokenLabel.textProperty().bind(task.messageProperty());
    new Thread(task).start();

}


    public String solveCaptcha(String attrib){
        String output = "";
    //Captcha
        List<WebElement> allImages = driver.findElements(By.tagName("img"));
        for (int i=0; i<allImages.size(); i++){
            if(allImages.get(i).getAttribute("alt").equals(attrib/*"Congratulations!"*/)){                        
                output = cb.crush(driver, allImages.get(i), imageView);
                if (!output.equals("")){
                    if(driver.findElements(By.id("Validate")).size() > 0){
                        driver.findElement(By.id("Validate")).sendKeys(output);
                    } else if (driver.findElements(By.name("Validate")).size() > 0){
                        driver.findElement(By.name("Validate")).sendKeys(output);
                    }

                    driver.findElement(By.className("submit")).click();
                }
                break;
            }
        }
        defSleep();
        return output;
    } 



    @FXML
    private void logoutButtonAction(ActionEvent event) {
        driver.get("http://www.tppcrpg.net/logout.php");
    }

    @FXML
    private void saveSettingsAction(ActionEvent event) {
        Time t = Time.getInstance();
        t.setFightSleepRandom(Integer.valueOf(timeBetweenRest.getText()));
        t.setFightSleepTime(Integer.valueOf(timeBetweenRestRandom.getText()));
        t.setTimeBetweenRest(Integer.valueOf(timeToRest.getText()));
        t.setTimeBetweenRestRandom(Integer.valueOf(timeToRestRandom.getText()));
        
        t.setTimeToRest(Integer.valueOf(fightSleepTimeField.getText()));
        t.setTimeToRestRandom(Integer.valueOf(fightSleepRandomField.getText()));
        t.saveLogToFile();
        
    }

    @FXML
    private void pokeButtonAction1(ActionEvent event) {
        
    }

    @FXML
    private void pokeButtonAction2(ActionEvent event) {
    }

    @FXML
    private void pokeButtonAction3(ActionEvent event) {
    }

    @FXML
    private void pokeButtonAction4(ActionEvent event) {
    }

    @FXML
    private void pokeButtonAction5(ActionEvent event) {
    }

    @FXML
    private void pokeButtonAction6(ActionEvent event) {
    }

    @FXML
    private void startSafariZoneAction(ActionEvent event) {

        
    }

    @FXML
    private void startSSAnneAction(ActionEvent event) {
        
        Task task = new Task<Void>() {
        @Override public Void call() {
        long startTime = System.currentTimeMillis();
        //driver.get("http://www.tppcrpg.net/battle.php?Battle=SSAnne");
        while(true){
            if(FightBreaker){
                FightBreaker = false;
                break;
            }
            if(driver.findElements(By.className("submit")).size() >0){
                driver.findElement(By.className("submit")).click();
                startTime = System.currentTimeMillis();
            }
            
            estimatedTime = System.currentTimeMillis() - startTime;
            if (estimatedTime > 20000) {
                System.out.println("Timed out!");
                driver.get("http://www.tppcrpg.net/resume_battle.php");
                driver.findElement(By.linkText("S.S. Anne"));
                startTime = System.currentTimeMillis();
            }
            
            Platform.runLater(new Runnable() {
                @Override public void run() {
                   String playerLevel = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@class='lvlitem']")).getText();
                   playerLevel = (playerLevel.substring(7, 14)).replaceAll(" ", "");
                   currLevel = Integer.valueOf(playerLevel);

                   updateUI();

                }
            });
            
            defSleep();
            bigSleep();
        }
        return null;
        }

        };
        new Thread(task).start();
    }

    @FXML
    private void startHunterBotAction(ActionEvent event) {
    }

    @FXML
    private void pokemonHuntComboBoxAction(ActionEvent event) {
    }

    @FXML
    private void accountCreateAction(ActionEvent event) {
        Task task = new Task<Void>() {
            @Override public Void call() {
                
                for(int i=0; i<Integer.valueOf(accountNumberField.getText());i++){
                    System.out.println("Creatin account #" + i);
                    driver.get("http://www.tppcrpg.net/signup.php");
                    
                    if(driver.findElements(By.id("NickName")).size() > 0){
                        int accM = (int)(Math.random()*10000);
                        driver.findElement(By.id("NickName")).sendKeys(accountPrefixField.getText()+accM);
                        driver.findElement(By.id("Password")).sendKeys(accountPasswordField.getText());
                        driver.findElement(By.id("ConfirmPassword")).sendKeys(accountPasswordField.getText());
                        driver.findElement(By.id("Email")).sendKeys(accountGmailField.getText()+"+"+accountPrefixField.getText()+"@gmail.com");


                        List<WebElement> starters = driver.findElements(By.id("Starter"));
                        for(int u =0; u<starters.size();u++){
                            if(starters.get(u).getAttribute("value").equals(starterSelection)){
                                starters.get(u).click();
                            }
                        }
                        Select tselect = new Select(driver.findElement(By.id("Team")));
                        tselect.selectByIndex(accountTeamCombo.getSelectionModel().getSelectedIndex()+1);
                        solveCaptcha("Validation Image");
                        Account.getAccList().add(new Account(accountPrefixField.getText()+accM, accountPasswordField.getText(), accountGmailField.getText()+"+"+accountPrefixField.getText()+"@gmail.com", accountTeamCombo.getSelectionModel().getSelectedItem()));
                        accList = Account.getAccList();
                        accountCombo.getItems().setAll(accList);
                        
                    }
                    multiProgress = (float)i / (float)(Integer.valueOf(accountNumberField.getText()) -1);
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                           multiProgressBar.setProgress(multiProgress);
                        }
                    });
                    
                }
                
                return null;
            }
    };
    new Thread(task).start();
        

        
        
        
    }

    @FXML
    private void tPokeRadioAction(ActionEvent event) {
        fPokeRadio.setSelected(false);
        sPokeRadio.setSelected(false);
        starterSelection = "3";
    }

    @FXML
    private void fPokeRadioAction(ActionEvent event) {
        tPokeRadio.setSelected(false);
        sPokeRadio.setSelected(false);
        starterSelection = "1";
    }

    @FXML
    private void sPokeRadioAction(ActionEvent event) {
        fPokeRadio.setSelected(false);
        tPokeRadio.setSelected(false);
        starterSelection = "2";
    }

    @FXML
    private void listToTradeAction(ActionEvent event) {
        Task task = new Task<Void>() {
        @Override public Void call() {
        for(int i=0;i<accList.size();i++){
            driver.get("http://www.tppcrpg.net/login.php");
            driver.findElement(By.name("LoginID")).sendKeys(accList.get(i).account);
            driver.findElement(By.name("NewPass")).sendKeys(accList.get(i).password);
            if(driver.findElements(By.name("Validate")).size() > 0){
                solveCaptcha("Validation Image");
            }
            if(driver.findElements(By.className("submit")).size() > 0){
                driver.findElement(By.className("submit")).click();
            }
            
            driver.get("http://www.tppcrpg.net/create_trade.php");
            driver.findElement(By.name("id")).sendKeys(listToTradeAccount.getText());
            driver.findElement(By.className("submit")).click();
            
            Select select = new Select(driver.findElement(By.id("CP")));
            for(int u=0;u<select.getOptions().size();u++){
                select.selectByIndex(u);
            }
            
            driver.findElement(By.className("submit")).click();
            multiProgress = (float)i / (float)(accList.size() -1);
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                       multiProgressBar.setProgress(multiProgress);
                    }
                });
            driver.get("http://www.tppcrpg.net/logout.php");
            defSleep();
        }
        System.out.println("Ending trading making.");
        
        return null;
            }
    };
    new Thread(task).start();
        
    }

    @FXML
    private void listToCatchAction(ActionEvent event) {

        Task task = new Task<Void>() {
        @Override public Void call() {
        for(int i=0;i<accList.size();i++){
            
            driver.get("http://www.tppcrpg.net/login.php");
            driver.findElement(By.name("LoginID")).sendKeys(accList.get(i).account);
            driver.findElement(By.name("NewPass")).sendKeys(accList.get(i).password);
            if(driver.findElements(By.name("Validate")).size() > 0){
                solveCaptcha("Validation Image");
            }
            if(driver.findElements(By.className("submit")).size() > 0){
                driver.findElement(By.className("submit")).click();
            }

            driver.get("http://www.tppcrpg.net/map.php?Map=" + (int)(Math.random()*10 + 2));
            /*if(driver.findElements(By.name("Find")).size() == 0){ //Remove accs that cant login
                accList.remove(i);
                continue;
            }*/
            
            int colca = 0;
            while (colca < Integer.valueOf(listToCatchAmount.getText())){
                if(driver.findElements(By.name("Find")).size() != 0){
                    driver.findElement(By.name("Find")).click();
                } 
                if (driver.findElements(By.className("submit")).size() > 0){
                    defSleep();
                    driver.findElement(By.className("submit")).click();
                    colca++;
                } else if (driver.findElements(By.linkText("Lets Battle!")).size() > 0 ){
                    driver.get("http://www.tppcrpg.net/map.php?Map="+(int)(Math.random()*10 + 2));
                } else if (driver.findElements(By.partialLinkText("Return To")).size() > 0){
                    driver.findElement(By.partialLinkText("Return To")).click();
                }
                
                defSleep();
            }
            multiProgress = (float)i / (float)(accList.size() -1);;
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                       multiProgressBar.setProgress(multiProgress);
                    }
                });
            driver.get("http://www.tppcrpg.net/logout.php");
        }
        System.out.println("Ending poke catching.");
        
        return null;
            }
    };
    new Thread(task).start();
        
    }

    @FXML
    private void verifyAccountsAction(ActionEvent event) {
        Task task = new Task<Void>() {
        @Override public Void call() {
        
            CheckingMails cm = new CheckingMails(accountGmailField.getText()+"@gmail.com",accountGmailPassField.getText());
            ArrayList<String> urls = cm.check();
            for(int i=0;i<urls.size();i++){
                driver.get(urls.get(i));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                multiProgress = (float)i / (float)(accList.size() -1);
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                       multiProgressBar.setProgress(multiProgress);
                    }
                });
            }

            return null;
        }
    };
    new Thread(task).start();
        
    }

    @FXML
    private void getTeamPromoAction(ActionEvent event) {
        Task task = new Task<Void>() {
            @Override public Void call() {
            for(int i=0;i<accList.size();i++){

                driver.get("http://www.tppcrpg.net/login.php");
                driver.findElement(By.name("LoginID")).sendKeys(accList.get(i).account);
                driver.findElement(By.name("NewPass")).sendKeys(accList.get(i).password);
                if(driver.findElements(By.name("Validate")).size() > 0){
                    solveCaptcha("Validation Image");
                }
                if(driver.findElements(By.className("submit")).size() > 0){
                    driver.findElement(By.className("submit")).click();
                }
                /***************************/
                driver.get("http://www.tppcrpg.net/team.php");
                ArrayList<WebElement> rewardList = (ArrayList<WebElement>) driver.findElements(By.name("Reward"));
                for(int u=0;u<rewardList.size();u++){
                    if(rewardList.get(u).getAttribute("value") == "1"){
                        rewardList.get(u).click();
                        driver.findElement(By.name("getReward")).click();
                        break;
                    }
                }

                /***************************/
                defSleep();
                multiProgress = (float)i / (float)(accList.size() -1);
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                       multiProgressBar.setProgress(multiProgress);
                    }
                });
                driver.get("http://www.tppcrpg.net/logout.php");
            }
            System.out.println("Ending team promo hunting.");

            return null;
            }   
        };
    new Thread(task).start();
    }

    @FXML
    private void continueManualAction(ActionEvent event) {
        manualBoolean = true;
        manual.visibleProperty().set(true);
        
    }

    @FXML
    private void manualAction(ActionEvent event) {
        Task task = new Task<Void>() {
        @Override public Void call() {
            for(int i=0;i<accList.size();i++){

                driver.get("http://www.tppcrpg.net/login.php");
                driver.findElement(By.name("LoginID")).sendKeys(accList.get(i).account);
                driver.findElement(By.name("NewPass")).sendKeys(accList.get(i).password);
                if(driver.findElements(By.name("Validate")).size() > 0){
                    solveCaptcha("Validation Image");
                }
                if(driver.findElements(By.className("submit")).size() > 0){
                    driver.findElement(By.className("submit")).click();
                }
                
                manual.visibleProperty().set(false);
                while(true){
                    if(manualBoolean){
                        manualBoolean = false;
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                multiProgress = (float)i / (float)(accList.size() -1);
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                       multiProgressBar.setProgress(multiProgress);
                    }
                });
                driver.get("http://www.tppcrpg.net/logout.php"); 
            }

            return null;
            }
        };
    new Thread(task).start();
        
    }

    @FXML
    private void startPreFighterAction(ActionEvent event) {
        
        Task task = new Task<Void>() {
        @Override public Void call() {
            for(int i=0;i<accList.size();i++){
                System.out.println("Promo Done already: " + accList.get(i).prePromoDone);
                if(!accList.get(i).prePromoDone){
                driver.get("http://www.tppcrpg.net/login.php");
                driver.findElement(By.name("LoginID")).sendKeys(accList.get(i).account);
                driver.findElement(By.name("NewPass")).sendKeys(accList.get(i).password);
                if(driver.findElements(By.name("Validate")).size() > 0){
                    solveCaptcha("Validation Image");
                }
                if(driver.findElements(By.className("submit")).size() > 0){
                    driver.findElement(By.className("submit")).click();
                }
                /******************/
                driver.get("http://www.tppcrpg.net/map.php?Map=3");
                while(true){
                    if(driver.findElements(By.name("Find")).size() > 0){
                        driver.findElement(By.name("Find")).click();
                        defSleep();
                        if(driver.findElements(By.xpath("/html/body/div[@id='body']/div[@id='inner']/form[1]/blockquote[@class='success']/strong[1]")).size() > 0 ){
                            System.out.println(driver.findElement(By.xpath("/html/body/div[@id='body']/div[@id='inner']/form[1]/blockquote[@class='success']/strong[1]")).getText());
                            if (driver.findElement(By.xpath("/html/body/div[@id='body']/div[@id='inner']/form[1]/blockquote[@class='success']/strong[1]")).getText().equals("Heracross")){
                                defSleep();
                                driver.findElement(By.className("submit")).click();
                                break;
                            }
                        }
                        
                    } else if (driver.findElements(By.linkText("Lets Battle!")).size() > 0 ){
                        driver.get("http://www.tppcrpg.net/map.php?Map=3");
                    } else if (driver.findElements(By.partialLinkText("Return To")).size() > 0){
                        driver.findElement(By.partialLinkText("Return To")).click();
                    }
                }
                
                driver.get("http://www.tppcrpg.net/change_roster.php");
                driver.get("http://www.tppcrpg.net/change_roster.php?c=&pn=214&o=");
                driver.findElement(By.xpath("/html/body/div[@id='body']/div[@id='inner']/div[@id='rightR']/ul/li/div[@class='sl']/ul/li[1]/a")).click();
                driver.get("http://www.tppcrpg.net/configure_roster.php");
                driver.findElement(By.className("tMove1")).click();
                Select movesel = new Select(driver.findElement(By.id("MoveA")));
                movesel.selectByValue("48");
                defSleep();
                //driver.findElement(By.className("submit")).click(); //Set Move!
                for(int y=0;y<driver.findElements(By.className("submit")).size();y++){
                    if (driver.findElements(By.className("submit")).get(y).getAttribute("value").equals("Set Move!")){
                        driver.findElements(By.className("submit")).get(y).click();
                    }
                }
                defSleep();
                
                for(int y=0;y<driver.findElements(By.className("submit")).size();y++){
                    if (driver.findElements(By.className("submit")).get(y).getAttribute("value").equals("Update Moves and Items")){
                        driver.findElements(By.className("submit")).get(y).click();
                    }
                }
                /******************/
                driver.get("http://www.tppcrpg.net/battle_trainer.php");
                driver.findElement(By.id("Trainer")).sendKeys("2502909");
                driver.findElement(By.className("submit")).click();                
                
                FightBreaker = false;
                long startTime = System.currentTimeMillis();
                startBigTime = System.currentTimeMillis();
                random = (long) Math.random()*Integer.valueOf(timeBetweenRestRandom.getText()); //minutes
                int calc = 0;
                while (true){
                    bigSleep();
                    if (FightBreaker || calc > 2){
                        break;
                    }
                    estimatedTime  = System.currentTimeMillis() - startTime;
                    if (estimatedTime > 10000){
                        driver.get("http://www.tppcrpg.net/battle_trainer.php");
                        driver.findElement(By.id("Trainer")).sendKeys("2502909");
                        driver.findElement(By.className("submit")).click();        
                        startTime = System.currentTimeMillis();
                    }
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                           /*String playerLevel = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@class='lvlitem']")).getText();
                           playerLevel = (playerLevel.substring(7, 14)).replaceAll(" ", "");
                           currLevel = Integer.valueOf(playerLevel);*/

                           updateUI();
                           
                        }
                    });
                    
                    if (breakEnabled.isSelected() && breaker){
                        System.out.println("Stopping.");
                        breaker = false;
                        break;
                    }
                    
                    
                    if (driver.findElements(By.id("Validate")).size() != 0 ){
                        startTime = System.currentTimeMillis();
                        //Captcha
                        updateMessage("Captcha: "+solveCaptcha("Congratulations!"));
                        //defSleep(1000);
                        driver.get("http://www.tppcrpg.net/battle.php?Battle=Trainer&Trainer=2502909");
                        startTime = System.currentTimeMillis();
                    }else if(driver.findElements(By.linkText("Restart Battle")).size() != 0){
                        calc++;
                        startTime = System.currentTimeMillis();
                        driver.findElement(By.linkText("Restart Battle")).click();
                    } else if (driver.findElements(By.className("submit")).size() != 0){
                        startTime = System.currentTimeMillis();
                        driver.findElement(By.className("submit")).click();
                    }
                    /*Platform.runLater(new Runnable() {
                        @Override public void run() {
                           updateUI();
                        }
                    });*/
                    defSleep();

                }
                
                driver.get("http://www.tppcrpg.net/team.php");
                driver.findElement(By.xpath("/html/body/div[@id='body']/div[@id='inner']/form/table[@class='ranks facrew']/tbody/tr[@class='r0'][1]/td[4]/input")).click();
                driver.findElement(By.className("submit")).click();
                
                driver.get("http://www.tppcrpg.net/configure_roster.php");
                driver.findElement(By.xpath("/html/body/div[@id='body']/div[@id='inner']/form/ul[@id='configure']/li[1]/p[1]/input")).click();
                
                movesel = new Select(driver.findElement(By.id("ItemA")));
                
                for(int n=0;n<movesel.getOptions().size();n++){
                    if(!movesel.getOptions().get(n).getAttribute("class").equals("disabled") && movesel.getOptions().get(n).getText().contains("Team Boost")){
                        movesel.selectByIndex(n);
                        break;
                    }
                }
                
                //driver.findElement(By.className("submit")).click();  //Set Item!
                for(int y=0;y<driver.findElements(By.className("submit")).size();y++){
                    if (driver.findElements(By.className("submit")).get(y).getAttribute("value").equals("Set Item!")){
                        driver.findElements(By.className("submit")).get(y).click();
                    }
                }
                defSleep();
                for(int y=0;y<driver.findElements(By.className("submit")).size();y++){
                    if (driver.findElements(By.className("submit")).get(y).getAttribute("value").equals("Update Moves and Items")){
                        driver.findElements(By.className("submit")).get(y).click();
                    }
                }
                /******************/
                
                driver.get("http://www.tppcrpg.net/battle_trainer.php");
                driver.findElement(By.id("Trainer")).sendKeys("2502909");
                driver.findElement(By.className("submit")).click();                
                
                FightBreaker = false;
                startTime = System.currentTimeMillis();
                startBigTime = System.currentTimeMillis();
                random = (long) Math.random()*Integer.valueOf(timeBetweenRestRandom.getText()); //minutes
                calc = 0;
                while (true){
                    bigSleep();
                    if (FightBreaker || calc > 5){
                        break;
                    }
                    estimatedTime  = System.currentTimeMillis() - startTime;
                    if (estimatedTime > 10000){
                        driver.get("http://www.tppcrpg.net/battle_trainer.php");
                        driver.findElement(By.id("Trainer")).sendKeys("2502909");
                        driver.findElement(By.className("submit")).click();        
                        startTime = System.currentTimeMillis();
                    }
                    Platform.runLater(new Runnable() {
                        @Override public void run() {
                           /*String playerLevel = driver.findElement(By.xpath("/html/body/div[@id='right']/ul/li[@class='lvlitem']")).getText();
                           playerLevel = (playerLevel.substring(7, 14)).replaceAll(" ", "");
                           currLevel = Integer.valueOf(playerLevel);*/

                           updateUI();
                           
                        }
                    });
                    
                    if (breakEnabled.isSelected() && breaker){
                        System.out.println("Stopping.");
                        breaker = false;
                        break;
                    }
                    
                    
                    if (driver.findElements(By.id("Validate")).size() != 0 ){
                        startTime = System.currentTimeMillis();
                        //Captcha
                        updateMessage("Captcha: "+solveCaptcha("Congratulations!"));
                        //defSleep(1000);
                        driver.get("http://www.tppcrpg.net/battle.php?Battle=Trainer&Trainer=2502909");
                        startTime = System.currentTimeMillis();
                    }else if(driver.findElements(By.linkText("Restart Battle")).size() != 0){
                        calc++;
                        startTime = System.currentTimeMillis();
                        driver.findElement(By.linkText("Restart Battle")).click();
                    } else if (driver.findElements(By.className("submit")).size() != 0){
                        startTime = System.currentTimeMillis();
                        driver.findElement(By.className("submit")).click();
                    }
                    /*Platform.runLater(new Runnable() {
                        @Override public void run() {
                           updateUI();
                        }
                    });*/
                    defSleep();

                }
                driver.get("http://www.tppcrpg.net/logout.php"); 
                /******************/
                }
                multiProgress = (float)i / (float)(accList.size() -1);
                Platform.runLater(new Runnable() {
                    @Override public void run() {
                       multiProgressBar.setProgress(multiProgress);
                    }
                });
                accList.get(i).prePromoDone = true;
                
                
            }

            return null;
            }
        };
    new Thread(task).start();
    }

    
    
    public void catchMap(String choice, String vari){
        if(choice.equals("map")){ //Map by map,  vari = map number
        
        } else if (choice.equals("poke")){ //Map by poke, vari = poke name
                
        } else if (choice.equals("item")){ //Map by item, vari = item name
                
        }
    
    }

    @FXML
    private void completeAllAltTradesAction(ActionEvent event) {
        Task task = new Task<Void>() {
        @Override public Void call() {
            

        driver.get("http://www.tppcrpg.net/complete_trade.php");
        ArrayList<WebElement> trades = (ArrayList<WebElement>) driver.findElements(By.partialLinkText("Trade #"));
        ArrayList<String> tradesUrl = new ArrayList();
        for(int i=0; i<trades.size();i++){
            tradesUrl.add(trades.get(i).getAttribute("href"));
        }
        
        for(int i=0; i<tradesUrl.size();i++){
            System.out.println(tradesUrl.get(i));
            driver.get(tradesUrl.get(i));
            if(driver.findElements(By.id("FP")).size() > 0){
                Select myPoke = new Select(driver.findElement(By.id("FP")));
                System.out.println("My pokes in trade: " + myPoke.getOptions().size());

                if(myPoke.getOptions().size() == 0 && driver.findElements(By.className("submit")).size() > 0){
                    driver.findElement(By.className("submit")).click();
                }
            }
            defSleep();
        }
        return null;
        }
        
    };
    new Thread(task).start();
    }
    
}
