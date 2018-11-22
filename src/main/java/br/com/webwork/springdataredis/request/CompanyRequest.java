package br.com.webwork.springdataredis.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest implements Serializable{

	private static final long serialVersionUID = -216746320315201855L;
	
	private Long id;
	private String name;

}
