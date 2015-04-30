package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import model.Account;
import server.interfaces.RMIAccount;
import util.R;
import util.R.info;

/**
 * 
 * @author Sissel
 * 
 * �������ʵ��Ӧ���������ܣ�һ������Ϊ��һ������ͻ��˵�½�����ַ����Եĺ������Ӷ˿�
 * ��һ����������Ϊ�ض�����Ϊ�ض��ͻ��˵����Ӷ˿��ṩ����
 */
public class AccountServer extends UnicastRemoteObject implements RMIAccount {

	private static final long serialVersionUID = 1L;

	/*
	 * ��Ӧ�����������ϵ�ȫ��account
	 */
	Map<String, String> passwords;
	Map<String, Account> accounts;
	Set<String> invitationIDs;
	/*
	 * ��Ӧ����account
	 */
	Account account;

	protected AccountServer() throws RemoteException {

	}

	public static void main(String[] args) {
		try {
			AccountServer dispatchSever = new AccountServer();
			
			// TODO �ļ�IO
			dispatchSever.passwords = new HashMap<String, String>();
			dispatchSever.accounts = new HashMap<String, Account>();
			dispatchSever.invitationIDs = new TreeSet<String>();
			
			Naming.rebind("AccountDispatch", dispatchSever);
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public info logout(Account account) throws RemoteException {
		this.unbindAccount(account);
		return R.info.SUCCESS;
	}

	@Override
	public info login(String id, String password) throws RemoteException {
		Account account = accounts.get(id);
		if (account == null) {
			return R.info.NOT_EXISTED;
		} else if (!passwords.get(id).equals(password)) {
			return R.info.INVALID;
		}
		this.dispatchAccount(account);
		return R.info.SUCCESS;
	}

	@Override
	public info uploadChange(Account account) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public info downloadChange(Account account) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public info logUp(String id, String password, String invitationID)
			throws RemoteException {
		if (accounts.containsKey(id)) {
			return R.info.ALREADY_EXISTED;
		} else if (!invitationIDs.contains(invitationID)) {
			return R.info.NOT_EXISTED;
		}
		Account newAccount = new Account(id);
		accounts.put(id, newAccount);
		passwords.put(id, password);
		this.dispatchAccount(newAccount);
		return R.info.SUCCESS;
	}

	@Override
	public info loginByTransientID(String id, String transientID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public info checkLink() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	private void dispatchAccount(Account account) {
		try {
			AccountServer as = new AccountServer();
			as.account = account;
			Naming.rebind("Account/" + account.getId(), as);
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private void unbindAccount(Account account){
		try {
			Naming.unbind("Account/" + account.getId());
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public info test(String command) {
		
		switch(command){
		case "init":
			accounts.put("Red", new Account("Red"));
			accounts.put("Green", new Account("Green"));
			accounts.put("Blue", new Account("Blue"));
			accounts.put("Yellow", new Account("Yellow"));
			passwords.put("Red", "r1234");
			passwords.put("Green", "g1234");
			passwords.put("Blue", "b1234");
			passwords.put("Yellow", "y1234");
			invitationIDs.add("fffff1");
			invitationIDs.add("fffff2");
			invitationIDs.add("fffff3");
			invitationIDs.add("fffff4");
		case "clean":
			accounts.clear();
			passwords.clear();
			invitationIDs.clear();
		}
		
		return R.info.SUCCESS;
	}

}
