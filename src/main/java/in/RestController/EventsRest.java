package in.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bindings.EventInfoDto;
import in.bindings.StatusDto;
import in.entity.Events;
import in.service.EventsService;

@RestController
public class EventsRest {

	@Autowired
	private EventsService eservice;
	@Autowired
	private StatusDto status;

	@PostMapping("/createEvent")

	public StatusDto createEvent(EventInfoDto eventDto) {

		status.setStatus(eservice.addEvent(eventDto));
		return status;
	}

	@PutMapping("/updateEvent")
	public StatusDto updateEvent(Events event) {

		status.setStatus(eservice.updateEvent(event));
		return status;
	}

	@DeleteMapping("/deleteEvent")
	public StatusDto deleteEvent(Integer eventId) {
		status.setStatus(eservice.deleteEvent(eventId));
		return status;
	}

	@GetMapping("/allevents")
	public List<Events> getAllEvents() {
		return eservice.getAllEvents();
	}
}
