/*
 * Shane Smyth
 * Mood manager - list of entries, save and load file
 */
package wellbuddymentalhealth;

// BufferedReader reads the file line by line
import java.io.BufferedReader;
// File lets me check if the save file exists
import java.io.File;
// FileReader opens the file for reading
import java.io.FileReader;
// FileWriter opens the file for writing
import java.io.FileWriter;
// IOException is thrown if a file fails
import java.io.IOException;
// PrintWriter writes text to the file
import java.io.PrintWriter;
// ArrayList is a list that can grow
import java.util.ArrayList;
// JOptionPane shows popup messages
import javax.swing.JOptionPane;

// MoodManager stores and saves all entries
public class MoodManager {

    // the list of mood entries in memory
    private ArrayList<MoodEntry> entries = new ArrayList<>();
    
    // the file name where entries are saved
    private static final String FILE_NAME = "moodentries.txt";
   
    
    // load saved entries when this is created
    public MoodManager() {
        // loadFromFile reads the saved file
        loadFromFile();
    }
    
    // add one entry and save the file
    public void addEntry(MoodEntry entry) {
        // add puts the entry in the ArrayList
        entries.add(entry);
        // save the list straight away
        saveToFile();
    }

    // a copy of the list, so it cannot be broken
    public ArrayList<MoodEntry> getEntries() {
        // new ArrayList copies the list
        return new ArrayList<>(entries);
    }

    // remove one entry and save the file
    public boolean removeEntry(MoodEntry entry) {
        // remove takes it out of the ArrayList
        boolean removed = entries.remove(entry);
        // save the list after the change
        saveToFile();
        // true if it was in the list
        return removed;
    }

    // how many entries are stored
    public int getEntryCount() {
        // size() is the number of entries
        return entries.size();
    }
    
    // write every entry to the file, one per line
    private void saveToFile() {
        // try, in case writing the file fails
        try {
            // PrintWriter writes each line
            PrintWriter out = new PrintWriter(
                    // FileWriter opens the save file
                    new FileWriter(FILE_NAME));
            // index loop, one entry at a time
            for (int i = 0; i < entries.size(); i++) {
                // get(i) takes the entry at index i
                MoodEntry e = entries.get(i);
                // instanceof checks the type
                // I check the type before I cast
                if (e instanceof StressMoodEntry) {
                    // cast to use the stress methods
                    StressMoodEntry s = (StressMoodEntry) e;
                    // replace \n and | in the notes
                    String notes = s.getNotes()
                        .replace("\n", " ")
                        .replace("|", "/");
                    // println writes one line
                    // fields are joined with |
                    out.println(s.getDate() + "|" + s.getMood()
                        + "|" + notes + "|" + s.getPressure()
                        + "|" + s.getSwitchOff()
                        + "|" + s.getOverwhelmed());
                }
            }
            // close finishes the write
            out.close();
        // IOException means the file failed
        } catch (IOException ex) {
            // a popup to tell the user
            JOptionPane.showMessageDialog(null,
                    "Your entries could not be saved.");
        }
    }
    // read the file back, one line per entry
    private void loadFromFile() {
        // File points at the save file
        File file = new File(FILE_NAME);
        // first run: no file yet, so nothing to load
        if (!file.exists()) {
            // return stops the method here
            return;
        }
        // try, in case reading the file fails
        try {
            // BufferedReader reads line by line
            BufferedReader in = new BufferedReader(
                    // FileReader opens the save file
                    new FileReader(file));
            // readLine gets the first line
            String line = in.readLine();
            // null means we have reached the end
            while (line != null) {
                // split breaks the line on |
                String[] p = line.split("\\|", -1);
                // p[0] is the date
                String date = p[0];
                // p[1] is the mood
                String mood = p[1];
                // p[2] is the notes
                String notes = p[2];
                // parseInt turns text into an int
                int pressure = Integer.parseInt(p[3]);
                // p[4] is the switch-off score
                int switchOff = Integer.parseInt(p[4]);
                // p[5] is the overwhelmed score
                int overwhelmed = Integer.parseInt(p[5]);
                // make a StressMoodEntry from parts
                StressMoodEntry entry = new StressMoodEntry(
                        date, mood, notes,
                        pressure, switchOff, overwhelmed);
                // add puts it into the ArrayList
                entries.add(entry);
                // readLine gets the next line
                line = in.readLine();
            }
            // close finishes the read
            in.close();
        // IOException means the file failed
        } catch (IOException ex) {
            // a popup to tell the user
            JOptionPane.showMessageDialog(null,
                    "Your saved entries could not be read.");
        // NumberFormatException is a bad number
        } catch (NumberFormatException ex) {
            // a line was not in the format I expect
            JOptionPane.showMessageDialog(null,
                    "The saved entries file is damaged.");
        // the line did not have enough parts
        } catch (ArrayIndexOutOfBoundsException ex) {
            // a line was not in the format I expect
            JOptionPane.showMessageDialog(null,
                    "The saved entries file is damaged.");
        }
    }
}
