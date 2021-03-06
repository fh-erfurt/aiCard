package de.aicard.card;

/**
 * Provides a 2 sided Card(front and back) for CardList and CardStatus
 * connects trough CardContent (Interface) to the different filetypes
 *
 * @author Martin Kuehlborn
 */
public class Card
{

    // MEMBER VARIABLES
    private CardContent cardFront;
    private CardContent cardBack;
    
    
    // CONSTRUCTORS
    
    public Card(CardContent _newCardFront, CardContent _newCardBack)
    {
        this.cardFront = _newCardFront;
        this.cardBack  = _newCardBack ;
    }
    
    
    // GETTER + SETTER
    public CardContent getCardFront() throws NullPointerException
    {
        if(this.cardFront == null)
        {
            throw new NullPointerException("CardFront not was not set.");
        }
        
        return this.cardFront;
    }
    
    public void setCardFront(CardContent _newCardFront)
    {
        this.cardFront = _newCardFront;
    }
    
    public CardContent getCardBack() throws NullPointerException
    {
        if(this.cardBack == null)
        {
            throw new NullPointerException("CardBack was not set.");
        }
        
        return this.cardBack;
    }
    
    public void setCardBack(CardContent newCardBack)
    {
        this.cardBack = newCardBack;
    }
}
