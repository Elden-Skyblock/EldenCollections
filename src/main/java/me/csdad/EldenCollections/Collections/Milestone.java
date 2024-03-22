package me.csdad.EldenCollections.Collections;

/**
 * Author: csdad
 * Date: 03/21/2024
 *
 * Milestone class.
 * A milestone should store the following
 * - Integer indicating how many of a certain item is needed to unlock
 * - A string indicating the action that should be taken when the milestone is reached
 * - A string indicating tool tip to be placed in game menus
 */
public class Milestone {

    // initialize the necessary variables
    private int amount;
    private String action;
    private String toolTip;

    // constructor for the milestone
    public Milestone(int amount, String action) {
        this.amount = amount;
        this.action = action;
    }

    // getter for the amount
    public int getAmount() {
        return amount;
    }

    // getter for the action
    public String getAction() {
        return action;
    }


}
