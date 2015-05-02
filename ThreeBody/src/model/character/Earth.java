package model.character;

import model.card.Card;

/*
 * 角色：地球
 * 目标：获得三体以及归一者的坐标，广播出去，使其消灭
 * 科技值：初始值最低       增长值最快
 * 资源：初始值中 	增长值中
 * 技能限制：无限制
 * 广播：可以获取坐标，可以发送（玩家点击确认发送）
 * 
 */

public class Earth extends Character{
	
	public  boolean isAvailable(Card card){
// 	switch(card){
//		case 
//		}	
		//TODO
		return false;
	}

	@Override
	public int addTechPoint(int nowTechPoint) {
		int techSpeed =15 ;
		return   nowTechPoint+techSpeed ;
	}

	@Override
	public int addResource(int nowResource) {
		int resourceSpeed=10;
		return nowResource+resourceSpeed;
	}
}
