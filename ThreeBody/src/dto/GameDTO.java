package dto;

import java.util.List;

import model.Broadcast;
import model.Operation;
import model.Player;

public class GameDTO {
    
    private List<Player> players;
    /*
     * ˭�Ļغ�
     */
    private Player whoseTurn;
    /*
     * ���ص���� 
     */
    private Player user;
    /*
     * ��ʷ��Ϣ��¼
     */
    private List<Broadcast> broadcasts;
    /*
     * ��ʷ������¼
     */
    private List<Operation> operations;
    /*
     * δִ�еĲ���
     */
    private List<Operation> unhandledOperations;
    
    public void depositOperation(Operation operation){
        
    }
}
