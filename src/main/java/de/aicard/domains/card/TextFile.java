package de.aicard.domains.card;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Provides an TextFile as String for side of a card
 *
 * @author Martin Kuehlborn
 */
@Entity
@Setter
@Getter
@DiscriminatorValue( value = "textfile")
public class TextFile extends CardContent
{
    // MEMBER VARIABLES
    @Column
    private String textData;


    // CONSTRUCTORS
    public TextFile()
    {
        this(null);
    }
    
    public TextFile(String _newTextData)
    {
        this.textData = _newTextData;
    }
    
    // GETTER + SETTER
    public String getTextData() throws NullPointerException
    {
        if(this.textData == null)
        {
            throw new NullPointerException("TextData was not set.");
        }
        
        return this.textData;
    }
    
    public void setTextData(String _newTextData)
    {
        this.textData = _newTextData;
    }
}