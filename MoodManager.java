/*
 * shane smyth
 * 
 */
package wellbuddymentalhealth;
import java.util.ArrayList;

public class MoodManager {

    private ArrayList<MoodEntry> entries = new ArrayList<>();
    
    public void addEntry(MoodEntry entry) {
        entries.add(entry);
    }

    public ArrayList<MoodEntry> getEntries() {
        return new ArrayList<>(entries);
    }

    public boolean removeEntry(MoodEntry entry) {
        return entries.remove(entry);
    }

    public int getEntryCount() {
        return entries.size();
    }
}
