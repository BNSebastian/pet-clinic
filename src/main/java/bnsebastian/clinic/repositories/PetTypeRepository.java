package bnsebastian.clinic.repositories;

import bnsebastian.clinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
