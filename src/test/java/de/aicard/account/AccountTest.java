package de.aicard.account;

import de.aicard.enums.AcademicGrade;
import de.aicard.enums.Faculty;
import de.aicard.enums.Visibility;
import de.aicard.learnset.LearnSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

/**
 * Test class for the functions of Account
 *
 * @author Antonio Blechschmidt, Semlali Amine
 */
//todo variabel kleinschreiben
public class AccountTest
{
    //private static final Logger logger = Logger.getLogger(Account.class.);
    @Test
    void testOwnLearnSetManipulation()
    {
        //setup
        Professor prof1 = new Professor("Prof@fh-erfurt.de","adminProf","Prof1","Professor1", AcademicGrade.UNIVERSITY_PROFESSOR);

        LearnSet learnSet1 = new LearnSet("IT", "This is an IT Learnset", Faculty.APPLIED_COMPUTER_SCIENCE);


        prof1.ownLearnSets.add(learnSet1);

        //test deleteFromOwnedLearningSetsByIndex
        prof1.deleteOwnLearnSetsByIndex(0);
        Assertions.assertTrue(prof1.ownLearnSets.isEmpty());

        //setup for deleteFromOwnedLearningSetsLastElement()
        prof1.ownLearnSets.add(learnSet1);
        prof1.createNewOwnLearnSet("IT", "This is the second IT Learnset", Faculty.APPLIED_COMPUTER_SCIENCE, Visibility.PUBLIC);

        //test deleteFromOwnedLearningSetsLastElement()
        prof1.deleteOwnLearnSetByLastElement();
        Assertions.assertEquals(prof1.getOwnLearnSetByIndex(prof1.ownLearnSets.size()-1), learnSet1);

        //setup for deleteAllFromOwnedLearningSets()
        prof1.createNewOwnLearnSet("IT", "This is the second IT Learnset", Faculty.APPLIED_COMPUTER_SCIENCE, Visibility.PUBLIC);

        //test deleteAllFromOwnedLearningSets()
        prof1.deleteAllOwnLearnSets();
        Assertions.assertTrue(prof1.ownLearnSets.isEmpty());
    }
    
    @Test
    void testFavoriteLearnSetManipulation()
    {
        //setup
        Professor Prof1 = new Professor("Prof@fh-erfurt.de","adminProf","Prof1","Professor1", AcademicGrade.UNIVERSITY_PROFESSOR);
        Professor Prof2 = new Professor("Prof@fh-erfurt.de","adminProf","Prof2","Professor2", AcademicGrade.UNIVERSITY_PROFESSOR);
        Prof2.createNewOwnLearnSet("IT", "This is an IT Learnset", Faculty.APPLIED_COMPUTER_SCIENCE, Visibility.PUBLIC);
        Prof2.createNewOwnLearnSet("IT", "This is the second IT Learnset", Faculty.APPLIED_COMPUTER_SCIENCE, Visibility.PUBLIC);
        
        //test addNewFavoriteSets() and getFavoriteSetByPosition()
        Prof1.addNewFavoriteLearnSet(Prof2.getOwnLearnSetByIndex(0));
        Assertions.assertEquals(Prof2.getOwnLearnSetByIndex(0), Prof1.getFavoriteLearnSetByIndex(0).getLearnSet());
        
        //test deleteFromOwnLearningSetsByIndex
        Prof1.deleteFavoriteLearnSetByIndex(0);
        Assertions.assertTrue(Prof1.favoriteLearnSets.isEmpty());
        
        //setup for deleteFromOwnLearningSetsLastElement()
        Prof1.addNewFavoriteLearnSet(Prof2.getOwnLearnSetByIndex(0));
        Prof1.addNewFavoriteLearnSet(Prof2.getOwnLearnSetByIndex(1));
        
        //test deleteFromOwnLearningSetsLastElement()
        Prof1.deleteFavoriteLearnSetByLastElement();
        Assertions.assertEquals(Prof1.getFavoriteLearnSetByIndex(Prof1.favoriteLearnSets.size()-1).getLearnSet(), Prof2.getOwnLearnSetByIndex(0));
        
        //setup for deleteAllFromOwnLearningSets()
        Prof1.addNewFavoriteLearnSet(Prof2.getOwnLearnSetByIndex(1));
        
        //test deleteAllFromOwnedLearningSets()
        Prof1.deleteAllFavoriteLearnSets();
        Assertions.assertTrue(Prof1.favoriteLearnSets.isEmpty());
    }
    
