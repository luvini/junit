package control;

import java.util.List;

import javax.faces.bean.ManagedBean;
import model.*;

/**
 * A classe ContatoMB é a Managed Bean dos Contatos
 * @author lucas
 * @see javax.faces.bean
 * @since 1.0
 */
@ManagedBean
public class ContatoMB {

	public ContatoMB() {
	}

	private Contato c = new Contato();

	public String getId() {
		return String.valueOf(c.getId());
	}
	
	public void setId(String id) {
		c.setId(Integer.parseInt(id));
	}

	public String getNome() {
		return c.getNome();
	}

	public void setNome(String nome) {
		c.setNome(nome);
	}

	public String getSobrenome() {
		return c.getSobrenome();
	}

	public void setSobrenome(String sobrenome) {
		c.setSobrenome(sobrenome);
	}

	public String gettelefone() {
		return c.getTelefone();
	}

	public void settelefone(String telefone) {
		c.setTelefone(telefone);
	}

	public String getEmail() {
		return c.getEmail();
	}

	public void setemail(String email) {
		c.setEmail(email);
	}

	/**
	 * Salva o objeto de Contato do formulário, no banco.
	 */
	public void salvar() {
		try {
			CRUD.inserir(c);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Lista todos os contatos do banco
	 * @return retorna uma lista de contatos List Contato
	 */
	public List<Contato> ler() {
		return CRUD.ler();
	}
	
	/**
	 * Atualiza um contato no banco
	 * @param id id do contato a ser atualizado
	 */
	public void atualizar(int id) {
		//System.out.println(id);
		CRUD.atualizar(id, c.getNome(), c.getSobrenome(), c.getTelefone(), c.getEmail());
	}
	
	/**
	 * Remove um contato do banco
	 * @param id id do contato a ser removido
	 */
	public void remover(int id) {
		CRUD.remover(id);
	}
}
