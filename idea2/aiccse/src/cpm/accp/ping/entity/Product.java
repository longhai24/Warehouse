package cpm.accp.ping.entity;

public class Product {
	private String pid;
	private String pname;
	private String ptype;
	private float pprice;
	private String pimg;
	private String pflag;
	private String description;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public float getPprice() {
		return pprice;
	}
	public void setPprice(float pprice) {
		this.pprice = pprice;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getPflag() {
		return pflag;
	}
	public void setPflag(String pflag) {
		this.pflag = pflag;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Product(String pid, String pname, String ptype, float pprice, String pimg, String pflag,
			String description) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.ptype = ptype;
		this.pprice = pprice;
		this.pimg = pimg;
		this.pflag = pflag;
		this.description = description;
	}
	public Product() {
		super();
	}
	public Product(String pname, String ptype, float pprice, String pimg, String pflag, String description) {
		super();
		this.pname = pname;
		this.ptype = ptype;
		this.pprice = pprice;
		this.pimg = pimg;
		this.pflag = pflag;
		this.description = description;
	}
	
}
