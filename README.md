# WellBuddy — Mental Health Section

This is the Mental Health section of the WellBuddy Java project, by Shane Smyth.

## Classes

- **MoodEntry:** A class to store the date, mood and notes for one entry.
- **StressMoodEntry:** Extends MoodEntry and implements Scorable. It includes three stress scores, each from 0 to 4, added together for a total out of 12.
- **Scorable:** An interface for anything that has a score.
- **MoodManager:** An ArrayList of entries, with methods to add, retrieve, remove and count them. It also saves and loads the file.
- **MentalHealthData:** A shared class so all screens use the same MoodManager.
- **GUI_MoodManager:** The Mental Health menu.
- **GUI_RecordMood:** The screen for recording a new mood entry.
- **GUI_ManageEntries:** The screen for searching, showing and deleting entries.

## Features

- I can record a mood with a stress check-in of three questions, each scored 0 to 4, for a total out of 12, and optional notes. Today's date is filled in automatically. The form checks that the date is valid and that all three questions are answered.
- Mood History shows a popup list of all entries.
- Statistics shows a popup with the total entries, the count for each mood, the most common mood and the average stress out of 12.
- In Manage Entries I can search by date, show all, or delete an entry (I type yes to confirm).
- Entries are saved to moodentries.txt and loaded when the app starts.

## OOP

StressMoodEntry extends MoodEntry and implements Scorable. getSummary is overridden, which is polymorphism.
