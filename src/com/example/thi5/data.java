package com.example.thi5;

public class data {
private String id, name;

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

@Override
public String toString() {
	return "ID: " + this.id + "\n" + "name: " + this.name;
}


}
