package model.card;

import java.util.List;

import config.CardConfig;
import config.GameConfig;
import model.Player;
import model.operation.ResourceChange;
import model.operation.ResourceChange.Type;
import dto.GameDTO;

public class WholeBlock extends Card{
	
	
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	

	public WholeBlock(String operator, String receiver) {
		super(operator, receiver);
		
		
		GameConfig gc=new GameConfig();
		List<CardConfig> cardList=gc.getCardsConfig();
		this.lifetime = cardList.get(6).getLifetime();
		this.requiredResource=cardList.get(6).getRequiredResource();
		this.requiredTechPoint=cardList.get(6).getRequiredTechPoint();
	}


	/*
	 * 将玩家的所有坐标全部设为PROTECTED
	 */

	@Override
	public void process() {
		
		GameDTO dto=GameDTO.getInstance();
		
		//get the operator, now operator==receiver
		Player pOperator=this.findOperator(dto);
		Player pReceiver=pOperator;
		
		//pay the resources
		ResourceChange rc=new ResourceChange(operator, receiver, Type.DECREASE, this.requiredResource);
		dto.depositOperation(rc);
		
		//set the coordinate ==10086(PROTECTED)
		for (int i = 0; i < 4; i++) {
			pOperator.getCoordinate().setCoordinateElement(i, 10086);
		}
	}
	

}
