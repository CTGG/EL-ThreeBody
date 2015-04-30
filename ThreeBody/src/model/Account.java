package model;

import java.awt.Image;
import java.io.Serializable;

public class Account implements Serializable{
    
    /**
	 * default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
    /*
     * ͷ��
     */
    private Image head;
    /*
     * ����
     */
    private int point;
    /*
     * ����
     */
    private int rank;
    /*
     * ����Ϸ�������������Ӯ����ǿ�˵�
     */
    private int totalGames;
    private int wins;
    private int losts;
    private String regions;
    
    /*
     * 
     */
    public Account(String id){
    	this.id = id;
    }
    
    /*
     * getters and setters
     */
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Image getHead() {
		return head;
	}
	public void setHead(Image head) {
		this.head = head;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getTotalGames() {
		return totalGames;
	}
	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosts() {
		return losts;
	}
	public void setLosts(int losts) {
		this.losts = losts;
	}
	public String getRegions() {
		return regions;
	}
	public void setRegions(String regions) {
		this.regions = regions;
	}
    
    

}
