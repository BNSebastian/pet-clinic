package bnsebastian.clinic.bootstrap;

import bnsebastian.clinic.model.Owner;
import bnsebastian.clinic.model.Vet;
import bnsebastian.clinic.services.OwnerService;
import bnsebastian.clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Sebastian");
        owner1.setLastName("Nicu");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Maria");
        owner2.setLastName("Maria");
        ownerService.save(owner2);

        System.out.println("Loaded owners.");

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
