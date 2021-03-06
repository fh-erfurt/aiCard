package de.aicard.account;

import de.aicard.Social.Chat;
import de.aicard.enums.AcademicGrade;
import de.aicard.learnset.LearnSet;
import de.aicard.learnset.LearnSetAbo;

import java.util.ArrayList;

/**
 * extends the account class
 * additional variable academicGrade
 * @author Clemens Berger
 */
public class Professor extends Account
{
    private AcademicGrade academicGrade;

    public Professor(String _email, String _password, String _name, String _description, AcademicGrade _academic)
    {
        this.email = _email;
        this.password = _password;
        this.name = _name;
        this.description = _description;
        this.ownLearnSets = new ArrayList<LearnSet>();
        this.favoriteLearnSets = new ArrayList<LearnSetAbo>();
        this.friends = new ArrayList<Account>();
        this.chats = new ArrayList<Chat>();
        this.academicGrade = _academic;
    }

    public AcademicGrade getAcademicGrade()
    {
        return academicGrade;
    }

    public void setAcademicGrade(AcademicGrade academicGrade)
    {
        this.academicGrade = academicGrade;
    }



}
