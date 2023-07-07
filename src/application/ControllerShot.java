package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;

public class ControllerShot implements Initializable{
	Image imageOfBK = new Image(getClass().getResourceAsStream("外星球場警.jpg"));
	Image imageOfStar = new Image(getClass().getResourceAsStream("準心.jpg"));
	Image imageOfTargetR = new Image(getClass().getResourceAsStream("方形標靶.jpg"));
	@FXML
	Pane paneOfStar;
	@FXML
	Pane paneOfBK;
	@FXML
	Pane paneOfPoint;
	@FXML
	ImageView IvOfTargetR1;
	@FXML
	Text textOfCounter;
	@FXML
	Text textOfMistake;
	@FXML
	Text ready;
	@FXML
	Pane paneOfNextTest;
	
	
	int counter;
	int mistake;
	int level = 1;
	
	String pathOfgunSF = "C:\\Users\\user\\eclipse-workspace\\PersonalProject\\src\\application\\槍聲.mp3";
	Media mediaOfgunSF = new Media(new File(pathOfgunSF).toURI().toString());
	MediaPlayer mediaplayerOfgunSF = new MediaPlayer(mediaOfgunSF);
	String pathOfWind = "C:\\Users\\user\\eclipse-workspace\\PersonalProject\\src\\application\\風聲.mp3";
	Media mediaOfWind = new Media(new File(pathOfWind).toURI().toString());
	MediaPlayer mediaplayerOfWind = new MediaPlayer(mediaOfWind);
	
	boolean door = true;
	
	Timer timerOfGame = new Timer();
	public void initialize(URL arg0, ResourceBundle arg1){
		counter = 3;
		mistake = 0;
		
		paneOfBK.setOpacity(0);
		ready.setOpacity(0);
		IvOfTargetR1.setOpacity(0);
		IvOfTargetR1.setDisable(true);
		textOfCounter.setText("Remain Target : " + counter);
		textOfMistake.setText("Mistake : " + mistake);
		paneOfNextTest.setOpacity(0);
		paneOfNextTest.setDisable(true);
		
		mediaplayerOfWind.setOnEndOfMedia(new Runnable() {
		    public void run() {
		    	mediaplayerOfWind.seek(Duration.ZERO);
		    }
		});
		mediaplayerOfWind.play();
		
		timerOfGame.scheduleAtFixedRate(new TimerTask(){
			double opac = 0;
			double opac2 = 1;
			int tempt = 1;
			public void run() {
					
				if(level == 1) {
					if(opac < 1) {
						paneOfPoint.setOpacity(opac);
						paneOfBK.setOpacity(opac);
						opac+=0.1;
					}else {
						level = 2;
					}
				}else if(level == 2) {
					if(tempt <= 3) {
						ready.setOpacity(1);
						ready.setText("ARE YOU READY");
						tempt++;
					}else if(tempt <= 6) {
						ready.setText("3");
						tempt++;
					}else if(tempt <= 9) {
						ready.setText("2");
						tempt++;
					}else if(tempt <= 12) {
						ready.setText("1");
						tempt++;
					}else {
						ready.setOpacity(0);
						level++;
					}
				}else if(level == 3) {
					
					if(counter >= 1) {
						if(door) {
							generateATargetR();
							door = false;
						}
					}else {
						ready.setOpacity(1);
						ready.setText("FINISH!");
						
						if(opac2 > 0) {
							paneOfBK.setOpacity(opac2);
							ready.setOpacity(opac2);
							paneOfPoint.setOpacity(opac2);
							opac2-=0.1;
							
						}else {
							ready.setOpacity(0);
							paneOfNextTest.setOpacity(1);
							paneOfNextTest.setDisable(false);
							timerOfGame.cancel();
						}
					}
				}
			}
		}, 0, 350);	
	}
	
	public void nextTestFunc(ActionEvent e) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("SceneTest.fxml"));
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		stage.setScene(scene);
		stage.show();
			
	}
	
	public void starFunc(MouseEvent e) {
		paneOfStar.setLayoutX(e.getSceneX()-126-17);
		paneOfStar.setLayoutY(e.getSceneY()-110+43);
		paneOfStar.setMouseTransparent(true);	
	}
	public void starFunc2(MouseEvent e) {
		paneOfStar.setLayoutX(341);
		paneOfStar.setLayoutY(171);
	}
	public void gunSF() {
		mediaplayerOfgunSF.seek(mediaplayerOfgunSF.getStartTime());	
		mediaplayerOfgunSF.play();
	}
	
	int posX;
	int posY;
	double scale;
	Random rand = new Random();
	public void generateATargetR() {
		
		int posX = rand.nextInt(740);
		int posY = rand.nextInt(370);
		double scale = rand.nextDouble()*0.5 + 0.5;
		
		IvOfTargetR1.setLayoutX(posX);
		IvOfTargetR1.setLayoutY(posY);
		IvOfTargetR1.setScaleX(scale);
		IvOfTargetR1.setScaleY(scale);
		IvOfTargetR1.setDisable(false);
		IvOfTargetR1.setOpacity(1);
		
	}
	
	public void funcOfR1() {
		IvOfTargetR1.setDisable(true);
		IvOfTargetR1.setOpacity(0);
		
		counter--;
		textOfCounter.setText("Remain Target : " + counter);
		door = true;
	}
	
	public void funcOfBK() {
		mistake++;
		textOfMistake.setText("Mistake : " + mistake);
		
	}
	
	
}
