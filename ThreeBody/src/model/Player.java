package model;

import java.util.Map;

import model.character.Character;

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
}
