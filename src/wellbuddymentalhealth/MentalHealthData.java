/*
* Shane Smyth
*/

package wellbuddymentalhealth;


public class MentalHealthData {
    
    private static final MoodManager manager = new MoodManager();
    public static MoodManager getManager() {
        return manager;
    }
    
}
