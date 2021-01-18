package de.aicard.card;

/**
 * Provides an VideoFile for side of a card that can be played and paused
 * Currently using placeholder Strings
 * Will be real Video in Java 2
 *
 * @author: Martin Kühlborn
 */
public class VideoFile implements CardContent
{
    // MEMBER VARIABLES
    private String m_VideoData;
    private boolean m_isPlaying;
    private String m_Title;
    
    // CONSTRUCTORS
    public VideoFile()
    {
        this(null, null);
    }
    
    public VideoFile(String _newVideoData, String _newTitle)
    {
        this.m_VideoData = _newVideoData;
        this.m_isPlaying = false;
        this.m_Title     = _newTitle;
    }
    
    
    // GETTER + Setter
    public String getVideoData() throws NullPointerException
    {
        if(this.m_VideoData == null)
        {
            throw new NullPointerException("VideoData was not set.");
        }
        
        return this.m_VideoData;
    }
    
    public void setVideoData(String _newVideoData)
    {
        this.m_VideoData = _newVideoData;
    }
    
    public boolean getIsPlaying()
    {
        return this.m_isPlaying;
    }
    
    public void setIsPlaying(boolean _newIsPlaying)
    {
        this.m_isPlaying = _newIsPlaying;
    }
    
    public String getTitle() throws NullPointerException
    {
        if(this.m_Title == null)
        {
            throw new NullPointerException("VideoTitle was not set.");
        }
        
        return this.m_Title;
    }
    
    public void setTitle(String _newTitle)
    {
        this.m_Title = _newTitle;
    }
    
    
    // METHODS
    public String pauseVideoData()
    {
        return "VideoData is paused";
    }
    
    public String playVideoData()
    {
        return "VideoData is playing";
    }
    
}
