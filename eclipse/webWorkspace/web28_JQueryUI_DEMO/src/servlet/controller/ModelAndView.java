/*
 * 결과페이지 이름과 
 * 이동방식(forward | redirect)에 대한 정보를 담고 있는 객체
 * ModelAndView
 */
package servlet.controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect;//
	
	public ModelAndView(String path, boolean isRedirect) {		
		this.path = path;
		this.isRedirect = isRedirect;
	}
	public ModelAndView() {	}
	
	public ModelAndView(String path) {		
		this.path = path;		
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}	
}













