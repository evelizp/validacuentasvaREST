package pe.com.claro.common.exception;

public class NoExitoException extends BaseException {

	private static final long serialVersionUID = 1L;

	public NoExitoException(String codError, String msjError) {
		super(codError, msjError);
	}

	public NoExitoException(String msjError, Exception objException) {
		super(msjError, objException);
	}
}