package dhome.rpc.java.impl;

import java.util.Date;

import dhome.rpc.spi.RpcInterface;

public class RpcImpl implements RpcInterface {

	public RpcImpl() {
		System.out.println("RpcImpl Constructor....");
	}
	
	@Override
	public String getName() {
		return (new Date()).toString();
	}

}
