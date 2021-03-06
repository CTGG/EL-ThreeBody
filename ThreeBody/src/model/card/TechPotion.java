package model.card;

import java.util.List;

import model.Player;
import model.operation.Operation;
import config.CardConfig;
import config.GameConfig;
import dto.GameDTO;
import model.operation.ResourceChange;
import model.operation.ResourceChange.Type;
import model.operation.TechChange;

/*
 * 科技药水
 * 通过消耗资源来增长科技
 */
public class TechPotion extends Card{

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	public TechPotion(String operator, String receiver) {
		super(operator, receiver);
		
		GameConfig gc = new GameConfig();
		List<CardConfig> cardList=gc.getCardsConfig();
		this.name="科技革命";
		this.lifetime=cardList.get(5).getLifetime();
		this.requiredResource=cardList.get(5).getRequiredResource();
		this.requiredTechPoint=cardList.get(5).getRequiredTechPoint();
	}

	@Override
	public void process(List<Operation> subOperations) {
		
		//pay  resources
		ResourceChange rc=new ResourceChange(operator, receiver, Type.DECREASE, this.requiredResource);
		subOperations.add(rc);
		
		//get techPoint
		TechChange tc=new TechChange(operator, receiver, TechChange.Type.INCREASE, 30);
		subOperations.add(tc);
		
		// description is not necessary
		
		// setUsed
		Player pOperator = this.findOperator(GameDTO.getInstance());
		pOperator.setPrivilegeTechnology(false);
		
		pOperator.refreshCardUnavailable();
		
	}
	
}
