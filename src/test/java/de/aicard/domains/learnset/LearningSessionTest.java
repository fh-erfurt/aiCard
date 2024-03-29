package de.aicard.domains.learnset;

import de.aicard.domains.card.Card;
import de.aicard.domains.card.CardContent;
import de.aicard.domains.enums.CardKnowledgeLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static de.aicard.domains.learnset.LearnSetTest.getTestLearnSet;

/**
 * This class tests the functions of the class LearningSessionTests
 *
 * @author Daniel Michel
 */
public class LearningSessionTest
{
    private static final Logger logger = Logger.getLogger(LearningSessionTest.class.getName());
    
    @Test
    public void testingCreatingLearningSession()
    {
        //given: Our TestLearnSet and an Abo of it.
        LearnSet learnSet = getTestLearnSet();
        try
        {
            LearnSetAbo abo = new LearnSetAbo(learnSet);
            int numberOfCards = 5;
            
            //when: we create a LearningSession of this abo with 5 Cards.
            LearningSession session = abo.createLearningSession(numberOfCards);
            
            //then: the cards in the LearningSession should be the first 5 cards of the LearnSetAbo
            
            CardContent cardBack = session.getCardStatusList().get(4).getCard().getCardBack();
            Assertions.assertEquals("data4", cardBack.getData());
            
        } catch (Exception e)
        {
            logger.warning("Strange things are happening... " + e.getMessage());
        }
        
    }
    
    @Test
    public void testingWorkingInSessions()
    {
        //given: our testLearnSet
        LearnSet set = getTestLearnSet();
        try
        {
            //also given: A LearnSetAbo of the testLearnSet and a Session of 5 Cards (as tested above)
            LearnSetAbo abo = new LearnSetAbo(set);
            int numOfCards = 5;
            LearningSession session = abo.createLearningSession(numOfCards);
            
            //when: we know all even cards in the Session
            while (session.isActive())
            {
                if (session.getCurrentCard() % 2 == 0)
                {
                    session.cardKnown();
                }
                else
                {
                    session.cardUnknown();
                }
            }
            
            //then: CardKnowLedgeLevel of Card 0, 2 and 4 of the LearnSetAbo should be SOMEINFORMATION
            for (int i = 0; i < numOfCards; i++)
            {
                if (i == 0 || i == 2 || i == 4)
                {
                    Assertions.assertEquals(CardKnowledgeLevel.SOMEINFORMATION, abo.getCardStatus().get(i).getCardKnowledgeLevel());
                }
                else
                {
                    Assertions.assertEquals(CardKnowledgeLevel.NOINFORMATION, abo.getCardStatus().get(i).getCardKnowledgeLevel());
                }
            }
            
            //when: creating a new LearningSession of the same Abo and 5 Cards
            LearningSession newSession = abo.createLearningSession(numOfCards);
            
            //then: different Cards should be in the Session: Card 1, 3, 5, 6, and 7 of the Abo
            Card aboCard1 = abo.getCardStatus().get(1).getCard();
            Card sessionCard0 = newSession.getCardStatusList().get(0).getCard();
            Assertions.assertEquals(aboCard1, sessionCard0);
            
            Card aboCard3 = abo.getCardStatus().get(3).getCard();
            Card sessionCard1 = newSession.getCardStatusList().get(1).getCard();
            Assertions.assertEquals(aboCard3, sessionCard1);
            
            Card aboCard5 = abo.getCardStatus().get(5).getCard();
            Card sessionCard2 = newSession.getCardStatusList().get(2).getCard();
            Assertions.assertEquals(aboCard5, sessionCard2);
            
            Card aboCard6 = abo.getCardStatus().get(6).getCard();
            Card sessionCard3 = newSession.getCardStatusList().get(3).getCard();
            Assertions.assertEquals(aboCard6, sessionCard3);
            
            Card aboCard7 = abo.getCardStatus().get(7).getCard();
            Card sessionCard4 = newSession.getCardStatusList().get(4).getCard();
            Assertions.assertEquals(aboCard7, sessionCard4);
            
        } catch (Exception e)
        {
            logger.warning("An exception occured: " + e.getMessage());
        }
    }
}
