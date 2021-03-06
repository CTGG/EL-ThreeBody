package control;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import io.NetClient;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.AboutUsPanel;
import ui.AnimatePanel;
import ui.FrameUtil;
import ui.MainFrame;
import ui.PreferencePanel;
import ui.RoomPanel;
import ui.ScorePanel;
import ui.StartMenuPanel;
import ui.account.AccountPanel;
import ui.game.GamePanel;
import ui.lobby.LobbyPanel;
import ui.sound.Media;
import ui.sound.Sound;
import dto.AccountDTO;

public class MainControl {
	
	private static MainControl instance;

	public JPanel currentPanel = null;
	public JFrame frame = null;
	private JPanel startMenuPanel = null;
	private JPanel gamePanel = null;
	private JPanel aboutUs = null;
	public LobbyPanel lobbyPanel = null;
	private JPanel account=null;
	private JPanel preference=null;
	public RoomPanel roomPanel=null;
	private AnimatePanel animate=null;
	private JPanel score=null;
	
	public AccountControl accountControl;
	public LobbyControl lobbyControl;
	public RoomControl roomControl;
	public GameControl gameControl;
	
	private boolean connected = false;
	
	
	public static void main(String[] args) {

		final MainControl mc = new MainControl();
		
		mc.accountControl = new AccountControl(mc);
		String id = AccountDTO.getInstance().getId();
		
		new Thread(new Runnable(){
			public void run(){
				try {
					NetClient.getInstance();
				} catch (MalformedURLException | RemoteException
						| NotBoundException e) {
					FrameUtil.sendMessageByPullDown(mc.currentPanel, "网络连接出错");
				}
			}
		}).start();
		
		if(!id.equals("未登录")){
//			if (mc.accountControl.loginByTransientID(id) == R.info.SUCCESS) {
//				mc.connected = true;
//			}
		}
		//TODO
		mc.frame = new MainFrame(mc);
		mc.toStartMenu();
//		mc.toAnimate("opening");
		Sound.load("BGM1");
		Media.playBGM(Sound.BGM);
		
		instance = mc;
	}
	
	public static MainControl getInstance(){
		return instance;
	}

	public void toStartMenu() {
		this.startMenuPanel = new StartMenuPanel(this);
		if(currentPanel!=null&&currentPanel==lobbyPanel){
			currentPanel.setVisible(false);	
		}
		currentPanel = this.startMenuPanel;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}

	public void toAnimate(String fileName) {
		currentPanel.setVisible(false);
		this.animate = new AnimatePanel(fileName,this);
		currentPanel = this.animate;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
		animate.run();
	}

	public void toPreference() {
		currentPanel.setVisible(false);
		if (this.preference == null) {
			this.preference = new PreferencePanel(this);
		}
		currentPanel = this.preference;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}

	public void toTutorial() {
	}

	public void toGame(int numOfPlayers) {
		// new GameControl
		gameControl = roomControl.getGameService();
		// 绘制gamePanel
		currentPanel.setVisible(false);
		this.gamePanel = new GamePanel(gameControl);
		currentPanel = this.gamePanel;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
		// 设定panel，开始游戏
		gameControl.setPanel((GamePanel)gamePanel);
		gameControl.turnChange();
	}

	public void toLobby() {
		// new LobbyControl
		if (lobbyControl == null){
			lobbyControl = new LobbyControl(this);
		}
		currentPanel.setVisible(false);
		this.lobbyPanel = new LobbyPanel(this);
		currentPanel = this.lobbyPanel;
		lobbyControl.setLobbyPanel((LobbyPanel)this.lobbyPanel);
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		lobbyControl.startRefresh();
	}

	public void toRoom(String roomName) {
		if(roomControl == null){
			roomControl = lobbyControl.getRoomService(roomName);
		}
		currentPanel.setVisible(false);
		roomPanel = new RoomPanel(this,roomControl);
		roomControl.setRoomPanel((RoomPanel)roomPanel);
		currentPanel = this.roomPanel;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}

	public void toAboutUs() {
		currentPanel.setVisible(false);
		this.aboutUs = new AboutUsPanel(this);
		currentPanel = this.aboutUs;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}
	
	public void toAccount(String id) {
		currentPanel.setVisible(false);
		this.account = new AccountPanel(this,id,this.accountControl);
		currentPanel = this.account;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}

	// TODO 先写着 = =
	public void toScore() {
		roomControl.exit();
		toStartMenu();
	}

	public void exit() {
		if(roomControl != null){
			roomControl.exit();
		}
		if(connected){
			accountControl.logout();
		}
		System.exit(0);
	}
	
	public void toScore(boolean isLost) {
		roomControl.exit();
		
		currentPanel.setVisible(false);
		this.score = new ScorePanel(isLost,this);
		currentPanel = this.score;
		frame.setContentPane(currentPanel);
		currentPanel.setVisible(true);
		frame.validate();
	}
	
	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

}
