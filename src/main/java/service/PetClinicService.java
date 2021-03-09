package service;

import model.Consult;
import model.Pet;
import model.Vet;
import repository.ConsultDao;
import repository.PetDao;
import repository.VetDao;
import utility.HibernateUtil;

import java.util.Arrays;
import java.util.Scanner;

public class PetClinicService {
    VetDao vetDao = new VetDao();
    PetDao petDao = new PetDao();
    ConsultDao consultDao = new ConsultDao();
    Scanner console = new Scanner(System.in);

    public int option(){
        int option = console.nextInt();
        return option;
    }
    public void showMenu(){
        System.out.println();
        System.out.println("0.Exit");
        System.out.println("1.Create");
        System.out.println("2.Find");
        System.out.println("3.Update");
        System.out.println("4.Delete");
    }
    public void createMenu(){
        System.out.println();
        System.out.println("1.Create Pet");
        System.out.println("2.Create Vet");
        System.out.println("3.Create consult");

    }
    public void findMenu(){
        System.out.println();
        System.out.println("1.Find Pet by ID");
        System.out.println("2.Find Vet by ID");
        System.out.println("3.Find consult by ID");
        System.out.println("4.Show all pets");
        System.out.println("5.Show all vets");
        System.out.println("6.Show all consults");

    }
    public void updateMenu(){
        System.out.println();
        System.out.println("1.Update Pet");
        System.out.println("2.Update Vet");
        System.out.println("3.Update consult");

    }
    public void deleteMenu(){
        System.out.println();
        System.out.println("1.Delete Pet");
        System.out.println("2.Delete Vet");
        System.out.println("3.Delete consult");

    }

    public void menuCommands(){
        showMenu();
        switch (option()){
            case 0:
                break;
            case 1:
                createMenu();
                createCommands();
                menuCommands();
                break;
            case 2:
                findMenu();
                findCommands();
                menuCommands();
                break;
            case 3:
                updateMenu();
                updateCommands();
                menuCommands();
                break;
            case 4:
                deleteMenu();
                deleteCommands();
                menuCommands();
                break;

        }
    }

    public void createCommands(){

        switch(option()){
            case 1:
                System.out.println("Create pet selected !");
                System.out.println("Please insert :");
                System.out.print("Race of the pet: " ); String race = console.next();
                System.out.print("Is the pet vaccinated? Write true or false: "); Boolean isVaccinated = console.nextBoolean();
                System.out.print("Date of birth: "); String birthdate = console.next();
                System.out.print("Name: "); String name = console.next();

                Pet pet = new Pet(race,isVaccinated,birthdate,name);
                petDao.createPet(pet);

                System.out.println("Pet created !");
                break;


            case 2:
                System.out.println("Create vet selected !");
                System.out.println("Please insert :");
                System.out.print("First name: "); String firstName = console.next();
                System.out.print("Last name: "); String lastName = console.next();
                System.out.print("Address: "); String adress = console.next();
                System.out.print("Speciality: "); String speciality = console.next();

                Vet vet = new Vet(firstName,lastName,adress,speciality);
                vetDao.createVet(vet);

                System.out.println("Vet created !");
                break;

            case 3:
                System.out.println("Create consult selected !");
                System.out.println("Please insert :");
                System.out.print("Date: "); String date = console.next();
                System.out.print("Description: "); String description = console.next();
                System.out.print("ID of the vet: "); Long idOfVet = console.nextLong();
                System.out.print("ID of pet: "); Long idOfPet = console.nextLong();

                Consult consult = new Consult(date,description,vetDao.getVet(idOfVet),petDao.getPet(idOfPet));
                consultDao.createConsult(consult);


                System.out.println("Consult created !");
                break;
        }
    }

    public void findCommands(){
        long id;
        switch (option()){
            case 1:
                System.out.println("Find Pet selected !");
                System.out.print("Please insert pet's ID:"); id = console.nextLong();
                System.out.println(petDao.getPet(id).toString());
                System.out.println("Pet found !");
                break;

            case 2:
                System.out.println("Find Vet selected !");
                System.out.print("Please insert vet's ID:"); id = console.nextLong();
                System.out.println(vetDao.getVet(id).toString());
                System.out.println("Vet found !");
                break;

            case 3:
                System.out.println("Find consult selected !");
                System.out.print("Please insert consult's ID:"); id = console.nextLong();
                System.out.println(consultDao.getConsult(id).toString());
                System.out.println("Vet found !");
                break;
            case 4:
                System.out.println("Pet list: ");
                petDao.printAllPets();
            case 5:
                System.out.println("Vet list: ");
                vetDao.printAllVets();
            case 6:
                System.out.println("Consult list: ");
                consultDao.printAllConsults();



        }
    }

