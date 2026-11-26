/*
 * Shane Smyth
 * Stress mood entry - MoodEntry plus stress scores
 */
package wellbuddymentalhealth;
// child class: a mood entry plus stress scores
public class StressMoodEntry 
        // Scorable is the score interface
        extends MoodEntry implements Scorable {
    
    // how much pressure the user felt
    private final int pressure;
    // how hard it was to switch off
    private final int switchOff;
    // how overwhelmed the user felt
    private final int overwhelmed;
    
    // constructor sets mood data and scores
    public StressMoodEntry (String date, 
        String mood, String notes, int pressure, 
        int switchOff, int overwhelmed) {
        
        // super runs the MoodEntry constructor
        super(date, mood, notes);
        // store the pressure score
        this.pressure = pressure;
        // store the switch-off score
        this.switchOff = switchOff;
        // store the overwhelmed score
        this.overwhelmed = overwhelmed;
    }

    // interface method: total stress
    @Override
    public int getScore() {
        // getTotalStress adds the three scores
        return getTotalStress();
    }  
    
    // getter for the pressure score
    public int getPressure() {
        // return gives the pressure back
        return pressure;
    }

    // getter for the switch-off score
    public int getSwitchOff() {
        // return gives the switch-off score
        return switchOff;
    }

    // getter for the overwhelmed score
    public int getOverwhelmed() {
        // return gives the overwhelmed score
        return overwhelmed;
    }

    // add the three scores together
    public int getTotalStress() {
        // + adds the three stress scores
        return pressure + switchOff + overwhelmed; 
    }
    
    // polymorphism: adds the stress score
    @Override
    public String getSummary() {
        // super.getSummary is date and mood
        return super.getSummary()
            // then add the stress in brackets
            + " (stress " + getTotalStress() + ")";
    }
}
