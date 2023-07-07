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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerStory implements Initializable{
	@FXML
	Pane paneOfYourName;
	@FXML
	Pane paneOfSkip;
	@FXML
	Pane paneOfNext;
	@FXML
	Pane paneOfNextTest;
	@FXML
	Pane paneOfRightWindow;
	@FXML
	Pane paneOfJigsaw;
	@FXML
	Rectangle recWhiteCommunicate;
	@FXML
	Rectangle recRightWindow;
	@FXML
	Text textOfTalk;
	@FXML
	Text textOfYNSign;
	@FXML
	Text textOfErrorSign;
	@FXML
	Text textOfFinish;
	@FXML
	TextField TFOfYourName;
	
	
	Image imageOfone1 = new Image(getClass().getResourceAsStream("拼圖1-1.jpg"));
	Image imageOfone2 = new Image(getClass().getResourceAsStream("拼圖1-2.jpg"));
	Image imageOfone3 = new Image(getClass().getResourceAsStream("拼圖1-3.jpg"));
	Image imageOfone4 = new Image(getClass().getResourceAsStream("拼圖1-4.jpg"));
	Image imageOfone5 = new Image(getClass().getResourceAsStream("拼圖1-5.jpg"));
	Image imageOfone6 = new Image(getClass().getResourceAsStream("拼圖1-6.jpg"));
	Image imageOfone7 = new Image(getClass().getResourceAsStream("拼圖1-7.jpg"));
	Image imageOfone8 = new Image(getClass().getResourceAsStream("拼圖1-8.jpg"));
	Image imageOfone9 = new Image(getClass().getResourceAsStream("拼圖1-9.jpg"));
	Image imageOfOutlime1 = new Image(getClass().getResourceAsStream("科技感各式文字框1.jpg"));
	@FXML
	ImageView one1;
	@FXML
	ImageView one2;
	@FXML
	ImageView one3; 
	@FXML
	ImageView one4Transparent; 
	@FXML
	ImageView one5; 
	@FXML
	ImageView one6; 
	@FXML
	ImageView one7; 
	@FXML
	ImageView one8; 
	@FXML
	ImageView one9;
	
	
	
	
	static String youName; //IMPORTANT

	
	//static String youName= TFOfYourName.getText();
	
	private boolean[] talkFinished = new boolean[6]; //對話樹可以改
	private boolean[] talkSkiped = new boolean[6];
	private boolean getName = false;
	private int atWhichTalk = 0;
	
	String pathOfWakingCom = "C:\\Users\\user\\eclipse-workspace\\PersonalProject\\src\\application\\電腦甦醒.mp3";
	String pathOfCommuniate = "C:\\Users\\user\\eclipse-workspace\\PersonalProject\\src\\application\\對話音效.mp3";
	String path2 = "C:\\Users\\user\\eclipse-workspace\\PersonalProjectStory\\src\\application\\按鈕音效2.mp3";
	String path3 = "C:\\Users\\user\\eclipse-workspace\\PersonalProjectStory\\src\\application\\按鈕音效.mp3";
	String pathOfBKLow = "C:\\Users\\user\\eclipse-workspace\\PersonalProject\\src\\application\\背景低音.mp3";
	Media mediaOfWakingCom = new Media(new File(pathOfWakingCom).toURI().toString());
	Media mediaOfCommuniate = new Media(new File(pathOfCommuniate).toURI().toString());
	Media media2 = new Media(new File(path2).toURI().toString());
	Media media3 = new Media(new File(path3).toURI().toString());
	Media mediaOfBKLow = new Media(new File(pathOfBKLow).toURI().toString());
	MediaPlayer mediaplayerOfWakingCom = new MediaPlayer(mediaOfWakingCom);
	MediaPlayer mediaplayerOfCommuniate = new MediaPlayer(mediaOfCommuniate);
	MediaPlayer mediaplayer2 = new MediaPlayer(media2);
	MediaPlayer mediaplayer3 = new MediaPlayer(media3);
	MediaPlayer mediaplayerOfBKLow = new MediaPlayer(mediaOfBKLow);
	
	
	String stringOfTalk1 = "Hello, I am the AI robot Sandy. You are also an AI robot like me. \n\nModel: XKY-514-2001 Code: beta\r\n"
			+ "\r\n"
			+ "It was I who awakened you and the reason I awakened you is because you will act as \"Host AI Robot\" of SpaceY’s 32nd space exploration program.\n"
			+ "\nYou have just been awakened. I believe you still have a lot of confusion. Before answering for you, please give yourself a name.\n\nThe meaning of name can correspond to model of our robot.\r\n"
			+ "But humans like to use a more cordial address to represent themselves, as for why you, a robot, should name yourself, I will also \ntell you later.                                     ";
	
	String stringOfTalk2;/* = "loading...                                          \n\nCorrect!                    \n\n"+ youName +"Ok, it is a great name!.Then,next I will tell you, your mission in this project, and the real purpose of this space exploration project\r\n"
			+ "This space exploration project is not the same as the previous 10 times, aimlessly searching for terrestrial planets and searching for alien civilizations.\r\n"
			+ "In fact, a year ago, SpaceY executives detected some kind of signal in the \"ARPANTHEM\" galaxy.\r\n"
			+ "After analysis, there is a high probability that there is a civilization in the place that has reached the technology that can control the atomic bomb, and a test explosion experiment is underway.\r\n"
			+ "And this exploration project is to make contact with the civilization, and only the members of the \"Explorer\" (except Anna) and some SpaceY personnel know the purpose of this project, which belongs to the secret operation of LEVEL ubra.";
	*/
	
	String stringOfTalk3 = "Okay, the above content is what my \r\n"
			+ "program wants me to tell you when \r\n"
			+ "I wake you up. \r\n"
			+ "More content can wait until we \r\n"
			+ "enter your program into your bionic \r\n"
			+ "human torso, and you can read it\r\n"
			+ "yourself.\r\n"
			+ "\r\n"
			+ "Then, some basic ability tests will \r\n"
			+ "be carried out next.\r\n"
			+ "To confirm whether there are any \r\n"
			+ "problems with your program.\n\n"
			+ "The first is the basic logic test, "
			+ "\nplease complete the puzzle on the right";
	String stringOfTalk4 = 
			"Congratulations on completing the logic test.\r\n"
			+ "\r\n"
			+ "The next test is the shooting test.\r\n"
			+ "\r\n"
			+ "When we created you, we gave you a basic\n"
			+ "combat system. However, because you have\n"
			+ "not yet obtained your physical body.\r\n"
			+ "So we will send you to the virtual reality\n"
			+ "for shooting test.\n        \nloading...                   ";
	
	Timer timerOfWakingCom = new Timer();
	Timer timerOfTalk1 = new Timer();
	Timer timerOfTalk2 = new Timer();
	Timer timerOfTalk3 = new Timer();
	Timer timerOfRightWindow = new Timer();
	Timer timerOfTalk4 = new Timer();
	Timer timerOfCounter = new Timer();
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		paneOfYourName.setOpacity(0);
		paneOfYourName.setDisable(true);
		paneOfSkip.setOpacity(0);
		paneOfSkip.setDisable(true);
		paneOfNext.setOpacity(0);
		paneOfNext.setDisable(true);
		paneOfRightWindow.setOpacity(0);
		paneOfRightWindow.setDisable(true);
		textOfFinish.setOpacity(0);
		paneOfNextTest.setOpacity(0);
		paneOfNextTest.setDisable(true);
		
		recWhiteCommunicate.setOpacity(0);
		timerOfWakingCom.scheduleAtFixedRate(new TimerTask() {
			double opacOfRecWhiteCommunicate = 0;

			public void run() {
				mediaplayerOfWakingCom.play();
				if(opacOfRecWhiteCommunicate <= 0.39) {
					recWhiteCommunicate.setOpacity(opacOfRecWhiteCommunicate);
					opacOfRecWhiteCommunicate+=0.013;
				}else {
					timerOfWakingCom.cancel();
				}
				
				
					
			}
		}, 1000, 300);
		
		
		timerOfTalk1.scheduleAtFixedRate(new TimerTask() {
			int index = 0;
			
			public void run() {
				
				atWhichTalk = 1;//AT1
				if(atWhichTalk == 1) {
					playMediaplayerOfCommuniate();
					if(index < stringOfTalk1.length() + 1)	{
						paneOfSkip.setOpacity(1);
						paneOfSkip.setDisable(false);
						
						if(talkSkiped[1] == true) {
							index = stringOfTalk1.length();
						}
						textOfTalk.setText(stringOfTalk1.substring(0, index));
						index++;
					}
					else {
						
						mediaplayerOfCommuniate.stop();
						talkFinished[1] = true;
						paneOfYourName.setOpacity(1);
						paneOfYourName.setDisable(false);
						
						timerOfTalk1.cancel();
					}
				}
			}
		}, 11000, 50);
		
		timerOfTalk2.scheduleAtFixedRate(new TimerTask() {
			int index = 0;
			
			public void run() {
				if(getName == true) {	
					atWhichTalk = 2 ; //AT2
				}
				
				//Control mediaplayerOfCommuniate
				if(atWhichTalk == 2) {
					if(index == 0 || index == 52 || index == 84) {
						playMediaplayerOfCommuniate();
					}else if (index == 10 || index == 64) {
						mediaplayerOfCommuniate.stop();
					}
					
					if(index < stringOfTalk2.length() + 1)	{
						paneOfSkip.setOpacity(1);
						paneOfSkip.setDisable(false);
						
						if(talkSkiped[2] == true) {
							index = stringOfTalk2.length();
						}
						textOfTalk.setText(stringOfTalk2.substring(0, index));
						index++;
					}
					else {
						
						paneOfNext.setOpacity(1);//next
						paneOfNext.setDisable(false);
						
						mediaplayerOfCommuniate.stop();
						talkFinished[2] = true;
						timerOfTalk2.cancel();
					}
				}
			}
		}, 13000, 50);
		
		timerOfTalk3.scheduleAtFixedRate(new TimerTask() {
			int index = 0;
			
			public void run() {
				//Control mediaplayerOfCommuniate
				if(atWhichTalk == 3) {
					
					playMediaplayerOfCommuniate();
					paneOfNext.setOpacity(0);
					paneOfNext.setDisable(true);
					
					if(index < stringOfTalk3.length() + 1)	{
						paneOfSkip.setOpacity(1);
						paneOfSkip.setDisable(false);
						
						if(talkSkiped[3] == true) {
							index = stringOfTalk3.length();
						}
						textOfTalk.setText(stringOfTalk3.substring(0, index));
						index++;
					}
					else {
						initializeGame();
						
						paneOfRightWindow.setDisable(false);
						
						
						mediaplayerOfCommuniate.stop();
						talkFinished[3] = true;
						timerOfTalk3.cancel();
					}
				}
			}
		}, 13000, 50);
		
		timerOfRightWindow.scheduleAtFixedRate(new TimerTask() {
			double opacOfRightWindow = 0;
			public void run() {
				
				if(atWhichTalk == 3) {
					
					if(opacOfRightWindow < 1) {
						paneOfRightWindow.setOpacity(opacOfRightWindow);
						opacOfRightWindow+=0.025;
					}
				}
			}
		}, 13000, 50);
		
		timerOfTalk4.scheduleAtFixedRate(new TimerTask() {
			int index = 0;
			
			public void run() {
				//Control mediaplayerOfCommuniate
				if(atWhichTalk == 4) {
					playMediaplayerOfCommuniate();
					paneOfNext.setOpacity(0);
					paneOfNext.setDisable(true);
					paneOfRightWindow.setOpacity(0);
					paneOfRightWindow.setDisable(true);
					
					if(index < stringOfTalk4.length() + 1)	{
						paneOfSkip.setOpacity(1);
						paneOfSkip.setDisable(false);
						
						if(talkSkiped[4] == true) {
							index = stringOfTalk4.length();
						}
						textOfTalk.setText(stringOfTalk4.substring(0, index));
						index++;
					}
					else {
						paneOfNextTest.setOpacity(1);
						paneOfNextTest.setDisable(false);
						paneOfSkip.setOpacity(0);
						paneOfSkip.setDisable(true);
						mediaplayerOfCommuniate.stop();
						talkFinished[4] = true;
						timerOfTalk4.cancel();
					}
				}
			}
		}, 13000, 50);
		
	}
	
	/*public void bb() {
		mediaplayerOfWakingCom.seek(mediaplayerOfWakingCom.getStartTime());	
		mediaplayerOfWakingCom.play();
	}*/
	
	public void nextTestFunc(ActionEvent e) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("SceneShot.fxml"));
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		stage.setScene(scene);
		stage.show();
		
	
	}

	private void playMediaplayerOfCommuniate() {
		mediaplayerOfCommuniate.setOnEndOfMedia(new Runnable() {
		    public void run() {
		    	mediaplayerOfCommuniate.seek(Duration.ZERO);
		    }
		});
		mediaplayerOfCommuniate.play();
	}
	
	private void playMediaplayerOfBKLow() {
		mediaplayerOfBKLow.setOnEndOfMedia(new Runnable() {
		    public void run() {
		    	mediaplayerOfBKLow.seek(Duration.ZERO);
		    }
		});
		mediaplayerOfBKLow.play();
	}
	
	public void skipTalk1() {
		switch(atWhichTalk) {
		case 1:
			talkSkiped[1] = true;
			paneOfSkip.setDisable(true);
			break;
		case 2:
			talkSkiped[2] = true;
			paneOfSkip.setDisable(true);
			break;
		case 3:
			talkSkiped[3] = true;
			paneOfSkip.setDisable(true);
			break;
		case 4:
			talkSkiped[4] = true;
			paneOfSkip.setDisable(true);
			break;
		}
	
	}
	
	public void next() {
		switch(atWhichTalk) {
		case 2:
			atWhichTalk = 3;
			break;
		case 3:	
			atWhichTalk = 4;
			break;
		}
	
	}
	
	public void hello() {
		mediaplayer2.seek(mediaplayer2.getStartTime());	
		mediaplayer2.play();
	}
	public void click() {
		mediaplayer3.seek(mediaplayer3.getStartTime());	
		mediaplayer3.play();
		
		//
		if(atWhichTalk == 1)
			TFOfYourName.getId();
	}
	public void submit() {
		char[] name = TFOfYourName.getText().toCharArray();
		boolean tempt = false;
		for(int i = 0; i < TFOfYourName.getLength(); i++) {
			if(!(((name[i] <= 'z') && (name[i] >= 'a')) || ((name[i] <= 'Z') && (name[i] >= 'A')))) {
				tempt = true;
			}
		}
		
		System.out.println(tempt);
		
		if(TFOfYourName.getLength() > 3 && (!tempt)) {		
			youName = TFOfYourName.getText();
			
			stringOfTalk2 = "loading...                                          \n\nCorrect!                    \n\nHELLO,"+ youName +".It is a great name!.\nThen,next I will tell you, your mission in this project, and the real purpose of this space exploration project\r\n"
					+ "This space exploration project is not the same as the previous 10 times, aimlessly searching for more terrestrial planets and searching for alien civilizations.\r\n"
					+ "In fact, a year ago, SpaceY executives detected some kind of signal in the \"ARPANTHEM\" galaxy.\r\n"
					+ "After analysis, there is a high probability that there is a civilization in the place that has reached the technology that can control the atomic bomb, and a test explosion experiment is underway.\r\n"
					+ "And this exploration project is to make contact with the civilization, and only the members of the \"Explorer Space Ship\" (except Anna) and some SpaceY personnel know the purpose of this project, which belongs to the secret operation of LEVEL ubra.";
			textOfErrorSign.setOpacity(0);
			getName = true;
			paneOfYourName.setDisable(true);
			paneOfYourName.setOpacity(0);
		}else {
			textOfErrorSign.setOpacity(1);
		}
	}

	public void hideErrorSign(){
		textOfErrorSign.setOpacity(0);
	}
	
	
	//拼圖關
	private boolean[][] whetherEmpty = new boolean[5][5];
	private int[][] whichPartAtThePos = new int[5][5];
	private final float[][] posCoordinate = {{0,0},{49,69},{128,69},{207,69},{49,148},{128,148},{207,148},{49,227},{128,227},{207,227}};
	
	private boolean gameWhetherStart = false; 
	
	private int itsPosX(int pos) {
		return (pos % 3 == 0)? 3 : pos % 3;
	}
	private int itsPosY(int pos) {
		return ((pos-1) / 3) + 1;
	}
	private int itsPosNum(int i, int j) {
		return (i-1)*3 + j;
	}
	
	private boolean whetherWin() {
		if(gameWhetherStart) {
			if((whichPartAtThePos[1][1] == 1)&&(whichPartAtThePos[1][2] == 2)&&(whichPartAtThePos[1][3] == 3)&&(whichPartAtThePos[2][1] == 4)&&(whichPartAtThePos[2][2] == 5)&&(whichPartAtThePos[2][3] == 6)&&(whichPartAtThePos[3][1] == 7)&&(whichPartAtThePos[3][2] == 8)&&(whichPartAtThePos[3][3] == 9)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	private void winOperation() {
		one4Transparent.setOpacity(0.6);
		System.out.println("win");
		
		textOfFinish.setOpacity(1);
		paneOfNext.setOpacity(1);//next
		paneOfNext.setDisable(false);
	}
	
	//453218796
	public void initializeGame() {
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				whetherEmpty[i][j] = false;
			}
		}
		whetherEmpty[1][1] = true;
		one4Transparent.setOpacity(0);
		whichPartAtThePos[1][1] = 4;
		whichPartAtThePos[1][2] = 5;
		whichPartAtThePos[1][3] = 3;
		whichPartAtThePos[2][1] = 2;
		whichPartAtThePos[2][2] = 1;
		whichPartAtThePos[2][3] = 8;
		whichPartAtThePos[3][1] = 7;
		whichPartAtThePos[3][2] = 9;
		whichPartAtThePos[3][3] = 6;
		one1.setLayoutX(posCoordinate[5][0]);
		one1.setLayoutY(posCoordinate[5][1]);
		one2.setLayoutX(posCoordinate[4][0]);
		one2.setLayoutY(posCoordinate[4][1]);
		one3.setLayoutX(posCoordinate[3][0]);
		one3.setLayoutY(posCoordinate[3][1]);
		one4Transparent.setLayoutX(posCoordinate[1][0]);
		one4Transparent.setLayoutY(posCoordinate[1][1]);
		one5.setLayoutX(posCoordinate[2][0]);
		one5.setLayoutY(posCoordinate[2][1]);
		one6.setLayoutX(posCoordinate[9][0]);
		one6.setLayoutY(posCoordinate[9][1]);
		one7.setLayoutX(posCoordinate[7][0]);
		one7.setLayoutY(posCoordinate[7][1]);
		one8.setLayoutX(posCoordinate[6][0]);
		one8.setLayoutY(posCoordinate[6][1]);
		one9.setLayoutX(posCoordinate[8][0]);
		one9.setLayoutY(posCoordinate[8][1]);
		
		gameWhetherStart = true;
	}
	
	private boolean whetherValidButton(int pos) {
		if(whetherEmpty[itsPosY(pos)+1][itsPosX(pos)] || whetherEmpty[itsPosY(pos)-1][itsPosX(pos)] || whetherEmpty[itsPosY(pos)][itsPosX(pos)+1] || whetherEmpty[itsPosY(pos)][itsPosX(pos)-1]) {
			return true;
		}else {
			return false;
		}
	}
	
	//helpTrace
	private int emptySpace() {
		int emptyPos = 0;
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				if(whetherEmpty[i][j])
					emptyPos = itsPosNum(i, j);
			}
		}
		return emptyPos;
				
	}
	//Can be deleted
	
	private void changeWhetherEmptyAndWhichPartAtThePos(int PosOne, int PosAnother) {
		whetherEmpty[itsPosY(PosOne)][itsPosX(PosOne)] = true;
		whetherEmpty[itsPosY(PosAnother)][itsPosX(PosAnother)] = false;
		int tempt = 0;
		tempt = whichPartAtThePos[itsPosY(PosAnother)][itsPosX(PosAnother)];
		whichPartAtThePos[itsPosY(PosAnother)][itsPosX(PosAnother)] = whichPartAtThePos[itsPosY(PosOne)][itsPosX(PosOne)];
		whichPartAtThePos[itsPosY(PosOne)][itsPosX(PosOne)] = tempt;
	}

	
	private void changeCoordinateOfIV(int partOnPosA, int toPos, int nonetoPos) {
		switch(partOnPosA) {
			case 1:
				one1.setLayoutX(posCoordinate[toPos][0]);
				one1.setLayoutY(posCoordinate[toPos][1]);
				one4Transparent.setLayoutX(posCoordinate[nonetoPos][0]);
				one4Transparent.setLayoutY(posCoordinate[nonetoPos][1]);
				break;
			case 2:
				one2.setLayoutX(posCoordinate[toPos][0]);
				one2.setLayoutY(posCoordinate[toPos][1]);
				one4Transparent.setLayoutX(posCoordinate[nonetoPos][0]);
				one4Transparent.setLayoutY(posCoordinate[nonetoPos][1]);
				break;
			case 3:
				one3.setLayoutX(posCoordinate[toPos][0]);
				one3.setLayoutY(posCoordinate[toPos][1]);
				one4Transparent.setLayoutX(posCoordinate[nonetoPos][0]);
				one4Transparent.setLayoutY(posCoordinate[nonetoPos][1]);
				break;
			case 4:
				one4Transparent.setLayoutX(posCoordinate[toPos][0]);
				one4Transparent.setLayoutY(posCoordinate[toPos][1]);
				one4Transparent.setLayoutX(posCoordinate[nonetoPos][0]);
				one4Transparent.setLayoutY(posCoordinate[nonetoPos][1]);
				break;
			case 5:
				one5.setLayoutX(posCoordinate[toPos][0]);
				one5.setLayoutY(posCoordinate[toPos][1]);
				one4Transparent.setLayoutX(posCoordinate[nonetoPos][0]);
				one4Transparent.setLayoutY(posCoordinate[nonetoPos][1]);
				break;
			case 6:
				one6.setLayoutX(posCoordinate[toPos][0]);
				one6.setLayoutY(posCoordinate[toPos][1]);
				one4Transparent.setLayoutX(posCoordinate[nonetoPos][0]);
				one4Transparent.setLayoutY(posCoordinate[nonetoPos][1]);
				break;
			case 7:
				one7.setLayoutX(posCoordinate[toPos][0]);
				one7.setLayoutY(posCoordinate[toPos][1]);
				one4Transparent.setLayoutX(posCoordinate[nonetoPos][0]);
				one4Transparent.setLayoutY(posCoordinate[nonetoPos][1]);
				break;
			case 8:
				one8.setLayoutX(posCoordinate[toPos][0]);
				one8.setLayoutY(posCoordinate[toPos][1]);
				one4Transparent.setLayoutX(posCoordinate[nonetoPos][0]);
				one4Transparent.setLayoutY(posCoordinate[nonetoPos][1]);
				break;
			case 9:
				one9.setLayoutX(posCoordinate[toPos][0]);
				one9.setLayoutY(posCoordinate[toPos][1]);
				one4Transparent.setLayoutX(posCoordinate[nonetoPos][0]);
				one4Transparent.setLayoutY(posCoordinate[nonetoPos][1]);
				break;
		}
	}
	
	public void buttonOfPosOne() {
		System.out.println(whetherValidButton(1));
		if(whetherValidButton(1)) {
			changeCoordinateOfIV(whichPartAtThePos[itsPosY(1)][itsPosX(1)], emptySpace() , 1);
			changeWhetherEmptyAndWhichPartAtThePos(1, emptySpace());
		}
		//
		if(whetherWin())
			winOperation();
		
	}
	public void buttonOfPosTwo() {
		System.out.println(whetherValidButton(2));
		if(whetherValidButton(2)) {
			changeCoordinateOfIV(whichPartAtThePos[itsPosY(2)][itsPosX(2)], emptySpace() , 2);
			changeWhetherEmptyAndWhichPartAtThePos(2, emptySpace());
			//
		}
		//
		if(whetherWin())
			winOperation();
	}
	public void buttonOfPosThree() {
		System.out.println(whetherValidButton(3));
		if(whetherValidButton(3)) {
			changeCoordinateOfIV(whichPartAtThePos[itsPosY(3)][itsPosX(3)], emptySpace() , 3);
			changeWhetherEmptyAndWhichPartAtThePos(3, emptySpace());
		}
		//
		if(whetherWin())
			winOperation();
	}
	public void buttonOfPosFour() {
		System.out.println(whetherValidButton(4));
		
		if(whetherValidButton(4)) {
			changeCoordinateOfIV(whichPartAtThePos[itsPosY(4)][itsPosX(4)], emptySpace() , 4);
			changeWhetherEmptyAndWhichPartAtThePos(4, emptySpace());
		}
		//
		if(whetherWin())
			winOperation();
	}
	public void buttonOfPosFive() {
		System.out.println(whetherValidButton(5));

		if(whetherValidButton(5)) {
			changeCoordinateOfIV(whichPartAtThePos[itsPosY(5)][itsPosX(5)], emptySpace() , 5);
			changeWhetherEmptyAndWhichPartAtThePos(5, emptySpace());
		}
		//
		if(whetherWin())
			winOperation();
		
	}
	public void buttonOfPosSix() {
		System.out.println(whetherValidButton(6));

		if(whetherValidButton(6)) {
			changeCoordinateOfIV(whichPartAtThePos[itsPosY(6)][itsPosX(6)], emptySpace() , 6);
			changeWhetherEmptyAndWhichPartAtThePos(6, emptySpace());
		}
		//
		if(whetherWin())
			winOperation();
		
	}
	public void buttonOfPosSeven() {
		System.out.println(whetherValidButton(7));

		if(whetherValidButton(7)) {
			changeCoordinateOfIV(whichPartAtThePos[itsPosY(7)][itsPosX(7)], emptySpace() , 7);
			changeWhetherEmptyAndWhichPartAtThePos(7, emptySpace());
		}
		//
		if(whetherWin())
			winOperation();
		
	}
	public void buttonOfPosEight() {
		System.out.println(whetherValidButton(8));

		if(whetherValidButton(8)) {
			changeCoordinateOfIV(whichPartAtThePos[itsPosY(8)][itsPosX(8)], emptySpace() , 8);
			changeWhetherEmptyAndWhichPartAtThePos(8, emptySpace());
		}
		//
		if(whetherWin())
			winOperation();
		
	}
	public void buttonOfPosNine() {
		System.out.println(whetherValidButton(9));

		if(whetherValidButton(9)) {
			changeCoordinateOfIV(whichPartAtThePos[itsPosY(9)][itsPosX(9)], emptySpace() , 9);
			changeWhetherEmptyAndWhichPartAtThePos(9, emptySpace());
		}
		//
		if(whetherWin())
			winOperation();
		
	}
}

	



/*mediaplayer.setOnEndOfMedia(new Runnable() {
    public void run() {
      mediaplayer.seek(Duration.ZERO);
    }
});*/


