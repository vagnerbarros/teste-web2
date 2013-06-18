package br.com.yousoft.cadastro;

import java.util.List;

import br.com.yousoft.dao.UsuarioDAO;
import br.com.yousoft.dominio.Perfil;
import br.com.yousoft.dominio.Situacao;
import br.com.yousoft.entidades.Usuario;
import br.com.yousoft.exceptions.AtualizacaoException;
import br.com.yousoft.exceptions.CadastroException;
import br.com.yousoft.exceptions.RemocaoException;
import br.com.yousoft.util.Constantes;
import br.com.yousoft.util.Criptografia;

public class CadastroUsuario {

	private UsuarioDAO dao;
	
	public CadastroUsuario(UsuarioDAO dao){
		this.dao = dao;
	}
	
	public void cadastrarAdmin(Usuario usuario) throws CadastroException{
        usuario.setPerfil(Perfil.ADMIN);
		cadastrar(usuario);
	}
	
	public void cadastrarCliente(Usuario usuario) throws CadastroException {
		usuario.setPerfil(Perfil.CLIENTE);
		cadastrar(usuario);
	}
	
	//método auxiliar que é utilizado por cadastrarCliente e cadastrarAdmin
	private void cadastrar(Usuario usuario) throws CadastroException{
		
		usuario.setStatus(Constantes.ATIVO);
		String senhaCriptografada = Criptografia.encryptPassword(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		usuario.setSituacao(Situacao.PAGAMENTO_OK);
		boolean ok = dao.salvarObjeto(usuario);
		if(!ok){
			throw new CadastroException("Erro ao tentar cadastrar usuário");
		}
	}
	
	public Usuario buscarId(Long id){
		return dao.buscarPorId(id);
	}
	
	public void atualizar(Usuario usuario) throws AtualizacaoException{
		boolean ok = dao.atualizarObjeto(usuario);
		if(!ok){
			throw new AtualizacaoException("Erro ao tentar atualizar usuário");
		}
	}
	
	public void remover(Usuario usuario) throws RemocaoException{
		boolean ok = dao.deletarObjeto(usuario);
		if(!ok){
			throw new RemocaoException("Erro ao tentar remover usuário");
		}
	}
	
	public List<Usuario> listar(){
		return dao.listarObjetos();
	}
	
	public Usuario logar(String login, String senha){
		String senhaCriptografada = Criptografia.encryptPassword(senha);
		return dao.logar(login, senhaCriptografada);
	}
}
