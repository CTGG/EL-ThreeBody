package model.card;

import java.util.List;

import config.CardConfig;
import config.GameConfig;
import model.Player;
import model.operation.ResourceChange;
import model.operation.ResourceChange.Type;
import dto.GameDTO;

/*
 * 对某个玩家禁一轮广播坐标功能
 */
public class NoBroadcasting extends Card{	
	
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;



	public NoBroadcasting(String operator, String receiver) {
		super(operator, receiver);
		
		GameConfig gc=new GameConfig();
		List<CardConfig> cardList=gc.getCardsConfig();
		this.lifetime=cardList.get(0).getLifetime();
		this.requiredResource=cardList.get(0).getRequiredResource();
		this.requiredTechPoint=cardList.get(0).getRequiredTechPoint();
	}

	@Override
	public void process() {
		
		GameDTO dto=GameDTO.getInstance();
		
		//get the  receiver
		Player pReceiver=this.findReceiver(dto);
		
		//pay the resource
		ResourceChange rc=new ResourceChange(operator, receiver, Type.DECREASE, this.requiredResource);
		dto.depositOperation(rc);
		
		//将receiver的broadcast设为false，在lifetime轮中
		pReceiver.setBroadcast(false);
		
	}


}
