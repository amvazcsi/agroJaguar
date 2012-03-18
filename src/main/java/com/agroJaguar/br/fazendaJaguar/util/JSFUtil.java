package com.agroJaguar.br.fazendaJaguar.util;

import java.util.List;
import java.util.Map;

import javax.el.MethodExpression;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe utilitária para utilização de JSF.
 */
public class JSFUtil {

	/**
	 * @param clientIdComponente Identificador do componente a ser recuperado.
	 * @return O componente com o id passada por parâmetro.
	 */
	public static UIComponent getComponente(String clientIdComponente) {
		return FacesContext.getCurrentInstance().getViewRoot().findComponent(clientIdComponente);
	}

	/**
	 * @param clientIdComponente Identificador do compomente a ser recuperado o label.
	 * @return Retorna o label associado a um componente, ou <code>null</code> se não for
	 * encontrado um label (outputLabel) para o componente.
	 */
	public static String getLabelComponente(String clientIdComponente) {
		
		UIViewRoot uiViewRoot = FacesContext.getCurrentInstance().getViewRoot();
		
		String[] split = clientIdComponente.split(":");
		
		//String idFormulario = split[0];
		String idComponente = split[1];

		// recupera o componente
		UIComponent uiComponent = uiViewRoot.findComponent(clientIdComponente);
		
		// recupera os componentes que estão no mesmo nivel (na árvore) do componente que está sendo procurado o label
		List<UIComponent> lsUIComponent = uiComponent.getParent().getChildren();
		
		// percorre os componentes procurando o label do componente
		for (UIComponent uiComponentFilhos : lsUIComponent) {
			if (uiComponentFilhos instanceof HtmlOutputLabel) {
				HtmlOutputLabel htmlOutputLabel = (HtmlOutputLabel) uiComponentFilhos;
				if (idComponente.equals(htmlOutputLabel.getFor())) {
					return htmlOutputLabel.getValue() != null ? htmlOutputLabel.getValue().toString() : null;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * @return {@link HttpServletRequest} Requisição em execução.
	 */
	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * @return {@link HttpServletResponse} Resposta em execução.
	 */
	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}
	
	/**
	 * @return {@link HttpSession} Sessão do usuário.
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}
	
	/**
	 * @return {@link ServletContext} Contexto da aplicação.
	 */
	public static ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	}
	
	/**
	 * @return O valor associado ao parametro em {@link HttpServletRequest}.
	 */
	public static String getParameter(String parametro) {
		
		Map<String, String> params = FacesContext.getCurrentInstance()
			.getExternalContext().getRequestParameterMap();
		
		return params.get(parametro);
	}
	
	/**
	 * @param chave Atributo do request.
	 * @return O valor associado ao atributo em {@link HttpServletRequest}.
	 */
	public static Object getRequestAttribute(String chave) {
		return ((HttpServletRequest) JSFUtil.getRequest()).getAttribute(chave);
	}
	
	/**
	 * @param chave nome do atributo a ser inserido no request.
	 * @param valor objeto a ser inserido no request.
	 * @return O valor associado ao atributo em {@link HttpServletRequest}.
	 */
	public static void setRequestAttribute(String chave, Object valor) {
		((HttpServletRequest) JSFUtil.getRequest()).setAttribute(chave, valor);
	}
	
	/**
	 * Retorna Managed Bean do {@link FacesContext}.
	 * 
	 * @param nomeManagedBean Nome do Managed Bean assim como aparece no arquivo faces-config.xml.
	 * @param clazz Classe do Managed Bean.
	 * @return O Managed Bean do {@link FacesContext}.
	 */
	public static <T> T getManagedBean(String nomeManagedBean, Class<T> classe){
		
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application application = facesContext.getApplication();
        
        return (T)application.evaluateExpressionGet(facesContext, "#{" + nomeManagedBean + "}", classe);
    }
	
	/**
	 * Cria uma {@link String} representando a method expression. 
	 * @param nomeManagedBean Nome do Managed Bean.
	 * @param nomeMetodo Nome do método.
	 * @return String representando a method expression.
	 */
	public static String getMethodExpression(String nomeManagedBean, String nomeMetodo) {
		return "#{" + nomeManagedBean + "." + nomeMetodo + "}";
	}
	
	/**
	 * Cria uma {@link MethodExpression}. 
	 * @param nomeManagedBean Nome do Managed Bean.
	 * @param nomeMetodo Nome do método.
	 * @return A {@link MethodExpression}.
	 */
	public static MethodExpression criarMethodExpression(String nomeManagedBean, String nomeMetodo) {
		
		String methodExpression = getMethodExpression(nomeManagedBean, nomeMetodo);
		
		return criarMethodExpression(methodExpression);
	}
	
	/**
	 * Cria uma {@link MethodExpression}. 
	 * @param methodExpression A representação em {@link String} da {@link MethodExpression}.
	 * @return A {@link MethodExpression}.
	 */
	public static MethodExpression criarMethodExpression(String methodExpression) {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		return facesContext.getApplication().getExpressionFactory().createMethodExpression(
				facesContext.getELContext(), methodExpression, String.class, new Class[0]);
		
	}
	
	/**
	 * Executa uma {@link MethodExpression}. 
	 * @param nomeManagedBean Nome do Managed Bean.
	 * @param nomeMetodo Nome do método.
	 * @return O retorno da execução da {@link MethodExpression}.
	 */
	public static Object executarMethodExpression(String nomeManagedBean, String nomeMetodo) {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		MethodExpression methodExpression = criarMethodExpression(nomeManagedBean, nomeMetodo);
		
		return methodExpression.invoke(facesContext.getELContext(), null);
	}
	
	/**
	 * @param htmlSelectOneMenu
	 * @return Retorna o label do item selecionado no combobox.
	 */
	@SuppressWarnings("unchecked")
	public static Object getLabelItemSelect(HtmlSelectOneMenu htmlSelectOneMenu) {
		
		if (htmlSelectOneMenu.getValue() != null) {
		
			Object valor = htmlSelectOneMenu.getValue();
			
			List<UIComponent> lsUIComponent = htmlSelectOneMenu.getChildren();
			
			for (UIComponent component : lsUIComponent) {
				if (component instanceof UISelectItems) {
					UISelectItems uiSelectItems = (UISelectItems) component;
					
					List<SelectItem> lsSelectItem = (List<SelectItem>) uiSelectItems.getValue();
					
					for (SelectItem selectItem : lsSelectItem) {
						if (selectItem.getValue() != null && selectItem.getValue().equals(valor)) {
							return selectItem.getLabel();
						}
					}
				}
			}
			
		}	
		
		return null;
	}
	
}
