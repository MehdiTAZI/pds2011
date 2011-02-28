package fr.esiag.mezzodijava.mezzo.coseventserver.model;

import java.util.Comparator;

/**
 * Utility Class for priority comparison between events
 * 
 * Override a compare method
 * 
 * UC n°: CI14 (FURPS)
 * 
 * @author Mezzo-Team
 * 
 */

import fr.esiag.mezzodijava.mezzo.cosevent.Event;
/**
 * Class PriorityEventComparator 
 * 
 * To compare events with priority and date
 * 
 * UC n°: FURPS CI14
 * 
 * @author Mezzo-Team
 * 
 */

public class PriorityEventComparator implements Comparator<Event> {

    /**
     * Compare two events.
     * 
     * @param Event
     *            1 and Event 2 Events to compare.
     */
    @Override
    public synchronized int compare(Event evt1, Event evt2) {

	if ((evt1.header.priority < evt2.header.priority) ||(evt1.header.date >= evt2.header.date) ) {
	    return -1;
	}
	else if ((evt1.header.priority > evt2.header.priority)|| (evt1.header.date < evt2.header.date)) {
	    return 1;
	}

	return 0;
    }
}
