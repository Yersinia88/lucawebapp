package hu.akakademia.lucawebapp.controller;

import hu.akakademia.lucawebapp.entity.dog.Breed;
import hu.akakademia.lucawebapp.populate.BreedListGenerator;
import hu.akakademia.lucawebapp.service.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lucawebapp/dog/breed")
public class BreedController {
    private BreedService breedService;
    private String fileName = "resources/database/breeds.txt";
    private List<Breed> basicBreedList = new BreedListGenerator().fillBreedList(fileName);

    @Autowired
    public BreedController(BreedService theBreedService) {
        this.breedService = theBreedService;
    }

    @GetMapping("/list")
    public String listBreeds(Model theModel) {
        List<Breed> breeds = breedService.findAll();
        theModel.addAttribute("breeds", breeds);
        return "lucawebapp/dog/breed-list";
    }

    //TODO: egyszer lehessen megnyomni
    @GetMapping("/populate")
    private String populate(Model theModel) {
        breedService.saveAll(basicBreedList);
        List<Breed> allBreeds = breedService.findAll();
        theModel.addAttribute("breeds", allBreeds);
        return "redirect:/lucawebapp/dog/breed/list";
    }

//    @GetMapping("/select")
//    public String selectBreed(@RequestParam("breedId") int theId, Model theModel) {
//        Breed theBreed = breedService.findById(theId);
//        theModel.addAttribute("breed", theBreed);
//        return "redirect:/lucawebapp/dog/breed/list";
//    }

    @GetMapping("/deleteAll")
    private String deleteAll() {
        breedService.deleteAll();
        return "redirect:/lucawebapp/dog/breed/list";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        //create the model attribute to bint the for mdata
        Breed theBreed = new Breed();
        List<Breed> all = breedService.findAll();
        //TODO: ne lehessen ugyanazt hozzáadni
        if (!(basicBreedList.contains(theBreed))) {
            theModel.addAttribute("breed", theBreed);
        }
        return "lucawebapp/dog/breed-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("breedId") int theId, Model theModel) {
        Breed theBreed = breedService.findById(theId);
        theModel.addAttribute("breed", theBreed);
        return "lucawebapp/dog/breed-form";
    }


    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("breed") Breed theBreed) {
        breedService.save(theBreed);
//redirect to the maping, not html!
        return "redirect:/lucawebapp/dog/breed/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("breedId") int theId) {
        breedService.deleteById(theId);
        return "redirect:/lucawebapp/dog/breed/list";
    }
}
