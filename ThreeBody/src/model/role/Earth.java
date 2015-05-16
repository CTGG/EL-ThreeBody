package model.role;

import java.util.List;

import config.GameConfig;
import config.RoleConfig;
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

public class Earth extends Role{
	
	public Earth() {
		super();
		
		GameConfig gc=new GameConfig();		
		List<RoleConfig> roleList=gc.getRolesConfig();
		this.initialResource=roleList.get(0).getInitialResource();
		this.initialTechPoint=roleList.get(0).getInitialTechPoint();
		this.tchDevelopSpeed=roleList.get(0).getTchDevelopSpeed();
		this.rsrRestoreSpeed=roleList.get(0).getRsrRestoreSpeed();
	}
	
	@Override
	public boolean isAvailable(Card card) {
		return true;
	}

}




	