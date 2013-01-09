package bolao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NaturalId;

@Entity
@XmlRootElement
public class Usuario implements Serializable, BoleiroListener{

	private static final long serialVersionUID = 3026097908340994246L;
	@Id
	@GeneratedValue
	@Column(name="cod_usuario")
	private Integer usuario;
	private String nome;
	private String email;
	
	@NaturalId
	private String login;
	private String senha;
	private boolean ativo;
	
	private Long pontuacaoTotal;
	
	@ElementCollection(targetClass = String.class)
	@JoinTable(
			name = "Usuario_permissao",
			uniqueConstraints ={@UniqueConstraint(columnNames = {"usuario","permissao"})},
			joinColumns = @JoinColumn(name = "usuario"))
	@Column(name = "permissao", length=50)
	private Set<String> permissao = new HashSet<String>();

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer codigo) {
		this.usuario = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result
				+ ((pontuacaoTotal == null) ? 0 : pontuacaoTotal.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		if (pontuacaoTotal == null) {
			if (other.pontuacaoTotal != null)
				return false;
		} else if (!pontuacaoTotal.equals(other.pontuacaoTotal))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public void atualizarPontuacao() {
		// TODO Auto-generated method stub
		
	}

	public Long getPontuacaoTotal() {
		return pontuacaoTotal;
	}
}
