package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/docente")
public class DocenteController {

    private final DocenteService docenteService;
    
    @Autowired
    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping
    public List<DocenteDTO>findAll(){
        return this.docenteService.findAll();
    }

    @GetMapping("/{id}")
    public DocenteDTO findById(@PathVariable(value = "id") Long id){
        return this.docenteService.findById(id);
    }

    @PostMapping
    public DocenteDTO save(@RequestBody DocenteDTO docenteDTO){
        return this.docenteService.save(docenteDTO);
    }

    @PutMapping
    public DocenteDTO update(@RequestBody DocenteDTO docenteDTO){
        return this.docenteService.update(docenteDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.docenteService.delete(id);
}
