package com.kusiyyasqa.app.controller;

@RestController
@RequestMapping("api/v1/voluntario")
public class VoluntarioController {

    private final VoluntarioService voluntarioService;
    
    @Autowired
    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    @GetMapping
    public List<VoluntarioDTO>findAll(){
        return this.voluntarioService.findAll();
    }

    @GetMapping("/{id}")
    public VoluntarioDTO findById(@PathVariable(value = "id") Long id){
        return this.voluntarioService.findById(id);
    }

    @PostMapping
    public VoluntarioDTO save(@RequestBody VoluntarioDTO voluntarioDTO){
        return this.voluntarioService.save(voluntarioDTO);
    }

    @PutMapping
    public VoluntarioDTO update(@RequestBody VoluntarioDTO voluntarioDTO){
        return this.voluntarioService.update(voluntarioDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.voluntarioService.delete(id);
    }
}
