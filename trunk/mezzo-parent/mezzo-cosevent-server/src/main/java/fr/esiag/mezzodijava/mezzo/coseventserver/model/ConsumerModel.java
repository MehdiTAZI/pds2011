package fr.esiag.mezzodijava.mezzo.coseventserver.model;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConsumerModel {

    private static final long serialVersionUID = 1L;

    private int id;
    
    private Channel channel;

    private String idConsumer;

    private SortedSet<EventModel> eventsInQueue = Collections
	    .synchronizedSortedSet(new TreeSet<EventModel>(new PriorityEventModelComparator()));

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getIdConsumer() {
	return idConsumer;
    }

    public void setIdConsumer(String idConsumer) {
	this.idConsumer = idConsumer;
    }

    public SortedSet<EventModel> getEvents() {
	return eventsInQueue;
    }

    public void setEvents(SortedSet<EventModel> events) {
	this.eventsInQueue = events;
    }

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public EventModel getLastFromQueue(){
		EventModel em;
		if (this.getQueueSize()==0){
			return null;
		}
		em = this.getEvents().last();
		this.getEvents().remove(em);
		return em;
	}
	
	public int getQueueSize(){
		return this.eventsInQueue.size();
	}  
}
