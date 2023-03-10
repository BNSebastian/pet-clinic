package bnsebastian.clinic.services;

import bnsebastian.clinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastname);

}

