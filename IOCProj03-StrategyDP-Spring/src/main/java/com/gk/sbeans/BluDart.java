package com.gk.sbeans;

import org.springframework.stereotype.Component;

@Component("bDart")
public class BluDart implements Courier {

	@Override
	public String deliver(int oid) {
		
		return oid+" order items are kept for delivery by BlueDart";
	}

}
