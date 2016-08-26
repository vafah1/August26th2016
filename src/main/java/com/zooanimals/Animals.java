package com.zooanimals;

public class Animals 
{
	private String animalsID = null;
	private String species = null;
	private String name = null;
	private String habitat = null;
	private int age = 0;
	private double weight = 0.0;
	
	
	public Animals() {
		super();
	}


	public String getAnimalsID() {
		return animalsID;
	}


	public void setAnimalsID(String animalsID) {
		this.animalsID = animalsID;
	}


	public String getSpecies() {
		return species;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getHabitat() {
		return habitat;
	}


	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Animals [animalsID=" + animalsID + ", species=" + species + ", name=" + name + ", habitat=" + habitat
				+ ", age=" + age + ", weight=" + weight + "]";
	}
	
	
	
}
