/*
 * shane smyth
 * 
 */
package wellbuddymentalhealth;

public class StressMoodEntry extends MoodEntry {
    
    private int pressure;
    private int switchOff;
    private int overwhelmed;
    
    public StressMoodEntry(String date, String mood, String notes, int pressure, 
        int switchOff, int overwhelmed) {
        
        super(date, mood, notes);
        this.pressure = pressure;
        this.switchOff = switchOff;
        this.overwhelmed = overwhelmed;
    }

    public int getPressure() {
        return pressure;
    }

    public int getSwitchOff() {
        return switchOff;
    }

    public int getOverwhelmed() {
        return overwhelmed;
    }

    public int getTotalStress() {
        return pressure + switchOff + overwhelmed; 
    }
}
