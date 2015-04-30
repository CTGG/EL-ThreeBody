package model.operation;

import model.card.Card;

public class CardUse extends Operation implements Operable{
	
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;
	
	private Card card;
	
	public CardUse(String operator,String receiver,Card card) {
		super(operator, receiver);
		this.card = card;
	}

	/*
	 * (non-Javadoc)
	 * @see model.operation.Visible#toOperator()
	 * �Բ����߿ɼ�
	 */
	@Override
	public String toOperator() {
		return this.operator + "ʹ����" + card.getName();
	}

	/*
	 * (non-Javadoc)
	 * @see model.operation.Visible#toReceiver()
	 * �Ա�ʹ���߲��ɼ�
	 */
	@Override
	public String toReceiver() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see model.operation.Visible#toOthers()
	 * �������˲��ɼ�
	 */
	@Override
	public String toOthers() {
		return null;
	}

	@Override
	public void process() {
		card.process();
	}

}
