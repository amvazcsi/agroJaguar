package com.agroJaguar.br.fazendaJaguar.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JSFMensagem {

	private static ResourceBundle resourceBundle = getResourceBundle();
	
	/**
	 * @return O {@link ResourceBundle} padrão da aplicação.
	 */
	private static ResourceBundle getResourceBundle() {
		return getResourceBundle("mensagens");
	}

	/**
	 * @param nome Nome do ResourceBundle.
	 * @return O {@link ResourceBundle} com o nome passado como parâmetro.
	 */
	private static ResourceBundle getResourceBundle(String nome) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Application application = facesContext.getApplication();
		
		return application.getResourceBundle(facesContext, nome);
	}

	/**
	 * Retorna a mensagem do resource bundle associado a chave.
	 * @param codigoMensagem
	 * @return A mensagem do resource bundle.
	 */
	public static String getMensagemAplicacao(String codigoMensagem) {
		return resourceBundle.getString(codigoMensagem);
	}
	
	/**
	 * Retorna a mensagem do resource bundle associado a chave setando seus parâmetros.
	 * @param codigoMensagem
	 * @param paramentrosMensagem
	 * @return
	 */
	public static String getMensagemAplicacaoFormatada(String codigoMensagem, Object... paramentrosMensagem) {
		
		String mensagem = getMensagemAplicacao(codigoMensagem);
		
		return formatarMensagem(mensagem, paramentrosMensagem);
	}

	/**
	 * Formata uma mensagem subistituindo seus parâmetros.
	 * 
	 * @param mensagem A mensagem.
	 * @param parametrosMensagem Os parâmetros da mensagem.
	 * @return A mensagem formatada com os parâmentros.
	 */
	public static String formatarMensagem(String mensagem, Object... parametrosMensagem) {

		if (parametrosMensagem != null) {
			Application application = FacesContext.getCurrentInstance().getApplication();
			MessageFormat messageFormat = new MessageFormat(mensagem, application.getDefaultLocale());
			mensagem = messageFormat.format(parametrosMensagem);
		}

		return mensagem;
	}

	/**
	 * Cria uma mensagem e coloca no {@link FacesContext}.
	 * 
	 * @param severity Severidade da mensagem. {@link Severity}
	 * @param mensagem Texto da mensagem ser criada.
     * @param parametrosMensagem Parametros para montar a mensagem.
	 */
	private static void addMenssagem(Severity severity, String codigoMensagem, Object... parametrosMensagem) {
		
		String mensagem = getMensagemAplicacaoFormatada(codigoMensagem, parametrosMensagem);
		
		FacesMessage facesMessage = new FacesMessage(severity, mensagem, null);

		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}
	
	/**
	 * Cria uma mensagem de informação e coloca no {@link FacesContext}.
	 * 
	 * @param codigoMensagem Texto da mensagem ser criada.
	 * @param parametrosMensagem Parametros para montar a mensagem.
	 */
	public static void addMenssagemInfo(String codigoMensagem, Object... parametrosMensagem) {
		addMenssagem(FacesMessage.SEVERITY_INFO, codigoMensagem, parametrosMensagem);
	}
	
	/**
	 * Cria uma mensagem de erro e coloca no {@link FacesContext}.
	 * 
	 * @param codigoMensagem Texto da mensagem ser criada.
     * @param parametrosMensagem Parametros para montar a mensagem.
	 */
	public static void addMenssagemErro(String codigoMensagem, Object... parametrosMensagem) {
		addMenssagem(FacesMessage.SEVERITY_ERROR, codigoMensagem, parametrosMensagem);
	}
	
	/**
	 * Cria uma mensagem de aviso e coloca no {@link FacesContext}.
	 * 
	 * @param codigoMensagem Texto da mensagem ser criada.
     * @param parametrosMensagem Parametros para montar a mensagem.
	 */
	public static void addMenssagemAviso(String codigoMensagem, Object... parametrosMensagem) {
		addMenssagem(FacesMessage.SEVERITY_WARN, codigoMensagem, parametrosMensagem);
	}

}
