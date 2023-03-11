package bnsebastian.clinic.bootstrap;

import bnsebastian.clinic.model.*;
import bnsebastian.clinic.services.OwnerService;
import bnsebastian.clinic.services.PetTypeService;
import bnsebastian.clinic.services.SpecialtyService;
import bnsebastian.clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Dog");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

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
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Ozzy");
        vet2.setLastName("Osbourne");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded vets.");
    }
}
