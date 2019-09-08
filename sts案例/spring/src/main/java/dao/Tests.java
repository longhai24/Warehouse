package dao;

public class Tests implements ITest{

	private TestDao t;
	@Override
	public void add() {
		// TODO Auto-generated method stub
		t.add();
	}

	@Override
	public void del() {
		// TODO Auto-generated method stub
		t.del();
	}

	public TestDao getT() {
		return t;
	}

	public void setT(TestDao t) {
		this.t = t;
	}

}
