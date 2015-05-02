package model.character;

import model.card.Card;

public abstract class Character {
    
    protected int initialTechPoint;
    protected int initialResource;
    
    /*
     * ÿ�غ���ֵ����ʱ���� 
     */
    public abstract int addTechPoint(int nowTechPoint);
    public abstract int addResource(int nowResource);
    
    /*
     * �ж�ĳ�������Ƿ���� 
     */
    public abstract boolean isAvailable(Card card);
    
    /*
     * getters
     */
    public int getInitialTechPoint() {
        return this.initialTechPoint;
    }
    public int getInitialResource() {
        return this.initialResource;
    }
}
