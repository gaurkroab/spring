package com.gk.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("pinfo")
@PropertySource("com/gk/commons/info.properties")
public class PersonInfo {
	
	@Value("${per.name}")
	private String pname;
	@Value("${per.addrs}")
	private String paddrs;
	@Value("${per.age}")
	private int page;
	
	@Value("${os.name}")
	private String osName;
	@Value("${user.name}")
	private String uname;
	@Value("${Path}")
	private String pathData;
	
	
	@Override
	public String toString() {
		return "PersonInfo [pname=" + pname + ", paddrs=" + paddrs + ", page=" + page + ", osName=" + osName
				+ ", uname=" + uname + ", pathData=" + pathData + "]";
	}
	
	
}
