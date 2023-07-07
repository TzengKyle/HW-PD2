package application;
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerTest implements Initializable{
	
	@FXML
	Text game;
	@FXML
	Text wordBox;
	@FXML
	Rectangle rec;
	@FXML
	Pane paneOfNextTest;
	
		
	String pathOfCommuniate = "C:\\Users\\user\\eclipse-workspace\\PersonalProject\\src\\application\\對話音效.mp3";
	Media mediaOfCommuniate = new Media(new File(pathOfCommuniate).toURI().toString());
	MediaPlayer mediaplayerOfCommuniate = new MediaPlayer(mediaOfCommuniate);
	
	String path3 = "C:\\Users\\user\\eclipse-workspace\\PersonalProject\\src\\application\\按鈕音效.mp3";
	Media media3 = new Media(new File(path3).toURI().toString());
	MediaPlayer mediaplayer3 = new MediaPlayer(media3);
	
	String stringOfTalk = "You have completed the first two tests and both passed successfully.\r\n"
			+ "The purpose of the final test is to test whether your comprehensive artificial intelligence is qualified.\r\n"
			+ "\r\n"
			+ "Finish this game!!";
	
	boolean win = false;

	Timer timerOfCounter = new Timer();
	Timer timerOfTalk = new Timer();
	public void initialize(URL arg0, ResourceBundle arg1) {
		game.setFont(Font.font("Monospaced",24));
		rec.setOpacity(0);
		drawPane();
		
		initializeValue();
		timerOfCounter.scheduleAtFixedRate(new TimerTask() {
			double opac = 0;
			public void run() {
				if(opac < 0.8) {
					rec.setOpacity(opac);
					opac+=0.05;
				}else {
					timerOfCounter.cancel();
				}
			}
		}, 0, 100);
		
		timerOfTalk.scheduleAtFixedRate(new TimerTask() {
			int index = 0;
			public void run() {
				
				if(index < stringOfTalk.length() + 1)	{
					playMediaplayerOfCommuniate();
					wordBox.setOpacity(1);
					wordBox.setDisable(false);
					
					wordBox.setText(stringOfTalk.substring(0, index));
					index++;
				}
				else {
					draw();
					mediaplayerOfCommuniate.stop();				
					timerOfTalk.cancel();
				}
			}
		}, 1600, 25);
	}
	
	public void click() {
		mediaplayer3.seek(mediaplayer3.getStartTime());	
		mediaplayer3.play();
	}
	
	private String gameString = ""; 
	private String num; // = String.format("%06d", number);
	
	private int[][] value = new int[6][6];
	
	private void generateValue() {
		if(!win) {
			int x = rand.nextInt(4) + 1;
			int y = rand.nextInt(4) + 1;
			while (value[x][y] != 0) {
				x = rand.nextInt(4) + 1;
				y = rand.nextInt(4) + 1;
			}
			value[x][y] = 2;
		}

	}
	
	private void drawPane() {
		gameString = ""; 
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 21; j++) {
				if (i % 2 == 0) {
					gameString = gameString + "=";
				}
				else {
					if (j % 5 == 0) {
						gameString = gameString + "|";
					}
					else if (((j - 1) % 5) == 0) {
						if (value[(i + 1) / 2][(j + 4) / 5] != 0) {
							num = String.format("%4d", value[(i + 1) / 2][(j + 4) / 5]);//value[(i + 1) / 2][(j + 4) / 5]
							gameString = gameString + num;
						}
						else
							gameString = gameString + "    ";
					} 
				}
			}
			gameString = gameString + "\n";
		}
		
	}
	
	public void draw() {
		drawPane();
		game.setText(gameString);
		System.out.println(gameString);
		
	}
	
	private Random rand = new Random();
	
	private void playMediaplayerOfCommuniate() {
		mediaplayerOfCommuniate.setOnEndOfMedia(new Runnable() {
		    public void run() {
		    	mediaplayerOfCommuniate.seek(Duration.ZERO);
		    }
		});
		mediaplayerOfCommuniate.play();
		
	}
	
	public void initializeValue() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if ((i == 0) || (i == 5)) {
					value[i][j] = -1;
				}
				else {
					if ((j == 0) || (j == 5)) {
						value[i][j] = -1;
					}
					else {
						value[i][j] = 0;
					}
				}
			}
		}
		int x1 = rand.nextInt(4) + 1;
		int y1 = rand.nextInt(4) + 1;
		int x2 = rand.nextInt(4) + 1;
		int y2 = rand.nextInt(4) + 1;
		while ((x1 == x2) && (y2 == y2)) {
			x2 = rand.nextInt(4) + 1;
			y2 = rand.nextInt(4) + 1;
		}
		value[x1][y1] = value[x2][y2] = 2;
		
	}
	
	private int[] operation(int tempt[]) {
		if ((tempt[1] == tempt[2]) && (tempt[3] == tempt[4])) {
			tempt[1] = 2 * tempt[2];
			tempt[2] = 2 * tempt[4];
			tempt[3] = tempt[4] = 0;
		}
		else if (tempt[1] == tempt[2]) {
			tempt[1] = 2 * tempt[2];
			tempt[2] = tempt[3];
			tempt[3] = tempt[4];
			tempt[4] = 0;
		}
		else if (tempt[2] == tempt[3]) {
			tempt[2] = 2 * tempt[3];
			tempt[3] = tempt[4];
			tempt[4] = 0;
		}
		else if (tempt[3] == tempt[4]) {
			tempt[3] = 2 * tempt[4];
			tempt[4] = 0;
		}
		return tempt;
		
	}
	
	public void upOperation() {

		int[] tempt = new int[5];
		int[] tempt2 = new int[5];
		int count = 1;
		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) { //移動
				tempt[j] = 0;
			}
			count = 1;

			for (int j = 1; j <= 4; j++) {
				if (value[j][i] != 0) {
					tempt[count] = value[j][i];
					count++;
				}
			}
			
			tempt2 = operation(tempt);

			for (int j = 1; j <= 4; j++) {
				value[j][i] = tempt2[j];
			}
		}
		generateValue();
		drawPane();
		game.setText(gameString);
		System.out.println(gameString);
		if(winTest()) {
			wordBox.setText("YOU FINISH THE TEST");
		}
		
	}
	
	public void downOperation() {

		int[] tempt = new int[5];
		int[] tempt2 = new int[5];
		int count = 1;
		for (int i = 1; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) { //移動
				tempt[j] = 0;
			}
			count = 1;

			for (int j = 4; j >= 1; j--) {
				if (value[j][i] != 0) {
					tempt[count] = value[j][i];
					count++;
				}
			}
		
			
			tempt2 = operation(tempt);
			
			for (int j = 1; j <= 4; j++) {
				value[j][i] = tempt2[5-j];
			}
		
		}
		generateValue();
		drawPane();
		game.setText(gameString);
		System.out.println(gameString);
		
	}
	
	public void leftOperation() {

		int[] tempt = new int[5];
		int[] tempt2 = new int[5];
		int count = 1;
		for (int j = 1; j <= 4; j++) {
			for (int i = 0; i <= 4; i++) { //移動
				tempt[i] = 0;
			}
			count = 1;

			for (int i = 1; i <= 4; i++) {
				if (value[j][i] != 0) {
					tempt[count] = value[j][i];
					count++;
				}
			}

			tempt2 = operation(tempt);

			for (int i = 1; i <= 4; i++) {
				value[j][i] = tempt2[i];
			}
		}
		generateValue();
		drawPane();
		game.setText(gameString);
		System.out.println(gameString);
		
	}
	
	public void rightOperation() {

		int[] tempt = new int[5];
		int[] tempt2 = new int[5];
		int count = 1;
		for (int j = 1; j <= 4; j++) {
			for (int i = 0; i <= 4; i++) { //移動
				tempt[i] = 0;
			}
			count = 1;

			for (int i = 4; i >= 1; i--) {
				if (value[j][i] != 0) {
					tempt[count] = value[j][i];
					count++;
				}
			}

			tempt2 = operation(tempt);

			for (int i = 1; i <= 4; i++) {
				value[j][i] = tempt2[5 - i];
			}

		}
		generateValue();
		drawPane();
		game.setText(gameString);
		System.out.println(gameString);
	}
	
	private boolean winTest() {
		boolean test = false;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (value[i][j] == 64)
					test = true;
			}
		}
		return test;
	}

	
	
	
}

	
		
	



