package model;

import java.util.Map;

public class Player {
    /*
     * �������˻�
     */
    private Account account;
    private Character character;
    private Coordinate coordinate;
    /*
     * �Ƿ���ʹ����Ȩ
     */
    private boolean privilegeUsed;
    /*
     * �Ƿ���AI
     */
    private boolean AI;
    /*
     * �Ƿ��Ѿ��ܱ�
     */
    private boolean lost;
    /*
     * �Ѿ���֪��������ҵ�����
     */
    private Map<Player,Coordinate> foundCoordinates;
    /*
     * �Ѿ���֪��������ҵ����
     */
    private Map<Player,Character> foundCharacters;
    /*
     * ��Դ���Ƽ���
     */
    private int resource;
    private int techPoint;
    
    /*
     * getters and setters
     */
    public int getResource() {
		return resource;
	}
	public int getTechPoint() {
		return techPoint;
	}
	public void setResource(int resource) {
		this.resource = resource;
	}
	public void setTechPoint(int techPoint) {
		this.techPoint = techPoint;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Character getCharacter() {
		return character;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	public boolean isPrivilegeUsed() {
		return privilegeUsed;
	}
	public boolean isAI() {
		return AI;
	}
	public boolean isLost() {
		return lost;
	}
	public Map<Player, Coordinate> getFoundCoordinates() {
		return foundCoordinates;
	}
	public Map<Player, Character> getFoundCharacters() {
		return foundCharacters;
	}
}
