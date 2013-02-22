package bolao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@XmlRootElement
@Table(name="aposta")
public class Aposta implements Serializable{
	
	private static final long serialVersionUID = 6310106160316720195L;

	@Id
	@GeneratedValue
	@Column(name="cod_aposta")
	private Integer aposta;
	
	@ManyToOne
	@JoinColumn(name="cod_jogo", nullable = false)
	private Jogo jogo;
	
	private Integer placarCasa;
	private Integer placarVisitante;
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name="cod_usuario", nullable = false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="cod_bolao", nullable= false)
	private Bolao bolao;
	
	private Integer pontuacao;

	public Integer getAposta() {
		return aposta;
	}

	public void setAposta(Integer aposta) {
		this.aposta = aposta;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Integer getPlacarCasa() {
		return placarCasa;
	}

	public void setPlacarCasa(Integer placarCasa) {
		this.placarCasa = placarCasa;
	}

	public Integer getPlacarVisitante() {
		return placarVisitante;
	}

	public void setPlacarVisitante(Integer placarVisitante) {
		this.placarVisitante = placarVisitante;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aposta == null) ? 0 : aposta.hashCode());
		result = prime * result + ((bolao == null) ? 0 : bolao.hashCode());
		result = prime * result + ((jogo == null) ? 0 : jogo.hashCode());
		result = prime * result
				+ ((placarCasa == null) ? 0 : placarCasa.hashCode());
		result = prime * result
				+ ((placarVisitante == null) ? 0 : placarVisitante.hashCode());
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
		Aposta other = (Aposta) obj;
		if (aposta == null) {
			if (other.aposta != null)
				return false;
		} else if (!aposta.equals(other.aposta))
			return false;
		if (bolao == null) {
			if (other.bolao != null)
				return false;
		} else if (!bolao.equals(other.bolao))
			return false;
		if (jogo == null) {
			if (other.jogo != null)
				return false;
		} else if (!jogo.equals(other.jogo))
			return false;
		if (placarCasa == null) {
			if (other.placarCasa != null)
				return false;
		} else if (!placarCasa.equals(other.placarCasa))
			return false;
		if (placarVisitante == null) {
			if (other.placarVisitante != null)
				return false;
		} else if (!placarVisitante.equals(other.placarVisitante))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	public Bolao getBolao() {
		return bolao;
	}

	public void setBolao(Bolao bolao) {
		this.bolao = bolao;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void atualizarPontuacao() {
		//variaveis que armazena placar do time de casa e visitante 
		Integer pc = this.jogo.getPlacarCasa();
		Integer pv = this.jogo.getPlacarVisitante();
		
		//variaveis que armazena apostas do time de casa e visitante 
		Integer ac = this.placarCasa;
		Integer av = this.placarVisitante;
		
		//logica da pontuacao
		if( (pc == null) || (pv == null)){
			this.pontuacao = 0;
		}else if ((ac>av && pc<pv) || (ac<av && pc>pv) || (ac==av && pc!=pv) || (ac!=av && pc==pv)) {
			//Se não houver acerto de nada
			this.pontuacao = 0;
		}else if ((ac>av && pc>pv && ac!=pc && av!=pv) || (ac<av && pc<pv && ac!=pc && av!=pv)) {
			//Se acertar o ganhador do jogo
			this.pontuacao = 2;
		}else if ((ac>av && pc>pv && ac!=pc && av==pv) || (ac<av && pc<pv && ac==pc && av!=pv)) {
			//Se acertar o placar do perdedor do jogo
			this.pontuacao = 4;
		}else if ((ac>av && pc>pv && ac==pc && av!=pv) || (ac<av && pc<pv && ac!=pc && av==pv)) {
			//Se acertar o placar o vencedor do jogo
			this.pontuacao = 6;
		}else if (ac==pc && av==pv) {
			//Se acertar o placar do jogo
			this.pontuacao = 10;
		}else if (ac==av && pc==pv && ac!=pc) {
			//Se acertar que o jogo eh empate, mas com placar diferente
			this.pontuacao = 5;
		}
	}
}