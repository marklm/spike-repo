package at.marklnet.markl.spikes.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CollectionTest {
    
    static final List<String> EXISTING_VALUES = 
            Arrays.asList(new String[] {"VAL1", "VAL2", "VAL3", "VAL4", "VAL5", "VAL6", "VAL7", "VAL8"});
    
    static final List<String> NEW_VALUES = Arrays.asList(new String[] {"VAL3", "VAL4", "VAL6"});
    

    /**
     * Tests creating List with removed items.
     */
    @Test
    public void removeFromCollections() {
        

        
        final List<String> removedValues = new ArrayList<String>();
        
        for (String oldValue : EXISTING_VALUES) {
            String removedValue = oldValue;
            for (String newValue : NEW_VALUES) {
                if (oldValue.equals(newValue)) {
                    // Exists
                    removedValue = null;
                } 
            }
            if (removedValue != null) {
                removedValues.add(removedValue);
            }
        }
        
        assertRemoveFromCollections(removedValues);
        
        
    }
    
    /**
     * Tests creating List with removed items, same behavior aus {@link #removeFromCollections()}.
     * 
     * Works with DTO fine, but consider when doing this with Domain Objects we are going to reload stuff from db :-(
     */
    @Test
    public void removeFromCollectionsImproved() {      
        final List<String> removedValues = new ArrayList<String>(EXISTING_VALUES);   
        removedValues.removeAll(NEW_VALUES);
        
        assertRemoveFromCollections(removedValues);   
    }
    
    private void assertRemoveFromCollections(List<String> removedValues) {
        assertEquals(5, removedValues.size());
        assertTrue(removedValues.contains("VAL1"));
        assertTrue(removedValues.contains("VAL2"));
        assertTrue(removedValues.contains("VAL5"));
        assertTrue(removedValues.contains("VAL7"));
        assertTrue(removedValues.contains("VAL8"));
    }

}
