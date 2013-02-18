package bolao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.IndexColumn;

import com.sun.xml.bind.CycleRecoverable;

@Entity
@XmlRootElement
@Table(name="jogo")
public class Jogo implements Serializable, CycleRecoverable{
	
	private static final long serialVersionUID = -1796023317406016L;

	@Id
	@GeneratedValue
	@Column(name="cod_jogo")
	private Integer jogo;
	
	@OneToOne
	@JoinColumn(name = "cod_clube_casa", nullable = false)
	@NotNull(message = "O clube que joga em casa deve ser preenchido.")
	private Clube clubeCasa;
	
	@OneToOne
	@JoinColumn(name = "cod_clube_visitante", nullable = false)
	@NotNull(message = "O clube visitante deve ser preenchido.")
	private Clube clubeVisitante;
	
	private Integer placarCasa;
	private Integer placarVisitante;
	
	@Column(nullable = false)
	@NotNull(message = "O número da rodada deve ser informado.")
	@DecimalMin(value = "1", message = "Valor inválido para rodada, valor mínimo é 1")	
	private Integer numeroRodada;
	
	@ManyToOne
	@JoinColumn(name="cod_campeonato", nullable = false)
	@NotNull(message = "Um jogo precisa ser associado a um campeonato.")
	private Campeonato campeonato;
	
	@OneToMany(mappedBy="jogo", fetch = FetchType.EAGER)
	@IndexColumn(name="cod_aposta")
	private List<Aposta> apostas = new ArrayList<Aposta>();
	
	public Integer getJogo() {
		return jogo;
	}

	public void setJogo(Integer jogo) {
		this.jogo = jogo;
	}

	public Clube getClubeCasa() {
		return clubeCasa;
	}

	public void setClubeCasa(Clube clubeCasa) {
		this.clubeCasa = clubeCasa;
	}

	public Clube getClubeVisitante() {
		return clubeVisitante;
	}

	public void setClubeVisitante(Clube clubeVisitante) {
		this.clubeVisitante = clubeVisitante;
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

	public Integer getNumeroRodada() {
		return numeroRodada;
	}

	public void setNumeroRodada(Integer numeroRodada) {
		this.numeroRodada = numeroRodada;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((campeonato == null) ? 0 : campeonato.hashCode());
		result = prime * result
				+ ((clubeCasa == null) ? 0 : clubeCasa.hashCode());
		result = prime * result
				+ ((clubeVisitante == null) ? 0 : clubeVisitante.hashCode());
		result = prime * result + ((jogo == null) ? 0 : jogo.hashCode());
		result = prime * result
				+ ((numeroRodada == null) ? 0 : numeroRodada.hashCode());
		result = prime * result
				+ ((placarCasa == null) ? 0 : placarCasa.hashCode());
		result = prime * result
				+ ((placarVisitante == null) ? 0 : placarVisitante.hashCode());
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
		Jogo other = (Jogo) obj;
		if (campeonato == null) {
			if (other.campeonato != null)
				return false;
		} else if (!campeonato.equals(other.campeonato))
			return false;
		if (clubeCasa == null) {
			if (other.clubeCasa != null)
				return false;
		} else if (!clubeCasa.equals(other.clubeCasa))
			return false;
		if (clubeVisitante == null) {
			if (other.clubeVisitante != null)
				return false;
		} else if (!clubeVisitante.equals(other.clubeVisitante))
			return false;
		if (jogo == null) {
			if (other.jogo != null)
				return false;
		} else if (!jogo.equals(other.jogo))
			return false;
		if (numeroRodada == null) {
			if (other.numeroRodada != null)
				return false;
		} else if (!numeroRodada.equals(other.numeroRodada))
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
		return true;
	}
	
	@Override
	//Para resolver problema de referencia ciclica
	public Object onCycleDetected(Context ctx) {
		Jogo jogo = new Jogo();
		jogo.setJogo(this.jogo);
		return jogo;
	}

	public List<Aposta> getApostas() {
		return apostas;
	}

	public void setApostas(List<Aposta> apostas) {
		this.apostas = apostas;
	}
}