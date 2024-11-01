import Model.Human.Human;
import Model.Human.Gender;
import Model.Service.LeafService;
import Model.Service.MainService;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LeafService<Human> leafService = new LeafService<>();
        String filePath = "src\\familyTree.txt";
        Human dima = new Human("Dmitry",
                "Yermoshin",
                Gender.male,
                LocalDate.of(2012, 12, 23));
        Human daniil = new Human("Daniil",
                "Yermoshin", Gender.male,
                LocalDate.of(1984, 8, 28));

        Human alina = new Human("Alina",
                "Yermoshina",
                Gender.female,
                LocalDate.of(1986, 10, 8));
        Human yulia = new Human("Yulia", "Yermoshina",
                Gender.female, LocalDate.of(2018, 2, 7));
        leafService.setBond(daniil, yulia);
        leafService.setBond(alina, yulia);
        leafService.setBond(daniil, dima);
        leafService.setBond(alina, dima);
        MainService service = new MainService();

        Human tatyana1 = new Human("Tatyana", "Yermoshina",
                Gender.female, LocalDate.of(1950, 7, 24));
        Human tatyana2 = new Human("Tatyana", "Kuznetsova",
                Gender.female, LocalDate.of(1961, 7, 14));
        Human fedor = new Human("Fedor", "Yermoshin",
                Gender.male, LocalDate.of(1946, 6, 3));
        Human alexander = new Human("Alexander", "Kuznetsov",
                Gender.male, LocalDate.of(1965, 10, 11));
        Human alexey = new Human("Alexey", "Yermoshin",
                Gender.male, LocalDate.of(1989, 1, 31));
        Human kirill = new Human("Kirill", "Yermoshin",
                Gender.male, LocalDate.of(1982, 3, 29));
        Human pavel = new Human("Pavel", "Yermoshin",
                Gender.male, LocalDate.of(1979, 11, 15));
        leafService.setBond(tatyana1, daniil);
        leafService.setBond(tatyana1, alexey);
        leafService.setBond(tatyana1, pavel);
        leafService.setBond(tatyana1, kirill);
        leafService.setBond(fedor, daniil);
        leafService.setBond(fedor, alexey);
        leafService.setBond(fedor, pavel);
        leafService.setBond(fedor, kirill);
        leafService.setBond(tatyana2, alina);
        leafService.setBond(alexander, alina);

        boolean y = service.addLeaf(dima);
        y = service.addLeaf(yulia);
        y = service.addLeaf(alina);
        y = service.addLeaf(daniil);
        y = service.addLeaf(kirill);
        y = service.addLeaf(pavel);
        y = service.addLeaf(alexey);
        y = service.addLeaf(fedor);
        y = service.addLeaf(tatyana1);
        y = service.addLeaf(tatyana2);
        y = service.addLeaf(alexander);
        boolean z = service.setWedding(daniil, alina);
        z = service.setWedding(tatyana1, fedor);
        z = service.setWedding(tatyana2, alexander);

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        service.saveTree(service.familyTree, filePath);
        for (Object human: service.familyTree){
            System.out.println(leafService.getInfoLeaf((Human) human));
        }
        service.familyTree.sortByAge();
        System.out.println();
        System.out.println(service.familyTree);
        service.familyTree.sortByAgeRevers();
        System.out.println();
        System.out.println(service.familyTree);
    }

}