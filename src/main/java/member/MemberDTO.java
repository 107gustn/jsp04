package member;

//DTO(=VO): DB를 나르기 위한 용도(DB 형식에 맞춰서 사용)
public class MemberDTO { 
	private String id;
	private String name;
	private int age;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
}
