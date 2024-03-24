package in.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.entity.Events;

public interface EventsRepo extends JpaRepository<Events, Integer> {

}
