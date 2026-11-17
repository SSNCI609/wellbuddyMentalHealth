# WellBuddy — Mental Health Section             (17 Nov 2026)

## What's New in This Commit?

I added the code to record a mood entry, store it while the app is running, display its details and show it in the mood history table.
I also added checks for invalid dates and unanswered stress questions.

## What Was Added?

- **MoodEntry:** A class to store the date, mood and notes for one entry.
- **StressMoodEntry:** Extends MoodEntry to include three stress responses, each scored [0–4]. It adds these responses together to give a total out of 12.
- **MoodManager:** I added an ArrayList to hold the mood entries, with methods to add, retrieve, remove and count them. *The remove method is not connected to the Delete button yet.*
- **MentalHealthData:** A shared class so all screens use the same MoodManager, which keeps entries available when the user switches screens.
- **GUI_RecordMood:** Connected the Save Entry button to read the form, check the input, create an entry and add it to the list.
- **GUI_EntryDetails:** Added a constructor that receives an entry and displays its information after saving.
- **GUI_MoodHistory:** Connected the table to the stored entries so it displays their dates, moods and stress totals.

The entries are currently stored in memory, so they disappear when the app is closed.

## Ideas for Future Development

I may separate recording a mood now from managing previous entries.

- **Record Mood Now:** Use Java's date and time tools to automatically record the current date and time.
- **Manage Previous Entries:** Allow the user to add a missed entry for an earlier date or edit an existing entry, including its notes, and choose the date and time the entry relates to.
- **Date and Time Validation:** Check that manually entered dates and times are valid and prevent future entries.
- **Track Changes:** Keep the original creation time and the last edited time separate from the date and time the mood entry relates to.

## What Is Next?

- **Data storage:** Save entries to a file so they persist after the app is closed.

Finish the Mood History screen so the user can:
- Select an entry and open its details.
- Search for entries by date.
- Click Show All to return to the full list.
- See a helpful message if nothing is selected or no entries match the search.
