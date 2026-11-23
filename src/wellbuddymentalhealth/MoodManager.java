/*
 * shane smyth
 * + add configuration so arraylist entries save and data percists. 
 */
package wellbuddymentalhealth;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MoodManager {

    private ArrayList<MoodEntry> entries = new ArrayList<>();
    
     // the storage file where saved entrie data is stored
    private static final String FILE_NAME = "moodentries.txt";
   
    
    // load saved entries when this is created
    public MoodManager() {
        loadFromFile();
    }
    
    public void addEntry(MoodEntry entry) {
        entries.add(entry);
         //save straight away
        saveToFile();
    }

    public ArrayList<MoodEntry> getEntries() {
        return new ArrayList<>(entries);
    }

    public boolean removeEntry(MoodEntry entry) {
        boolean removed = entries.remove(entry);
        saveToFile();
        return removed;
    }

    public int getEntryCount() {
        return entries.size();
    }
    
    // I write every entry to the file, one per line
    private void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(
                    new FileWriter(FILE_NAME));
            for (MoodEntry e : entries) {
                // I check the type before I cast
                if (e instanceof StressMoodEntry) {
                    StressMoodEntry s = (StressMoodEntry) e;
                    // no line breaks or "|" in notes
                    String notes = s.getNotes();
                    notes = notes.replace("\n", " ");
                    notes = notes.replace("|", "/");
                    String line = s.getDate();
                    line += "|" + s.getMood();
                    line += "|" + notes;
                    line += "|" + s.getPressure();
                    line += "|" + s.getSwitchOff();
                    line += "|" + s.getOverwhelmed();
                    out.println(line);
                }
            }
            out.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Your entries could not be saved.",
                    "Save problem",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    // I read the file back, one line per entry
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        // first run: no file yet, so nothing to load
        if (!file.exists()) {
            return;
        }
        try {
            BufferedReader in = new BufferedReader(
                    new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                String[] p = line.split("\\|", -1);
                String date = p[0];
                String mood = p[1];
                String notes = p[2];
                int pressure = Integer.parseInt(p[3]);
                int switchOff = Integer.parseInt(p[4]);
                int overwhelmed = Integer.parseInt(p[5]);
                StressMoodEntry entry = new StressMoodEntry(
                        date, mood, notes,
                        pressure, switchOff, overwhelmed);
                entries.add(entry);
                line = in.readLine();
            }
            in.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Your saved entries could not be read.",
                    "Load problem",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException
                | ArrayIndexOutOfBoundsException ex) {
            // a line was not in the format I expect
            JOptionPane.showMessageDialog(null,
                    "The saved entries file is damaged.",
                    "Load problem",
                    JOptionPane.ERROR_MESSAGE);
        }
    }// one tab-separated line per entry
}
