package com.agroJaguar.br.fazendaJaguar.persistencia;

import com.agroJaguar.br.fazendaJaguar.persistencia.bean.UsuarioBean;

/**
 * Factory dos objetos disponibilizados pelo submódulo util. Os métodos NÃO devem
 * ser implementados como SINGLETON, exceto se especificado ao contrário.
 */
public class JaguarFacade {

	private static JaguarFacade processamento = new JaguarFacade();
	
    //~ Construtores ---------------------------------------------------------------------------------------------------

    private JaguarFacade(){}
    

    //~ Metodos --------------------------------------------------------------------------------------------------------

    public static JaguarFacade getInstancia() {
        return processamento;
    }
    
	/**
	 * Obtem uma lista de Higroscopia 
	 * @return
	 * @throws Exception
	 */
	public static UsuarioBean obterUsuario(UsuarioBean usuarioBean) throws Exception{
		
		UsuarioBean usuario = new UsuarioBean();
		usuario.setCodUsuario(1);
		usuario.setDscLogin("Jaguar");
		usuario.setIndAtivo(true);
        /*StringBuffer sql = new StringBuffer();
        sql.append("SELECT u " +
        		   "  FROM UsuarioBean u " +
        		   "  WHERE u.dscLogin='" + usuarioBean.getDscLogin() +"'"+
        		   "    AND u.dscSenha='" + usuarioBean.getDscSenha() +"'");
        (UsuarioBean) new DAOTransation().obterObjeto(sql.toString(),UsuarioBean.class);*/
        
		return usuario;
    }
} // Fim da Classe.