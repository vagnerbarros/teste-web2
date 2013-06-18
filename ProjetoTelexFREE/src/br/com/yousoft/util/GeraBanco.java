package br.com.yousoft.util;

import javax.swing.JOptionPane;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.yousoft.dominio.Perfil;
import br.com.yousoft.dominio.Situacao;
import br.com.yousoft.entidades.Usuario;
import br.com.yousoft.fachada.Fachada;

public class GeraBanco {
    public static void main (String [] args){
    	try {
    		Configuration cfg = new Configuration();
            cfg.configure();
            SchemaExport se = new SchemaExport(cfg);
            se.create(true, true);
            
            Usuario u = new Usuario();
            u.setNome("YouSoft");
            u.setLogin("1");
            u.setSenha("1");
            
            Fachada f = Fachada.getInstance();
            f.cadastroUsuario().cadastrarAdmin(u);
            
            JOptionPane.showMessageDialog(null, "O Banco de Dados foi gerado com sucesso!",
            		"Fafica .:. Alerta",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.out.println(e);
            JOptionPane.showMessageDialog(null, "Erro ao Gerar a Base de Dados!",
            	"Fafica .:. Alerta",JOptionPane.ERROR_MESSAGE);
		}
    }
}