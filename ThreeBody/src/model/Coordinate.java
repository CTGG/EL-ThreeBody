package model;

public class Coordinate {
    
    public static final int UNKNOWN = 998;
    public static final int PROTECTED = 10086;
    
    private int[] sequence;
    private boolean[] isProtected;
    
    /**
     * 
     * @param number ����ĵڼ���
     * @return ���û�б��������������������꣬���򷵻�PROTECTED
     */
    public int getCoordinateElement(int number){
    	if(isProtected[number]){
    		return PROTECTED;
    	}
    	return sequence[number];
    }
    
    public void setCoordinateElement(int number,int value){
    	sequence[number] = value;
    }
    
}
