package br.com.webwork.springdataredis.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponse implements Serializable{

	private static final long serialVersionUID = 1325105195120633054L;
	
	private Long id;
	private String name;

}
