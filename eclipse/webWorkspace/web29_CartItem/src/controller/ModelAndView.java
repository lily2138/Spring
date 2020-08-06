/*
 * 결과페이지 이름과
 * 이동방식(forwqrd | redirect)에 대한 정보를 담고있는 객체
 * ModelAndView 
 */

package controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect;	//null
	
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	
	public ModelAndView() {
		
	}
	
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

	@Override
	public String toString() {
		return "ModelAndView [path=" + path + ", isRedirect=" + isRedirect + "]";
	}
	
	
	
}
