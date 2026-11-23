/*
 * shane smyth
 * 
 */
package wellbuddymentalhealth;
//MoodEntry is the class that defines what a mood entry contains.

public class MoodEntry {

    private String date;
    private String mood;
    private String notes;
    
    //The constructor
    public MoodEntry(String date, String mood, String notes) {
        this.date = date;
        this.mood = mood;
        this.notes = notes;  
    }

    public String getDate() {
        return date;
    }

    public String getMood() {
        return mood;
    }

    public String getNotes() {
        return notes;
    }
    
}