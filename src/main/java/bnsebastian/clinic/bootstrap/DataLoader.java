package bnsebastian.clinic.bootstrap;

import bnsebastian.clinic.model.Owner;
import bnsebastian.clinic.model.Pet;
import bnsebastian.clinic.model.PetType;
import bnsebastian.clinic.model.Vet;
import bnsebastian.clinic.services.OwnerService;
import bnsebastian.clinic.services.PetTypeService;
import bnsebastian.clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Dog");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Sebastian");
        owner1.setLastName("Nicu");
        owner1.setAddress("123 Brick road");
        owner1.setCity("Miami");
        owner1.setTelephone("540129399");

        Pet sebastiansPet = new Pet();
        sebastiansPet.setPetType(savedDogPetType);
        sebastiansPet.setOwner(owner1);
        sebastiansPet.setBirthDate(LocalDate.now());
        sebastiansPet.setName("Rocky");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Maria");
        owner2.setLastName("Maria");
        owner2.setAddress("123 Brick road");
        owner2.setCity("Miami");
        owner2.setTelephone("540129399");

        Pet mariasPet = new Pet();
        mariasPet.setPetType(savedCatPetType);
        mariasPet.setOwner(owner2);
        mariasPet.setBirthDate(LocalDate.now());
        mariasPet.setName("Rocky");
        System.out.println("Loaded owners.");

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Axel");
        vet1.setLastName("Rose");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ozzy");
        vet2.setLastName("Osbourne");
        vetService.save(vet2);

        System.out.println("Loaded vets.");

    }
}
