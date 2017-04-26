package Day17;

public class Person implements Comparable<Person>{
	private String name;
	private int age;
	//空参构造   alt+shift+s+c
	public Person() {
		super();
		}
	//有参构造  alt+shift+s+o
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		
	}
	//set ，get方法  alt+shift+s+r
	public String getName() {
		return name;
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
	@Override
	//重写toString方法   alt+shift+s+s
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	//重写Equals方法和hashcode方法 alt+shif+s+h
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
//	@Override
//	public int compareTo(Person o) {
//		int Lenght=this.name.length()-o.name.length();
//		int num=Lenght==0?this.name.compareTo(o.name):Lenght;
//		return num;
//	}
	@Override
	public int compareTo(Person o) {
		int num=this.age-o.age;
		return num==0?this.name.compareTo(o.name):num;
	}

	
}