    @Test
    void testFriendManipulation()
    {
        //setup
        Professor Prof1 = new Professor("Prof@fh-erfurt.de","adminProf","Prof1","Professor1", AcademicGrade.UNIVERSITY_PROFESSOR);
        Professor Prof2 = new Professor("Prof@fh-erfurt.de","adminProf","Prof2","Professor2", AcademicGrade.UNIVERSITY_PROFESSOR);
        Professor Prof3 = new Professor("Prof@fh-erfurt.de","adminProf","Prof3","Professor3", AcademicGrade.UNIVERSITY_PROFESSOR);
        
        //test addFriend() and getFriendByIndex()
        Prof1.addFriend(Prof2);
        Assertions.assertEquals(Prof1.getFriendByIndex(0), Prof2);
        
        //test removeFriend()
        Prof1.removeFriend(Prof2);
        Assertions.assertTrue(Prof1.friends.isEmpty());
        
        //setup for removeFriendByIndex()
        Prof1.addFriend(Prof2);
        Prof1.addFriend(Prof3);
        
        //test removeFriendByIndex()
        Prof1.removeFriend(0);
        Assertions.assertEquals(Prof1.getFriendByIndex(0), Prof3);
        
    }
    /*
     @Test
     void testGroupManipulation()
     {
     //setup
     Professor Prof1 = new Professor("Prof@fh-erfurt.de","adminProf","Prof1","Professor1", AcademicGrade.A);
     Professor Prof2 = new Professor("Prof@fh-erfurt.de","adminProf","Prof2","Professor2", AcademicGrade.A);
     Prof1.createGroup();
     Prof2.createGroup();
     
     //test createGroup() and leaveGroup()
     Prof1.leaveGroup(Prof1.getGroups());
     Assertions.assertEquals(Prof1.getGroups(), null);
     
     //test joinGroup() negetiv
     Prof1.joinGroup(Group _group);
     Assertions.assertEquals(Prof1.getGroups(), null);
     //test joinGroup() positiv
     Prof1.joinGroup(Group _group);
     }
     **/

    @Test
    void testChatManipulation()
    {
        //setup
        Professor Prof1 = new Professor("Prof@fh-erfurt.de","adminProf","Prof1","Professor1", AcademicGrade.UNIVERSITY_PROFESSOR);
        Professor Prof2 = new Professor("Prof@fh-erfurt.de","adminProf","Prof2","Professor2", AcademicGrade.UNIVERSITY_PROFESSOR);

        //test addNewChat()
        Prof1.addNewChat(Prof2);
        Assertions.assertEquals(Prof1.chats.get(0), Prof2.chats.get(0));

        //test addNewChat()
        Prof1.deleteChat(0);
        Assertions.assertTrue(Prof1.chats.isEmpty());
    }

    @Test
    void testLoginandPasswordChange()
    {
        //setup
        Professor Prof1 = new Professor("Prof@fh-erfurt.de","adminProf","Prof1","Professor1", AcademicGrade.UNIVERSITY_PROFESSOR);

        //test login()
        Assertions.assertEquals(Prof1.login("Prof@fh-erfurt.de", "adminProf"), "login was successful");
        Assertions.assertEquals(Prof1.login("Prof@fh-erfurt.de", "adminProf123"), "login failed"); //wrong password
        Assertions.assertEquals(Prof1.login("Prof@fh-erfurt.com", "adminProf"), "login failed");//wrong email

        //test resetPassword
        Prof1.resetPassword("Prof@fh-erfurt.de", "adminProf123");
        Assertions.assertEquals(Prof1.getPassword(), "adminProf123");
    }

    @Test
    void testMessageLikeManipulation()
    {
        Professor prof1 = new Professor("Prof@fh-erfurt.de","adminProf","Prof1","Professor1", AcademicGrade.UNIVERSITY_PROFESSOR);
        Professor prof2 = new Professor("Prof@fh-erfurt.de","adminProf","Prof2","Professor2", AcademicGrade.UNIVERSITY_PROFESSOR);
        prof1.addNewChat(prof2);
        prof2.getChats().get(0).sendMessage("Hello",prof1);

        //test clickLike
        prof1.clicksLikeOfMessage(0,1); //likes Message of Prof2
        Assertions.assertEquals(prof1.getChats().get(0).getChatHistory().get(1).getLikes(),1);
        prof2.clicksLikeOfMessage(0,1); // likes own Message
        Assertions.assertEquals(prof1.getChats().get(0).getChatHistory().get(1).getLikes(),2);
    }
}