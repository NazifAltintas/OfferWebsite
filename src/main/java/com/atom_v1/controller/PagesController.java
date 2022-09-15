package com.atom_v1.controller;

import com.atom_v1.data.*;
import com.atom_v1.services.implementations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class PagesController {

    private CategoryServiceImpl categoryService;
    private LocationServiceImpl locationService;
    private CompanyServiceImpl companyService;
    private TaskServiceImpl taskService;
    private OfferServiceImpl offerService;
    private CommentServiceImpl commentService;
    private UserServiceImpl userService;

    @Autowired
    public PagesController(CategoryServiceImpl categoryService, LocationServiceImpl locationService, CompanyServiceImpl companyService, TaskServiceImpl taskService, OfferServiceImpl offerService, CommentServiceImpl commentService, UserServiceImpl userService) {
        this.categoryService = categoryService;
        this.locationService = locationService;
        this.companyService = companyService;
        this.taskService = taskService;
        this.offerService = offerService;
        this.commentService = commentService;
        this.userService = userService;
    }


    @GetMapping(path = "/")
    public String indexPage(Model model) {

        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("locations", locationService.getAllLocations());
        return "index";
    }

    @GetMapping(path = "/about")
    public String aboutPage(Model model) {

        return "about";
    }

    @GetMapping(path = "/contact")
    public String contactPage(Model model) {

        return "contact";
    }

    @GetMapping(path = "accountSettings")
    public String accountPage(Model model) {

        return "accountSettings";
    }

    @GetMapping(path = "/howDoesItWork")
    public String servicePage(Model model) {

        return "howDoesItWork";
    }

    @GetMapping(path = "/signUp")
    public String signUpPage(Model model) {

        return "registrationPages";
    }
    @GetMapping(path = "/addressForm")
    public String addressForm(Model model) {

        return "addAddress";
    }




    //########################### CATEGORY  ###############################################

    @GetMapping("/category/{id}")
    public String showSingleCategory(@PathVariable String id, Model model) {
        Long aLong;

        try {
            aLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Give a proper a number");
            aLong = 1L;
        }

        Category category = categoryService.getCategoryById(aLong);
        model.addAttribute(category);

        return "singleCategory";
    }

    @GetMapping("makeCategory")
    public String makeCategory() {
        return "addCategory";
    }

    @PostMapping("/createCategory")
    public String createCategory(@ModelAttribute("category") Category category) {
        categoryService.createCategory(category);
        return "redirect:index";
    }
    //########################### LOCATION  ###############################################

    @GetMapping("/location/{id}")
    public String showSingleLocation(@PathVariable String id, Model model) {

        Long aLong;

        try {
            aLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Give a proper a number");
            aLong = 1L;
        }

        Location location = locationService.getLocationById(aLong);
        model.addAttribute(location);

        return "singleLocation";
    }

    @GetMapping("makeLocation")
    public String makeLocation() {
        return "addLocation";
    }

    @PostMapping("createLocation")
    public String createLocation(@ModelAttribute("location") Location location) {
        locationService.createLocation(location);
        return "redirect:index";
    }
    //########################### TASK  ###############################################

    @GetMapping("task/{id}")
    public String showSingleTask(@PathVariable String id, Model model) {

        Long aLong;

        try {
            aLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Give a proper a number");
            aLong = 1L;
        }

        Task task = taskService.getTaskById(aLong);
        model.addAttribute(task);

        return "singleTask";
    }


    @GetMapping(path = "taskForm")
    public String getTaskForm(Model model) {
        model.addAttribute("task", new Task());

        return "taskForm";
    }

    @PostMapping(path = "createNewTask")
    public String createNewTask(@ModelAttribute("task") Task task) {

        taskService.createTask(task);


        return "redirect:companies";

    }

    //########################### COMPANY ###############################################
    @GetMapping(path = "/companies")
    public String companyPage(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("companies", companyService.getAllCompanies());

        return "companies";
    }

    @GetMapping(path = "/lcompanies")
    public String lcompanyPage(Model model) {
        model.addAttribute("locations", locationService.getAllLocations());
        model.addAttribute("companies", companyService.getAllCompanies());

        return "lcompanies";
    }

    @GetMapping(path = "/companies/{id}")
    public String companyPageByCategory(@PathVariable String id, Model model) {
        Long aLong;

        try {
            aLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Give a proper a number");
            aLong = 1L;
        }
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("companies", companyService.getCompaniesByCategoryId(aLong));

        return "companies";
    }

    @GetMapping(path = "/lcompanies/{id}")
    public String companyPageByLocation(@PathVariable String id, Model model) {
        Long aLong;

        try {
            aLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Give a proper a number");
            aLong = 1L;
        }
        model.addAttribute("locations", locationService.getAllLocations());
        model.addAttribute("companies", companyService.getCompaniesByLocationId(aLong));

        return "lcompanies";
    }

    @GetMapping("company/{id}")
    public String showSingleCompany(@PathVariable String id, Model model) {
        Long aLong;

        try {
            aLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Give a proper a number");
            aLong = 1L;
        }

        Company company = companyService.getCompanyById(aLong);
        model.addAttribute(company);
        model.addAttribute("categories", categoryService.getCategoriesByCompanyId(company.getCompanyId()));
        model.addAttribute("locations", locationService.getLocationsByCompanyId(company.getCompanyId()));
        model.addAttribute("users", userService.getUserByCompanyName(company.getCompanyName()));

        return "singleCompany";
    }

    @GetMapping("companyForm")
    public String makeCompany(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("locations", locationService.getAllLocations());
        return "addCompany";
    }

    @PostMapping("createCompany")
    public String createCompany(@ModelAttribute("company") Company company) {
        companyService.createCompany(company);
        return "redirect:companies";
    }

    //########################### COMMENT  ###############################################
    @GetMapping("comment/{id}")
    public String showSingleComment(@PathVariable String id, Model model) {
        Long aLong;

        try {
            aLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Give a proper a number");
            aLong = 1L;
        }

        Comment comment = commentService.getCommentById(aLong);
        model.addAttribute(comment);

        return "singleComment";
    }

    @GetMapping("commentForm")
    public String makeComment(Model model) {
        model.addAttribute("comment", new Comment());

        return "addComment";
    }

    @PostMapping("companyComment/{id}")
    public String createComment(@PathVariable String id, Model model, @ModelAttribute("comment") Comment comment) {
        Long aLong;

        try {
            aLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Give a proper a number");
            aLong = 1L;
        }

        Company company = companyService.getCompanyById(aLong);
        comment.setCompany(company);
        commentService.createComment(comment);

        return "registrationSuccess";
    }

    @GetMapping(path = "/comments/{id}")
    public String getComments(@PathVariable String id, Model model) {
        Long aLong;

        try {
            aLong = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Give a proper a number");
            aLong = 1L;
        }
        Company company = companyService.getCompanyById(aLong);
        model.addAttribute(company);
        model.addAttribute("categories", categoryService.getCategoriesByCompanyId(company.getCompanyId()));
        model.addAttribute("locations", locationService.getLocationsByCompanyId(company.getCompanyId()));
        model.addAttribute("users", userService.getUserByCompanyName(company.getCompanyName()));
        model.addAttribute("comments", company.getComments());

        return "comments";
    }
    //########################### FORMATTER  ###############################################

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        //The date format to parse or output your dates
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //Create a new CustomDateEditor
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        //Register it as custom editor for the Date type
        binder.registerCustomEditor(Date.class, editor);
    }
}
