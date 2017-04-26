//类名首字母必须大些
//方法和属性名必须小写
//多个单词组成的类名或方法必须采用驼峰标识
//如： 类名：StudentAdmin   方法和属性： studentName

package StudentTest;
//对象封装
public class Student {
// 创建属性
	private int on;
	private String name;
	private int age;
	private int java;
	private int c_shar;
	private int html;
	private int sum;
	private int sql;
	private int avg;
// 属性封装
	public void setOn(int on){
		this.on=on;
	}
	public int getOn(){
		return this.on;
	}
	public String getName() {
//参数和属性重名时就要用this区分;
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJava() {
		return this.java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getC_shar() {
		return this.c_shar;
	}
	public void setC_shar(int c_shar) {
		this.c_shar = c_shar;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	public int getSum() {
		return sum;
	}
	public void setSum() {
		this.sum = this.html+this.c_shar+this.sql+this.java;
	}
	public int getSql() {
		return sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public int getAvg() {
		return avg;
	}
	public void setAvg() {
		this.avg = this.sum/4;
	}
//输出对象toString 方法
	public String toString(){
//定义 String 类型变量    “/t”换行
		String msg="\t"+this.on+"\t"+this.name+"\t"+this.age+"\t"+this.java+"\t"+this.c_shar+"\t"
	    +this.html+"\t"+this.sql+"\t"+this.sum+"\t"+this.avg;
// 返回变量值		
		return msg;
	}
}
