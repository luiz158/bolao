package bolao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Campeonato implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="cod_campeonato")
	private Integer campeonato;
	
	private String nome;
	private String descricao;
}
