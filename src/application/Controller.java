package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller implements Initializable{
	private int test = 1;
	
	private Stage stage;
	private Parent root;
	private Scene scene;
	
	static String path1 = "C:\\Users\\user\\eclipse-workspace\\PersonalProject\\src\\application\\太空背景音樂.mp3";
	static String path2 = "C:\\Users\\user\\eclipse-workspace\\PersonalProject\\src\\application\\按鈕音效2.mp3";
	static String path3 = "C:\\Users\\user\\eclipse-workspace\\PersonalProject\\src\\application\\按鈕音效.mp3";
	static Media media1 = new Media(new File(path1).toURI().toString());
	static Media media2 = new Media(new File(path2).toURI().toString());
	static Media media3 = new Media(new File(path3).toURI().toString());
	static MediaPlayer mediaplayer1 = new MediaPlayer(media1);
	static MediaPlayer mediaplayer2 = new MediaPlayer(media2);
	static MediaPlayer mediaplayer3 = new MediaPlayer(media3);
	
	
	Image logo1 = new Image(getClass().getResourceAsStream("遊戲設計公司.png"));
	Image logo2 = new Image(getClass().getResourceAsStream("LOGO.png"));
	Image loading = new Image(getClass().getResourceAsStream("LOADING.png"));
	Image cover1 = new Image(getClass().getResourceAsStream("封面1-1.jpg"));
	Image cover2 = new Image(getClass().getResourceAsStream("封面1-2.jpg"));
	Image cover3 = new Image(getClass().getResourceAsStream("封面1-3.jpg"));
	Image cover4 = new Image(getClass().getResourceAsStream("封面1-4.jpg"));
	Image cover5 = new Image(getClass().getResourceAsStream("封面1-5.jpg"));
	
	@FXML
	ImageView IVofLogo1;
	@FXML
	ImageView IVofLoading;
	@FXML
	Text bottonWord;
	@FXML
	ImageView IVofCover;
	@FXML
	Text gameName;
	@FXML
	Rectangle rec1;
	@FXML
	Rectangle rec2;
	@FXML
	Text quit;
	@FXML
	Text start;
	@FXML
	Button ButOfStart;
	@FXML
	Button ButOfQuit;
	@FXML
	ImageView IVOfgameName;
	
	@FXML
	Rectangle wordBox;
	@FXML
	Rectangle rec3;
	@FXML
	Rectangle rec4;
	@FXML
	Text ques;
	@FXML
	Text yes;
	@FXML
	Text no;
	@FXML
	Button ButOfYes;
	@FXML
	Button ButOfNo;
	
	@FXML
	Button newGame1;
	@FXML
	Button newGame2;
	@FXML
	Button cancel;
	
	
	
	Timer t1 = new Timer();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		IVofLogo1.setOpacity(0);
		IVofLoading.setOpacity(0);
		bottonWord.setOpacity(0);
		IVofCover.setOpacity(0);
		gameName.setOpacity(0);
		rec1.setOpacity(0);
		rec2.setOpacity(0);
		quit.setOpacity(0);
		start.setOpacity(0);
		ButOfStart.setOpacity(0);
		ButOfQuit.setOpacity(0);
		IVOfgameName.setOpacity(0);
		
		wordBox.setOpacity(0);
		rec3.setOpacity(0);
		rec4.setOpacity(0);
		ques.setOpacity(0);
		yes.setOpacity(0);
		no.setOpacity(0);
		ButOfYes.setOpacity(0);
		ButOfNo.setOpacity(0);
		
		newGame1.setOpacity(0);
		newGame2.setOpacity(0);
		cancel.setOpacity(0);
		
		ButOfYes.setDisable(true);
		ButOfNo.setDisable(true);
		ButOfStart.setDisable(true);
		ButOfQuit.setDisable(true);
		newGame1.setDisable(true);
		newGame2.setDisable(true);
		cancel.setDisable(true);
		
		startOper();
	}
	
	public void startOper() {
		t1.scheduleAtFixedRate(new TimerTask() {
			int tempt = 1;
			int indexOfLogo = 1;
			double opacOfLogo = 0; 
			double opacOfCover = 0; 
			int temptOfCover = 0;
			@Override
			public void run() {
			
				if(indexOfLogo == 1) {
					
					if(opacOfLogo < 1) {
						IVofLogo1.setOpacity(opacOfLogo);
						opacOfLogo+=0.05;
					}else {
						if(tempt <= 10) {
							tempt++;
						}else {
							tempt = 1;
							indexOfLogo++;
						}
					}	
				}else if(indexOfLogo == 2) {
					if(opacOfLogo >= 0) {
						IVofLogo1.setOpacity(opacOfLogo);
						opacOfLogo-=0.05;
					}else {
						opacOfLogo = 0;
						IVofLogo1.setOpacity(0);
						indexOfLogo++;
					}
				}else if (indexOfLogo == 3) {
					
					if(tempt == 1) {
						if(opacOfLogo <= 1) {
							IVofLoading.setOpacity(opacOfLogo);
							bottonWord.setOpacity(opacOfLogo);
							opacOfLogo+=0.05;
							
						}else {
							tempt++;
						}
						
					}else if(tempt % 2 == 0 && tempt < 6) {
						if(opacOfLogo <= 1) {
							
							IVofLoading.setOpacity(opacOfLogo);
							opacOfLogo+=0.025;
						}else {
							tempt++;
						}
						
					}else if(tempt % 2 == 1 && tempt < 6){
						if(opacOfLogo >= 0.5) {
							IVofLoading.setOpacity(opacOfLogo);
							opacOfLogo-=0.025;
						}else {
							tempt++;
						}
					}else if(tempt == 6){
						tempt = 0;;
						indexOfLogo++;
						IVofLoading.setOpacity(0);
						
					}else {
						
					}
					
					
				}else if(indexOfLogo == 4){
					ButOfStart.setDisable(false);
					ButOfQuit.setDisable(false);
					mediaplayer1.play();
					bottonWord.setOpacity(1);
					if(opacOfCover <= 1) {
						IVofCover.setOpacity(opacOfCover);
						gameName.setOpacity(opacOfCover);
						rec1.setOpacity(opacOfCover);
						rec2.setOpacity(opacOfCover);
						quit.setOpacity(opacOfCover);
						start.setOpacity(opacOfCover);
						ButOfStart.setOpacity(opacOfCover);
						ButOfQuit.setOpacity(opacOfCover);
						IVOfgameName.setOpacity(opacOfCover);
						opacOfCover+=0.025;
						
					}else {
						
						switch(tempt % 13) {
						case 0:
							if(temptOfCover<=5){
								IVofCover.setImage(cover1);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 1:
							if(temptOfCover<=5){
								IVofCover.setImage(cover2);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 2:
							if(temptOfCover<=5){
								IVofCover.setImage(cover3);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 3:
							if(temptOfCover<=5){
								IVofCover.setImage(cover4);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 4:
							if(temptOfCover<=5){
								IVofCover.setImage(cover5);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 5:
							if(temptOfCover<=5){
								//IVofCover.setImage(cover2);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 6:
							if(temptOfCover<=5){
								//IVofCover.setImage(cover3);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 7:
							if(temptOfCover<=5){
								//IVofCover.setImage(cover4);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 8:
							if(temptOfCover<=5){
								IVofCover.setImage(cover5);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 9:
							if(temptOfCover<=5){
								IVofCover.setImage(cover4);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 10:
							if(temptOfCover<=5){
								IVofCover.setImage(cover3);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 11:
							if(temptOfCover<=5){
								IVofCover.setImage(cover2);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						case 12:
							if(temptOfCover<=5){
								IVofCover.setImage(cover1);
								temptOfCover++;
							}else {
								tempt++;
								temptOfCover = 0;
							}
							break;
						default:
							break;
						}
						
					}
				}else {
					t1.cancel();
				}
			}
			
		}, 0, 100);
	}
	
	
	
	public void hello() {
		mediaplayer2.seek(mediaplayer2.getStartTime());	
		mediaplayer2.play();
	}
	public void click() {
		mediaplayer3.seek(mediaplayer3.getStartTime());	
		mediaplayer3.play();
	}
	
	

	public void startFunc() {
		if(test == 1) {
			wordBox.setOpacity(1);
			newGame1.setOpacity(1);
			newGame2.setOpacity(1);
			cancel.setOpacity(1);
			newGame1.setDisable(false);
			newGame2.setDisable(false);
			cancel.setDisable(false);
			
	
			test = 0;
		}
	}
	
	public void cancelFunc() {
		wordBox.setOpacity(0);
		newGame1.setOpacity(0);
		newGame2.setOpacity(0);
		cancel.setOpacity(0);
		newGame1.setDisable(true);
		newGame2.setDisable(true);
		cancel.setDisable(true);
		test = 1;
	}
	
	public void newGameFunc(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SceneStory.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.getIcons().add(logo2);
		stage.setScene(scene);
		stage.show();
		
		mediaplayer1.stop();
		t1.cancel();
	}
	
	
	public void quit() {
		if(test == 1) {
			wordBox.setOpacity(1);
			rec3.setOpacity(1);
			rec4.setOpacity(1);
			ques.setOpacity(1);
			yes.setOpacity(1);
			no.setOpacity(1);
			ButOfYes.setOpacity(1);
			ButOfNo.setOpacity(1);
			ButOfYes.setDisable(false);
			ButOfNo.setDisable(false);
			
			test = 0;
		}
    }
	
	public void sureQuit() {
		Stage stage = (Stage)ButOfQuit.getScene().getWindow();
        t1.cancel();
        mediaplayer1.stop();
        stage.close();
	}
	
	public void noySureQuit() {
		wordBox.setOpacity(0);
		rec3.setOpacity(0);
		rec4.setOpacity(0);
		ques.setOpacity(0);
		yes.setOpacity(0);
		no.setOpacity(0);
		ButOfYes.setOpacity(0);
		ButOfNo.setOpacity(0);
		ButOfYes.setDisable(true);
		ButOfNo.setDisable(true);
		ButOfStart.setDisable(false);
		ButOfQuit.setDisable(false);
		
		test = 1;
	}
	
}
