package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/nacionalidad")
public class NacionalidadController {

    private final NacionalidadService nacionalidadService;
    
    @Autowired
    public NacionalidadController(NacionalidadService nacionalidadService) {
        this.nacionalidadService = nacionalidadService;
    }

    @GetMapping
    public List<NacionalidadDTO>findAll(){
        return this.nacionalidadService.findAll();
    }

    @GetMapping("/{id}")
    public NacionalidadDTO findById(@PathVariable(value = "id") Long id){
        return this.nacionalidadService.findById(id);
    }

    @PostMapping
    public NacionalidadDTO save(@RequestBody NacionalidadDTO nacionalidadDTO){
        return this.nacionalidadService.save(nacionalidadDTO);
    }

    @PutMapping
    public NacionalidadDTO update(@RequestBody NacionalidadDTO nacionalidadDTO){
        return this.nacionalidadService.update(nacionalidadDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.nacionalidadService.delete(id);
    }
}
