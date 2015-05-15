package control;

import java.rmi.RemoteException;

import model.Room;
import server.interfaces.RMIRoom;
import ui.RoomPanel;
import util.R;
import dto.AccountDTO;

public class RoomControl {
	
	private RMIRoom rmir;
	private MainControl mainControl;
	private Room room;
	private RoomPanel roomPanel;
	private GameStartChecker gsc;
	
	public RoomControl(MainControl mc,RMIRoom rmir){
		this.mainControl = mc;
		this.rmir = rmir;
		this.room = this.refreshRoom();
		this.gsc = new GameStartChecker();
		gsc.start();
	}
	
	public void setRoomPanel(RoomPanel roomPanel){
		this.roomPanel = roomPanel;
	}
	
	/**
	 * 
	 * @return SUCCESS：准备好
	 */
	public R.info ready(){
		try {
			return rmir.ready(AccountDTO.getInstance().getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return SUCCESS：取消准备
	 */
	public R.info cancelReady(){
		try {
			return rmir.cancelReady(AccountDTO.getInstance().getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return INVALID：有玩家没准备好
	 *         SUCCESS: 成功开始
	 */
	public R.info start(){
		try {
			return rmir.start();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return SUCCESS: 成功离开房间
	 */
	public synchronized R.info exit(){
		try {
			gsc.end();
			mainControl.roomControl = null;
			mainControl.toLobby();
			return rmir.exit(AccountDTO.getInstance().getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return 刷新后的Room
	 */
	public Room refreshRoom(){
		try {
			return rmir.refresh();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Room getRoom(){
		return room;
	}
	
	/**
	 * 
	 * @return GameControl对象
	 */
	public GameControl getGameService(){
		try {
			return new GameControl(rmir.getGameServer());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 检查游戏是否开始，若开始，进入游戏界面
	 */
	private class GameStartChecker extends Thread{
		boolean running = true;
		public void end(){
			running = false;
		}
		@Override
		public void run(){
			while(running && !room.isStart()){
				try {
					refreshRoomPanel();
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(room.isStart()){
				mainControl.toGame(room.getSize());
			}else{
				mainControl.toLobby();
			}
		}
	}
	
	private synchronized void refreshRoomPanel(){
		System.out.println("zaishua");
		room = refreshRoom();
		roomPanel.refresh();
	}
}
