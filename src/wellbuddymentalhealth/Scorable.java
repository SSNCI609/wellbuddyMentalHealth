/*
 * Shane Smyth
 * Scorable interface - anything with a score
 */
package wellbuddymentalhealth;

// Promises that any class which implements Scorable its methods without 
// caring which class it's dealing with.
public interface Scorable {
    int getScore();
}
