package com.tioba.printerbackend.entities.enums;


public enum StatusMaintenance {
	
	OPEN (1,"Aberta"),
	COMPLETED(2,"Concluída"),
	REPROVED(3,"Reprovada");
	
	private Integer code;
	private String codeName;
	
	private StatusMaintenance(Integer code, String codeName) {
		
		this.code = code;
		this.codeName = codeName;
	}

	public Integer getCode() {
		return code;
	}
	
	public String getCodeName() {
		return codeName;
	}
	
	public static StatusMaintenance toEnum(Integer code) {
		
		if(code == null) {
			return null;
		}
		for(StatusMaintenance x : StatusMaintenance.values()){
			if(code.equals(x.getCode())){
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid code: " + code);
	}
}
