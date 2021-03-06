package de.aicard.Social;

import de.aicard.account.Account;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The class message is used to store informations about a message which are :
 * the message its self - the sender - the time it was sent - the number of likes and the people who liked this message as a list
 *
 *
 * @author Amine Semlali
 */
public class Message
{
    private String message;
    private Account sender;
    private LocalDateTime time;
    private ArrayList<Account> likedBy  ;

    //constructor
    
    /**
     * Constructor of a Message.
     * @param _newSender the person that sends the message
     * @param _newMessage the message to send
     *
     * likes are initialized to 0  and time is the time the message was sent
     *
     * @author Amine Semlali
     */
    public Message(String _newMessage, Account _newSender)
    {
        message = _newMessage;
        sender = _newSender;
        time = LocalDateTime.now();
        likedBy = new ArrayList<Account>();
    }

    //Setter & getter

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String _newMessage)
    {
        this.message = _newMessage;
    }

    /**
     * The function getLikedBy is used to get the list of the persons that liked the message
     *
     * @author Amine Semlali
     */
    public ArrayList<Account> getLikedBy()
    {
        return this.likedBy;
    }

    public void setLikedby (ArrayList<Account> _newLikedBy)
    {
        this.likedBy = _newLikedBy;
    }

    public LocalDateTime getTime()
    {
        return this.time;
    }

    //functions

    /**
     * the function clickLike checks if a person is in the list of those who liked the message
     * if the person liked the message, his name is removed from the list (dislike)
     * if the person didn't like the message,his name is added to the list (like)
     *
     * @author Amine Semlali
     */
    public void clickLike(Account _account)
    {
        if(likedBy.contains(_account))
        {
            likedBy.remove(_account);
        }
        else
        {
            likedBy.add(_account);
        }
    }
    /**
     * the function getLikes return the number of likes that a message has
     *
     * @author Amine Semlali
     */
    public int getLikes()
    {
        return likedBy.size();
    }


}

