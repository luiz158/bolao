package bolao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Jogos implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="cod_jogo")
	private Integer jogo;
	
	private 
	
}
