package com.management.project_managment.dto;

import com.management.project_managment.services.validation.UserInsertValid;

@UserInsertValid
public class UserInsertDTO extends UserDTO {
	private static final long serialVersionUID = 1L;

	private String password;

	UserInsertDTO() {
		super();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}


/*    
Classe que estende a superclasse UserDTO, para inserir o password, foi criada justamente por conta do password 
atributo que não sera trafegado no UserDTO. 
*/