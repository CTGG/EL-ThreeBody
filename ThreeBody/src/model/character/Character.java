package model.character;

import model.card.Card;

public abstract class Character {
    
    private int techPoint;
    private int resource;
    
    /*
     * ÿ�غ���ֵ����ʱ���� 
     */
    public abstract void addTechPoint();
    public abstract void addResource();
    
    /*
     * �ж�ĳ�������Ƿ���� 
     */
    public abstract boolean isAvailable(Card card);
    
    /*
     * getters and setters
     */
    public int getTechPoint() {
        return techPoint;
    }
    public void setTechPoint(int techPoint) {
        this.techPoint = techPoint;
    }
    public int getResource() {
        return resource;
    }
    public void setResource(int resource) {
        this.resource = resource;
    }
    
}
