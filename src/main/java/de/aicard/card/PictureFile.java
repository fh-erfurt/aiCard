package de.aicard.card;

/**
 * Provides an PictureFile for side of a card
 * Currently using placeholder Strings
 * Will be real Picture in Java 2
 *
 * @author Martin Kuehlborn
 */
public class PictureFile implements CardContent
{

    // MEMBER VARIABLES
    /**
     * Placeholder for an audio file. Will be a real audio in Java 2
     */
    private String pictureData;
    /**
     * The title of the CardContent. Will be shown on top of the AudioData.
     */
    private String title;
    
    
    // CONSTRUCTORS
    
    public PictureFile(String _newPictureData)
    {
        this.pictureData = _newPictureData;
    }
    
    // GETTER + SETTER
    public String getPictureData() throws NullPointerException
    {
        if(this.pictureData == null)
        {
            throw new NullPointerException("PictureData was not set.");
        }
        
        return this.pictureData;
    }
    
    public void setPictureData(String _newPictureData)
    {
        this.pictureData = _newPictureData;
    }
    
    public String getTitle() throws NullPointerException
    {
        if(this.title == null)
        {
            throw new NullPointerException("PictureTitle was not set.");
        }
        
        return this.title;
    }
    
    public void setTitle(String _newTitle)
    {
        this.title = _newTitle;
    }
}
