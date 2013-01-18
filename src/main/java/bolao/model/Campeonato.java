package bolao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="campeonato")
public class Campeonato implements Serializable{
	
	private static final long serialVersionUID = 7841428922800516409L;

	@Id
	@GeneratedValue
	@Column(name="cod_campeonato")
	private Integer campeonato;
	
	@Column(nullable = false, unique = true)
	@NotNull(message = "O nome do campeonato deve ser preenhido")
	private String nome;
	
	
	private Integer ano;
	
	private String descricao;
	
	@OneToMany(mappedBy="campeonato")
	private Set<Jogo> jogos = new HashSet<Jogo>();

	public Integer getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Integer campeonato) {
		this.campeonato = campeonato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(Set<Jogo> jogos) {
		this.jogos = jogos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((campeonato == null) ? 0 : campeonato.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((jogos == null) ? 0 : jogos.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		if (campeonato == null) {
			if (other.campeonato != null)
				return false;
		} else if (!campeonato.equals(other.campeonato))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (jogos == null) {
			if (other.jogos != null)
				return false;
		} else if (!jogos.equals(other.jogos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
