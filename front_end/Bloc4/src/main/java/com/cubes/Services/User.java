package com.cubes.Services;

public class User {
    public  String Name;
    public  String Phone;
    public  String Competence1;
    public  String Competence2;
    public  String Competence3;
    
    public User() {
		this.Name = "";
		this.Phone = "";
		this.Competence1 = "";
		this.Competence2 = "";
		this.Competence3 = "";
    }
    
    public User(String name,
            String phone,
            String competence1,
            String competence2,
            String competence3)
            {
                Name = name;
                Phone = phone;
                Competence1 = competence1;
                Competence2 = competence2;
                Competence3 = competence3;
            }
    
    public String getName() {
        return Name;
    }

    public String getPhone() {
    	return Phone;
    }
    
    public String getCompetence1() {
        return Competence1;
    }
    
    public String getCompetence2() {
        return Competence2;
    }
    
    public String getCompetence3() {
        return Competence3;
    }

}