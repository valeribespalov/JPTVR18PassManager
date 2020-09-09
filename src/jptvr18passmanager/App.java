/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr18passmanager;

import classes.NewResource;
import classes.NewResource;
import classes.SaveToFile;
import entity.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import javax.annotation.Resources;

/**
 *
 * @author pupil
 */
class App {
    private List<Resource> listResources = new ArrayList<>();
    private SaveToFile saveToFile = new SaveToFile();

    public App() {
        listResources.addAll(saveToFile.loadListResources());
    }
    
    public void run(){
        System.out.println("--- Менеджер паролей --- ");
        String repeat = "r";
        do{
       
            System.out.println("   Выберите задачу ");
            System.out.println(" 0 Выход из программы ");
            System.out.println(" 1 - добавить ресурс ");
            System.out.println(" 2 - список ресурсов ");
            Scanner scanner = new Scanner(System.in);
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = "q";
                    break;
                case 1:
                    System.out.println("   Выбрана задача 1 ");
                    System.out.println("   ________________ ");
                  //  Resource resource = new Resource();
                  //  resource.setUrl("http://kutsehariduskeskus.ee");
                  //  resource.setLogin("admin");
                  //  resource.setPassword("123123");
                  //  listResources.add(resource);
                    NewResource nr = new NewResource();                 
                    listResources.add(nr.createRecource()); 
                    SaveToFile saveToFile = new SaveToFile();
                    saveToFile.saveResource(listResources);
                    break;
                case 2:
                    System.out.println("   Выбрана задача 2 ");
                    System.out.println("   ________________ ");
                    System.out.println("   Список ресурсов");
                    for(Resource r : listResources){
                        System.out.println(r.toString());
                    }
                    break;
            }
        }while(!"q".equals(repeat));
       
    }
    
}

