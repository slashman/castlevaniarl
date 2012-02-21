package sz.util;

public class OutParameter {
	private Object object;
	private int intValue;
	public void setObject(Object what){
		object = what;
	}
	
	public Object getObject(){
		return object;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
}
