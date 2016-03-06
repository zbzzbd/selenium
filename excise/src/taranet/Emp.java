package taranet;

public class Emp extends Page {
	public String[] emps = {"1","2","3"};
	@Override
	public String[] getData(){
		return emps;
	}
}
