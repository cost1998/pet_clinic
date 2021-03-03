import service.PetClinicService;

public class Main {
    public static void main(String[] args) {

        PetClinicService petClinicService = new PetClinicService();
        petClinicService.showMenu();
        petClinicService.menuCommands();
        petClinicService.createCommands();
        petClinicService.findCommands();


    }

}