    public void updateCommands(){
        long id;
        switch (option()){
            case 1:
                System.out.println("Update pet selected !");
                System.out.println("List of pets: ");
                petDao.printAllPets();
                System.out.println("Please insert pet's ID: "); id = console.nextLong();
                System.out.println("This is the selected pet: ");
                System.out.println(petDao.getPet(id).toString());
                Pet pet = new Pet();
                pet = petDao.getPet(id);
                System.out.println("Please insert :");
                System.out.print("Race of the pet: " ); String race = console.next();
                System.out.print("Is the pet vaccinated? Write true or false: "); Boolean isVaccinated = console.nextBoolean();
                System.out.print("Date of birth: "); String birthdate = console.next();
                System.out.print("Name: "); String name = console.next();
                pet.setRace(race);
                pet.setVaccinated(isVaccinated);
                pet.setBirthdate(birthdate);
                pet.setName(name);
                petDao.updatePet(pet);
                System.out.println("Pet updated!");
                break;
            case 2:
                Vet vet = new Vet();
                System.out.println("Update vet selected !");
                System.out.println("List of vets: ");
                vetDao.printAllVets();
                System.out.println("Please insert vet's ID: "); id = console.nextLong();
                vet = vetDao.getVet(id);
                System.out.println("This is the selected vet: ");
                System.out.println(vet.toString());
                System.out.println("Please insert :");
                System.out.print("First name: "); String firstName = console.next();
                System.out.print("Last name: "); String lastName = console.next();
                System.out.print("Address: "); String adress = console.next();
                System.out.print("Speciality: "); String speciality = console.next();
                vet.setFirstName(firstName);
                vet.setLastName(lastName);
                vet.setAdress(adress);
                vet.setSpeciality(speciality);
                vetDao.updateVet(vet);
                System.out.println("Vet updated!");
                break;
            case 3:
                Consult consult = new Consult();
                System.out.println("Update consult selected !");
                System.out.println("List of consults: ");
                consultDao.printAllConsults();
                System.out.println("Please insert consult's ID: "); id = console.nextLong();
                consult = consultDao.getConsult(id);
                System.out.println("This is the selected consult: ");
                System.out.println(consult.toString());
                System.out.println("Please insert :");
                System.out.print("Date: "); String date = console.next();
                System.out.print("Description: "); String description = console.next();
                System.out.print("ID of the vet: "); Long idOfVet = console.nextLong();
                System.out.print("ID of pet: "); Long idOfPet = console.nextLong();
                consult.setDate(date);
                consult.setDescription(description);
                consult.setVet(vetDao.getVet(idOfVet));
                consult.setPet(petDao.getPet(idOfPet));
                consultDao.updateConsult(consult);
                System.out.println("Consult updated!");
                break;

        }
    }

    public void deleteCommands(){
        long id;
        switch(option()){
            case 1:
                System.out.println("Delete pet selected!");
                System.out.println("List of pets: ");
                petDao.printAllPets();
                System.out.println("Which one would you like to delete? Insert ID: "); id = console.nextLong();
                Pet petToDelete = petDao.getPet(id);
                petDao.deletePet(petToDelete);
                System.out.println("Pet deleted !");
                break;
            case 2:
                System.out.println("Delete vet selected!");
                System.out.println("List of vets: ");
                vetDao.printAllVets();
                System.out.println("Which one would you like to delete? Insert ID: "); id = console.nextLong();
                vetDao.deleteVet(vetDao.getVet(id));
                System.out.println("Vet deleted !");
                break;
            case 3:
                System.out.println("Delete consult selected!");
                System.out.println("List of consult: ");
                consultDao.printAllConsults();
                System.out.println("Which one would you like to delete? Insert ID: "); id = console.nextLong();
                consultDao.deleteConsult(consultDao.getConsult(id));
                System.out.println("Vet deleted !");
                break;


        }
    }

}
