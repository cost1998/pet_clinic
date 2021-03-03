package service;

import model.Consult;
import model.Pet;
import model.Vet;
import repository.ConsultDao;
import repository.PetDao;
import repository.VetDao;

import java.util.Scanner;

public class PetClinicService {

    Scanner console = new Scanner(System.in);

    public int option(){
        int option = console.nextInt();
        return option;
    }
    public void showMenu(){
        System.out.println("1.Create");
        System.out.println("2.Find");
        System.out.println("3.Update");
        System.out.println("4.Delete");
    }
    public void createMenu(){
        System.out.println("1.Create Pet");
        System.out.println("2.Create Vet");
        System.out.println("3.Create consult");

    }
    public void findMenu(){
        System.out.println("1.Find Pet by name");
        System.out.println("2.Find Vet by name");
        System.out.println("3.Find consult by ID");

    }
    public void updateMenu(){
        System.out.println("1.Update Pet");
        System.out.println("2.Update Vet");
        System.out.println("3.Update consult");

    }
    public void deleteMenu(){
        System.out.println("1.Delete Pet");
        System.out.println("2.Delete Vet");
        System.out.println("3.Delete consult");

    }

    public void menuCommands(){
        switch (option()){
            case 1:
                createMenu();
                createCommands();
                break;
            case 2:
                findMenu();
                findCommands();
                break;
            case 3:
                updateMenu();
                break;
            case 4:
                deleteMenu();
                break;

        }
    }

    public void createCommands(){
        switch(option()){
            case 1:
                System.out.println("Create pet selected !");
                System.out.println("Please insert :");
                System.out.print("An ID: "); long petId = console.nextLong();
                System.out.print("Race of the pet: "); String race = console.next();
                System.out.print("Is the pet vaccinated? Write true or false: "); boolean isVaaccinated = console.nextBoolean();
                System.out.print("Date of birth: "); String birthdate = console.next();
                System.out.print("Name: "); String name = console.next();

                Pet pet = new Pet(petId,race,isVaaccinated,birthdate,name);
                PetDao petDao = new PetDao();
                petDao.createPet(pet);

                System.out.println("Pet created !");
                break;

            case 2:
                System.out.println("Create vet selected !");
                System.out.println("Please insert :");
                System.out.print("An ID: "); long vetId = console.nextLong();
                System.out.print("First name: "); String firstName = console.next();
                System.out.print("Last name: "); String lastName = console.next();
                System.out.print("Adress: "); String adress = console.next();
                System.out.print("Speciality: "); String speciality = console.next();

                Vet vet = new Vet(vetId,firstName,lastName,adress,speciality);
                VetDao vetDao = new VetDao();
                vetDao.createVet(vet);

                System.out.println("Vet created !");
                break;

            case 3:
                System.out.println("Create consult selected !");
                System.out.println("Please insert :");
                System.out.print("Date: "); String date = console.nextLine();
                System.out.print("Description: "); String description = console.nextLine();
                System.out.print("Name of the vet: "); String nameOfVet = console.nextLine();
                System.out.print("Name of pet: "); String nameOfPet = console.nextLine();
                VetDao vetDao1 = new VetDao();
                PetDao petDao1 = new PetDao();

                Consult consult = new Consult(date,description,vetDao1.getVet(nameOfVet),petDao1.getPet(nameOfPet));


                System.out.println("Consult created !");
                break;

        }
    }

    public void findCommands(){
        switch (option()){
            case 1:
                System.out.println("Find Pet selected !");
                System.out.print("Please insert pet's name:"); String petName = console.next();
                PetDao petDao = new PetDao();
                petDao.getPet(petName);
                System.out.println("Pet found !");
                break;

            case 2:
                System.out.println("Find Vet selected !");
                System.out.print("Please insert vet's last name:"); String vetLastName = console.next();
                VetDao vetDao = new VetDao();
                vetDao.getVet(vetLastName);
                System.out.println("Vet found !");
                break;

            case 3:
                System.out.println("Find consult selected !");
                System.out.print("Please insert consult's ID:"); long id = console.nextLong();
                ConsultDao consultDao = new ConsultDao();
                consultDao.getConsult(id);
                System.out.println("Vet found !");
                break;
        }
    }

}
