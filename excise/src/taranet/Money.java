package taranet;

public abstract  class Money {
	protected static final String ZHI_MONEY="纸币";
	protected static final String JIN_MONEY="金币";
	protected static final String YIN_MONEY="银币";
	
	public void show(){
		System.out.println(JIN_MONEY);
		System.out.println(ZHI_MONEY);
		System.out.println(YIN_MONEY);
	}
	public abstract String getType();
	public abstract int getNumber();
}
