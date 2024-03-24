package in.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bindings.EventInfoDto;
import in.entity.Events;
import in.repository.EventsRepo;

@Service
public class EventsService {

	@Autowired
	private EventsRepo erepo ;
	public boolean addEvent (EventInfoDto eventDto) {
		Events events = new Events() ;
		BeanUtils.copyProperties(eventDto, events);
		Events save = erepo.save(events) ;
		return save == null ? false :true ;     
	}
	public boolean deleteEvent (Integer eventId) {
		Optional<Events> event = erepo.findById(eventId);
		if  ( event.isPresent()) {
			
			erepo.deleteById(eventId);
			return true ;
		}
		return false ;
	}
	public boolean updateEvent ( Events event) {
		Events save = erepo.save(event) ;
		return save == null ? false :true ;
	}
	
	public List<Events> getAllEvents (){
		return erepo.findAll();
	}
}
