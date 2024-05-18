package com.tioba.printerbackend.entities.enums;


public enum StatusPrinter {
	
	ACTIVE (1,"Ativa"),
	INACTIVE(2,"Inativa");
	
	private Integer code;
	private String codeName;
	
	private StatusPrinter(Integer code, String codeName) {
		
		this.code = code;
		this.codeName = codeName;
	}

	public Integer getCode() {
		return code;
	}
	
	public String getCodeName() {
		return codeName;
	}
	
	public static StatusPrinter toEnum(Integer code) {
		
		if(code == null) {
			return null;
		}
		for(StatusPrinter x : StatusPrinter.values()){
			if(code.equals(x.getCode())){
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid code: " + code);
	}
}
