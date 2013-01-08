package bolao.controller;

import java.awt.List;
import java.util.HashSet;

import org.hibernate.Session;

import bolao.model.Usuario;
import bolao.util.HibernateUtil;

public class TesteUsuario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		Session sessao = null;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println("COnectou");
		}finally{
			sessao.close();
		}*/
		
		Usuario usuario  = new Usuario();
		
		usuario.setCodigo(0);
		usuario.setAtivo(true);
		usuario.setEmail("fred.jampa@gmail.com");
		usuario.setLogin("fred_trovao");
		usuario.setNome("Fred");
		usuario.setSenha("12345");
		
		UsuarioController usuarioController = new UsuarioController();
		usuarioController.salvar(usuario);
		
		System.out.println("Usuario Salvo");
	}
	
}
