package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import web.service.CarService;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public ModelAndView getListCars(@RequestParam(required = false) Integer count) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allCars", carService.getCarsByCount(count));
        modelAndView.setViewName("cars");
        return modelAndView;
    }

}
