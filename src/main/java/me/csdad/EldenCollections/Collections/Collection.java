package me.csdad.EldenCollections.Collections;

import java.util.HashMap;

/**
 * Author: csdad
 * Date: 03/21/2024
 *
 * Collection class.
 * A collection should store the following
 * - Identifier of its matching in-game data
 * - Common name of the item
 * - Category ? (optional)
 * - Milestones to unlock
 * - Styling ? (optional)
 */
public class Collection {

    // initialize the necessary variables
    private HashMap<Integer, Milestone> milestones;
    private String identifier;
    private String commonName;

    // constructor for the collection
    public Collection(String identifier, String commonName) {
        this.identifier = identifier;
        this.commonName = commonName;
        this.milestones = new HashMap<>();
    }

    // getter for the identifier
    public String getIdentifier() {
        return identifier;
    }

    // getter for the common name
    public String getCommonName() {
        return commonName;
    }

    // getter for the milestones
    public HashMap<Integer, Milestone> getMilestones() {
        return milestones;
    }

    // add a milestone to the collection
    public void addMilestone(int amount, Milestone milestone) {
        milestones.put(amount, milestone);
    }



}
