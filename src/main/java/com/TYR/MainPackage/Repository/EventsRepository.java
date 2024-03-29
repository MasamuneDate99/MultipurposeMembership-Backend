package com.TYR.MainPackage.Repository;

import com.TYR.MainPackage.Model.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events, String> {
}
