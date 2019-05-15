package model;

import javax.persistence.*;

/**
 * Classe de contato
 * @author lucas
 * @see javax.persistence
 * @since 1.0
 */
@Entity
@Table(name = "contato")
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column
	private int id;

	@Column
	private String nome;

	@Column
	private String sobrenome;

	@Column
	private String telefone;

	@Column
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}