/*
 * Shane Smyth
 * Mood entry class - date, mood and notes
 */
package wellbuddymentalhealth;

public class MoodEntry {

    // the date of this entry
    private String date;
    // the mood the user picked
    private String mood;
    // any extra notes the user typed
    private String notes;
    
    // constructor sets the three fields
    public MoodEntry(String date, String mood, String notes) {
        // this.date stores the date passed in
        this.date = date;
        // this.mood stores the mood passed in
        this.mood = mood;
        // this.notes stores the notes passed in
        this.notes = notes;  
    }

    // getter for the date
    public String getDate() {
        // return gives the date back
        return date;
    }

    // getter for the mood
    public String getMood() {
        // return gives the mood back
        return mood;
    }

    // getter for the notes
    public String getNotes() {
        // return gives the notes back
        return notes;
    }
     
    // short line, child classes can override
    public String getSummary() {
        // join the date and mood with a dash
        return getDate() + " - " + getMood();
    }
}