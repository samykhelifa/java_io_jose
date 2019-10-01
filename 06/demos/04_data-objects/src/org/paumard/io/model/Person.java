package org.paumard.io.model;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = -2807088706568377647L;
	
	private String name;
	private int age;
	
	public Person() {
	}
	
//	private void writeObject(ObjectOutputStream oos) throws Exception {
//		
//		DataOutputStream dos = new DataOutputStream(oos);
//		dos.writeUTF(name + "::" + age);
//	}
	
//	private void readObject(ObjectInputStream ois) throws Exception {
//		
//		DataInputStream dis = new DataInputStream(ois);
//		String content = dis.readUTF();
//		String[] strings = content.split("::");
//		this.name = strings[0];
//		this.age = Integer.parseInt(strings[1]);
//	}
	
	private Object writeReplace() throws ObjectStreamException {
		return new PersonProxy(name + "::" + age);
	}

	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

//	@Override
//	public void writeExternal(ObjectOutput out) throws IOException {
//		
//		String pk = name + "::" + age;
//		out.write(pk.getBytes());
//	}

//	@Override
//	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//		
//		byte[] buffer = new byte[1024];
//		int read = in.read(buffer);
//		String content = new String(buffer, 0, read);
//		String[] strings = content.split("::");
//		this.name = strings[0];
//		this.age = Integer.parseInt(strings[1]);
//	}
}
