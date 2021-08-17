package de.aicard.domains.card;

import de.aicard.domains.BaseEntity;
import de.aicard.domains.enums.DataType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


/**
 * CardContent is one Side of a card
 *
 * @author Martin Kuehlborn
 */

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardContent extends BaseEntity
{
    @Column
    private String title;
    @Column(length = 512)
    private String data;
    @Column
    private DataType type;

    
    public CardContent(String title,String data, String type){
        this.title = title;
        this.data = data;
        this.type = getDataTypeFromString(type);
    }
    
    private DataType getDataTypeFromString(String type){
        DataType dataType;
        switch (type) {
            case "PictureFile":
                dataType = DataType.PictureFile;
                break;
            case "VideoFile":
                dataType = DataType.VideoFile;
                break;
            case "AudioFile":
                dataType = DataType.AudioFile;
                break;
            default:
                dataType = DataType.TextFile;
                break;
        }
        return dataType;
    }
}
