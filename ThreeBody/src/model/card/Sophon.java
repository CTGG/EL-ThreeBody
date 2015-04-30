package model.card;

import model.Coordinate;
import model.Player;
import model.operation.CoordinateGet;
import model.operation.CoordinateGetFail;
import model.operation.ResourceChange;
import dto.GameDTO;

/**
 * 
 * @author Sissel
 * �߼����ӣ�
 */
public class Sophon extends Card{

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	
	private int number;

	/**
	 * 
	 * @param operator
	 * @param receiver
	 * @param number ��Ҫ��ȡ����ҵĵڼ�������
	 */
	public Sophon(String operator, String receiver,int number) {
		super(operator, receiver);
		this.techPoint = 30;
		this.resource = 80;
		this.number = number;
	}

	@Override
	public void process() {
		GameDTO dto = GameDTO.getInstance();
		Player pOperator = null;
		Player pReceiver = null;
		//�ҵ���Ӧ�����
		for (Player player : dto.getPlayers()) {
			if(player.getAccount().getId().equals(this.operator)){
				pOperator = player;
			}
			if(player.getAccount().getId().equals(this.receiver)){
				pReceiver = player;
			}
		}
		//������Ӧ����Դ��ͨ��������Operation��ʵ��
		ResourceChange rc = new ResourceChange(operator, receiver, ResourceChange.Type.DECREASE, this.resource);
		dto.depositOperation(rc);
		//ִ�л�ȡ�������
		Coordinate coordinate = pReceiver.getCoordinate();
		int result = coordinate.getCoordinateElement(number);
		if(result == Coordinate.UNKNOWN){
			CoordinateGetFail cgf = new CoordinateGetFail(operator,receiver);
			dto.depositOperation(cgf);
		}else{
			// �趨operator���ѷ��ֵ�����ֵ
			pOperator.getFoundCoordinates().get(pReceiver).setCoordinateElement(number, result);
			CoordinateGet cg = new CoordinateGet(operator,receiver,number,result);
			dto.depositOperation(cg);
		}
	}

}
