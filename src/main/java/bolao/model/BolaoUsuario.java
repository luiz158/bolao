/*package bolao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bolao_usuario")
public class BolaoUsuario implements Serializable{
	
	private static final long serialVersionUID = -8042523162137843250L;

	@Id
	@GeneratedValue
	private Integer cod_bolao_usuario;
	
	@ManyToOne
	@JoinColumn(name="cod_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="cod_bolao")
	private Bolao bolao;
	
	private Integer pontuacaoTotal;
	
	@OneToMany(mappedBy="bolaoUsuario")
	private Set<Aposta> apostas = new HashSet<Aposta>();

	public Integer getCod_bolao_usuario() {
		return cod_bolao_usuario;
	}

	public void setCod_bolao_usuario(Integer cod_bolao_usuario) {
		this.cod_bolao_usuario = cod_bolao_usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Bolao getBolao() {
		return bolao;
	}

	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}

	public Integer getPontuacaoTotal() {
		return pontuacaoTotal;
	}

	public void setPontuacaoTotal(Integer pontuacaoTotal) {
		this.pontuacaoTotal = pontuacaoTotal;
	}

	public Set<Aposta> getApostas() {
		return apostas;
	}

	public void setApostas(Set<Aposta> apostas) {
		this.apostas = apostas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apostas == null) ? 0 : apostas.hashCode());
		result = prime * result + ((bolao == null) ? 0 : bolao.hashCode());
		result = prime
				* result
				+ ((cod_bolao_usuario == null) ? 0 : cod_bolao_usuario
						.hashCode());
		result = prime * result
				+ ((pontuacaoTotal == null) ? 0 : pontuacaoTotal.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		BolaoUsuario other = (BolaoUsuario) obj;
		if (apostas == null) {
			if (other.apostas != null)
				return false;
		} else if (!apostas.equals(other.apostas))
			return false;
		if (bolao == null) {
			if (other.bolao != null)
				return false;
		} else if (!bolao.equals(other.bolao))
			return false;
		if (cod_bolao_usuario == null) {
			if (other.cod_bolao_usuario != null)
				return false;
		} else if (!cod_bolao_usuario.equals(other.cod_bolao_usuario))
			return false;
		if (pontuacaoTotal == null) {
			if (other.pontuacaoTotal != null)
				return false;
		} else if (!pontuacaoTotal.equals(other.pontuacaoTotal))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}*/