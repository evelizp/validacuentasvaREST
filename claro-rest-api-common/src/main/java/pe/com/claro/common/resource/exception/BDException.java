
package pe.com.claro.common.resource.exception;

public class BDException extends ComunesExceptionBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7482288873992395827L;

	public BDException(int code, String msg) {
		super(code, msg);

	}

	public BDException(int status, int code, String msg, String developerMessage) {
		super(status, code, msg, developerMessage);

	}

	public BDException(int code, String msg, String developerMessage) {
		super(code, msg, developerMessage);

	}

}
