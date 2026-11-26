/*
 * Shane Smyth
 * Shared data - holds one MoodManager for all screens
 */

package wellbuddymentalhealth;

public class MentalHealthData {
    
    // one MoodManager for the whole app
    private static final MoodManager manager = new MoodManager();
    // getter so other classes can use it
    public static MoodManager getManager() {
        // return the shared manager
        return manager;
    }
    
}
