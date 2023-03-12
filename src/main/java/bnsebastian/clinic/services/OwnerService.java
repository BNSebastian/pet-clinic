package bnsebastian.clinic.services;

import bnsebastian.clinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastname);

    List<Owner> findAllByLastNameLike(String lastName);
}

