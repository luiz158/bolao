package bolao.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Bolao implements Serializable{
	
	private static final long serialVersionUID = 7550853307233198965L;

	@Id
	@GeneratedValue
	@Column(name="cod_bolao")
	private Integer bolao;
	
	private String nome;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="cod_usuario")
	private Usuario presidente;
	
	@Column(name="data_criacao")
	private Date dataCriacao;
	
	@OneToMany(mappedBy="usuario")
	private List<Usuario> apostadores;

	public Integer getBolao() {
		return bolao;
	}

	public void setBolao(Integer bolao) {
		this.bolao = bolao;
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

	public Usuario getPresidente() {
		return presidente;
	}

	public void setPresidente(Usuario presidente) {
		this.presidente = presidente;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<Usuario> getApostadores() {
		return apostadores;
	}

	public void setApostadores(List<Usuario> apostadores) {
		this.apostadores = apostadores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apostadores == null) ? 0 : apostadores.hashCode());
		result = prime * result + ((bolao == null) ? 0 : bolao.hashCode());
		result = prime * result
				+ ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((presidente == null) ? 0 : presidente.hashCode());
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
		Bolao other = (Bolao) obj;
		if (apostadores == null) {
			if (other.apostadores != null)
				return false;
		} else if (!apostadores.equals(other.apostadores))
			return false;
		if (bolao == null) {
			if (other.bolao != null)
				return false;
		} else if (!bolao.equals(other.bolao))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (presidente == null) {
			if (other.presidente != null)
				return false;
		} else if (!presidente.equals(other.presidente))
			return false;
		return true;
	}
	
}