package model;

import java.util.List;
import java.util.Map;

public class Room {
    
    List<Account> accounts;
    String name;
    /*
     * �Ƿ�ʼ
     */
    boolean state;
    /*
     * ÿλ����Ƿ�׼����
     */
    Map<Player,Boolean> ready;
    /*
     * ������������
     */
    int size;

}
