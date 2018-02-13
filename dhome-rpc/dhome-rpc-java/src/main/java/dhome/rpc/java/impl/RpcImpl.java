package dhome.rpc.java.impl;

import dhome.rpc.java.RpcInterface;

public class RpcImpl implements RpcInterface {

	public RpcImpl() {
		System.out.println("RpcImpl Constructor....");
	}
	
	@Override
	public String getName() {
		return "12345678";
	}

}
